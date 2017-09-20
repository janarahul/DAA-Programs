import java.util.*;

class Hamiltonian {
	int x[];
	int n;
	int adj[][];
	Hamiltonian(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no of vertices");
		n = sc.nextInt();
		adj =new  int [n][n];
		System.out.println("Enter input matrix ");
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				adj[i][j]=sc.nextInt();
			}
		}
		
		x = new int[n];	
		for(int z= 0;z<n;z++)
			x[z]=1;
		x[0]=1;
		
		hamil(1);
	}
	public void hamil(int k){
		while(true){
//			System.out.println("next value being called with "+k);
			nextValue(k);
			if(x[k] == 1){
				return;
			}
			if(k == n-1){
				disp();
				System.out.println();
			}
			else {
//				System.out.println("hamil  being called with "+(k+1));
				hamil(k+1);
			}
		}
	}
	public void nextValue(int k){
		int j=0;
		while(true){

			x[k] = (x[k]+1)%(n);
//			System.out.println("in next value,x[k]= "+x[k]);
			if(x[k] == 1){
				return;	
			}
			if(adj[x[k-1]][x[k]] != 0){
				for(j=0;j<k;j++){
					if(x[k] == x[j]){
//						System.out.println("next value being called with "+k);
						break;
					}
				}
				if(j == k){
					if( (k < n-1) || ( ( k==n-1 )&& (adj[x[k]][x[0]] != 0) ) ){
						return;
					}
				}
			}
		}
	}
	public void disp(){
		for(int i=0;i<n;i++){
			System.out.print(" "+x[i]);
		}
	}

} 

class Lab12 {
	public static void main(String args[]){
		new Hamiltonian();
	}
}
