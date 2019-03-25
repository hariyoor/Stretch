

public interface Grid {
	public void generateGrid() ;
	
	public String solve(int currPosition, char currTile, String currPath) ;
	
	public boolean checkValidity(int currPosition, char currTile) ;
	
	public String toString() ;
}