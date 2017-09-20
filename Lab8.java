import java.util.*;
class Kruskal {
	int p[];
	int[][] t ;

	Kruskal(int n) {
		p = new int[n];
		t = new int[n][3];
	}
	int find(int i) {
		if(p[i] != i) {
			return find(p[i]);
		}
		return i;
	}
	void union(int i,int j) {
		p[j] =i;
	}
	boolean checkt(int i,int j,int n){	
		for(int x=0;x<n;x++) {
			if(t[x][0]==i && t[x][1]==j ){
				return false;
			}
			if(t[x][0]==j && t[x][1]==i ){
				return false;
			}
			
		}
		return true;
	}
	void display (int n) {
		for(int i=0;i<n;i++) {
                        for(int j=0;j<3;j++) {
                                System.out.print(t[i][j]+" ");
                        }
                        System.out.println();
                }
	}
	public void kruskal(int adj[][],int n) {
		int mincost,ecounter,min,u=-1,v=-1;
		for(int i=0;i<n;i++) {
			p[i] = i;
			t[i][0]=t[i][1]=0;
			t[i][2]=999;
		}
		mincost = 0;
		ecounter =0;
		
		while(ecounter <n-1) {
			min = 999;
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++){
					if( i !=j && checkt(i,j,n)&& adj[i][j]<min && find(i) != find(j)){
						min = adj[i][j];
						u =i;
						v =j;
					}
					
				}
			}
			if(find(u) != find(v)){
				t[ecounter][0] = u;
				t[ecounter][1] = v;
				t[ecounter][2] = min;
				mincost += min;
				union(find(u), find(v));
				
			}
			else{
				adj[u][v] =999;
			}
			ecounter++;
		}
		

	}
}

class Lab8 {
	public static void main(String[] args ) {
		
		Scanner sc = new Scanner(System.in);
                System.out.println("Enter no of vertices");
                int n = sc.nextInt();
		Kruskal k = new Kruskal(n);
                int[][] adj = new int[n][n];
                System.out.println("Enter data of the graph");
                for(int i=0;i<n;i++) {
                        for(int j=0;j<n;j++) {
                        	adj[i][j]=sc.nextInt();
                                
                        }
                }
		k.kruskal(adj,n);
		k.display(n);

	}
}
