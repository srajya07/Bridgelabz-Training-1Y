import java.util.Scanner;
class PowerofNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the no. : ");
        int num = sc.nextInt();
		System.out.print("Rise to the power : ");
        int pow = sc.nextInt();
		int r=1;
		
		if(n>0){
			for(int i=0; i<pow; i++){
				r=r*num;
			}
			System.out.print("The result is : "+r);
		}else{
			System.out.println("Invalid Input");
		}
		
    }
}
