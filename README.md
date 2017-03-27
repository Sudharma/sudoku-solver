# Problem Statement  
Build a sudoku-solver  that takes an incomplete sudoku through an HTTP-API and returns a completed sudoku or an error message.
 The API codes the sudoku as a list of 81 comma separated values [1-9]. Empty fields are represented by 'x'.
 
# Components
1. REST controller which serves the incoming request. 
2. Services are plain Java as of now which holds the crux of the logic of solving sudoku.(this can be extracted to other component)
3. Model which takes care rendering the response as per the Result.

# Tech Stack / Pre requisites
1. REST is implemented with Jersey 2.0 with JAX.WS.RS spec
2. Java-8
3. Apache Tomcat 7
4. Maven 3.3.9 for building
5. IDE independent. Eclipse is recommended.

# Working of Sudoku Solver

From the input recieved from the end user which is series of 81 numbers(comma seperated). The number x is being replaced with zero (0) and a board of [9][9] 2D array is built. [i][j] represents the ith row and jth column. 
    1. Start with row wise traversal and check if any unoccupied(0) is available. If No its a success (more details later)
    2. If yes start from digits 1 to 9 and fill the unoccupied space temporarily. This is done by checking if the number is already present in row or column or the box. The logic for box is with example that row is 2 and column is 8 , mod row and column with 3 (n%3) so that the box is identified and iterate with the box as a matrix and check if the number we want to assign is already present. 
    3. Step 2 executes recurrsively and finds proper number till the rows,column and box are filled.
    4. the above method is in short backtracking which will loop the whole board.
    5. Java 8 is used but very sparingly since the loops cannot be avoided.

# Exception Cases

1. If the input length is incorrect , i,e not equal to 81 (NxN) then its considered improper Board.
2. If the input length is correct but the values given are not valid Sudoku board then `cannot be complete` ERROR is shown.
3. More the number of x in the input will also solve the problem.

# Download and Execution.

1. Clone the repository
2. `mvn clean package` which will build `target/sudoku-challenge.war`
3. Copy the war in `<apache-tomcat>/webapps/sudoku-challenge.war`
4. `curl --request GET  http://localhost:8080/sudoku-challenge/rest/solve?input=<series of sudoku numbers with x>`

 
   







