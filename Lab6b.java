import java.util.*;

class Lab6b {
	public static void knapsack(int n,int m,int[] w,float x[]){
		int u=m;
		int i=0;
		for(i=0;i<=n-1;i++) {
			if(w[i]>u)
				break;
			
			x[i]=(float)1.0;
			u = u-w[i];
		}
		if(i<=n-1) {
			x[i]=(float)u/(float)w[i];
		}
	}
	public static void sort(int w[],float[] ratio,int index[],int n) {
		int temp=0;
		float temp1=0;
		for(int i=0;i<n;i++){
			for(int j=0;j<n-i-1;j++){
				if(ratio[j]<ratio[j+1]){
					
					temp1 = ratio[j];
					ratio[j]=ratio[j+1];	
					ratio[j+1]=temp1;		
					temp = w[j];
					w[j]=w[j+1];	
					w[j+1]=temp;
					temp =	index[j];	
					index[j]=index[j+1];	
					index[j+1]=temp;		
				}
			}
		}
	}	
	public static void display(float x[],int n,int index[]){
		for(int i=0;i<n;i++){
			System.out.println("item: "+index[i]+"is :"+x[i]);
		}
	
	}
	
	public static void main(String args[]){
		int n,m;
		int[] w,p,index;
		float x[],ratio[];
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no of items")	;
		n = sc.nextInt();
		System.out.println("Enter size of knapsack");
		m = sc.nextInt();
		w = new int[n];
		index = new int[n];
		p = new int[n];
		x = new float[n];
		ratio = new float[n];
		
		System.out.println("Enter weights and profits of items");
		for(int i=0;i<n;i++){
			p[i] =sc.nextInt();
			w[i] =sc.nextInt();
		}
		for(int i=0;i<n;i++){ 
			x[i] =0;
			index[i]=i;
			ratio[i] =(float)p[i]/(float)w[i];
		}
		
		sort(w,ratio,index,n);
		knapsack(n,m,w,x);
		display(x,n,index);
		
	}
}
