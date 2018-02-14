package edu.jsu.mcis;

public class TicTacToeModel{
    
    private static final int DEFAULT_WIDTH = 3;
    
    /* Mark (represents X, O, or an empty square */
    
    public enum Mark {
        
        X("X"), 
        O("O"), 
        EMPTY("-");

        private String message;
        
        private Mark(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    /* Result (represents the final state of the game: X wins, O wins, a tie,
       or NONE if the game is not yet over) */
    
    public enum Result {
        
        X("X"), 
        O("O"), 
        TIE("Tie"), 
        NONE("none");

        private String message;
        
        private Result(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    }
    
    private Mark[][] grid; /* Game grid */
    private boolean xTurn; /* True if X is current player */
    private int width;     /* Size of game grid */
    
    /* DEFAULT CONSTRUCTOR */
    
    public TicTacToeModel() {
        
        /* No arguments (call main constructor; use default size) */
        
        this(DEFAULT_WIDTH);
        
    }
    
    /* CONSTRUCTOR */
    
    public TicTacToeModel(int width) {
        
        /* Initialize width; X goes first */
        
        this.width = width;
        xTurn = true;
        
        /* Create grid (width x width) as a 2D Mark array */
		grid = new Mark[width][width];
		
		for (int i = 0; i < width; ++i){
			for (int j = 0; j < width; ++j){
				grid[i][j] = Mark.EMPTY;
				
			}
		}
		
    }
	
    public boolean makeMark(int row, int col) {
        
        /* Place the current player's mark in the square at the specified
           location, but only if the location is valid and if the square is
           empty! */
        if ( (isValidSquare(row,col)) && (!isSquareMarked(row,col)) ){
			if (xTurn)
				
				grid[row][col] = Mark.X;
				
			else
				grid[row][col]= Mark.O;
			
			xTurn = !xTurn;
			return true;
		}
			
			
		
        /* INSERT YOUR CODE HERE */

        return false; /* remove this line! */
        
    }
	
    private boolean isValidSquare(int row, int col) {
        
        /* Return true if specified location is within grid bounds */
        if (row >= 0){
			if (col >= 0){
				if (row <= (width-1)){
					if (col <= (width-1)){
						return true;
					}
				}
			}
		}
        /* INSERT YOUR CODE HERE */

        return false; /* remove this line! */
        
    }
	
    private boolean isSquareMarked(int row, int col) {
        
        /* Return true if square at specified location is marked */
        return grid[row][col] != Mark.EMPTY;
        /* INSERT YOUR CODE HERE */

        //return false; /* remove this line! */
            
    }
	
    public Mark getMark(int row, int col) {
        
        /* Return mark from the square at the specified location */
        
		return grid[row][col];
		
        /* INSERT YOUR CODE HERE */

        //return null; /* remove this line! */
            
    }
	
    public Result getResult() {
        
        /* Use isMarkWin() to see if X or O is the winner, if the game is a
           tie, or if the game is not over, and return the corresponding Result
           value */
        Mark mark = (this.xTurn) ? Mark.X : Mark.O;
		
		if (isMarkWin(Mark.X))
			return Result.X;
		if (isMarkWin(Mark.O))
			return Result.O;
		if (isTie())
			return Result.TIE;
		else
			return Result.NONE;
		
        /* INSERT YOUR CODE HERE */

        //return null; /* remove this line! */

    }
	
    private boolean isMarkWin(Mark mark) {
        
        /* Check the squares of the board to see if the specified mark is the
           winner */
        
        /* Verticals */
		boolean won = true;
		
		for (int col = 0; col < width; ++col){
			won = true;
			for (int row = 0; row < width; ++row){
				if (grid[row][col] != mark)
				won = false;
			}
			if (won) {
				return true;
			}
		}
		/* Horizontals */
		for (int row = 0; row < width; ++row){
			won = true;
			for (int col = 0; col < width; ++col){
				if (grid[row][col] != mark)
				won = false;
			}
			if (won){
				return true;
			}
		}
		/* Diagonals */
		won = true;
		for (int i = 0; i < width; ++i){
			if (grid[i][i] != mark)
				won = false;
		}
		if (won){
			return true;
		}
		
		
		won = true;
		for (int i = 0; i < width; ++i){
			if (grid[i][width-i-1] != mark)
				won = false;
		}		
        if (won){
			return true;
		}
		
		return false; /* remove this line! */

    }
	
    private boolean isTie() {
        
        /* Check the squares of the board to see if the game is a tie */
		boolean boardFull = true;
		for (int i = 0; i < this.width; ++i){
			for (int j = 0; j < this.width; ++j){
				if (grid[i][j] == Mark.EMPTY){
					boardFull = false;
				}
			}
		}
        if (!boardFull)
			return false;
		else {
			return !((isMarkWin(Mark.X)) || (isMarkWin(Mark.O)));
		}
		
        //return false; /* remove this line! */
        
    }

    public boolean isGameover(){
        
        /* Return true if the game is over */
        
        return Result.NONE != getResult();
        
    }

    public boolean isXTurn(){
        
        /* Getter for xTurn */
        
        return xTurn;
        
    }

    public int getWidth(){
        
        /* Getter for width */
        
        return width;
        
    }
   
}