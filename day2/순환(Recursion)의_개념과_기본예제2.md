# 순환의 개념과 기본예제 -2

### Recursive Thinking

Recursion은 수학함수 계산에만 유용한가?

- 수학함수뿐 아니라 다른 많은 문제들을 recursion으로 해결할 수 있다.

1. 문자열의 길이 계산

  *pseudoCode*

  ```pseudocode
  if the String is empty
  retunr 0;
  else 
   return 1 plus the legnth of the string that excludes the first Character;
  ```

  *code.java*

  ```java
  public static int length(String str){
      if(str.equals(""))
          return 0;
      else
          return 1 + length(str.substring(1));
      // substring은 첫글자를 제외하고 나머지글자만 가져온다.
  }
  ```

2. 문자열의 프린트

   *code.java*

   ```java
   public static void printChars(String str){
       if(str.length() == 0)
           return;
       else{
           System.out.println(str.CharAt(0));
       	printChars(str.substring(1));
   	}
   }
   ```

3. 문자열을 뒤집어서 프린트

   *code.java*

   ```java
   public static void printCharReverse(String str){
       if(str.length()==0)
           return;
       else{
           printCharsReverse(str.substring(1));
           System.out.print(str.charAt(0))
       }
   }
   ```

4. 2진수로 변환하여 출력 

   * 음이 아닌 정수 n을 이진수로 변환하여 인쇄한다.

   *code.java*

   ```java
   public static void printInBinary(int n){
       if(n<2)
           System.out.print(n);
       else{
           // n을 2로 나눈 몫을 먼저 2진수로 변환하여 print한 후,
           printInBinary(n/2);
           // n을 2로 나눈 나머지를 인쇄한다.
           System.out.print(n%2);
       }
   }
   ```

5. 배열의 합 구하기

   `data[0]`에서 `data[n-1]`까지의 합을 구하여 반환한다.

   *code.java*

   ```java
   public static int sum(int n, int [] data){
       if(n<=0)
           return 0;
       else
           return sum(n-1, data) + data[n-1];
   }
   ```

6. 데이터 파일로 부터 n개의 정수 읽어오기

   `Scanner in` 이 참조하는 파일로부터 n개의 정수를 입력받아 배열 `data`의 `data[0]`~`data[n-1]`에 저장한다.

   *code.java*

   ```java
   public static void readFrom(int n, int [] data, Scanner in){
       if(n==0)
           return;
       else{
           readFrom(n-1, data, in);
           data[n-1] = in.nextInt();
       }
   }
   ```

---

### Recursion VS Iteration

* 모든 순환함수는 반복문(Iteration)으로 변경가능
* 그 역도 성립함. 즉 **모든 반목문은 recursion으로 표현가능**
* 순환함수는 복잡한 알고리즘을 단순하고 알기 쉽게 표현하는 것을 가능하게 한다.
* 하지만 함수 호출에 따른 오버헤드가 있다.(매개변수 전달, 엑티베이션 프레임 생성등.)

---

### Designing Recusion - 순환 알고리즘의 설계

* 적어도 하나의 base case, 즉 순환되지 않고 종료되는 case가 있어야한다.
* 모든 case는 결국 base case로 수렴해야 한다.
* 위의 두 조건을 지키지 않으면 무한 loop를 피할 수 없다.
* 암시적(implicit) 매개변수를 명시적(explicit) 매개변수로 바꾸어라!

1. 순차탐색(Sequential Search)

   *code.java*

   ```java
   public static int search(int [] data, int n, int target){
       for(int i = 0; i<n; i++){
           if(data[i]==target)
               return i;
       }
       return -1;
   }
   ```

   위의 함수의 미션은 data[0]에서 data[n-1] 사이에서 target을 검색하는 것이다. 하지만 검색 구간의 시작 인덱스는 0을 보통 생략한다. 즉, 암시적 매개변수이다.

2. 매개변수의 명시화 :  다시한번 순차탐색

   ```java
   int search(int [] data, int begin, int end, int target){
       if(begin > end)
           return -1;
       else if(target == data[begin])
           return begin;
       else
           return search(data, begin + 1, end, target);
   }
   ```

   위 함수의 미션은 data[begin]에서 data[end] 사이에서 target을 검색한다. 즉, 검색구간의 시작점을 명시적(explicit)으로 지정한다.

   이 함수를 search(data, 0, n-1, target)으로 호출한다면 암시적 매개변수를 사용하는 앞의 함수와 완전히 동일한 일을 한다.

3. 순차탐색 :  다른 버전 ( * binary search랑은 다릅니다.)

   ```java
   int search(int [] data, int begin, int end, int target){
       if(begin > end)
           return -1;
       else{
           int middle = (begin + end)/2;
           if(data[middle] == target)
               return middle;
           int idx = search(data, begin, middle-1, target);
           if(idx != -1)
               return idx;
           else 
               return search(data, middle+1, end, target);
       }
   }
   ```

4. 매개변수의 명시화 - 최대값 찾기

   ```java
   	public static int findMax(int[] data, int begin, int end) {
   		if (begin == end)
   			return data[begin];
   		else
   			return Math.max(data[begin], findMax(data, begin + 1, end));
   	}
   ```

   위 함수의 미션은 data[begin]에서 data[end] 사이에서 최대값을 찾아 반환한다.  begin<=end라고 가정한다.

5. 최대값 찾기 다른 버전

   ```java
   int findMax(int [] data, int begin, int end){
       if(begin == end)
           return data[begin];
       else{
           int middle = (begin + end)/2;
           int max1 = findMax(data, begin, middle);
           int max2 = findMax(data, middle+1, end);
           return Math.max(max1, max2);
       }
   }
   ```

6. Binary Search use Recursion

   ```java
   public static int binarySearch(String [] items, String target, int begin, int end){
       if(begin>end)
           return -1;
       else{
           int middle= (begin+end)/2;
           int comResult = target.compareTO(items[middle]);
           if(comResult == 0)
               return middle;
           else if(comResult < 0)
               return binarySearch(items, target, begin, middle-1);
           else
               return binarySearch(items, target, middle+1, end);
       }
   }
   ```

   * `compareTo`함수는 함수를 호출한 객체를 인자값과 비교하는것.비교대상이 동일하면 0, 비교대상이 작으면 -1, 크면 1을 반환한다.