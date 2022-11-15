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

1. key, value를 가지고 있는 MapObject 배열을 생성한다.
2. hash function을 통해 key의 해시값을 받고, MapObject 배열의 인덱스값으로 사용한다.
3. key의 hashCode를 hash function의 결과값을 인덱스 배열에 접근한다.
4. get method을 수행할 때, 먼저 key값이 존재하는지 확인 후 value값을 반환한다.

## 참고사항

* hash code는 동일 값에 동일 결과를 가져다 줌.

