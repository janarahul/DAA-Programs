import java.util.*;

class Staff {
	String staffId,name,phoNo;
	float salary;

	public Staff() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter id,name,phoNo,salary");
		staffId = sc.next();
		name = sc.next();
		phoNo = sc.next();
		salary = sc.nextFloat();
	}
	void display() {
		System.out.printf("Name=%s Id=%s Phono=%s Salary=%f\n", name, staffId, phoNo, salary);
	}
}

class Teaching extends Staff {
	String domain,pub;

	public Teaching() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter domain,publications");
		domain = sc.next();
		pub = sc.next();
	}
		
	void display() {
		super.display();
		System.out.printf("Domain=%s\n Publications=%s\n", domain, pub);
	}


}

class Technical extends Staff {
	String skills;

	public Technical() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Skills");
		skills = sc.next();
	}
		
	void display() {
		super.display();
		System.out.printf("Skills=%s\n", skills);
	}


}

class Contract extends Staff {
	String period;

	public Contract() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter period");
		period = sc.next();
	}
		
	void display() {
		super.display();
		System.out.printf("Period=%s\n", period);
	}


}

public class Lab2 {
	public static void main(String[] args) {
		int i;
		Teaching ob1[] = new Teaching[3];
		for(i=0;i<3;i++) {
			System.out.println("Enter "+ (i+1) +" Teaching details\n");	
			ob1[i] = new Teaching();
		}
		
		Technical ob2[] = new Technical[3];
		for(i=0;i<3;i++) {
			System.out.println("Enter "+ (i+1) +" Technical details\n");	
			ob2[i] = new Technical();
		}

		Contract ob3[] = new Contract[3];
		for(i=0;i<3;i++) {
			System.out.println("Enter "+ (i+1) +" Contract details\n");	
			ob3[i] = new Contract();
		}
		System.out.println("\nTeaching Details:");
		
		for(i=0;i<3;i++) {
			ob1[i].display();
		}

		System.out.println("\nTechnical Details:");
		for(i=0;i<3;i++) {
			ob2[i].display();
		}
		System.out.println("\nContract Details:");
		for(i=0;i<3;i++) {
			ob3[i].display();
		}
	}	

}
