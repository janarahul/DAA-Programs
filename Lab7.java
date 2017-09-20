import java.util.*;
import java.io.*;


class Dj {
	int p[];
	public Dj (int n) {
		p = new int[n];
	}
	public void path(int k) {
		if(p[k] == -1 ) {
			return;
		}
			path(p[k]);
		
		System.out.print(k+" ");
	} 
	public void dijkstra(int adj[][],int n,int src) {
		int visit[] = new int[n];
		int d[] = new int[n];
		
		int min=0,w=0;
		for(int i=0;i<n;i++) {
			visit[i]=0;
			d[i]= 999;
			p[i]= -1;
		}
		visit[src]=1;
		d[src]=0;
		p[src]=-1;
		for(int i=0;i<n;i++) {
			if(adj[src][i] != 999 && adj[src][i] != 0) {
				d[i]=adj[src][i];
				p[i]=src;
			}

		}
		for(int i=1;i<n;i++) {
			min = 999;
			for(int j=0;j<n;j++) {
				if(visit[j]==0 && d[j] < min) {
					min =d[j];
					w=j;
				}
			}
			visit[w]=1;
			for(int k=0;k<n;k++) {
				if(visit[k]==0 && adj[w][k] != 999 && adj[w][k] != 0) {
					if(d[k] > (d[w] + adj[w][k])) {
						d[k]= d[w] + adj[w][k];
						p[k]=w;
					}
				}
			}	
		}
		for(int i=0;i<n;i++) {
			System.out.println("Distence of node "+i+"from source is "+d[i]+"parent is "+p[i]);
			System.out.println("path taken is");
			System.out.print(src+" ");
			path(i);
			System.out.println();
		}
	}	
}

class Lab7 {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int x= sc.nextInt();
		Dj obj = new Dj(x);
		int adj[][] = new int[x][x];
		for(int i=0;i<x;i++) {
			for(int j=0;j<x;j++) {
				if(i ==j ) {
					adj[i][j] = 0;
				} else {
					System.out.println("Is "+i+"connected to "+j+"?if yes enter weight, if not enter 999");
					adj[i][j]=sc.nextInt();
				}
			}

		}
		obj.dijkstra(adj,x,0);
	}

}
