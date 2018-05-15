# PricklyPossie
| operation	| worst case | average case |
| --- | --- | --- |
| add | O(1) | O(1) |
| peekMin | O(n) | O(n) |
| removeMin | O(n) | O(n) |

We decided to use this version as our v2 because we wanted to stay in compliance with the api. This homework was the most clean of the two homeworks that were in compliance with the api. Simplicity is key most of the time and we thought this was one of the times when simplicity was needed. 

### add 
Our add method uses the built in add method of arraylist. It simply adds the value to the end of the arraylist.

### isEmpty
Our isEmpty method checks if the size of the arraylist is of size 0 and returns true if it is of size 0.

### peekMin
peekMin returns the smallest value of the arraylist by using a foreach loop to iterate through the arraylist. 

### removeMin
removeMin finds the smallest value and records its value and its index. Then, the remove function of arraylist is called to remove that value from the arraylist. The value at the removed index is returned. 

## Heap todo
1. write the default constructor
2. write isEmpty
3. write peekMin
4. write minOf
5. write swap
6. write minChildPos
7. write removeMin
8. write add
9. write toString
10. test and compile
11. Succeed 
12. learnanation
