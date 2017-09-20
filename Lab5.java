import java.util.*;
import java.io.*;

class MergeSort {
	int[] a = new int[1000000];
	int[] tmp = new int[1000000];
	
	public void mergeSort(int low,int high) {
		if(low < high) {
			int mid = low + (high-low)/2;
			mergeSort(low,mid);
			mergeSort(mid+1,high);
			merge(low,mid,high);
			//for(int i=0;i<5;i++){System.out.printf("%d ",a[i]);}
			
		}

	}
 
	public void merge(int low,int mid,int high) {
		int i,j,k;
		for(i=low;i<=high;i++) {
			tmp[i]=a[i];
		}
		i=low;
		j=low;
		k=mid+1;
	
		while(i<=mid && k <=high) {
			if(tmp[i]<tmp[k]) {
				a[j]=tmp[i];
				i++;
				j++;
			}
			else {
				a[j]=tmp[k];
				j++;
				k++;

			}

		}

		while(i<=mid) {
			a[j]=tmp[i];
			j++;
			i++;

		}		
	}
};

public class Lab5 {

	public static void main(String[] args) throws IOException {

		MergeSort obj = new MergeSort();
		double start,end;
		Random rd = new Random();
		File file = new File("plot.txt");
		file.createNewFile();
		FileWriter fw = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);

		for(int i=5000;i<1000000;i=i+500){
		
			for(int j=0;j<i;j++) {
				obj.a[j]=rd.nextInt(1000000);
			}
		
			start=System.currentTimeMillis();
			obj.mergeSort(0,i-1);
			end=System.currentTimeMillis();
			bw.write(i+"\t"+(end-start)*0.001+"\n");
		}
		bw.close();
		fw.close();
	}
};
