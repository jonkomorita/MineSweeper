
/**
 * Jonathyn Komorita
 * CSCD 350
 * Board class that handles most of the basic functionality for a MineSweeper game
 */
public class Board {
		
		char[][] board;
		char[][] solution;
		int numOfRows;
		int numOfCols;
		
		Board( int rows, int cols, char[][] bombs ) {
			this.numOfRows = checkColsRows(rows);
			this.numOfCols = checkColsRows(cols);
			this.board = populateBoard( bombs );
			this.solution = solveBoard();
		}
		
		private int checkColsRows( int number ) {
			if( number < 1 ) {
				number = 1;
			}
			else if( number > 100) {
				number = 100;
			}
			return number;
		}
		
		
		private char[][] populateBoard( char[][] bombs ) {
			numOfRows += 2;
			numOfCols += 2;
			char[][] retboard = new char[numOfRows][numOfCols];
			retboard = setEmptyRow( retboard, 0);
			retboard = setEmptyRow( retboard, numOfRows - 1 );
			retboard = setEmptyCol( retboard, 0 );
			retboard = setEmptyCol( retboard, numOfCols - 1 );
			for( int i = 1; i < numOfRows - 1; i++ ) {
				char[] line = bombs[i-1];
				for( int j = 1; j < numOfCols - 1; j++ ) {
					retboard[i][j] = line[j-1];
				}
			}
			return retboard;
		}// end setBombs
		
		private char[][] setEmptyRow( char[][] board, int row ) {
			for( int i = 0; i < board[0].length; i++ ) {
				board[row][i] = '.';
			}
			return board;
		}
		
		private char[][] setEmptyCol( char[][] board, int col ){
			for( int i = 0; i < board.length; i++ ) {
				board[i][col] = '.'; 
			}
			return board;
		}
		
		private char[][] solveBoard() {
			char[][] solution = zeroBoard();
			
			for( int i = 0; i < numOfRows; i++ ) {
				for( int j = 0; j < numOfCols; j++ ) {
					if( solution[i][j] == '*' ) {

						solution[i-1][j-1] = iterateCell( solution[i-1][j-1] ); 
						solution[i][j-1] = iterateCell( solution[i][j-1] ); 
						solution[i+1][j-1] = iterateCell( solution[i+1][j-1] ); 
						
						solution[i-1][j] = iterateCell( solution[i-1][j] ); 
						solution[i+1][j] = iterateCell( solution[i+1][j] ); 
						
						solution[i-1][j+1] = iterateCell(solution[i-1][j+1]); 
						solution[i][j+1] = iterateCell(solution[i][j+1]);     
						solution[i+1][j+1] = iterateCell(solution[i+1][j+1]); 
						
					}
				}
			}
			
			return solution;
		}// end solveBoard
		
		public char iterateCell( char cell ) {
			int number;
			char ret;
			if( cell != '*' ) {
				number = Character.getNumericValue(cell);
				number += 1;
				ret = Character.forDigit(number, 10);
			}
			else {
				ret = cell;
			}
			return ret;
		}// end iterateCell
		
		public char[][] zeroBoard(){
			solution = copyArray(board);
			for( int i = 0; i < numOfRows; i++ ) {
				for( int j = 0; j < numOfCols; j++ ) {
					if( solution[i][j] != '*' ) {
						solution[i][j] = '0';
					}
				}
			}
			return solution;
		}// end zeroBoard
		
		public char[][] copyArray( char[][] arr ){
			char[][] copy = new char[arr.length][arr[0].length];
			for( int i = 0; i < arr.length; i++ ) {
				for( int j = 0; j < arr[0].length; j++ ) {
					copy[i][j] = arr[i][j];
				}
			}
			return copy;
		}// end copyArry
		
		public void printBoard( int option ) {
			char[][] pBoard;
			if( option == 0 ) {
				pBoard = copyArray( board );
			}else {
				pBoard = copyArray( solution );
			}
			for( int i = 1; i < numOfRows-1; i++ ) {
				for( int j = 1; j < numOfCols-1; j++ ) {
					System.out.print(pBoard[i][j]);
					if( j == numOfCols - 2 ) {
						System.out.print('\n');
					}
				}
			}
		}// end printBoard
		
		public static char[][] getTestBoard( int rows, int cols ){
			char[][] arr = new char[rows][cols];
			for( int i = 0; i < rows; i++ ) {
				for( int j = 0; j < cols; j++ ) {
					if( j % 5 == 0 ) {
						arr[i][j] = '*';
					}
					else {
						arr[i][j] = '.';
					}
				}
			}
			return arr;
		}
		
	}// end Board Class
