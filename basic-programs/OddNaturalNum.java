import java.util.Scanner;
class OddNaturalNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        for (int i = 1; i < x; i += 2) {
            System.out.print(i + " ");
        }
    }
}
