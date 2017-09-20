import java.util.*;
import java.io.*;

class QuickSort {
	int a[] = new int[1000000];

	void quickSort(int l,int h){
		if(l<h){
			int s= partition(l,h);
			quickSort(l,s-1);
			quickSort(s+1,h);
		}

	}
	void swap(int i,int j){
		int temp;
		temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	int partition(int low,int high){
		int i=low;
		int j=high+1;
		int l=i;
		do{
			do{
				i++;
			}while(a[i] < a[l] && i< high);
			do{
				j--;
			}while(a[j] > a[l]&& j> low);
			if(i<j){
				swap(i,j);
			}
		}while(i<j);
		swap(l,j);
		return j;
	}

}
public class Lab41 {

	public static void main(String[] args) throws IOException {

		QuickSort obj = new QuickSort();
		/*double start,end;
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
			obj.quickSort(0,i-1);
			end=System.currentTimeMillis();
			bw.write(i+"\t"+(end-start)*0.001+"\n");
		}
		bw.close();
		fw.close();
		*/
		Random rd = new Random();
		for(int i =0;i<5;i++)
			obj.a[i]=rd.nextInt(5);
		obj.quickSort(0,4);
		for(int i =0;i<5;i++)
			System.out.println(obj.a[i]);
	}
};
