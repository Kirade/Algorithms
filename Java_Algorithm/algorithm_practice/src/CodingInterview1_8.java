import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
코딩인터뷰 완전분석 연습문제 1.8

M*N 행렬의 한 원소가 0일 경우, 해당 원소가 속한 행과 열의 모든 원소를 0으로 설정하는 알고리즘을 작성하라.
 */

public class CodingInterview1_8 {

	private int m,n;
	private int[][] matrix;

	public CodingInterview1_8() throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		this.m = Integer.parseInt(bf.readLine());
		this.n = Integer.parseInt(bf.readLine());
		this.matrix = read_matrix(m,n);
	}

	private int[][] read_matrix(int m, int n) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));


		int[][] matrix = new int[m][n];

		for(int i=0; i<m; i++){
			String[] line = bf.readLine().split(" ");

			for(int j=0; j<n; j++){
				matrix[i][j] = Integer.valueOf(line[j]);
			}
		}

		return matrix;
	}

	public void solution(){
		int[][] temp = new int[m][n];

		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				temp[i][j] = matrix[i][j];
			}
		}

		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				if(matrix[i][j] == 0){
					temp = change(temp, i, j, m, n);
				}
			}
		}

		show(temp);
	}

	private int[][] change(int[][] input, int row, int col, int m, int n){
		for(int i=0; i<n; i++){
			input[row][i] = 0;
		}

		for(int j=0; j<m; j++){
			input[j][col] = 0;
		}

		return input;
	}

	private void show(int[][] matrix){
		for(int j=0; j<n; j++) {
			for (int i = 0; i < n; i++) {
				System.out.print(matrix[j][i] + " ");
			}
			System.out.println();
		}
	}
}
