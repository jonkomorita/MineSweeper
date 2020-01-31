import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Jonathyn Komorita
 * CSCD 350
 * Driver for MineSweeper game
 * Will load the boards from the data.txt file, which contains a 4x4 and 3x5 board,
 * and then it will print the 'hints'
 */
public class Main {

	

	public static void main(String[] args) {

		Scanner in = new Scanner( System.in );
		int numOfRows = 0;
		int numOfCols = 0;
		char[][] bombs = null;
		File file = new File("C:\\Users\\Jon\\eclipse-workspace\\MineSweeper\\src\\data.txt");
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		    String line;
		    int count = 0;
		    while ((line = br.readLine()) != null) {
		       char[] input = line.toCharArray();
		       if( input[0] != '.' && input[0] != '*' ) {
			       numOfRows = Character.getNumericValue(input[0]);
			       numOfCols = Character.getNumericValue(input[2]);
			       if( numOfRows == 0 && numOfCols == 0 ) {
			    	   System.exit(0);
			       }
			       bombs = new char[numOfRows][numOfCols];
		       }
		       else {
		    	   for( int i = 0; i < numOfCols; i++ ) {
		    		   bombs[count][i] = input[i];
		    	   }
		    	   count++;
		    	   if( count == numOfRows ) {
		    		   Board b = new Board( numOfRows, numOfCols, bombs );
		    		   System.out.println("Solution: " + numOfRows + "x" + numOfCols );
		    		   b.printBoard(1);
		    		   count = 0;
		    	   }
		       }
		    }
		}
		catch( Exception e ) {
			e.printStackTrace();
		}
		
		
		in.close();

	}
	

	
	
}// end Main Class
