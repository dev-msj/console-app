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

1. 현재 사용 중인 Map 공간이 MAP_SIZE보다 큰지 확인한다.
2. multipleHashFunction의 결과값을 index로 하여 접근한 배열의 값이 null이면 MapObject를 저장한다.
3. 해시 충돌이 발생하면 key의 hash code를 1씩 증가시켜 2번 과정을 MAP_SIZE만큼 반복한다.

### get method

1. multipleHashFunction의 결과값을 index로 하여 접근한 배열의 key값이 findKey값이 동일하면 해당 배열의 value를 반환한다.
2. 배열의 key값이 findKey값이 동일하지 않으면 key의 hash code를 1씩 증가시켜 1번 과정을 MAP_SIZE만큼 반복한다.
3. MAP_SIZE만큼 반복해도 index를 찾지 못하면 NPE를 발생시킨다. 

### remove method

1. multipleHashFunction의 결과값을 index로 하여 접근한 배열의 key값이 findKey값이 동일하면 해당 배열에 null을 저장한다.
2. 배열의 key값이 findKey값이 동일하지 않으면 key의 hash code를 1씩 증가시켜 1번 과정을 MAP_SIZE만큼 반복한다.
3. MAP_SIZE만큼 반복해도 index를 찾지 못하면 NPE를 발생시킨다.

## 참고사항

* hash code는 동일 값에 동일 결과를 가져다 줌.
