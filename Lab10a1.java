import java.util.*;
import java.io.*;

class Floyds {
int[][] mat;
int n;
	Floyds(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no of vertices");
		n = sc.nextInt();
		mat = new int[n][n];
		System.out.println("Enter values");
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				mat[i][j] = sc.nextInt();
		floyds(n);
		System.out.println("output:");
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				System.out.print(mat[i][j]+ " ");
			}
			System.out.println();
		}
	}
	public void floyds(int n){
		for(int k=0;k<n;k++){
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				mat[i][j] = min(mat[i][j],mat[i][k]+mat[k][j]);
			}
		}
	}}
	public int min(int a,int b){
		return (a<b)?a:b;
	}
}


class Lab10a1 {
	public static void main(String args[]){
		new Floyds();
	}
}
