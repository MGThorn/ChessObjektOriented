

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
		this.whiteTurn=true;
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
		if(whiteTurn==squares[row][column].isColor()) {
			if(calc.checkingMove()) {
				calc.divideSudoLegalMoves(row, column);	
				demarkAllInvisMoves();
			}else {
				System.out.println("illigal move");
				calc.calculateMovesWhileInCheck(getKingRow(whiteTurn),getKingColumn(whiteTurn));
			}
		}else {
			System.out.println("wrong Color");
		}
	}
	public void demarkAllMoves() {
		for(int i=0;i<=7;i++) {
			for(int j=0;j<=7;j++) {
				squares[i][j].setMarked(false);
			}
		}
	}
	public void demarkAllInvisMoves() {
		for(int i=0;i<=7;i++) {
			for(int j=0;j<=7;j++) {
				squares[i][j].setInvisMarked(false);
			}
		}
	}
	public void demarkAllsimularMarkedSqares() {
		for(int i=0;i<=7;i++) {
			for(int j=0;j<=7;j++) {
				if(squares[i][j].isMarked()==squares[i][j].isInvisMarked()) {
					squares[i][j].setMarked(false);
				}
			}
		}
	}
	
	public void switchMarkVis(boolean visible) {
		System.out.println("-----------switchMarkVis-----------------");
		for(int i=0;i<=7;i++) {
			for(int j=0;j<=7;j++) {
				if(squares[i][j].isMarked()||squares[i][j].isInvisMarked()) {
					squares[i][j].setInvisMarked(!visible);
					//is rigth but --> not triggered by checkingMove /alegitly bc no piece is Marked?
					//bugFixes: System.out.println(squares[i][j].getType()+" at row "+i+" column "+j+" marked visible"+!visible);
					squares[i][j].setMarked(visible);
				}
					
			}
		}
	}
	public void printMarkedSquares() {
		for(int i=0;i<=7;i++) {
			for(int j=0;j<=7;j++) {
				if(squares[i][j].isMarked()) {
					System.out.println("Piece "+squares[i][j].getType()+" at "+i+j+" is marked");
				}else {
					System.out.println("Piece "+squares[i][j].getType()+" at "+i+j+" is NOT marked");
				}
				if(squares[i][j].isInvisMarked()) {
					System.out.println("Piece "+squares[i][j].getType()+" at "+i+j+" is invis marked");
				}else {
					System.out.println("Piece "+squares[i][j].getType()+" at "+i+j+" is NOT invis marked");
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
	public int getKingColumn(boolean color) {
		for(int i=0;i<=7;i++) {
			for(int j=0;j<=7;j++) {
				if(squares[i][j].isColor()==color&&squares[i][j].getType()=="King") {
					int J =j;
					return J;				
				}
			}
		}return -1;
	}
	public int getKingRow(boolean color) {
		for(int i=0;i<=7;i++) {
			for(int j=0;j<=7;j++) {
				if(squares[i][j].isColor()==color&&squares[i][j].getType()=="King") {
					int I =i;
					return I;				
				}
			}
		}return -1;
	}

	public boolean isWhitesTurn() {
		return whiteTurn;
	}

	public void setWhitesTurn(boolean white) {
		this.whiteTurn = white;
	}
	

}

