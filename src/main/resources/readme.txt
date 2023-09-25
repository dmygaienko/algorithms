n <= 10 ^ 5 is the most common constraint you will see on LeetCode. In this range, the slowest acceptable common time complexity is
O(n⋅logn), although a linear time approach O(n) is commonly the goal.

In this range, ask yourself if sorting the input or using a heap can be helpful. If not, then aim for an O(n) algorithm.
Nested loops that run in O(n ^ 2) are unacceptable - you will probably need to make use of a technique learned in this course
to simulate a nested loop's behavior in O(1) or O(logn):

- Hash map
- A two pointers implementation like sliding window
- Monotonic stack
- Binary search
- Heap

A combination of any of the above
If you have an O(n) algorithm, the constant factor can be reasonably large (around 40).
One common theme for string problems involves looping over the characters of the alphabet at each iteration resulting
in a time complexity of O(26n).