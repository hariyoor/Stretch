import java.util.ArrayList;

public class ForwardGrid implements Grid {
	private int rows, columns, start;
	private ArrayList<Integer> blocks;
	private ArrayList<ArrayList<String>> grid;
	
	public ForwardGrid(int rows, int columns, int start, ArrayList<Integer> blocks) {
		this.rows = rows;
		this.columns = columns;
		this.start = start;
		this.blocks = blocks;
		grid = new ArrayList<ArrayList<String>>();
	}
	
	public void generateGrid() {
		int counter = 0;
		for(int i = 0; i < rows; i++) {
			grid.add(i, new ArrayList<String>());
			for(int j = 0; j < columns; j++) {
				counter++;
				if(blocks.contains(counter)) {
					grid.get(i).add(j, "B");
				} else {
					grid.get(i).add(j, counter + "");
				}
			}
		}
		System.out.println(this);
		String result = solve(this.start, 'A',"");
		System.out.println(result);
	}
	
	public String solve(int currPosition, char currTile, String currPath) {
		if(currTile == 'A') {
			if(checkValidity(currPosition,currTile)) {
				currPath += currTile;
				if((currPosition+2) % columns == 0) {
					return currPath;
				}
				return solve(currPosition+3,'B', currPath);
			} else {
				return solve(currPosition,'B',currPath);
			}
		} else if (currTile == 'B') {
			if(checkValidity(currPosition, currTile)) {
				currPath += currTile;
				if((currPosition+columns+1) % columns == 0) {
					return currPath;
				}
				return solve((currPosition+columns)+2,'C',currPath);
			} else {
				return solve(currPosition, 'C',currPath);
			}
		} else {
			if(checkValidity(currPosition, currTile)) {
				currPath+=currTile;
				if((currPosition+2*columns+1) % columns == 0) {
					return currPath;
				}
				return solve(currPosition+(2*columns)+2, 'A', currPath);
			} else {
				return solve(currPosition, 'A',currPath);
			}
		}
	}
	
	public boolean checkValidity(int currPosition, char currTile) {
		int positions[];
		
		if(currTile == 'A') {
			positions = new int[3];
			positions[0] = currPosition;
			positions[1] = currPosition + 1;
			positions[2] = currPosition + 2;
			
			boolean rowOver = (positions[0]%columns==0) || (positions[1]%columns==0);
			
			if(rowOver) {
				return false;
			}
			
			for(int curr : positions) {
				boolean blocked = blocks.contains(curr);
				
				if(blocked) {
					return false;
				}
			}
		} else if(currTile == 'B') {
			positions = new int[3];
			positions[0] = currPosition;
			positions[1] = currPosition + this.columns;
			positions[2] = positions[1] + 1;
			
			for(int curr: positions) {
				boolean blocked = blocks.contains(curr);
				boolean colOver = curr/this.columns > rows;
				
				if(blocked || colOver) {
					return false;
				}
			}
		} else if(currTile == 'C') {
			positions = new int[4];
			positions[0] = currPosition;
			positions[1] = positions[0] + 1;
			positions[2] = positions[1] + this.columns;
			positions[3] = positions[2] + this.columns;
			
			for(int curr: positions) {
				boolean blocked = blocks.contains(curr);
				boolean colOver = curr/this.columns > rows;
				if(blocked || colOver) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	public String toString() {
		String result = "";
		
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < columns; j++) {
				result += grid.get(i).get(j) + " ";
			}
			result += "\n";
		}
		
		return result;
	}
}
