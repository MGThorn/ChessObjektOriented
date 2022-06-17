

public class Util {
	
	
	
	 public static Piece [] [] fenToBoard(String fen) {
		 	Piece [] [] ret = new Piece[8][8];
	        int row= 0;
	        int column=0;
	        
	        
	        for(int i=0;i<fen.length();i++) {
	            
	             if(Character.isLetter(fen.charAt(i))){
	            	 
	            	 switch(fen.charAt(i)){
	                 case 'p':
	                	 ret[row][column]=new Piece("Pawn",false);
	                     break;
	                 case 'n':
	                	 ret[row][column]=new Piece("Night",false);             	
	                     break;
	                 case 'b':
	                	 ret[row][column]=new Piece("Bishop",false);
	                     break;
	                 case 'r':
	                	 ret[row][column]=new Piece("Rook",false);
	                     break;
	                 case 'q':
	                	 ret[row][column]=new Piece("Queen",false);
	                     break;
	                 case 'k':
	                	 ret[row][column]=new Piece("King",false);
	                 	 break;
	                 case 'P':
	                	 ret[row][column]=new Piece("Pawn",true);
	                     break;
	                 case 'N':
	                	 ret[row][column]=new Piece("Knight",true);                 	
	                     break;
	                 case 'B':
	                	 ret[row][column]=new Piece("Bishop",true);
	                     break;
	                 case 'R':
	                	 ret[row][column]=new Piece("Rook",true);
	                     break;
	                 case 'Q':
	                	 ret[row][column]=new Piece("Queen",true);
	                     break;
	                 case 'K':
	                	 ret[row][column]=new Piece("King",true);
	                 	 break;
	                 case 'w':
	                	 //TODO rest einfügen
	                 	 break;
	                 
	                 default:
	                	 System.out.println("Fehler FEN hat ungültiges format: falscher Buchstabe");
	                	 for (int j = 0; j < ret.length; j++) {
	                		 for (int l = 0; l < ret.length; l++) {
	                			 ret[j][l]=new Piece("null");
	                		 }
	     					
	     				}
	                	 return ret;
	                	      
	         		}row++;
	              }else if(Character.getType(fen.charAt(i))==9){
	            	  for(int k=0;k<Character.getNumericValue(fen.charAt(i));k++) {
	            		  ret[row][column]=new Piece("null");
	            		  row++;
	            	  }
	            	  
	            	               
	               
	              }else if(fen.charAt(i)=='/') {
	            	  column++;
	            	  row=0;
	                  
	              }else if(fen.charAt(i)=='-') {
	            	  break;
	                  
	              }else if(fen.charAt(i)==' ') {
	            	  break;
	            	  
	              }else {
	            	  for (int j = 0; j < ret.length; j++) {
	                		 for (int l = 0; l < ret.length; l++) {
	                			 ret[j][l]=new Piece("null");
	                		 }
	     					
	     				}
	                	 return ret;
	                  
	              }
	             
	            
	        }
	        return  ret;
	    }
	 
	 

}
