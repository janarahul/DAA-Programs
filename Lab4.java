import java.util.*;
import java.io.*;

class QuickSort {
	int[] a = new int[1000000];
	
	
	public void quickSort(int low,int high) {
		if(low < high) {
			int s= partition(low,high);
			quickSort(low,s-1);
			quickSort(s+1,high);
			//for(int i=0;i<5;i++){System.out.printf("%d ",a[i]);}
			
		}

	}
	public void swap(int i,int j) {
		int tmp;
		tmp=a[i];
		a[i]=a[j];
		a[j]=tmp;
	}
 
	public int partition(int low,int high) {
		int i=low,j=high+1,p=a[low];
		
	
		do {
			do {
				i=i+1;
			}while(a[i]<p && i<high);

			do {
				j=j-1;
			}while(a[j]> p && j >low);
			if(i<j) {
				swap(i,j);
			}

		}while(i<j);	
		swap(j,low);
		return j;
	}
};

public class Lab4 {

	public static void main(String[] args) throws IOException {
		
		QuickSort obj = new QuickSort();
		double start,end;
		Random rd = new Random();
		File file = new File("Qplot.txt");
		file.createNewFile();
		FileWriter fw = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write("TitleText:Quicksort" +"\n");
		for(int i=5000;i<1000000;i=i+500){
		
			for(int j=0;j<i;j++) {
				obj.a[j]=rd.nextInt(1000000);
			}
		
			start=System.currentTimeMillis();
			obj.quickSort(0,i-1);
			//for(int k=0;k<5;k++){System.out.printf("%d ",obj.a[k]);}

			end=System.currentTimeMillis();
			bw.write(i+"\t"+(end-start)*0.001+"\n");
		}
		bw.close();
		fw.close();
	}
};
