import java.util.Scanner;

class GradeCalculator {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
		System.out.println("Enter Marks Of Physics :");
        int physics = sc.nextInt();
		
		System.out.println("Enter MArks Of Chemistry :");
        int chemistry = sc.nextInt();
		
		System.out.println("Enter Marks of Maths :");
        int maths = sc.nextInt();

        double average = (physics + chemistry + maths) / 3.0;

        System.out.println("Average Marks : " + average);

        if (average >= 90) {
            System.out.println("Grade: A | Excellent");
        } else if (average >= 75) {
            System.out.println("Grade: B | Very Good");
        } else if (average >= 60) {
            System.out.println("Grade: C | Good");
        } else if (average >= 40) {
            System.out.println("Grade: D | Pass");
        } else {
            System.out.println("Grade: F | Fail");
        }
    }
}
