import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter grid details:");
		
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		
		while(!input.equals("exit")) {
			String[] response = input.split(" ", 4);
			int rows = Integer.parseInt(response[0]);
			int columns = Integer.parseInt(response[1]);
			int start = Integer.parseInt(response[2]);
			
			String[] blockDetails = response[3].split(" ");
//			int[] blocks = new int[Integer.parseInt(blockDetails[0])];
//			for(int i = 1; i <= blocks.length; i++) {
//				System.out.println(blockDetails[i]);
//				blocks[i-1] = Integer.parseInt(blockDetails[i]);
//			}
			
			ArrayList<Integer> blocks = new ArrayList<Integer>();
			for(int i = 1; i <= Integer.parseInt(blockDetails[0]); i++) {
				blocks.add(i-1, Integer.parseInt(blockDetails[i]));
			}
			Grid grid = new Grid(rows, columns, start, blocks);
			grid.generateGrid();
			
			System.out.println("Enter grid details:");
			input = in.nextLine();
		}
		System.out.println("Successfully Exited Application.");
	}

}
