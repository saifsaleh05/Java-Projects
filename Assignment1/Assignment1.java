/*
 Name: Saifeddin Saleh
 ID: 1231474
 Lab section: 3
 Lecture section: 2
 */

package Assignment1;
import java.util.Scanner;
public class Assignment1 {
	public static void main(String [] args) {
		int x;
		System.out.println("Welcome to the Scientific Calculator!");
		System.out.println("Please enter your first name: ");
		Scanner input  = new Scanner(System.in);
		String name = input.next();
		System.out.println("Please enter your 9-digit ID number: ");
		int id = input.nextInt();
		
		while(!isValidID(id) && id!=-1) {
			System.out.println("Please enter a valid ID or -1 to exit");
			 id = input.nextInt();
			 if(id==-1) {
				 return; 
			 }
		}
		System.out.println("ID is valid!");
		System.out.println("Welcome, "+name+"! Please select an option from the menu:");
		System.out.println("1. Calculate Sine, Cosine, and Tangent");
		System.out.println("2. Calculate Factorial");
		System.out.println("3. Decimal to Hexadecimal Conversion");
		System.out.println("4. Exit");
		System.out.println("Enter your choice: ");
		x = input.nextInt();
		if(x==1) {
			System.out.println("Enter an angle in degrees: ");
			int angle = input.nextInt();
			calculateTrigFunctions(angle);
		}
		else if(x==2) {
			System.out.println("Enter a positive integer: ");
			int number = input.nextInt();
			calculateFactorial(number);
		}
		else if(x==3) {
			System.out.println("Enter a positive integer: ");
			int decimal = input.nextInt();
			decimalToHex(decimal);
		}
		else if(x==4){
			return;
		}
		else {
			System.out.println("Invalid input");
		}
		

		while(x!=4) {
				System.out.println("1. Calculate Sine, Cosine, and Tangent");
				System.out.println("2. Calculate Factorial");
				System.out.println("3. Decimal to Hexadecimal Conversion");
				System.out.println("4. Exit");
				System.out.println("Enter your choice: ");
				x=input.nextInt();
				switch(x){
				case 1:
					System.out.println("Enter an angle in degrees: ");
					int angle = input.nextInt();
					calculateTrigFunctions(angle);
					break;
				case 2:
					System.out.println("Enter a positive integer: ");
					int number = input.nextInt();
					calculateFactorial(number);
					break;
				case 3:
					System.out.println("Enter a positive integer: ");
					int decimal = input.nextInt();
					decimalToHex(decimal);
					break;
				case 4:
					System.out.println("Goodbye!");
					x=4;
					break;
					default:
						System.out.println("Invaild input");
				}
			}
		
	
	}
	public static boolean isValidID(int id) {
		int count = 0;
		int tmp = id;
		int digit;
		int sum =0;
		while(tmp!=0) {
			count++;
			tmp/=10;
		}
		for(int i=1;i<=9;i++) {
			digit = id%10;
			if(i%2==0) {
				digit *=2;
				if(digit>=10) {
					digit = (digit%10)+1;
				}
			}
			id/=10;
			sum += digit;
		}
		if(count==9 && sum%10==0) {
			return true;
		}
		else {
			return false;
		}
	}
	public static void calculateTrigFunctions(int angle) {
		double radians = angle*(Math.PI/180.0);
		double sine = Math.sin(radians);
		double cosine = Math.cos(radians);
		double tangent = Math.tan(radians);
		System.out.printf("Sine(%d) = %.4f\n", angle,sine);
		System.out.printf("Cosine(%d) = %.4f\n", angle, cosine);
		System.out.printf("Tangent(%d) = %.4f\n", angle, tangent);
	}
	public static void calculateFactorial(int number) {
		if(number<0) {
			System.out.println("Please enter a positve integer");
			return;
		}
		int factorial = 1;
		int fact = 1;
		int tmp = number;
		while(tmp>=1) {
			factorial *= fact;
			tmp--;
			fact++;
		}
		System.out.println(number+"! = "+factorial);
		System.out.println();
	}
	public static void decimalToHex(int decimal) {
		int original = decimal;
		if(decimal<0) {
			System.out.println("Please enter a positve integer");
			return;
		}
		else if(decimal==0) {
			System.out.println("0");
			return;
		}
		
		int remainder;
		String number = "";
		while(decimal>0) {
			remainder = decimal%16;
			if(remainder<10) {
				number = remainder + number;
			}
			else {
				switch(remainder) {
				case 10:
					number = 'A'+number;
					break;
				case 11:
					number = 'B'+number;
					break;
				case 12:
					number = 'C'+number;
					break;
				case 13:
					number = 'D'+number;
					break;
				case 14:
					number = 'E'+number;
					break;
				case 15:
					number = 'F'+number;
				}
			}
			decimal /=16;
		}
		System.out.println("Hex representation of "+original+" is "+number);
	}
	
 }

