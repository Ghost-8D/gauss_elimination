# gauss_elimination

This program calculates the solution of a system of equations with n variables using the Gauss elimination process. The number of supported equations are 1-10. The program also calculates the error percentage for each equation and displays them on screen along with the solution. If the system has no solution the program will print an error message and terminate.

### Usage:
Compile with:  
```bash
javac gauss_elimination.java
```

Execute with:
```bash
java gauss_elimination < fileName.txt # Where fileName.txt is the name of the input file
```

### Input file format:
```
n # number of equations
x1 y1 z1 # coefficients of equation 1 separated by space
x2 y2 z2 # coefficients of equation 2 separated by space
...
xn yn zn # coefficients of equation n separated by space
```

### Example with 3 equations (n = 3)

Equations:
- 2 * x - 1 * y - 4 * z = -1
- 1 * x + 5 * y + 1 * z = 0
- 1 * x + 3 * y + 2 * z = 4

Input file (test1.txt):
```
3 
2 -1 -4 -1
1 5 1 0
1 3 2 4
```

Running program: 
```
java gauss_elimination < test1.txt
```

Output: 
```
  GAUSSIAN ELIMINATION

  The Problem

  2.00 -1.00 -4.00	x 1	-1.00
  1.00  5.00  1.00	x 2	 0.00
  1.00  3.00  2.00	x 3	 4.00

  The Solution

  2.00 -1.00 -4.00	 3.00000	-1.00000
  1.00  5.00  1.00	-1.00000	 0.00000
  1.00  3.00  2.00	 2.00000	 4.00000

  Accuracy of Solution

  for equation  1 the error is 	    0.00000%
  for equation  2 the error is 	    0.00000%
  for equation  3 the error is 	    0.00000%
```
