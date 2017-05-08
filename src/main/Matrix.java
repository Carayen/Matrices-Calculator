package main;

public class Matrix {
	private int[][]matrix1;
	private int[][]matrix2;
	
	public Matrix(int matrix1[][], int matrix2[][]){
		this.matrix1 = matrix1;
		this.matrix2 = matrix2;
	}

	public int[][] add() {
		int[][] addMatrix = new int[matrix1.length][matrix1[0].length];
		for(int x = 0; x < matrix1.length; x++){
			for(int y = 0; y < matrix1[0].length; y++){
				addMatrix[x][y] = matrix1[x][y] + matrix2[x][y];
			}
		}
		return addMatrix;
	}

	public int[][] subtract() {
		int[][] subMatrix = new int[matrix1.length][matrix1[0].length];
		for(int x = 0; x < matrix1.length; x++){
			for(int y = 0; y < matrix1[0].length; y++){
				subMatrix[x][y] = matrix1[x][y] - matrix2[x][y];
			}
		}
		return subMatrix;
	}

	public int[][] multiplication(){
		int [][] multMatrix;
		int matrix1Row = matrix1.length;
		int matrix1Col = matrix1[0].length;
		int matrix2Row = matrix2.length;
		int matrix2Col = matrix2[0].length;
		
		if(matrix1Row < matrix2Row && matrix1Col > matrix2Col){
			multMatrix = new int[matrix1Row][matrix2Col];
			
			for(int a = 0; a < matrix1Row; a++){
				for(int b = 0; b < matrix2Col; b++){
					multMatrix[a][b] = 0;
				}
			}
			
			for(int x = 0; x < matrix1Row; x++){
				for(int y = 0; y < matrix2Col; y++){
					for(int z = 0; z < matrix1Col; z++){
						multMatrix[x][y] += matrix1[x][z] * matrix2[z][y];
					}
				}
			}
		} else{
			multMatrix = new int[matrix2Row][matrix1Col];
			
			for(int a = 0; a < matrix2Row; a++){
				for(int b = 0; b < matrix1Col; b++){
					multMatrix[a][b] = 0;
				}
			}
			
			for(int x = 0; x < matrix2Row; x++){
				for(int y = 0; y < matrix1Col; y++){
					for(int z = 0; z < matrix2Col; z++){
						multMatrix[x][y] += matrix2[x][z] * matrix1[z][y];
					}
				}
			}
		}
		return multMatrix;
	}
	
	public String toString(int[][]matrix){
		String result = "";
		for(int x = 0; x < matrix.length; x++){
			for(int y = 0; y < matrix[0].length; y++){
				result += String.format("%11d", matrix[x][y]);
			}
			result += "\n";
		}
		return result;
	}
}