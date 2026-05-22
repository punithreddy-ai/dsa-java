# 01 - Arrays

Arrays are the most fundamental data structure. An array stores elements in **contiguous memory**, where each element is accessed by its index starting from 0.

---

## Key Concepts

### Declaration in Java
```java
int[] arr = new int[5];                // empty array of size 5
int[] arr = {10, 20, 30, 40, 50};     // array with values
System.out.println(arr[0]);            // 10 → first element
System.out.println(arr[arr.length-1]); // 50 → last element
```

### Looping
```java
// Standard for loop
for (int i = 0; i < arr.length; i++) {
    System.out.println(arr[i]);
}

// Enhanced for loop
for (int x : arr) {
    System.out.println(x);
}
```

### Useful Utilities
```java
import java.util.Arrays;

Arrays.sort(arr);              // sort ascending
Arrays.sort(arr, 0, 3);       // sort only index 0 to 2
Arrays.fill(arr, 0);          // fill all with 0
System.out.println(Arrays.toString(arr)); // print nicely
```

---

## Time Complexity Cheatsheet

| Operation         | Time Complexity |
|------------------|----------------|
| Access by index  | O(1)           |
| Search (linear)  | O(n)           |
| Insert at end    | O(1)           |
| Insert at middle | O(n)           |
| Delete           | O(n)           |
| Sort             | O(n log n)     |

---

## Problems Solved

### 1. Find Maximum Element — `MaxElement.java`
**Approach:** Linear scan, track max variable  
**Time:** O(n) | **Space:** O(1)

```java
int max = arr[0];
for (int i = 1; i < arr.length; i++) {
    if (arr[i] > max) max = arr[i];
}
```

---

### 2. Reverse an Array — `ReverseArray.java`
**Approach:** Two pointers from both ends, swap and move inward  
**Time:** O(n) | **Space:** O(1)

```java
int left = 0, right = arr.length - 1;
while (left < right) {
    int temp = arr[left];
    arr[left] = arr[right];
    arr[right] = temp;
    left++; right--;
}
```

---

### 3. Second Largest Element — `SecondLargest.java`
**Approach:** Track two variables (max and secondMax) in one pass  
**Time:** O(n) | **Space:** O(1)

```java
int max = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
for (int x : arr) {
    if (x > max) { second = max; max = x; }
    else if (x > second && x != max) { second = x; }
}
```

---

### 4. Two Sum — `TwoSum.java`
**Approach:** HashMap to store seen values; look up complement each step  
**Time:** O(n) | **Space:** O(n)

```java
HashMap<Integer, Integer> map = new HashMap<>();
for (int i = 0; i < arr.length; i++) {
    int complement = target - arr[i];
    if (map.containsKey(complement)) return new int[]{map.get(complement), i};
    map.put(arr[i], i);
}
```

---

### 5. Best Time to Buy and Sell Stock — `BestTimeToBuyAndSellStock.java`
**Approach:** Track minimum price seen so far; compute profit at each step  
**Time:** O(n) | **Space:** O(1)

```java
int minPrice = Integer.MAX_VALUE, maxProfit = 0;
for (int price : prices) {
    if (price < minPrice) minPrice = price;
    else maxProfit = Math.max(maxProfit, price - minPrice);
}
```

---

## Patterns Learned

| Pattern | Used in |
|---|---|
| Linear scan | Max Element |
| Two Pointers | Reverse Array |
| Track two variables | Second Largest |
| HashMap lookup | Two Sum |
| Greedy / min tracking | Stock Profit |

---

## Tips to Remember

- Always check for **empty array** edge cases
- Use `Integer.MIN_VALUE` / `Integer.MAX_VALUE` instead of hardcoding limits
- Two pointers = O(n) time, O(1) space — always prefer over nested loops
- HashMap trades space for speed — O(n) space gets you O(n) time instead of O(n²)
