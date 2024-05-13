I want to mension that All of here are just practice, I took notes of the foundamental and relevant concepts on my personal digital NoteBook. In a future I try to add about graphs and document more (specificly the boundary cases of each)  
##  
I also am trying to combine with the book( only practices ):  
_"Data Structures and Algorithms in Java" by Michael T. Goodrich (Author), Roberto Tamassia (Author), Michael H. Goldwasser_.    
But this I'll do slowly because I do it when:
- My teacher doesn't come & I have free hour
- When I don't have Internet || Energy && I have charged my laptop
- Any other moments in which I can't choose what do

<br>


# Some Content THat I've Learned    
## Basic Algorithms   
- Define what exactly is an algorithm   


- Find a maximum element in an array
- Find a minimum element in an array
- Find the 17th element in the fibonacci sequence
- Calculate the factorial of a number
- Calculate the sum of the digits of a positive integer
- etc.  

## Algorithms Complexity
### Measurement Diff: ( software-agnostic && hardware-agnostic ) && ( Seconds || Millis )
### Time Complexity
### Space Complexity

## Algorithms Analysis   
### Take in account:
- `input >= 0`
  - `input` is a positive integer 
- Functions do more work for more input
  - Pass by each(`<arr_size_100>`) -> `100` times
  - Pass by each(`<arr_size_1000>`) -> `1000` times
  - Pass by each(`<arr_size_n>`) -> `n` times
- Drop all constant factors
  - `log_2(n) + 1` -> `log_2(n)`
  - `3n + 2` -> `n`
  - `50n` -> `n`
- Ignore lower order terms
  - `3n^2 + 2n + 1` -> `n^2`
  - `6n^3 + 2n^2 + 3n + 1` -> `n^3`   
- ignore base of logarithm
  - we can change the base, the algorithm will be the same
  - `log_2(n)` -> `log(n)`
  - `log_10(n)` -> `log(n)`
  - `log_3(n)` -> `log(n)`
### Asymptotic Notation 
  - Big-O
    > same or faster 
  - Little-O
    > faster
  - Big-Omega
    > same or slower
  - Little-Omega
    > slower
  - Big-Theta
    > `O()` and `Omega()` are the same  


#### Examples

- `n^3 = O(n^2)` -> `false`
- `n^2 = O(n^3)` -> `true`
- `n^2 = O(n^2)` -> `true`
- `(n(n-1))/2 = O(n^2)` -> `true`


- `(n(n-1))/2 = o(n^2)` -> `false`
- `n^2 = o(n^3)` -> `true`
- `n^2 = o(n^2)` -> `false`
- `n^3 = o(n^4)` -> `true`


- `n^4 = Ω(n^3)` -> `true`
- `log n = Ω(1)` -> `true`
- `n = Ω(log n)` -> `true`
- `n = Ω(n)` -> `true`
- `n = Ω(n^2)` -> `true`


- `n^2 = ω(n)` -> `true`
- `n^3 = ω(n^2)` -> `true`
- `log n = ω(1)` -> `true`
- `n = ω(log n)` -> `true`


- `n^2 = Θ(n^2)` -> `true`
- `n^2 = Θ(n^3)` -> `false`
- `n^2 = Θ(n^2)` -> `true`

## Understand
### OOP
### Generic Programming
### Recursion concepts
### Divide and Conquer

