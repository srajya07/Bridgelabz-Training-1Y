import java.util.Scanner;
class GreatestFactor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the no. : ");
        int n = sc.nextInt();
		
		if(n>0){
			for(int i=n-1; i>0; i--){
                if(n%i==0){
					System.out.println(i);
					break;
				}
			}
		}else{
			System.out.println("Invalid Input");
		}
		
    }
}
