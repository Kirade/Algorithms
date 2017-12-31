import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
코딩인터뷰 완전분석 연습문제 1.7

이미지를 표현하는 N*N 행렬이 있다. 이미지의 각 픽셀은 4바이트로 표현된다.
이때, 이미지를 90도 회전시키는 메서드를 작성하라. 행렬을 추가로 사용하지 않고도 할 수 있겠는가?
 */

public class CodingInterview1_7 {

	private int n;
	private int[][] matrix;

	class Point{
		int r;
		int c;
		int data;

		public Point(int r, int c){
			this.r = r;
			this.c = c;
		}

		public void row_plus(){
			this.r += 1;
		}

		public void col_plus(){
			this.c += 1;
		}

		public void row_minus(){
			this.r -= 1;
		}

		public void col_minus(){
			this.c -= 1;
		}

		public void set(int r, int c){
			this.r = r;
			this.c = c;
		}
	}

	public CodingInterview1_7() throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		this.n = Integer.parseInt(bf.readLine());
		this.matrix = read_matrix();
	}

	private int[][] read_matrix() throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bf.readLine());
		int[][] matrix = new int[n][n];
		int count = 0;
		while(count < n){
			String[] line = bf.readLine().split(" ");

			for(int i=0; i<n; i++){
				matrix[count][i] = Integer.valueOf(line[i]);
			}
			count++;
		}

		return matrix;
	}

	public void solution(){
		int temp1;
		int temp2;

		//초기값
		Point p1 = new Point(0,0);
		Point p2 = new Point(0,n-1);
		Point p3 = new Point(n-1,n-1);
		Point p4 = new Point(n-1,0);

		for(int p=0; p<n/2; p++) {

			for (int i = 0; i < (n - 1) - (2*p); i++) {
				temp1 = matrix[p2.r][p2.c];
				matrix[p2.r][p2.c] = matrix[p1.r][p1.c];
				temp2 = matrix[p3.r][p3.c];
				matrix[p3.r][p3.c] = temp1;
				temp1 = matrix[p4.r][p4.c];
				matrix[p4.r][p4.c] = temp2;
				matrix[p1.r][p1.c] = temp1;

				p1.col_plus();
				p2.row_plus();
				p3.col_minus();
				p4.row_minus();
			}

			p1.set(0,0);
			p2.set(0,n-1);
			p3.set(n-1,n-1);
			p4.set(n-1,0);

			p1.col_plus();
			p1.row_plus();
			p2.col_minus();
			p2.row_plus();
			p3.col_minus();
			p3.row_minus();
			p4.col_plus();
			p4.row_minus();
		}

		show(matrix);
	}

	private void show(int [][] matrix){
		for(int j=0; j<n; j++) {
			for (int i = 0; i < n; i++) {
				System.out.print(matrix[j][i] + " ");
			}
			System.out.println();
		}
	}

}

