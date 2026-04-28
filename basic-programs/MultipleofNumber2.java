import java.util.Scanner;
class MultipleOfNumber2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the no. : ");
        int n = sc.nextInt();
		
		if(n>0 && n<=100){
			int i=n-1;
            while(i>1){
                if(n%i==0){
					System.out.println(i);
				}
                i--;
            }
		}else{
			System.out.println("Invalid Input");
		}
		
    }
}
