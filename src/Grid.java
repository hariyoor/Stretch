import java.util.ArrayList;

public class Grid {
	private int rows, columns, start;
	private ArrayList<Integer> blocks;
	private ArrayList<ArrayList<String>> grid;
	
	public Grid(int rows, int columns, int start, ArrayList<Integer> blocks) {
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
			
			System.out.println();
		}
		System.out.println(this);
	}
	
	public void solve(int currPosition, char currTile) {
		if(currTile == 'A') {
			
		} else if (currTile == 'B') {
			
		} else {
			
		}
	}
	
	public boolean checkValidity(int currPosition, char currTile) {
		if(currTile == 'A') {
			
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
