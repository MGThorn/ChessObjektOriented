
public class Piece {
	private boolean color;
	private String type;
	private boolean marked;
	private boolean invisMarked;
	private String markedBy;
	private boolean inDoubleCheck;
	public boolean isInDoubleCheck() {
		return inDoubleCheck;
	}
	public void setInDoubleCheck(boolean inDoubleCheck) {
		this.inDoubleCheck = inDoubleCheck;
	}
	public String getMarkedBy() {
		return markedBy;
	}
	public void setMarkedBy(String markedBy) {
		this.markedBy = markedBy;
	}
	private boolean hasMoved;
	private boolean canBeInflictedByEnpassant;
	private int value;
	
	public boolean isHasMoved() {
		return hasMoved;
	}
	public void setHasMoved(boolean hasMoved) {
		this.hasMoved = hasMoved;
	}
	public boolean isCanBeInflictedByEnpassant() {
		return canBeInflictedByEnpassant;
	}
	public void setCanBeInflictedByEnpassant(boolean canBeInflictedByEnpassant) {
		this.canBeInflictedByEnpassant = canBeInflictedByEnpassant;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public boolean isInvisMarked() {
		return invisMarked;
	}
	public void setInvisMarked(boolean invisMarked) {
		this.invisMarked = invisMarked;
	}
	public boolean isMarked() {
		return marked;
	}
	public void setMarked(boolean marked) {
		this.marked = marked;
	}
	//Constructor
	public Piece() {
		this.type="null";
		
	}
	public Piece(String type) {
		this.type = type;
		this.color = false;
	}
	public Piece(String type,boolean color) {

		this.type = type;
		this.color = color;
	}
	//Constructor end
	
	//getter and setter
	public boolean isColor() {
		return color;
	}
	public void setColor(boolean color) {
		this.color = color;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	//getter and setter end
	
}
