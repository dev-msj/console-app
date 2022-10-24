# 간단한 Big Integer 처리해보기

---

## 목표

Integer나 Long에서 감당할 수 없는 아주 큰 수를 핸들링 할 수 있는 간단한 클래스를 작성해보자.

## 힌트

String으로 구현하고 약간의 알고리즘을 사하면 된다.

## 구현 내용

1. 1의 자리수부터 문자를 하나씩 꺼내 덧셈한다.
2. default value가 '0'인 uppderNumber도 더한다.
3. 덧셈 결과의 1의 자리수는 StringBuilder에 추가한다.
4. 덧셈 결과가 10 이상이면 10의 자리수는 upperNumber에 저장한다.
5. 1-5 과정을 반복한다.
6. 마지막 loop가 끝난 후 upperNumber가 '0'이 아니라면 StringBuilder에 추가한다.
7. StringBuilder를 reverse한다.

## 설계

### Model

* **BigInt** 
  * description : Long 타입의 크기를 벗어나는 Decimal Number를 String 형태로 저장
  * public variable
    * decimalString : String형의 Decimal값을 저장한다.
  * public method
    * constructor : String형의 Decimal 값을 받아 decimalString에 저장한다. 파라메터가 없을 경우 기본값은 "0"이다.
    * multiplyTenToSelf : 자신의 Decimal String에 10을 곱한다.
    * equals & hashCode : 전달된 객체가 동일한 값을 가지는지 비교한다.
    * compareTo : 전달된 객체의 String Number 값을 비교하여 비교 대상보다 크면 1, 동일하면 0, 작으면 -1을 반환한다.
    * toString : decimalString 값을 출력한다.
  * private method
    * compareFirstChar : 각 객체들의 0번째 index에 있는 Char Number들의 크기 비교 결과를 반환한다.

### Service

* BigIntCalculator
  * description : BigInt 연산 클래스의 인터페이스. 2개의 BigInt들 간의 산술 연산 기능을 제공한다.
  * private static variable
    * resultDecimalString : 연산 결과를 저장
  * public static method
    * plus : 2개의 BigInt 객체를 받아 덧셈 연산 후 BigInt형으로 결과를 반환한다.

## 적용

### 곱셈

곱셈은 자리수 별로 곱하면서 right padding을 추가하고 그 결과들을 더하면 된다.

### 뺄셈

뺄셈은 큰 수에서 작은 수로 연산한다. <br> 
크기 비교는 0 padding으로 맞춰졌기 때문에 charAt(0)의 숫자만 비교하면 알 수 있다.

### 나눗셈

(작은 수 * n)을 반복하며 큰 수에서 작은 수를 빼보고, 결과가 음수이면 (n - 1)이 몫이고 {큰 수 - ((작은 수 * n) - 1)}의 값이 나머지다.