import java.util.*;
import java.io.*;

class Lab6a1 {
	public static int knapsack(int w[],int p[],int n,int m,int adj[][]){

		for(int i=0;i<=n;i++){
			for(int j=0;j<=m;j++){
				if(i==0 || j==0)
					adj[i][j] =0;
				else{
					if(w[i]>j)
						adj[i][j] = adj[i-1][j];
					else
						adj[i][j] = max(adj[i-1][j],adj[i-1][j-w[i]]+p[i]);

				}
			}
		}
		return adj[n][m];

	}
	public static int max(int a,int b){
		return (a>b)?a:b;
	}
	public static void main(String args[]){
		int n,m;

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no of items");
		n = sc.nextInt();	
		System.out.println("Enter knapsack size");
		m = sc.nextInt();	
		int adj[][] = new int[n+1][m+1];
		int w[] = new int[n+1];
		int p[] = new int[n+1];
		System.out.println("Enteritem weightn ,profit");
		for(int i=1;i<=n;i++){
			w[i]=sc.nextInt();
			p[i]= sc.nextInt();
		}		
		int profit = knapsack(w,p,n,m,adj);
		System.out.println("profit ="+ profit); 
	}
}
