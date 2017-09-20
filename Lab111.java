import java.util.*;
import java.io.*;

class Subset {
int[] w,x;
int n,s,r,m;
	Subset(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no of elements in set");
		n = sc.nextInt();
		w = new int[n+1];
		x = new int[n];
		System.out.println("Enter elements in set");
		for(int i=0;i<n;i++){
			w[i]= sc.nextInt();
			x[i]=0;
		}
		w[n] =0;
		System.out.println("Enter sum required");
		m = sc.nextInt();
		subset(0,0,sum());
	
	}
	public int sum(){
		int sum =0;
		for(int i =0;i<n;i++)
			sum += w[i];
		return sum;
	}
	public void subset(int s,int k,int r){
		if(k<n){
			x[k]=1;
			if(s+w[k] == m)
				disp();
			else if(s+w[k]+w[k+1] <= m)
				subset(s+w[k],k+1,r-w[k]);
			if(s+r-w[k] >=m && s+w[k+1] <= m){
				x[k] =0;
				subset(s,k+1,r);
			
			}
			x[k]=0;
		}
	}
	public void disp(){
		for(int i=0;i<n;i++){
			if(x[i] != 0)
				System.out.print(w[i]+" ");
		}
		System.out.println();
	}

}

class Lab111 {
	public static void main(String args[]){
		new Subset();
	}
}
