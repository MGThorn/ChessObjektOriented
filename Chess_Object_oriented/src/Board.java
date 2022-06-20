

public class Board {
	
	private Piece [] [] squares = new Piece[8][8];
	final String standartFen = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";
	private Calculator calc;
	private boolean whiteTurn=true;
	
	public Board() {
		squares=Util.fenToBoard(standartFen);
	}
	
	public Calculator getCalc() {
		return calc;
	}

	public void setCalc(Calculator calc) {
		this.calc = calc;
	}

	public void restart(){
		squares=Util.fenToBoard(standartFen);
	}
	public void restart(String Fen) {
		squares=Util.fenToBoard(Fen);
	}
	
	public Piece[][] getSquares() {
		return squares;
	}

	public void setSquares(Piece[][] squares) {
		this.squares = squares;
	}
	
	/*public void setSquare(Piece pice,int row, int column) {
		this.squares;
	}*/
	public void markMoves(int row,int column) {
		demarkAllMoves();
		calc.divideSudoLegalMoves(row, column);
	}
	public void demarkAllMoves() {
		for(int i=0;i<=7;i++) {
			for(int j=0;j<=7;j++) {
				squares[i][j].setMarked(false);
			}
		}
	}
	
	public void switchMarkVis(boolean visible) {
		for(int i=0;i<=7;i++) {
			for(int j=0;j<=7;j++) {
				if(squares[i][j].isMarked()||squares[i][j].isInvisMarked()) {
					squares[i][j].setInvisMarked(!visible);
					squares[i][j].setMarked(visible);
				}
					
			}
		}
	}
	

	
	public void moving(int oldRow,int oldColumn, int newRow, int newColumn) {
		if(squares[newRow][newColumn].isMarked()) {
			squares[newRow][newColumn]= new Piece(squares[oldRow][oldColumn].getType(),squares[oldRow][oldColumn].isColor());
			//squares[newRow][newColumn]=squares[oldRow][oldColumn];
			squares[oldRow][oldColumn]= new Piece("null");
			demarkAllMoves();
			whiteTurn=!whiteTurn;
		}
	}
	public void getKingColumn(boolean color) {
		for(int i=0;i<=7;i++) {
			for(int j=0;j<=7;j++) {
				if(squares[i][j].isColor()&&squares[i][j].getType()=="King") {
					
				}
					
			}
		}
	}
	public int getKingRow(boolean color) {
		for(int i=0;i<=7;i++) {
			for(int j=0;j<=7;j++) {
				if(squares[i][j].isColor()&&squares[i][j].getType()=="King") {
					return i;
				}else {
					return -1;
				}
					
			}
		}
	}

	public boolean isWhitesTurn() {
		return whiteTurn;
	}

	public void setWhitesTurn(boolean white) {
		this.whiteTurn = white;
	}
	

}

