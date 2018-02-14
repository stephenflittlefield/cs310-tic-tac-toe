package edu.jsu.mcis;

public class TicTacToeView {

    private TicTacToeModel model;
    
    /* CONSTRUCTOR */
	
    public TicTacToeView(TicTacToeModel model) {
        
        this.model = model;
        
    }
	
    public void viewModel() {
        
        /* Print the board to the console (see examples) */
		
		System.out.println("\n");
		
		int width = model.getWidth();
		System.out.print("  ");
		
		for (int i=0; i < width; ++i){
			System.out.print(i);
		}
		System.out.println("\n");
		
		for (int i=0; i < width; ++i){
			System.out.print(i + " ");
			for (int j=0; j < width; ++j){
				System.out.print(model.getMark(i,j));
			}
			System.out.print("\n");
		}
		
		
		
		

    }

    public void showNextMovePrompt() {
		
		System.out.print("\n" +  "Player (X) move:");
		System.out.print("Enter the row and column numbers, seperated by a space:");
		
			/*I could not get player O to print out*/
		
		
    }

    public void showInputError() {

        /* Display an error if input is invalid (see examples) */
		System.out.println("Your choice is not valid");
        /* INSERT YOUR CODE HERE */

    }

    public void showResult(String r) {

        /* Display final winner */
		
        System.out.println(r + "!");

    }
	
}