import java.util.*;
import java.io.*;

class Lab9 {
	public static int prims(int adj[][],int v) {
		int min,cost=0,i,j,u=0,ve=0,count=0;
		int visit[] = new int[v];
		for(i = 0; i < v ; i++) {
			visit[i] = 0;
		}
		visit[0] = 1;
		min = 999;
		count = 1;
		while(count < v ) {

			for(i=0;i<v;i++) {
				for(j=0;j<v;j++) {
					if((visit[i] == 1) && (visit[j] ==0) && (adj[i][j] < min) ) {
						min = adj[i][j]	;
						u=i;
						ve=j;	
					
					}
				
				}
			}
			
			cost += min;
			adj[u][ve]=adj[ve][u]=999;
			System.out.println(u+" is connected to "+ ve +" weight= "+ min);
			visit[ve]=1;
			min = 999;
			count++;	
		}	
		return cost;
	}

	public static void main(String[] args) {

		int adj[][],v=0,i,j,cost=0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no of vertices");
		v = sc.nextInt();
		adj = new int[v][v];

		for(i=0;i<v;i++) {
			for(j=0;j <= i;j++) {
				System.out.printf("If %d and %d are connected enter weight else enter 999:",i,j);
				adj[i][j]=adj[j][i]=sc.nextInt();
			}		
		}

		cost=prims(adj,v);
		System.out.println("Cost= "+ cost);
	}


}

