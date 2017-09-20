import java.util.*;
import java.io.*;

class Hamiltonian {
int mat[][],x[];
int n;
	Hamiltonian(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no of vertices");
		n = sc.nextInt();
		mat = new int[n][n];
		x = new int[n];
		x[0] = 0;
		System.out.println("Enter values in matrix");
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				mat[i][j] = sc.nextInt();
		hamil(1);
				
	}
	public void hamil(int k){
		while(true){
			nextValue(k);
			if(x[k]==0){
				return;
			}
			if(k == n-1 ){
				disp();
				System.out.println();
			}
			else{
				hamil(k+1);
			}
		}
	}
	public void nextValue(int k){
		int j;
		while(true){
			x[k] = (x[k]+1)%n;
			if(x[k]==0)
				return;
			if(mat[x[k-1]][x[k]] !=0){
				for(j=0;j<k;j++){
					if(x[j] == x[k])
						break;
				}
				if(j == k){
					if(k <n-1 || (k == n-1) && (mat[x[k]][x[0]] != 0) );
						return;
				}
			}
		}
	}
	public void disp(){
		for(int i=0;i<n;i++)
			System.out.println(x[i]);	
	}
}

class Lab121 {
	public static void main(String args[]){
		new Hamiltonian();
	}
}
