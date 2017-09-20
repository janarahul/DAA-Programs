class MergeSort {
	int a[] = new int[1000000];
	int temp[] = new int[1000000];
	void mergeSort(int low,int high){
		if(low<high){
			int mid = low + (high-low)/2;
			mergeSort(low,mid);
			mergeSort(mid+1,high);
			simpleMerge(low,mid,high);
		}

	}
	void simpleMerge(int low,int mid,int high){
		for(int i=low;i<=high;i++){
			temp[i]=a[i];
		}
		int i=low,j=low,k=mid+1;
		while(i<=mid && k<=high){
			if(temp[i] < temp[k]){
				a[j] =temp[i];
				i++;
			}
			else{
				a[j]=temp[k];
				k++;
			}
			j++;
		}
		while(i<=mid){
			a[j]=temp[i];
			j++;
			i++;
		}
	}
	
}
public class Lab51 {

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
