package main;

import java.util.Scanner;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		Random rand = new Random();
		
		System.out.print("Enter the amount of rows for array1: ");
		int array1Row = input.nextInt();
		
		System.out.print("Enter the amount of columns for array1: ");
		int array1Col = input.nextInt();
		
		System.out.print("Enter the amout of rows for array2: ");
		int array2Row = input.nextInt();
		
		System.out.print("Enter the amount of columns for array2: ");
		int array2Col = input.nextInt();
		
		int[][] array1 = new int[array1Row][array1Col];
		int[][] array2 = new int[array2Row][array2Col];
		
		System.out.print("Choose random input or input your own(R:Random, P:Personal Input: ");
		String inputChoice = input.next();
		
		if(inputChoice.equals("R") || inputChoice.equals("r")){
			for(int x = 0; x < array1Row; x++){
				for(int y = 0; y < array1Col; y++){
					array1[x][y] = rand.nextInt(101);
				}
			}
			
			for(int a = 0; a < array2Row; a++){
				for(int b = 0; b < array2Col; b++){
					array2[a][b] = rand.nextInt(101);				
				}
			}
		} else if(inputChoice.equals("P") || inputChoice.equals("p")){
			for(int x = 0; x < array1Row; x++){
				for(int y = 0; y < array1Col; y++){
					System.out.print("Enter your data for array1[" + x + "][" + y + "]: ");
					array1[x][y] = input.nextInt();
				}
			}
			
			for(int x = 0; x < array1Row; x++){
				for(int y = 0; y < array1Col; y++){
					System.out.print("Enter your data for array2[" + x + "][" + y + "]: ");
					array2[x][y] = input.nextInt();
				}
			}
		} else{
			throw new IllegalArgumentException("Choose: " + inputChoice + " but did not match with R or P.");
		}
					
		Matrix matrix1 = new Matrix(array1, array2);
		
		System.out.println("\nArray1: \n" + matrix1.toString(array1));
		System.out.println("Array2: \n" + matrix1.toString(array2));
		
	System.out.print("Choose whether you want to add, subtract, or multiply(A:Add, S:Subtract, M:Multiply, Q:Quit): ");
		String mathChoice = input.next();
		
		while(true){
			if(mathChoice.equals("A") || mathChoice.equals("a")){
				if(array1Row == array2Row && array1Col == array2Col){
					System.out.println("Addition Matrix");
					System.out.println(matrix1.toString(matrix1.add()));
				} else if(array1Row != array2Row){
					throw new IllegalArgumentException("Array1(Row): " + array1Row + " did not match Array2(Row): " + array2Row + ".");
				} else{
					throw new IllegalArgumentException("Array1(Column): " + array2Col + " did not match Array2(Column): " + array2Col + ".");
				}
			} else if(mathChoice.equals("S") || mathChoice.equals("s")){
				if(array1Row == array2Row && array1Col == array2Col){
					System.out.println("\nSubtration Matrix");
					System.out.println(matrix1.toString(matrix1.subtract()));
				} else if(array1Row != array2Row){
					throw new IllegalArgumentException("Array1(Row): " + array1Row + " did not match Array2(Row): " + array2Row + ".");
				} else{
					throw new IllegalArgumentException("Array1(Column): " + array2Col + " did not match Array2(Column): " + array2Col + ".");
				}
			} else if(mathChoice.equals("M") || mathChoice.equals("m")){
				if(array1Col == array2Row){
					System.out.println("\nMultiplication Matrix");
					System.out.print(matrix1.toString(matrix1.multiplication()));
				} else if(array2Col == array1Row){
					System.out.println("\nMultiplication Matrix");
					System.out.print(matrix1.toString(matrix1.multiplication()));
				} else{
					throw new IllegalArgumentException("Array1(Column): " + array2Col + " did not match Array2(Row): " + array2Row + ".");
				}
			} else if(mathChoice.equals("Q") || mathChoice.equals("q")){
				break;
			}else{
				throw new IllegalArgumentException("Choose: " + mathChoice + " but did not match with A, S, M, or Q.");
			}
			System.out.print("Choose whether you want to add, subtract, or multiply(A:Add, S:Subtract, M:Multiply, Q:Quit): ");
			mathChoice = input.next();
		}
	}
}
