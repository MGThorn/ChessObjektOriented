
public class Calculator {
	Board board;
	
	Calculator(Board board){
		this.board = board;
	}
	
	public void calculateAllSudoLegalMoves(boolean color) {
		for(int i=0;i<=7;i++) {
			for(int j=0;j<=7;j++) {
				if(color==board.getSquares()[i][j].isColor()) {
					divideSudoLegalMoves(i,j);
				}
			}
		}
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
		if(board.isWhitesTurn()==board.getSquares()[pieceRow][pieceColumn].isColor()) {
			int temp=-1;
			int temp2=-2;
			if(board.getSquares()[pieceRow][pieceColumn].isColor()) {
				if(pieceRow+temp>=0&&pieceColumn+temp2>=0&&!board.getSquares()[pieceRow+temp][pieceColumn+temp2].isColor()) {
					board.getSquares()[pieceRow+temp][pieceColumn+temp2].setMarked(true);
				}
				temp=1;				
				if(pieceRow+temp<=7&&pieceColumn+temp2>=0&&!board.getSquares()[pieceRow+temp][pieceColumn+temp2].isColor()) {
					board.getSquares()[pieceRow+temp][pieceColumn+temp2].setMarked(true);
				}	
				temp=2;
				temp2=-1;
				if(pieceRow+temp<=7&&pieceColumn+temp2>=0&&!board.getSquares()[pieceRow+temp][pieceColumn+temp2].isColor()) {
					board.getSquares()[pieceRow+temp][pieceColumn+temp2].setMarked(true);
				}	
				temp2=1;				
				if(pieceRow+temp<=7&&pieceColumn+temp2<=7&&!board.getSquares()[pieceRow+temp][pieceColumn+temp2].isColor()) {
					board.getSquares()[pieceRow+temp][pieceColumn+temp2].setMarked(true);
				}	
				temp2=2;
				temp=1;
				if(pieceRow+temp<=7&&pieceColumn+temp2<=7&&!board.getSquares()[pieceRow+temp][pieceColumn+temp2].isColor()) {
					board.getSquares()[pieceRow+temp][pieceColumn+temp2].setMarked(true);
				}	
				temp=-1;				
				if(pieceRow+temp>=0&&pieceColumn+temp2<=7&&!board.getSquares()[pieceRow+temp][pieceColumn+temp2].isColor()) {
					board.getSquares()[pieceRow+temp][pieceColumn+temp2].setMarked(true);
				}
				temp=-2;
				temp2=1;
				if(pieceRow+temp>=0&&pieceColumn+temp2<=7&&!board.getSquares()[pieceRow+temp][pieceColumn+temp2].isColor()) {
					board.getSquares()[pieceRow+temp][pieceColumn+temp2].setMarked(true);
				}
				temp2=-1;				
				if(pieceRow+temp>=0&&pieceColumn+temp2>=0&&!board.getSquares()[pieceRow+temp][pieceColumn+temp2].isColor()) {
					board.getSquares()[pieceRow+temp][pieceColumn+temp2].setMarked(true);
				}	
			}else {
				if(pieceRow+temp>=0&&pieceColumn+temp2>=0&&(board.getSquares()[pieceRow+temp][pieceColumn+temp2].isColor()||board.getSquares()[pieceRow+temp][pieceColumn+temp2].getType()=="null")) {
					board.getSquares()[pieceRow+temp][pieceColumn+temp2].setMarked(true);
				}
				temp=1;				
				if(pieceRow+temp<=7&&pieceColumn+temp2>=0&&(board.getSquares()[pieceRow+temp][pieceColumn+temp2].isColor()||board.getSquares()[pieceRow+temp][pieceColumn+temp2].getType()=="null")) {
					board.getSquares()[pieceRow+temp][pieceColumn+temp2].setMarked(true);
				}	
				temp=2;
				temp2=-1;
				if(pieceRow+temp<=7&&pieceColumn+temp2>=0&&(board.getSquares()[pieceRow+temp][pieceColumn+temp2].isColor()||board.getSquares()[pieceRow+temp][pieceColumn+temp2].getType()=="null")) {
					board.getSquares()[pieceRow+temp][pieceColumn+temp2].setMarked(true);
				}	
				temp2=1;				
				if(pieceRow+temp<=7&&pieceColumn+temp2<=7&&(board.getSquares()[pieceRow+temp][pieceColumn+temp2].isColor()||board.getSquares()[pieceRow+temp][pieceColumn+temp2].getType()=="null")) {
					board.getSquares()[pieceRow+temp][pieceColumn+temp2].setMarked(true);
				}	
				temp2=2;
				temp=1;
				if(pieceRow+temp<=7&&pieceColumn+temp2<=7&&(board.getSquares()[pieceRow+temp][pieceColumn+temp2].isColor()||board.getSquares()[pieceRow+temp][pieceColumn+temp2].getType()=="null")) {
					board.getSquares()[pieceRow+temp][pieceColumn+temp2].setMarked(true);
				}	
				temp=-1;				
				if(pieceRow+temp>=0&&pieceColumn+temp2<=7&&(board.getSquares()[pieceRow+temp][pieceColumn+temp2].isColor()||board.getSquares()[pieceRow+temp][pieceColumn+temp2].getType()=="null")) {
					board.getSquares()[pieceRow+temp][pieceColumn+temp2].setMarked(true);
				}
				temp=-2;
				temp2=1;
				if(pieceRow+temp>=0&&pieceColumn+temp2<=7&&(board.getSquares()[pieceRow+temp][pieceColumn+temp2].isColor()||board.getSquares()[pieceRow+temp][pieceColumn+temp2].getType()=="null")) {
					board.getSquares()[pieceRow+temp][pieceColumn+temp2].setMarked(true);
				}
				temp2=-1;				
				if(pieceRow+temp>=0&&pieceColumn+temp2>=0&&(board.getSquares()[pieceRow+temp][pieceColumn+temp2].isColor()||board.getSquares()[pieceRow+temp][pieceColumn+temp2].getType()=="null")) {
					board.getSquares()[pieceRow+temp][pieceColumn+temp2].setMarked(true);
				}
				
			}
		}
	}
	
	public void markBishop(int pieceRow, int pieceColumn) {
		if(board.isWhitesTurn()==board.getSquares()[pieceRow][pieceColumn].isColor()&&board.getSquares()[pieceRow][pieceColumn].isColor()==true) {
    		
			//up left
			int temp=-1;
    		int temp2=-1;
			while(pieceRow+temp>=0&&pieceColumn+temp2>=0) {
				if(board.getSquares()[pieceRow+temp][pieceColumn+temp2].getType()=="null") {
					board.getSquares()[pieceRow+temp][pieceColumn+temp2].setMarked(true);
					temp--;
					temp2--;
				}else {
					if(!board.getSquares()[pieceRow+temp][pieceColumn+temp2].isColor()) {
						board.getSquares()[pieceRow+temp][pieceColumn+temp2].setMarked(true);
					}
					break;
				}
				
			}
			//down left
			temp=-1;
			temp2=1;
			while(pieceRow+temp>=0&&pieceColumn+temp2<=7) {
				if(board.getSquares()[pieceRow+temp][pieceColumn+temp2].getType()=="null") {
					board.getSquares()[pieceRow+temp][pieceColumn+temp2].setMarked(true);
					temp--;
					temp2++;
				}else {
					if(!board.getSquares()[pieceRow+temp][pieceColumn+temp2].isColor()) {
						board.getSquares()[pieceRow+temp][pieceColumn+temp2].setMarked(true);
					}
					break;
				}
				
			}
			//up right
			temp=1;
			temp2=-1;
			while(pieceRow+temp<=7&&pieceColumn+temp2>=0) {
				if(board.getSquares()[pieceRow+temp][pieceColumn+temp2].getType()=="null") {
					board.getSquares()[pieceRow+temp][pieceColumn+temp2].setMarked(true);
					temp++;
					temp2--;
				}else {
					if(!board.getSquares()[pieceRow+temp][pieceColumn+temp2].isColor()) {
						board.getSquares()[pieceRow+temp][pieceColumn+temp2].setMarked(true);
					}
					break;
				}
				
			}
			//down right
			temp=1;
			temp2=1;
			while(pieceRow+temp<=7&&pieceColumn+temp2<=7) {
				if(board.getSquares()[pieceRow+temp][pieceColumn+temp2].getType()=="null") {
					board.getSquares()[pieceRow+temp][pieceColumn+temp2].setMarked(true);
					temp++;
					temp2++;
				}else {
					if(!board.getSquares()[pieceRow+temp][pieceColumn+temp2].isColor()) {
						board.getSquares()[pieceRow+temp][pieceColumn+temp2].setMarked(true);
					}
					break;
				}
				
			}
		}
		if(board.isWhitesTurn()==board.getSquares()[pieceRow][pieceColumn].isColor()&&board.getSquares()[pieceRow][pieceColumn].isColor()==false) {
			
			//up left
			int temp=-1;
    		int temp2=-1;
			while(pieceRow+temp>=0&&pieceColumn+temp2>=0) {
				if(board.getSquares()[pieceRow+temp][pieceColumn+temp2].getType()=="null") {
					board.getSquares()[pieceRow+temp][pieceColumn+temp2].setMarked(true);
					temp--;
					temp2--;
				}else {
					if(board.getSquares()[pieceRow+temp][pieceColumn+temp2].isColor()) {
						board.getSquares()[pieceRow+temp][pieceColumn+temp2].setMarked(true);
					}
					break;
				}
				
			}
			//down left
			temp=-1;
			temp2=1;
			while(pieceRow+temp>=0&&pieceColumn+temp2<=7) {
				if(board.getSquares()[pieceRow+temp][pieceColumn+temp2].getType()=="null") {
					board.getSquares()[pieceRow+temp][pieceColumn+temp2].setMarked(true);
					temp--;
					temp2++;
				}else {
					if(board.getSquares()[pieceRow+temp][pieceColumn+temp2].isColor()) {
						board.getSquares()[pieceRow+temp][pieceColumn+temp2].setMarked(true);
					}
					break;
				}
				
			}
			//up right
			temp=1;
			temp2=-1;
			while(pieceRow+temp<=7&&pieceColumn+temp2>=0) {
				if(board.getSquares()[pieceRow+temp][pieceColumn+temp2].getType()=="null") {
					board.getSquares()[pieceRow+temp][pieceColumn+temp2].setMarked(true);
					temp++;
					temp2--;
				}else {
					if(board.getSquares()[pieceRow+temp][pieceColumn+temp2].isColor()) {
						board.getSquares()[pieceRow+temp][pieceColumn+temp2].setMarked(true);
					}
					break;
				}
				
			}
			//down right
			temp=1;
			temp2=1;
			while(pieceRow+temp<=7&&pieceColumn+temp2<=7) {
				if(board.getSquares()[pieceRow+temp][pieceColumn+temp2].getType()=="null") {
					board.getSquares()[pieceRow+temp][pieceColumn+temp2].setMarked(true);
					temp++;
					temp2++;
				}else {
					if(board.getSquares()[pieceRow+temp][pieceColumn+temp2].isColor()) {
						board.getSquares()[pieceRow+temp][pieceColumn+temp2].setMarked(true);
					}
					break;
				}
				
			}
			
		}
	}
	
	public void markRook(int pieceRow, int pieceColumn) {
	if(board.isWhitesTurn()==board.getSquares()[pieceRow][pieceColumn].isColor()&&board.getSquares()[pieceRow][pieceColumn].isColor()==true) {
	    		
				//up 
				int temp=-1;
				while(pieceRow+temp>=0) {
					if(board.getSquares()[pieceRow+temp][pieceColumn].getType()=="null") {
						board.getSquares()[pieceRow+temp][pieceColumn].setMarked(true);
						temp--;
					}else {
						if(!board.getSquares()[pieceRow+temp][pieceColumn].isColor()) {
							board.getSquares()[pieceRow+temp][pieceColumn].setMarked(true);
						}
						break;
					}
					
				}
				//down
				temp=1;
				while(pieceRow+temp<=7) {
					if(board.getSquares()[pieceRow+temp][pieceColumn].getType()=="null") {
						board.getSquares()[pieceRow+temp][pieceColumn].setMarked(true);
						temp++;
					}else {
						if(!board.getSquares()[pieceRow+temp][pieceColumn].isColor()) {
							board.getSquares()[pieceRow+temp][pieceColumn].setMarked(true);
						}
						break;
					}
					
				}
				//left
				temp=-1;
				while(pieceColumn+temp>=0) {
					if(board.getSquares()[pieceRow][pieceColumn+temp].getType()=="null") {
						board.getSquares()[pieceRow][pieceColumn+temp].setMarked(true);
						temp--;
					}else {
						if(!board.getSquares()[pieceRow][pieceColumn+temp].isColor()) {
							board.getSquares()[pieceRow][pieceColumn+temp].setMarked(true);
						}
						break;
					}
					
				}
				//right
				temp=1;
				while(pieceColumn+temp<=7) {
					if(board.getSquares()[pieceRow][pieceColumn+temp].getType()=="null") {
						board.getSquares()[pieceRow][pieceColumn+temp].setMarked(true);
						temp++;
					}else {
						if(!board.getSquares()[pieceRow][pieceColumn+temp].isColor()) {
							board.getSquares()[pieceRow][pieceColumn+temp].setMarked(true);
						}
						break;
					}
					
				}
			}
			if(board.isWhitesTurn()==board.getSquares()[pieceRow][pieceColumn].isColor()&&board.getSquares()[pieceRow][pieceColumn].isColor()==false) {
	    		
				//up 
				int temp=-1;
				while(pieceRow+temp>=0) {
					if(board.getSquares()[pieceRow+temp][pieceColumn].getType()=="null") {
						board.getSquares()[pieceRow+temp][pieceColumn].setMarked(true);
						temp--;
					}else {
						if(board.getSquares()[pieceRow+temp][pieceColumn].isColor()) {
							board.getSquares()[pieceRow+temp][pieceColumn].setMarked(true);
						}
						break;
					}
					
				}
				//down left
				temp=1;
				while(pieceRow+temp<=7) {
					if(board.getSquares()[pieceRow+temp][pieceColumn].getType()=="null") {
						board.getSquares()[pieceRow+temp][pieceColumn].setMarked(true);
						temp++;
					}else {
						if(board.getSquares()[pieceRow+temp][pieceColumn].isColor()) {
							board.getSquares()[pieceRow+temp][pieceColumn].setMarked(true);
						}
						break;
					}
					
				}
				//up right
				temp=-1;
				while(pieceColumn+temp>=0) {
					if(board.getSquares()[pieceRow][pieceColumn+temp].getType()=="null") {
						board.getSquares()[pieceRow][pieceColumn+temp].setMarked(true);
						temp--;
					}else {
						if(board.getSquares()[pieceRow][pieceColumn+temp].isColor()) {
							board.getSquares()[pieceRow][pieceColumn+temp].setMarked(true);
						}
						break;
					}
					
				}
				//down right
				temp=1;
				while(pieceColumn+temp<=7) {
					if(board.getSquares()[pieceRow][pieceColumn+temp].getType()=="null") {
						board.getSquares()[pieceRow][pieceColumn+temp].setMarked(true);
						temp++;
					}else {
						if(board.getSquares()[pieceRow][pieceColumn+temp].isColor()) {
							board.getSquares()[pieceRow][pieceColumn+temp].setMarked(true);
						}
						break;
					}
					
				}
			}
	}
		
	public void markKing(int pieceRow, int pieceColumn) {
		if(board.isWhitesTurn()==board.getSquares()[pieceRow][pieceColumn].isColor()) {
			int temp=-1;
			int temp2=-1;
			if(board.getSquares()[pieceRow][pieceColumn].isColor()) {
				if(pieceRow+temp>=0&&pieceColumn+temp2>=0&&!board.getSquares()[pieceRow+temp][pieceColumn+temp2].isColor()) {
					board.getSquares()[pieceRow+temp][pieceColumn+temp2].setMarked(true);
				}
				temp=0;				
				if(pieceRow+temp>=0&&pieceColumn+temp2>=0&&!board.getSquares()[pieceRow+temp][pieceColumn+temp2].isColor()) {
					board.getSquares()[pieceRow+temp][pieceColumn+temp2].setMarked(true);
				}	
				temp=1;				
				if(pieceRow+temp<=7&&pieceColumn+temp2>=0&&!board.getSquares()[pieceRow+temp][pieceColumn+temp2].isColor()) {
					board.getSquares()[pieceRow+temp][pieceColumn+temp2].setMarked(true);
				}	
				temp2=0;				
				if(pieceRow+temp<=7&&pieceColumn+temp2>=0&&!board.getSquares()[pieceRow+temp][pieceColumn+temp2].isColor()) {
					board.getSquares()[pieceRow+temp][pieceColumn+temp2].setMarked(true);
				}	
				temp2=1;				
				if(pieceRow+temp<=7&&pieceColumn+temp2<=7&&!board.getSquares()[pieceRow+temp][pieceColumn+temp2].isColor()) {
					board.getSquares()[pieceRow+temp][pieceColumn+temp2].setMarked(true);
				}	
				temp=0;				
				if(pieceRow+temp<=7&&pieceColumn+temp2<=7&&!board.getSquares()[pieceRow+temp][pieceColumn+temp2].isColor()) {
					board.getSquares()[pieceRow+temp][pieceColumn+temp2].setMarked(true);
				}
				temp=-1;				
				if(pieceRow+temp>=0&&pieceColumn+temp2<=7&&!board.getSquares()[pieceRow+temp][pieceColumn+temp2].isColor()) {
					board.getSquares()[pieceRow+temp][pieceColumn+temp2].setMarked(true);
				}
				temp2=0;				
				if(pieceRow+temp>=0&&pieceColumn+temp2<=7&&!board.getSquares()[pieceRow+temp][pieceColumn+temp2].isColor()) {
					board.getSquares()[pieceRow+temp][pieceColumn+temp2].setMarked(true);
				}	
			}else {
				if(pieceRow+temp>=0&&pieceColumn+temp2>=0&&(board.getSquares()[pieceRow+temp][pieceColumn+temp2].isColor()||board.getSquares()[pieceRow+temp][pieceColumn+temp2].getType()=="null")) {
					board.getSquares()[pieceRow+temp][pieceColumn+temp2].setMarked(true);
				}
				temp=0;				
				if(pieceRow+temp>=0&&pieceColumn+temp2>=0&&(board.getSquares()[pieceRow+temp][pieceColumn+temp2].isColor()||board.getSquares()[pieceRow+temp][pieceColumn+temp2].getType()=="null"))  {
					board.getSquares()[pieceRow+temp][pieceColumn+temp2].setMarked(true);
				}	
				temp=1;				
				if(pieceRow+temp<=7&&pieceColumn+temp2>=0&&(board.getSquares()[pieceRow+temp][pieceColumn+temp2].isColor()||board.getSquares()[pieceRow+temp][pieceColumn+temp2].getType()=="null"))  {
					board.getSquares()[pieceRow+temp][pieceColumn+temp2].setMarked(true);
				}	
				temp2=0;				
				if(pieceRow+temp<=7&&pieceColumn+temp2>=0&&(board.getSquares()[pieceRow+temp][pieceColumn+temp2].isColor()||board.getSquares()[pieceRow+temp][pieceColumn+temp2].getType()=="null"))  {
					board.getSquares()[pieceRow+temp][pieceColumn+temp2].setMarked(true);
				}	
				temp2=1;				
				if(pieceRow+temp<=7&&pieceColumn+temp2<=7&&(board.getSquares()[pieceRow+temp][pieceColumn+temp2].isColor()||board.getSquares()[pieceRow+temp][pieceColumn+temp2].getType()=="null"))  {
					board.getSquares()[pieceRow+temp][pieceColumn+temp2].setMarked(true);
				}	
				temp=0;				
				if(pieceRow+temp<=7&&pieceColumn+temp2<=7&&(board.getSquares()[pieceRow+temp][pieceColumn+temp2].isColor()||board.getSquares()[pieceRow+temp][pieceColumn+temp2].getType()=="null"))  {
					board.getSquares()[pieceRow+temp][pieceColumn+temp2].setMarked(true);
				}
				temp=-1;				
				if(pieceRow+temp>=0&&pieceColumn+temp2<=7&&(board.getSquares()[pieceRow+temp][pieceColumn+temp2].isColor()||board.getSquares()[pieceRow+temp][pieceColumn+temp2].getType()=="null"))  {
					board.getSquares()[pieceRow+temp][pieceColumn+temp2].setMarked(true);
				}
				temp2=0;				
				if(pieceRow+temp>=0&&pieceColumn+temp2<=7&&(board.getSquares()[pieceRow+temp][pieceColumn+temp2].isColor()||board.getSquares()[pieceRow+temp][pieceColumn+temp2].getType()=="null"))  {
					board.getSquares()[pieceRow+temp][pieceColumn+temp2].setMarked(true);
				}
			}
		}
	}

	
	
	public boolean checkingMove() {
		calculateAllSudoLegalMoves(!board.isWhitesTurn());
		board.switchMarkVis(false);
		if()
			//TODO finish
		return true;
	}
	

}
