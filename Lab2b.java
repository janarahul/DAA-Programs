import java.util.*;
import java.io.*;

public class Lab2b {

	String name,dob;
	Scanner sc = new Scanner(System.in);
	
	public void getInfo() {
		System.out.println("Enter name:");
		name = sc.nextLine();

		System.out.println("Enter doB:");
		dob = sc.next();
	}
	
	public void tokenize() {
		StringTokenizer token = new StringTokenizer(dob, "/");
		System.out.print(name);
		while(token.hasMoreElements()) {
			System.out.print(", "+token.nextToken());
		}
		System.out.println();
	
	}

	public static void main(String args[]) {
		Lab2b obj = new Lab2b();
		obj.getInfo();
		obj.tokenize();
	}
	

} 
