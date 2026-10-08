  import java.util.Scanner;

class Student {
    private String name, course;
    private int roll, credits;
    private double marks;

    public Student(String name, int roll, double marks, String course, int credits) {
        this.name = name;
        this.roll = roll;
        this.marks = marks;
        this.course = course;
        this.credits = credits;
    }

    public double calculateFee() { return credits * 1500.0; }
    public boolean checkEligibility() { return marks >= 50.0; }

    public double calculateScholarship() {
        double fee = calculateFee();
        if (marks >= 85) return fee * 0.20;
        if (marks >= 70) return fee * 0.10;
        return 0.0;
    }

    public double calculateFinalFee() { return calculateFee() - calculateScholarship(); }

    public void displayDetails() {
        System.out.println("\n--- Registration Details ---");
        System.out.println("Name: " + name + " | Roll: " + roll + " | Course: " + course);
        System.out.println("Marks: " + marks + " | Credits: " + credits);
        System.out.println("Total Fee: Rs. " + calculateFee());
        System.out.println("Scholarship: Rs. " + calculateScholarship());
        System.out.println("Final Fee: Rs. " + calculateFinalFee());
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Name, Roll, Marks, Course, Credits: ");
        Student s = new Student(sc.next(), sc.nextInt(), sc.nextDouble(), sc.next(), sc.nextInt());

        if (s.checkEligibility()) {
            s.displayDetails();
        } else {
            System.out.println("\nNot Eligible: Marks are below 50.");
        }
    }
}