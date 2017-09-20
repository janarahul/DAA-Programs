
import java.util.Scanner;

 class Stud{
    private String usn;
    private String name;
    private String branch;
    private long phono ;

    void getinfo(){
        Scanner in = new Scanner(System.in);
        System.out.printf("Enter usn,name,branch,phono\n");
        usn=in.nextLine();
        name=in.nextLine();
        branch=in.nextLine();
        phono=in.nextLong();
    }
	void display(){

        System.out.printf("USN=%-10s\tNAME=%s\tBRANCH=%s\tPHONO=",usn,name,branch);
	System.out.println(phono);

    }
};

public class Student{
    private static int n;
    static private int i;
    public static void main(String[] args){
        Scanner inn = new Scanner(System.in);
        System.out.printf("Enter no students");
        n=inn.nextInt();
        Stud[] students = new Stud[n];
        for(i=0;i<n;i++){
            students[i] = new Stud();
            students[i].getinfo();
        }
        for(i=0;i<n;i++){
            students[i].display();
        }
    }
};
