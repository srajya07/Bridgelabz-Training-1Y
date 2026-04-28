import java.util.Scanner;

class BMICalculator {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
		System.out.println("Enter Your Weight in Kg :");
        float weight = sc.nextFloat();
		
		System.out.println("Enter Yout Height in Cm :");
        float height = sc.nextFloat(); 

        float heightMeter = height / 100;
         bmi = weight / (heightMeter * heightMeter);

        System.out.println("BMI : " + bmi);

        if (bmi < 18.5) {
            System.out.println("Underweight");
        } else if (bmi < 25) {
            System.out.println("Normal weight");
        } else if (bmi < 30) {
            System.out.println("Overweight");
        } else {
            System.out.println("Obese");
        }
    }
}
