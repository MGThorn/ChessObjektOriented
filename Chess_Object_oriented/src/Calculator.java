
public class Calculator {
	Board board;
	
	Calculator(Board board){
		this.board = board;
	}
	
	public void calculateAllSudoLegalMoves(boolean color) {
		
	}
	public void divideSudoLegalMoves(int pieceRow, int pieceColumn) {
		if(board.getSquares()[pieceRow][pieceColumn].getType()=="Pawn") {
			markPawn(pieceRow,pieceColumn);
		}else if(board.getSquares()[pieceRow][pieceColumn].getType()=="Night") {
			markNight(pieceRow,pieceColumn);
			
		}else if(board.getSquares()[pieceRow][pieceColumn].getType()=="Bishop") {
			markBishop(pieceRow,pieceColumn);
			
		}else if(board.getSquares()[pieceRow][pieceColumn].getType()=="Rook") {
			markRook(pieceRow,pieceColumn);
			
		}else if(board.getSquares()[pieceRow][pieceColumn].getType()=="Queen") {
			markBishop(pieceRow,pieceColumn);
			markRook(pieceRow,pieceColumn);
			
		}else if(board.getSquares()[pieceRow][pieceColumn].getType()=="King") {
			markKing(pieceRow,pieceColumn);
		}else{
			System.out.println("no Piece selected");			
		}
	}

	public void markPawn(int pieceRow, int pieceColumn) {
		if(board.isWhitesTurn()==board.getSquares()[pieceRow][pieceColumn].isColor()&&board.getSquares()[pieceRow][pieceColumn].isColor()==true) {
    		if(pieceColumn-1>=0&&board.getSquares()[pieceRow][pieceColumn-1].getType()=="null") {
    			board.getSquares()[pieceRow][pieceColumn-1].setMarked(true);
    			//normal Pawn Move
    		}if(pieceColumn-2>=0&&board.getSquares()[pieceRow][pieceColumn-2].getType()=="null"&&pieceColumn==6&&board.getSquares()[pieceRow][pieceColumn-1].getType()=="null") {
    			board.getSquares()[pieceRow][pieceColumn-2].setMarked(true);
    			//first Pawn Move
    		}if(pieceRow+1<=7&&pieceColumn-1>=0&&board.getSquares()[pieceRow+1][pieceColumn-1].isColor()==false&&board.getSquares()[pieceRow+1][pieceColumn-1].getType()!="null") {
    			board.getSquares()[pieceRow+1][pieceColumn-1].setMarked(true);
    			//taking right
    		}if(pieceRow-1>=0&&pieceColumn-1>=0&&board.getSquares()[pieceRow-1][pieceColumn-1].isColor()==false&&board.getSquares()[pieceRow-1][pieceColumn-1].getType()!="null") {
    			board.getSquares()[pieceRow-1][pieceColumn-1].setMarked(true);
    			//taking left
    		}//TODO enpassant
		}
		if(board.isWhitesTurn()==board.getSquares()[pieceRow][pieceColumn].isColor()&&board.getSquares()[pieceRow][pieceColumn].isColor()==false) {
			if(pieceColumn+1<=7&&board.getSquares()[pieceRow][pieceColumn+1].getType()=="null") {
    			board.getSquares()[pieceRow][pieceColumn+1].setMarked(true);
    			//normal Pawn Move
    		}if(pieceColumn+2>=0&&board.getSquares()[pieceRow][pieceColumn+2].getType()=="null"&&pieceColumn==1&&board.getSquares()[pieceRow][pieceColumn+1].getType()=="null") {
    			board.getSquares()[pieceRow][pieceColumn+2].setMarked(true);
    			//first Pawn Move
    		}if(pieceRow-1>=0&&pieceColumn+1<=7&&board.getSquares()[pieceRow-1][pieceColumn+1].isColor()==true) {
    			board.getSquares()[pieceRow-1][pieceColumn+1].setMarked(true);
    			//taking right
    		}if(pieceRow+1<=7&&pieceColumn+1<=7&&board.getSquares()[pieceRow+1][pieceColumn+1].isColor()==true) {
    			board.getSquares()[pieceRow+1][pieceColumn+1].setMarked(true);
    			//taking left
    		}//TODO enpassant
			
		}
		
	}

	public void markNight(int pieceRow, int pieceColumn) {
		
	}
	
	public void markBishop(int pieceRow, int pieceColumn) {
		
	}
	
	public void markRook(int pieceRow, int pieceColumn) {
		
	}
	
	public void markKing(int pieceRow, int pieceColumn) {
		
	}

	
	
	public boolean checkingMove() {
		return true;
	}
	

}
