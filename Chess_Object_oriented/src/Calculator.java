
public class Calculator {
	Board b;
	private boolean inCheck;
	
	
	Calculator(Board board){
		this.b = board;
	}
	public boolean checkingMove(int row, int column) {
		System.out.println("------checkingMove-------");
		
		int kr = b.getKingRow(b.isWhitesTurn());
		int kc = b.getKingColumn(b.isWhitesTurn());
		
		calculateAllSudoLegalMoves(!b.isWhitesTurn());
		//bug fixes: board.printMarkedSquares();
		
		b.switchMarkVis(false);
		
		//bug fixes: board.printMarkedSquares();
		if(b.countCheckers()>1) {
			inCheck=true;
			//bug fixes: System.out.println(board.isWhitesTurn()+" King on row "+board.getKingRow(board.isWhitesTurn())+" on Column "+board.getKingColumn(board.isWhitesTurn())+" is in check");
			return false;
			
		}else if(kr==row&&kc==column&&b.countCheckers()==1){
			inCheck=true;
			return true;
		}else {
		
			inCheck=false;
			//bug fixes:System.out.println(board.isWhitesTurn()+" King on row "+board.getKingRow(board.isWhitesTurn())+" on Column "+board.getKingColumn(board.isWhitesTurn())+" is not in check");
			return true;
			
		}
		
	}
	public void calculateMovesWhileInCheck(int KingRow,int KingColumn) {
		/*b.demarkAllMoves();
		markKing(KingRow,KingColumn);
		System.out.println("-------calculateMovesWhileInCheck(for King)--------");
		b.printMarkedSquares();
		b.demarkAllsimularMarkedSqares();
		*/
		
	}
	public void calculateKingMovesWhileInCheck(int KingRow,int KingColumn) {
		System.out.println("-------calculateMovesWhileInCheck(for King)--------");
		b.printMarkedSquares();
		b.demarkAllsimularMarkedSqares();
		//b.demarkAllInvisMoves();
		
		
	}
	

	
	public void calculateAllSudoLegalMoves(boolean color) {
		for(int i=0;i<=7;i++) {
			for(int j=0;j<=7;j++) {
				if(color==b.getSquares()[i][j].isColor()&&b.getSquares()[i][j].getType()!="null") {
					divideSudoLegalMoves(i,j);
					//bug Fixes: System.out.println("calcAllSudoLegalMoves for "+color+" and Piece at "+i+j);
					
				}
			}
		}
	}
	public void divideSudoLegalMoves(int pieceRow, int pieceColumn) {
		if(b.getSquares()[pieceRow][pieceColumn].getType()=="Pawn") {
			markPawn(pieceRow,pieceColumn);
		}else if(b.getSquares()[pieceRow][pieceColumn].getType()=="Night") {
			markNight(pieceRow,pieceColumn);
			
		}else if(b.getSquares()[pieceRow][pieceColumn].getType()=="Bishop") {
			markBishop(pieceRow,pieceColumn);
			
		}else if(b.getSquares()[pieceRow][pieceColumn].getType()=="Rook") {
			markRook(pieceRow,pieceColumn);
			
		}else if(b.getSquares()[pieceRow][pieceColumn].getType()=="Queen") {
			markBishop(pieceRow,pieceColumn);
			markRook(pieceRow,pieceColumn);
			
		}else if(b.getSquares()[pieceRow][pieceColumn].getType()=="King") {
			markKing(pieceRow,pieceColumn);
		}else{
			System.out.println("Calculator Detects: no Piece selected");			
		}
	}

	public void markPawn(int pieceRow, int pieceColumn) {
		//boolean color = b.getSquares()[pieceRow][pieceColumn].isColor();
		if(b.getSquares()[pieceRow][pieceColumn].isColor()==true) {
    		if(pieceColumn-1>=0&&b.getSquares()[pieceRow][pieceColumn-1].getType()=="null") {
    			v
    			//normal Pawn Move
    		}if(pieceColumn-2>=0&&b.getSquares()[pieceRow][pieceColumn-2].getType()=="null"&&pieceColumn==6&&b.getSquares()[pieceRow][pieceColumn-1].getType()=="null") {
    			if (b.getSquares()[pieceRow][pieceColumn - 2].setMarked(true)) {
    				b.getSquares()[pieceRow][pieceColumn].setAChecker(true);
				}//first Pawn Move
    		}if(pieceRow+1<=7&&pieceColumn-1>=0&&b.getSquares()[pieceRow+1][pieceColumn-1].isColor()==false&&b.getSquares()[pieceRow+1][pieceColumn-1].getType()!="null") {
    			if (b.getSquares()[pieceRow+1][pieceColumn - 1].setMarked(true)) {
    				b.getSquares()[pieceRow][pieceColumn].setAChecker(true);
				}//taking right
    		}if(pieceRow-1>=0&&pieceColumn-1>=0&&b.getSquares()[pieceRow-1][pieceColumn-1].isColor()==false&&b.getSquares()[pieceRow-1][pieceColumn-1].getType()!="null") {
    			if (b.getSquares()[pieceRow-1][pieceColumn - 1].setMarked(true)) {
    				b.getSquares()[pieceRow][pieceColumn].setAChecker(true);
				}//taking left
    		}//TODO enpassant
		}
		if(b.getSquares()[pieceRow][pieceColumn].isColor()==false) {
			if(pieceColumn+1<=7&&b.getSquares()[pieceRow][pieceColumn+1].getType()=="null") {
    			b.getSquares()[pieceRow][pieceColumn+1].setMarked(true);
    			//normal Pawn Move
    		}if(pieceColumn+2>=0&&b.getSquares()[pieceRow][pieceColumn+2].getType()=="null"&&pieceColumn==1&&b.getSquares()[pieceRow][pieceColumn+1].getType()=="null") {
    			b.getSquares()[pieceRow][pieceColumn+2].setMarked(true);
    			//first Pawn Move
    		}if(pieceRow-1>=0&&pieceColumn+1<=7&&b.getSquares()[pieceRow-1][pieceColumn+1].isColor()==true) {
    			b.getSquares()[pieceRow-1][pieceColumn+1].setMarked(true);
    			//taking right
    		}if(pieceRow+1<=7&&pieceColumn+1<=7&&b.getSquares()[pieceRow+1][pieceColumn+1].isColor()==true) {
    			b.getSquares()[pieceRow+1][pieceColumn+1].setMarked(true);
    			//taking left
    		}//TODO enpassant
			
		}
		
	}

	public void markNight(int pieceRow, int pieceColumn) {
		int temp=-1;
		int temp2=-2;
		boolean color = b.getSquares()[pieceRow][pieceColumn].isColor();
		

		if(pieceRow+temp>=0&&pieceColumn+temp2>=0&&(color!=b.getSquares()[pieceRow+temp][pieceColumn+temp2].isColor()||b.getSquares()[pieceRow+temp][pieceColumn+temp2].getType()=="null")) {
			if (b.getSquares()[pieceRow+temp][pieceColumn+temp2].setMarked(true)) {
				b.getSquares()[pieceRow][pieceColumn].setAChecker(true);
			}
		}
		temp=1;				
		if(pieceRow+temp<=7&&pieceColumn+temp2>=0&&(color!=b.getSquares()[pieceRow+temp][pieceColumn+temp2].isColor()||b.getSquares()[pieceRow+temp][pieceColumn+temp2].getType()=="null")) {
			if (b.getSquares()[pieceRow+temp][pieceColumn+temp2].setMarked(true)) {
				b.getSquares()[pieceRow][pieceColumn].setAChecker(true);
			}
		}	
		temp=2;
		temp2=-1;
		if(pieceRow+temp<=7&&pieceColumn+temp2>=0&&(color!=b.getSquares()[pieceRow+temp][pieceColumn+temp2].isColor()||b.getSquares()[pieceRow+temp][pieceColumn+temp2].getType()=="null")) {
			if (b.getSquares()[pieceRow+temp][pieceColumn+temp2].setMarked(true)) {
				b.getSquares()[pieceRow][pieceColumn].setAChecker(true);
			}
		}	
		temp2=1;				
		if(pieceRow+temp<=7&&pieceColumn+temp2<=7&&(color!=b.getSquares()[pieceRow+temp][pieceColumn+temp2].isColor()||b.getSquares()[pieceRow+temp][pieceColumn+temp2].getType()=="null")) {
			if (b.getSquares()[pieceRow+temp][pieceColumn+temp2].setMarked(true)) {
				b.getSquares()[pieceRow][pieceColumn].setAChecker(true);
			}
		}	
		temp2=2;
		temp=1;
		if(pieceRow+temp<=7&&pieceColumn+temp2<=7&&(color!=b.getSquares()[pieceRow+temp][pieceColumn+temp2].isColor()||b.getSquares()[pieceRow+temp][pieceColumn+temp2].getType()=="null")) {
			if (b.getSquares()[pieceRow+temp][pieceColumn+temp2].setMarked(true)) {
				b.getSquares()[pieceRow][pieceColumn].setAChecker(true);
			}
		}	
		temp=-1;				
		if(pieceRow+temp>=0&&pieceColumn+temp2<=7&&(color!=b.getSquares()[pieceRow+temp][pieceColumn+temp2].isColor()||b.getSquares()[pieceRow+temp][pieceColumn+temp2].getType()=="null")) {
			if (b.getSquares()[pieceRow+temp][pieceColumn+temp2].setMarked(true)) {
				b.getSquares()[pieceRow][pieceColumn].setAChecker(true);
			}
		}
		temp=-2;
		temp2=1;
		if(pieceRow+temp>=0&&pieceColumn+temp2<=7&&(color!=b.getSquares()[pieceRow+temp][pieceColumn+temp2].isColor()||b.getSquares()[pieceRow+temp][pieceColumn+temp2].getType()=="null")) {
			if (b.getSquares()[pieceRow+temp][pieceColumn+temp2].setMarked(true)) {
				b.getSquares()[pieceRow][pieceColumn].setAChecker(true);
			}
		}
		temp2=-1;				
		if(pieceRow+temp>=0&&pieceColumn+temp2>=0&&(color!=b.getSquares()[pieceRow+temp][pieceColumn+temp2].isColor()||b.getSquares()[pieceRow+temp][pieceColumn+temp2].getType()=="null")) {
			if (b.getSquares()[pieceRow+temp][pieceColumn+temp2].setMarked(true)) {
				b.getSquares()[pieceRow][pieceColumn].setAChecker(true);
			}
		}	
			
		
	}
	
	public void markBishop(int pieceRow, int pieceColumn) {
		if(b.getSquares()[pieceRow][pieceColumn].isColor()==true) {
    		
			//up left
			int temp=-1;
    		int temp2=-1;
			while(pieceRow+temp>=0&&pieceColumn+temp2>=0) {
				if(b.getSquares()[pieceRow+temp][pieceColumn+temp2].getType()=="null") {
					b.getSquares()[pieceRow+temp][pieceColumn+temp2].setMarked(true);
					temp--;
					temp2--;
				}else {
					if(!b.getSquares()[pieceRow+temp][pieceColumn+temp2].isColor()) {
						b.getSquares()[pieceRow+temp][pieceColumn+temp2].setMarked(true);
					}
					break;
				}
				
			}
			//down left
			temp=-1;
			temp2=1;
			while(pieceRow+temp>=0&&pieceColumn+temp2<=7) {
				if(b.getSquares()[pieceRow+temp][pieceColumn+temp2].getType()=="null") {
					b.getSquares()[pieceRow+temp][pieceColumn+temp2].setMarked(true);
					temp--;
					temp2++;
				}else {
					if(!b.getSquares()[pieceRow+temp][pieceColumn+temp2].isColor()) {
						b.getSquares()[pieceRow+temp][pieceColumn+temp2].setMarked(true);
					}
					break;
				}
				
			}
			//up right
			temp=1;
			temp2=-1;
			while(pieceRow+temp<=7&&pieceColumn+temp2>=0) {
				if(b.getSquares()[pieceRow+temp][pieceColumn+temp2].getType()=="null") {
					b.getSquares()[pieceRow+temp][pieceColumn+temp2].setMarked(true);
					temp++;
					temp2--;
				}else {
					if(!b.getSquares()[pieceRow+temp][pieceColumn+temp2].isColor()) {
						b.getSquares()[pieceRow+temp][pieceColumn+temp2].setMarked(true);
					}
					break;
				}
				
			}
			//down right
			temp=1;
			temp2=1;
			while(pieceRow+temp<=7&&pieceColumn+temp2<=7) {
				if(b.getSquares()[pieceRow+temp][pieceColumn+temp2].getType()=="null") {
					b.getSquares()[pieceRow+temp][pieceColumn+temp2].setMarked(true);
					temp++;
					temp2++;
				}else {
					if(!b.getSquares()[pieceRow+temp][pieceColumn+temp2].isColor()) {
						b.getSquares()[pieceRow+temp][pieceColumn+temp2].setMarked(true);
					}
					break;
				}
				
			}
		}
		if(b.getSquares()[pieceRow][pieceColumn].isColor()==false) {
			
			//up left
			int temp=-1;
    		int temp2=-1;
			while(pieceRow+temp>=0&&pieceColumn+temp2>=0) {
				if(b.getSquares()[pieceRow+temp][pieceColumn+temp2].getType()=="null") {
					b.getSquares()[pieceRow+temp][pieceColumn+temp2].setMarked(true);
					temp--;
					temp2--;
				}else {
					if(b.getSquares()[pieceRow+temp][pieceColumn+temp2].isColor()) {
						b.getSquares()[pieceRow+temp][pieceColumn+temp2].setMarked(true);
					}
					break;
				}
				
			}
			//down left
			temp=-1;
			temp2=1;
			while(pieceRow+temp>=0&&pieceColumn+temp2<=7) {
				if(b.getSquares()[pieceRow+temp][pieceColumn+temp2].getType()=="null") {
					b.getSquares()[pieceRow+temp][pieceColumn+temp2].setMarked(true);
					temp--;
					temp2++;
				}else {
					if(b.getSquares()[pieceRow+temp][pieceColumn+temp2].isColor()) {
						b.getSquares()[pieceRow+temp][pieceColumn+temp2].setMarked(true);
					}
					break;
				}
				
			}
			//up right
			temp=1;
			temp2=-1;
			while(pieceRow+temp<=7&&pieceColumn+temp2>=0) {
				if(b.getSquares()[pieceRow+temp][pieceColumn+temp2].getType()=="null") {
					b.getSquares()[pieceRow+temp][pieceColumn+temp2].setMarked(true);
					temp++;
					temp2--;
				}else {
					if(b.getSquares()[pieceRow+temp][pieceColumn+temp2].isColor()) {
						b.getSquares()[pieceRow+temp][pieceColumn+temp2].setMarked(true);
					}
					break;
				}
				
			}
			//down right
			temp=1;
			temp2=1;
			while(pieceRow+temp<=7&&pieceColumn+temp2<=7) {
				if(b.getSquares()[pieceRow+temp][pieceColumn+temp2].getType()=="null") {
					b.getSquares()[pieceRow+temp][pieceColumn+temp2].setMarked(true);
					temp++;
					temp2++;
				}else {
					if(b.getSquares()[pieceRow+temp][pieceColumn+temp2].isColor()) {
						b.getSquares()[pieceRow+temp][pieceColumn+temp2].setMarked(true);
					}
					break;
				}
				
			}
			
		}
	}
	
	public void markRook(int pieceRow, int pieceColumn) {
	if(b.getSquares()[pieceRow][pieceColumn].isColor()==true) {
	    		
				//up 
				int temp=-1;
				while(pieceRow+temp>=0) {
					if(b.getSquares()[pieceRow+temp][pieceColumn].getType()=="null") {
						b.getSquares()[pieceRow+temp][pieceColumn].setMarked(true);
						temp--;
					}else {
						if(!b.getSquares()[pieceRow+temp][pieceColumn].isColor()) {
							b.getSquares()[pieceRow+temp][pieceColumn].setMarked(true);
						}
						break;
					}
					
				}
				//down
				temp=1;
				while(pieceRow+temp<=7) {
					if(b.getSquares()[pieceRow+temp][pieceColumn].getType()=="null") {
						b.getSquares()[pieceRow+temp][pieceColumn].setMarked(true);
						temp++;
					}else {
						if(!b.getSquares()[pieceRow+temp][pieceColumn].isColor()) {
							b.getSquares()[pieceRow+temp][pieceColumn].setMarked(true);
						}
						break;
					}
					
				}
				//left
				temp=-1;
				while(pieceColumn+temp>=0) {
					if(b.getSquares()[pieceRow][pieceColumn+temp].getType()=="null") {
						b.getSquares()[pieceRow][pieceColumn+temp].setMarked(true);
						temp--;
					}else {
						if(!b.getSquares()[pieceRow][pieceColumn+temp].isColor()) {
							b.getSquares()[pieceRow][pieceColumn+temp].setMarked(true);
						}
						break;
					}
					
				}
				//right
				temp=1;
				while(pieceColumn+temp<=7) {
					if(b.getSquares()[pieceRow][pieceColumn+temp].getType()=="null") {
						b.getSquares()[pieceRow][pieceColumn+temp].setMarked(true);
						temp++;
					}else {
						if(!b.getSquares()[pieceRow][pieceColumn+temp].isColor()) {
							b.getSquares()[pieceRow][pieceColumn+temp].setMarked(true);
						}
						break;
					}
					
				}
			}
			if(b.getSquares()[pieceRow][pieceColumn].isColor()==false) {
	    		
				//up 
				int temp=-1;
				while(pieceRow+temp>=0) {
					if(b.getSquares()[pieceRow+temp][pieceColumn].getType()=="null") {
						b.getSquares()[pieceRow+temp][pieceColumn].setMarked(true);
						temp--;
					}else {
						if(b.getSquares()[pieceRow+temp][pieceColumn].isColor()) {
							b.getSquares()[pieceRow+temp][pieceColumn].setMarked(true);
						}
						break;
					}
					
				}
				//down left
				temp=1;
				while(pieceRow+temp<=7) {
					if(b.getSquares()[pieceRow+temp][pieceColumn].getType()=="null") {
						b.getSquares()[pieceRow+temp][pieceColumn].setMarked(true);
						temp++;
					}else {
						if(b.getSquares()[pieceRow+temp][pieceColumn].isColor()) {
							b.getSquares()[pieceRow+temp][pieceColumn].setMarked(true);
						}
						break;
					}
					
				}
				//up right
				temp=-1;
				while(pieceColumn+temp>=0) {
					if(b.getSquares()[pieceRow][pieceColumn+temp].getType()=="null") {
						b.getSquares()[pieceRow][pieceColumn+temp].setMarked(true);
						temp--;
					}else {
						if(b.getSquares()[pieceRow][pieceColumn+temp].isColor()) {
							b.getSquares()[pieceRow][pieceColumn+temp].setMarked(true);
						}
						break;
					}
					
				}
				//down right
				temp=1;
				while(pieceColumn+temp<=7) {
					if(b.getSquares()[pieceRow][pieceColumn+temp].getType()=="null") {
						b.getSquares()[pieceRow][pieceColumn+temp].setMarked(true);
						temp++;
					}else {
						if(b.getSquares()[pieceRow][pieceColumn+temp].isColor()) {
							b.getSquares()[pieceRow][pieceColumn+temp].setMarked(true);
						}
						break;
					}
					
				}
			}
	}
		
	public void markKing(int pieceRow, int pieceColumn) {
		int temp=-1;
		int temp2=-1;
		if(b.getSquares()[pieceRow][pieceColumn].isColor()) {
			if(pieceRow+temp>=0&&pieceColumn+temp2>=0&&!b.getSquares()[pieceRow+temp][pieceColumn+temp2].isColor()) {
				b.getSquares()[pieceRow+temp][pieceColumn+temp2].setMarked(true);
			}
			temp=0;				
			if(pieceRow+temp>=0&&pieceColumn+temp2>=0&&!b.getSquares()[pieceRow+temp][pieceColumn+temp2].isColor()) {
				b.getSquares()[pieceRow+temp][pieceColumn+temp2].setMarked(true);
			}	
			temp=1;				
			if(pieceRow+temp<=7&&pieceColumn+temp2>=0&&!b.getSquares()[pieceRow+temp][pieceColumn+temp2].isColor()) {
				b.getSquares()[pieceRow+temp][pieceColumn+temp2].setMarked(true);
			}	
			temp2=0;				
			if(pieceRow+temp<=7&&pieceColumn+temp2>=0&&!b.getSquares()[pieceRow+temp][pieceColumn+temp2].isColor()) {
				b.getSquares()[pieceRow+temp][pieceColumn+temp2].setMarked(true);
			}	
			temp2=1;				
			if(pieceRow+temp<=7&&pieceColumn+temp2<=7&&!b.getSquares()[pieceRow+temp][pieceColumn+temp2].isColor()) {
				b.getSquares()[pieceRow+temp][pieceColumn+temp2].setMarked(true);
			}	
			temp=0;				
			if(pieceRow+temp<=7&&pieceColumn+temp2<=7&&!b.getSquares()[pieceRow+temp][pieceColumn+temp2].isColor()) {
				b.getSquares()[pieceRow+temp][pieceColumn+temp2].setMarked(true);
			}
			temp=-1;				
			if(pieceRow+temp>=0&&pieceColumn+temp2<=7&&!b.getSquares()[pieceRow+temp][pieceColumn+temp2].isColor()) {
				b.getSquares()[pieceRow+temp][pieceColumn+temp2].setMarked(true);
			}
			temp2=0;				
			if(pieceRow+temp>=0&&pieceColumn+temp2<=7&&!b.getSquares()[pieceRow+temp][pieceColumn+temp2].isColor()) {
				b.getSquares()[pieceRow+temp][pieceColumn+temp2].setMarked(true);
			}	
		}else {
			if(pieceRow+temp>=0&&pieceColumn+temp2>=0&&(b.getSquares()[pieceRow+temp][pieceColumn+temp2].isColor()||b.getSquares()[pieceRow+temp][pieceColumn+temp2].getType()=="null")) {
				b.getSquares()[pieceRow+temp][pieceColumn+temp2].setMarked(true);
			}
			temp=0;				
			if(pieceRow+temp>=0&&pieceColumn+temp2>=0&&(b.getSquares()[pieceRow+temp][pieceColumn+temp2].isColor()||b.getSquares()[pieceRow+temp][pieceColumn+temp2].getType()=="null"))  {
				b.getSquares()[pieceRow+temp][pieceColumn+temp2].setMarked(true);
			}	
			temp=1;				
			if(pieceRow+temp<=7&&pieceColumn+temp2>=0&&(b.getSquares()[pieceRow+temp][pieceColumn+temp2].isColor()||b.getSquares()[pieceRow+temp][pieceColumn+temp2].getType()=="null"))  {
				b.getSquares()[pieceRow+temp][pieceColumn+temp2].setMarked(true);
			}	
			temp2=0;				
			if(pieceRow+temp<=7&&pieceColumn+temp2>=0&&(b.getSquares()[pieceRow+temp][pieceColumn+temp2].isColor()||b.getSquares()[pieceRow+temp][pieceColumn+temp2].getType()=="null"))  {
				b.getSquares()[pieceRow+temp][pieceColumn+temp2].setMarked(true);
			}	
			temp2=1;				
			if(pieceRow+temp<=7&&pieceColumn+temp2<=7&&(b.getSquares()[pieceRow+temp][pieceColumn+temp2].isColor()||b.getSquares()[pieceRow+temp][pieceColumn+temp2].getType()=="null"))  {
				b.getSquares()[pieceRow+temp][pieceColumn+temp2].setMarked(true);
			}	
			temp=0;				
			if(pieceRow+temp<=7&&pieceColumn+temp2<=7&&(b.getSquares()[pieceRow+temp][pieceColumn+temp2].isColor()||b.getSquares()[pieceRow+temp][pieceColumn+temp2].getType()=="null"))  {
				b.getSquares()[pieceRow+temp][pieceColumn+temp2].setMarked(true);
			}
			temp=-1;				
			if(pieceRow+temp>=0&&pieceColumn+temp2<=7&&(b.getSquares()[pieceRow+temp][pieceColumn+temp2].isColor()||b.getSquares()[pieceRow+temp][pieceColumn+temp2].getType()=="null"))  {
				b.getSquares()[pieceRow+temp][pieceColumn+temp2].setMarked(true);
			}
			temp2=0;				
			if(pieceRow+temp>=0&&pieceColumn+temp2<=7&&(b.getSquares()[pieceRow+temp][pieceColumn+temp2].isColor()||b.getSquares()[pieceRow+temp][pieceColumn+temp2].getType()=="null"))  {
				b.getSquares()[pieceRow+temp][pieceColumn+temp2].setMarked(true);
			}
		}
		if(inCheck) {
			calculateKingMovesWhileInCheck(pieceRow,pieceColumn);
		}
	}
	
	public boolean inBounds(int row, int column){
		if(row>=0&&row<=7&&column>=0&&column<=7) {
			return true;
		}
		return false;
	}
	

}
