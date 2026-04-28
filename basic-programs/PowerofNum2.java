import java.util.Scanner;
class PowerofNum2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the no. : ");
        int num = sc.nextInt();
		System.out.print("Rise to the power : ");
        int pow = sc.nextInt();
		int r=1;
		
		if(n>0){
			int i=1;
			while(i<=p){
                r=r*num;
                i++;
            }
			System.out.print("The result is : "+r);
		}else{
			System.out.println("Invalid Input");
		}
		
    }
}
