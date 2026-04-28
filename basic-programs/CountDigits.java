import java.util.Scanner;

class CountDigits {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
		System.out.println("Enter Number For Which You have to Count :");
        int number = sc.nextInt();

        int count = 0;

        while (number != 0) {
            number = number / 10;
            count++;
        }

        System.out.println("Number of digits : " + count);

    }
}
