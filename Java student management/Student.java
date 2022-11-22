import java.util.Scanner;

import javax.security.sasl.SaslException;
public class Student{
    private String firstName;
    private String lastName;
    private int year;
    private String studentID;
    private String courses;
    private double tuitionBalances;
    private int costOfCourses = 300;
    private static int id  = 800;


    //Create a constructor for name and year of students
    public Student(){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter your first name: ");
        this.firstName = in.nextLine();

        System.out.print("Enter your last name: ");
        this.lastName = in.nextLine();

        System.out.print("Enter your current year: ");
        this.year = in.nextInt();
        setStudentID();
        /*switch(year){
            case 1:
            String year = "first";
            System.out.println("Welcome, "+firstName+" "+lastName+" "+"in"+" "+year+" year"+" with the id of "+studentID);
            break;
            case 2:
            year = "second";
            System.out.println("Welcome, "+firstName+" "+lastName+" "+"in"+" "+year+" year"+" with the id of "+studentID);
            break;
            case 3:
            year = "third";
            System.out.println("Welcome, "+firstName+" "+lastName+" "+"in"+" "+year+" year"+" with the id of "+studentID);
            break;
            case 4:
            year = "fourth";
            System.out.println("Welcome, "+firstName+" "+lastName+" "+"in"+" "+year+" year"+" with the id of "+studentID);
            break;
            case 5:
            year = "fifth";
            System.out.println("Welcome, "+firstName+" "+lastName+" "+"in"+" "+year+" year"+" with the id of "+studentID);
            break;
            default:
            System.out.println("Error, please try again");

        }*/
       

    }

    //ID generator
    private String setStudentID(){
        // Year + ID;
        id++;
        this.studentID = year +""+id;
        return this.studentID;

    }

    //Courses enrolled
    public void enrolled(){
        //Get inside a loop, user hits 0
        do{
        System.out.println("Enter course to enroll (Q to quit): ");
        Scanner in = new Scanner(System.in);
        String course = in.nextLine();
        if(!course.equals("Q")){
            courses += "\n" + course;
            tuitionBalances += costOfCourses;
        }   
        else{
            break;
        }
    } while(1!=0);
        //System.out.println("ENROLLED IN: "+courses);
        //System.out.println("TUTION BALANCE: "+tuitionBalances);


    }

    //Show status
    public String showInfo(){
        return "Name: "+firstName+" "+lastName+"\nCourses enrolled: "+courses+"\nYear: "+year+"\nStudent ID: "+studentID+"\nBalance: $" +tuitionBalances; 
    }

    //View balance
    public void viewBalance(){
        System.out.println("Your tuition balance is: $ "+tuitionBalances);
    }

    //Pay tuition
    public void payTuition(){
        viewBalance();
        System.out.print("Please make your payment now. Enter the amount you want to pay: ");
        Scanner in = new Scanner(System.in);
        double payment = in.nextDouble();
        tuitionBalances = tuitionBalances - payment;
        System.out.println("Thank you for your payment of $ "+payment);
        if(tuitionBalances < 0){
            tuitionBalances =0;
            System.out.println("Your tuition balance is: $ "+tuitionBalances);
        }
        else{
        
        viewBalance();
        }
    }



public static void main(String[] args){
    //Ask how many new users to add
    System.out.print("Enter the number of of students to enroll: ");
    Scanner in = new Scanner(System.in);
    int numOfStudents = in.nextInt();
    Student[] students = new Student[numOfStudents];
    // Create n students
    for(int i=0;i<numOfStudents;i++){
        students[i] = new Student();
        students[i].enrolled();
        students[i].payTuition();

    }
    for(int i=0;i<numOfStudents;i++){
    System.out.println(students[i].showInfo());
    }

    /*Student stud1 = new Student();
    stud1.enrolled();
    stud1.payTuition();
    System.out.println(stud1.showInfo());*/

   
}
}