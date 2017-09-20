import java.util.*;

class Lab6a {
	public static int max(int a,int b){
		return(a>b?a:b);	
	}
	public static int knapsack(int n,int m,int[] w,int p[],int v[][]){
		for(int i=0;i<=n;i++){
			for(int j=0;j<=m;j++){
				if(i==0 |j==0)
					v[i][j]=0;
				else{
					if(w[i]>j)
						v[i][j]=v[i-1][j];
					else
						v[i][j]=max(v[i-1][j],p[i]+v[i-1][j-w[i]]);
				}
			}
		}
		return v[n][m];
	}
	
	
	public static void main(String args[]){
		int n,m;
		int[] w,p;
		int[][] v;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no of items")	;
		n = sc.nextInt();
		System.out.println("Enter size of knapsack");
		m = sc.nextInt();
		w = new int[n+1];
		v = new int[n+1][m+1];
		p = new int[n+1];
		System.out.println("Enter profits and weights of items");
		for(int i=1;i<=n;i++){
			p[i] =sc.nextInt();
			w[i] =sc.nextInt();
		}
		
		int profit=knapsack(n,m,w,p,v);
		System.out.println("Profit: "+profit);
		
	}
}
