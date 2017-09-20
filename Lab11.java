import java.util.*;

class Subset {
        int[] w;
        int[] x;
        int m,n;
	Subset(){
                
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter no of values in set");
                n=sc.nextInt();
                w = new int[n+1];//the values in the set
                x = new int[n];//solution vector
		w[n] = 0;//set last one to 0,only for terminating condition
                System.out.println("Enter the values");
                for(int i=0;i<n;i++){
                        w[i] =sc.nextInt();
                }
                System.out.println("Enter sum required");
                m=sc.nextInt();//the required sum
		
                subset(0,0,sum());//sum considered,element no,remaining sum


	}
	int sum(){ // imp funtion
		int sum=0;
		for(int i=0;i<n;i++){
			sum += w[i]; 
		}
		return sum;
	}
	
        public void subset(int s, int k,int r){
		if(k<n) {
            		x[k]=1;
        	        if(s+w[k] == m)
        	                disp();
        	        else if(s+w[k]+w[k+1] <= m){
        	                subset(s+w[k],k+1,r-w[k]);
			}
        	        if(s+r-w[k] >= m ){//&& s+w[k+1]<= m){
				x[k] = 0;
       	 	                subset(s,k+1,r-w[k]);
			}
			x[k] = 0;
		}
        }
        public void disp() {
                for(int i=0;i<n;i++){
                        if(x[i] ==1)
                                System.out.print(w[i]+" ");
                }
		System.out.println();
        }

}
class Lab11 {
	
	public static void main(String[] args){
		new Subset();	
	}
}
