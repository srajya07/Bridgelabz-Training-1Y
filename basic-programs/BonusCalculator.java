import java.util.Scanner;
class BonusCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter Your Salary : ");
        int x = sc.nextInt();
		
		System.out.print("How long are you serving : ");
		int t = input.nextInt();
		
		if(t>5){
			int b = (x*5)/100;
			System.out.println("Your Bonus is : Rs. " +b);
		}else{
			System.out.println("You are not eligible for bonus");
		}
        
    }
}
