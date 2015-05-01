
import java.util.*;
import java.io.*;

public class NumberTriangle {
	public static int greatest = 0;
	public static ArrayList<int[]> theTriangle = new ArrayList<int[]>(); 
	
	public static void main(String[] args) 
	{
		System.out.println("Creating variables...");
		File file = new File("theTriangle.txt");
		Scanner readFile = null;
		try {
			readFile = new Scanner(file);
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found.");
		}
		String currentLine;
		String[] tokens;
		int[] tokenNums;
		
		System.out.println("Filling arraylist...");
		do {
			currentLine = readFile.nextLine();
			tokens = currentLine.split("\\s+");
			tokenNums = new int[tokens.length];
			for (int m = 0; m < tokens.length; m++)
			{
				tokenNums[m] = Integer.parseInt(tokens[m]);
			}
			theTriangle.add(tokenNums);
		} while (readFile.hasNextLine());
		readFile.close();
		
		bottomUp();
		System.out.println("The email is "+greatest+"@yodle.com.");
	}
	
	public static void bottomUp() {
		int currentLine = theTriangle.size()-1;
		int choice1, choice2 = 0;
		while(theTriangle.size() > 1) {
			for(int i = 0; i < theTriangle.get(currentLine-1).length; i++) {
				choice1 = theTriangle.get(currentLine)[i];
				choice2 = theTriangle.get(currentLine)[i+1];
				//System.out.print("choice1 ="+choice1+" choice2 ="+choice2+" my root is "+theTriangle.get(currentLine-1)[i]+" || ");
				if (choice1 > choice2)
					theTriangle.get(currentLine-1)[i] = theTriangle.get(currentLine-1)[i] + choice1;
				else
					theTriangle.get(currentLine-1)[i] = theTriangle.get(currentLine-1)[i] + choice2;
			}
			//System.out.println();
			currentLine--;
			theTriangle.remove(theTriangle.size()-1);
		}
		greatest = theTriangle.get(0)[0];
	}
	
}
