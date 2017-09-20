import java.util.*;
import java.io.*;

class Lab3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a= sc.nextInt();
		int b = sc.nextInt();	
		try {
			System.out.println((a/b));
		} catch (ArithmeticException e1) {
			System.out.println(e1.toString());
			e1.printStackTrace();

		} finally {
			System.out.println("Exception Handled Succefully");
		}

	}


}
