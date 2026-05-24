# 02 - Strings

A String is a sequence of characters. In Java, Strings are **immutable** — once created they cannot be changed. Every operation creates a new String object.

---

## Key Concepts

### Basic Operations
```java
String s = "hello";
s.length()           // 5
s.charAt(0)          // 'h'
s.toUpperCase()      // "HELLO"
s.toLowerCase()      // "hello"
s.substring(1, 3)    // "el"  (index 1 inclusive, 3 exclusive)
s.contains("ell")    // true
s.replace("l", "r")  // "herro"
s.trim()             // removes leading/trailing spaces
s.split(" ")         // splits into String array by space
```

### Always use .equals() not ==
```java
String a = "hello";
String b = "hello";
a == b        // ❌ compares memory address (unreliable)
a.equals(b)   // ✅ compares actual content → true
```

### Convert between String and char[]
```java
char[] chars = s.toCharArray();   // String → char array
String back = new String(chars);  // char array → String
```

### StringBuilder — use when building strings in a loop
```java
StringBuilder sb = new StringBuilder();
sb.append("hello");
sb.append(" world");
String result = sb.toString(); // "hello world"
// sb.append() is O(1) — much faster than s += "x" which is O(n)
```

### Char Arithmetic
```java
char c = 'b';
c - 'a'   // 1  (useful for frequency arrays)
c + 1     // 'c'
(int) c   // 98  (ASCII value)
Character.isLetter(c)   // true
Character.isDigit(c)    // false
Character.toLowerCase(c) // 'b'
```

---

## Time Complexity Cheatsheet

| Operation            | Time Complexity |
|---------------------|----------------|
| Access char by index | O(1)           |
| Search substring     | O(n*m)         |
| String concatenation (+= in loop) | O(n²) |
| StringBuilder append | O(1) amortized |
| toCharArray()        | O(n)           |
| equals()             | O(n)           |

---

## Problems Solved

### 1. Check Palindrome — `CheckPalindrome.java`
**Approach:** Two pointers from both ends, compare characters moving inward  
**Time:** O(n) | **Space:** O(1)

```java
int left = 0, right = s.length() - 1;
while (left < right) {
    if (s.charAt(left) != s.charAt(right)) return false;
    left++; right--;
}
return true;
```

---

### 2. Reverse a String — `ReverseString.java`
**Approach:** Convert to char array, two pointer swap, convert back  
**Time:** O(n) | **Space:** O(n)

```java
char[] chars = s.toCharArray();
int left = 0, right = chars.length - 1;
while (left < right) {
    char temp = chars[left];
    chars[left] = chars[right];
    chars[right] = temp;
    left++; right--;
}
return new String(chars);
```

---

### 3. First Non-Repeating Character — `FirstNonRepeatingChar.java`
**Approach:** Frequency array int[26], two pass — count then find first with count == 1  
**Time:** O(n) | **Space:** O(1)

```java
int[] count = new int[26];
for (char c : s.toCharArray()) count[c - 'a']++;
for (char c : s.toCharArray()) if (count[c - 'a'] == 1) return c;
return '_';
```

---

### 4. Check Anagram — `CheckAnagram.java`
**Approach:** Increment count for s1, decrement for s2, all zeros = anagram  
**Time:** O(n) | **Space:** O(1)

```java
if (s1.length() != s2.length()) return false;
int[] count = new int[26];
for (int i = 0; i < s1.length(); i++) {
    count[s1.charAt(i) - 'a']++;
    count[s2.charAt(i) - 'a']--;
}
for (int c : count) if (c != 0) return false;
return true;
```

---

### 5. Longest Substring Without Repeating Characters — `LongestSubstringWithoutRepeating.java`
**Approach:** Sliding window with HashSet — expand right, shrink left on duplicate  
**Time:** O(n) | **Space:** O(n)

```java
HashSet<Character> set = new HashSet<>();
int left = 0, maxLen = 0;
for (int right = 0; right < s.length(); right++) {
    while (set.contains(s.charAt(right))) { set.remove(s.charAt(left)); left++; }
    set.add(s.charAt(right));
    maxLen = Math.max(maxLen, right - left + 1);
}
return maxLen;
```

---

## Patterns Learned

| Pattern | Used in |
|---|---|
| Two Pointers | Palindrome, Reverse String |
| Frequency Array int[26] | First Non-Repeating, Anagram |
| Sliding Window + HashSet | Longest Substring |
| char arithmetic (c - 'a') | Non-Repeating, Anagram |

---

## Tips to Remember

- Strings are **immutable** — always use `char[]` or `StringBuilder` when modifying
- Always use `.equals()` not `==` to compare strings
- `c - 'a'` maps characters to array indices (a=0, b=1 ... z=25)
- Sliding window = two pointers that expand/shrink a range → O(n) instead of O(n²)
- `int[26]` frequency array is O(1) space since it never grows beyond 26
