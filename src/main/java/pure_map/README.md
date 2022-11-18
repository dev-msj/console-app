# Pure Map

---

## 목적

자료 구조 이해를 위해 Map을 Pure Java로 구현해보자.

## 조건

* PureMap은 <K, V> 제네릭을 가진다.
* K는 중복할 수 없다.
* K, V는 null을 받을 수 있다.
* 기본 저장공간의 크기는 16이다.
* 기본 로드 팩터(데이터의 갯수 / 저장공간) 0.75다.

## 설계

### put method

1. {데이터 갯수 / 저장공간}이 load factor보다 크면 저장공간을 늘리고 리해싱한다.
2. multipleHashFunction의 결과값을 index로 하여 접근한 배열의 값이 null이면 MapObject를 저장한다.
3. 해시 충돌이 발생하면 더블 해싱 기법으로 현재 데이터 갯수만큼 반복하며 null인 공간을 찾는다.

### get method

1. multipleHashFunction의 결과값을 index로 하여 접근한 배열의 key값이 findKey값과 동일하면 해당 배열의 value를 반환한다.
2. 배열의 key값이 findKey값이 동일하지 않으면 더블 해싱 기법으로 현재 데이터 갯수만큼 반복하며 key가 동일한 index를 찾는다.
3. 현재 데이터 갯수만큼 반복해도 index를 찾지 못하면 NPE를 발생시킨다. 

### remove method

1. multipleHashFunction의 결과값을 index로 하여 접근한 배열의 key값이 findKey값과 동일하면 해당 배열에 null을 저장한다.
2. 배열의 key값이 findKey값이 동일하지 않으면 더블 해싱 기법으로 현재 데이터 갯수만큼 반복하며 key가 동일한 index를 찾는다.
3. 현재 데이터 갯수만큼 반복해도 index를 찾지 못하면 NPE를 발생시킨다.
