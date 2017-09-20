import java.util.*;
import java.io.*;

class Krushkal {
int[] p;
int t[][];
	Krushkal(int n){
	p = new int[n];
	t = new int[n][3];
	}
	void krushkal(int n,int adj[][]){
		for(int i=0;i<n;i++){
			p[i] = i;

		}
		int ecount=0,u=0,v=0;
		int min =999,i,j=-1;
		while(ecount <n){
			for( i=0;i<n;i++){
				for( j=0;j<n;j++){
					if(i !=j && checkt(i,j,n)&& adj[i][j] < min && find(i) != find(j)){
						u =i;
						v = j;
						min = adj[i][j];
					}
				}	
			}
			if(find(u) != find(v)){
				t[ecount][0] = u;
				t[ecount][1] = v;
				t[ecount][2] = adj[u][v];
				union(find(u),find(v));

			}
			else{
				adj[u][v] =999;
			}
			ecount++;
			min =999;

		}
		for(int z=0;z<n;z++){
			for(int q=0;q<3;q++){
				System.out.print(t[z][q] + " ");
			}
			System.out.println();
		}
	}
	int find(int k){
		if(p[k] != k){
			return find(p[k]);
		}
		return k;
	}
	boolean checkt(int i,int j,int n){
		for(int k=0;k<n;k++)
		{

			if(t[k][0] == i && t[k][1] == j)
				return false;
			if(t[k][0] == j && t[k][1] == i)
				return false;
			
		}
		return true;
	}		
	void union(int i,int j){
		p[j]=i;
	}
}

class Lab81 {

	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt();
		int adj[][] = new int[n][n];
		Krushkal obj = new Krushkal(n);
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				adj[i][j] =sc.nextInt();
			}
		}
		obj.krushkal(n,adj);
	}
}
