import java.util.*;

class Lab10a {
	public static void floyd(int adj[][],int n) {
		for(int k=0;k<n;k++) {
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					adj[i][j] = min(adj[i][j],adj[i][k]+adj[k][j]);
				}
			}
		}
	}
	public static int min(int a,int b) {
		if(a<b) 
			return(a);
		return(b);
	} 
	public static void main(String[] args) {
		int i,j;
		Scanner sc = new Scanner(System.in);	
		System.out.println("Enter no of vertices");
		int n = sc.nextInt();
		int[][] adj = new int[n][n];	
		System.out.println("Enter data of the graph");
		for(i=0;i<n;i++) {
			for(j=0;j<n;j++) {
				if(i ==j){
					adj[i][j] =0;
				}
				else {
					System.out.printf("Is %d connected to %d ? enter weight or Enter 999 if not connected\n",i,j);
					adj[i][j]=sc.nextInt();
				}
			}
		}
		floyd(adj,n);
		System.out.println("Output is");
		for(i=0;i<n;i++) {
			for(j=0;j<n;j++) {
				System.out.print(adj[i][j]+" ");	
			}
			System.out.println();
		}
		
	}

}
