import java.util.Scanner;

class Question15{
    public static void main(String... args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        int n = sc.nextInt();

   
        if (n <= 0) {
            System.out.println("Please enter a natural number");
        } else {

            long factorial = 1;
            for (int i = 1; i <= n; i++) {
                factorial = factorial * i;
            }

            System.out.println("Factorial of " + n + " is: " + factorial);
        }

    }
}
