import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestMineSweeper {
	
	
	char[][] arr1 = new char[][] {
		{'*','.','.','.'},
		{'.','.','.','.'},
		{'.','*','.','.'},
		{'.','.','.','.'}
	};
	char[][] arr1Zero = new char[][] {
		{'0','0','0','0','0','0'},
		{'0','*','0','0','0','0'},
		{'0','0','0','0','0','0'},
		{'0','0','*','0','0','0'},
		{'0','0','0','0','0','0'},
		{'0','0','0','0','0','0'}
	};
	char[][] arr1Solution = new char[][] {
		{'1','1','1','0','0','0'},
		{'1','*','1','0','0','0'},
		{'1','2','2','1','0','0'},
		{'0','1','*','1','0','0'},
		{'0','1','1','1','0','0'},
		{'0','0','0','0','0','0'}
	};
	
	
	@Test
	void testSmallRowsAndCols() {
		Board b1 = new Board( 0, 0, Board.getTestBoard( 1, 1) );
		assertEquals( 3 , b1.numOfCols );
		assertEquals( 3, b1.numOfRows );
	}
	
	@Test
	void testLargeRowsAndCols() {
		Board b2 = new Board( 101, 101, Board.getTestBoard( 100, 100) );
		assertEquals( 102, b2.numOfCols );
		assertEquals( 102, b2.numOfRows );
	}
	
	@Test
	void testNormalRowsAndCols() {
		Board b2 = new Board( 4, 4, Board.getTestBoard( 4, 4) );
		assertEquals( 6, b2.numOfCols );
		assertEquals( 6, b2.numOfRows );
	}
	
	@Test
	void testHighBoard() {
		Board b = new Board( 1, 100, Board.getTestBoard(1, 100) );
		assertEquals( 102, b.numOfCols );
		assertEquals( 3, b.numOfRows );
	}
	
	@Test
	void testLongBoard() {
		Board b = new Board( 100, 1, Board.getTestBoard(100, 1) );
		assertEquals( 3, b.numOfCols );
		assertEquals( 102, b.numOfRows );
	}
	
	@Test
	void testSolution() {
		Board b = new Board( 4, 4, arr1 );
		assertArrayEquals( arr1Solution, b.solution );
	}
	
	@Test
	void testZeroBoard() {
		Board b = new Board( 4, 4, arr1 );
		assertArrayEquals( arr1Zero , b.zeroBoard() );
	}
	
	@Test
	void testArrayCopy() {
		Board b = new Board( 4, 4, arr1 );
		assertArrayEquals( arr1 , b.copyArray(arr1) );
	}

}
