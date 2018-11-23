# 순환(Recursion)의 개념과 기본예제 -1

*code01.java*

```java
public class Code01 {
	    public static void main(String [] args){
	        func();
	    }
	    
	    public static void func(){
	        System.out.println("Hello");
	        func();
	   }
	}
```

* 무한루프

*Code02.java*

```java
public class Code02{
    public static void main(String [] args){
        func(4);
    }
    
    public static void func(int k){
        //base case
        if(k<=0) 
            return;
        //Recursive case
        else{
            System.out.println("Hello...");
            func(k-1);
        }
    }
}
```

* Base Case : 적어도 하나의 recursion에 빠지지 않는 경우가 존재해야한다.
* Recursive Case : recursion을 반복하다보면 결국 base case로 수렴해야한다.

*code03.java*

```java
public class Code03{
    public static void main(String [] args){
        int result = func(4);
        System.out.println(result);
    }
    
    public static int func(int n){
        if(n==0)
            return 0;
        else
            return n + func(n-1);
    }
}
```

---

### 순환함수와 수학적 귀납법

#### 정리

`func(int n)`은 음이 아닌 정수 n에 대해서 0에서 n까지의 합을 올바로 계산한다.

#### 증명

1. n = 0인 경우 : n=0인 경우 0을 반환한다. 올바르다.
2. 임의의 양의 정수 k에 대해서 n<k인 경우 0에서 n까지의 합을 올바르게 계산하여 반환한다고 가정하자
3. n=k인 경우를 고려해보자.  func은 먼저`func(k-1)` 호출하는데 2번의 가정에 의해서 0에서 k-1까지의 합이 올바른 계산되어 반환된다. 메서드 func은 그 값을 n을 더해서 반환한다. 따라서 메서드 func은 0에서 k까지의 합을 올바로 계산하여 반환한다.

---

### Factorial : n!

1. 0! = 1
2. n! = nx(n-1)!

*factorial.java*

```java
public static int factorial(int n){
    if(n==0)
        return 1;
    else
        return n*factorial(n-1);
}
```

####  Factorial을 수학적 귀납법으로 보자

정리 : `factorial(int n)`은 음이 아닌 정수  n에 대해서 n!을 올바로 계산한다.

증명 :

1. n=0인 경우 : n=0인 경우 1을 반환한다. 올바르다.
2. 임의의 양의 정수 k에 대해서 n < k 인 경우 n!을 올바르게 계산한다고 가정하자.
3. n=k인 경우를 고려해보자. `factorial`은 먼저 `factorial(k-1)` 호출하는데 2번의 가정에 의해서 (k-1)! 이 올바로 계산되어 반환된다. 따라서 메서드 factorial은`k*(k-1)! = k!`을 반환하게된다.

*power.java*

```java
public static double power(double x, int n){
    if(n==0)
        return 1;
    else
        return x * power(x, n-1);
}
```

---

### Fibonacci Number

*원리*

```
f(0) = 0
f(1) = 1
f(n) = f(n-1) + f(n-2) (단, n > 1)
```

*fibonacci.java*

```java
public static int fibonacci(int n){
    if(n < 2)
        return n;
    else
        return fibonacci(n-1) + fibonacci(n-2);
}
```

---

### 최대공약수 : Euclid Method(유클리드 호제법)

*gcd.java*

```java
public static double gcd(int m, int n){
    if(m<n){
        int tmp = m; m=n; n=tmp; // swap m and n
    }
    if(m%n == 0)
        return n;
    else
        return gcd(n, m%n);
}
```

* m>=n인 두 양의 정수  m, n에 대해서 m이 n의 배수이면, gcd(m,n)=n이고, 그렇지 않으면 gcd(m,n) = gcd(n, m%n)이다

좀 더 간단하게

```
gcd(p, q) - if q = 0, p
		  - else gcd(q, p%q)
```

*moresimplegcd.java*

```java
public static double gcd(int p, int q){
    if(q==0)
        return p;
    else
        return gcd(q, p%q);
}
```
