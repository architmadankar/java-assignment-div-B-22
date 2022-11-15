package sed;
import java.util.Scanner;
import java.text.SimpleDateFormat;  
import java.util.Date;  
public class testing {


	public static void main(String[] args) {
		
		
		Scanner sc=new Scanner(System.in);
		Date date=java.util.Calendar.getInstance().getTime();  


		
		
		
		
		printStars();


		System.out.println("\n\n\n"
				+ "WELCOME TO RIDE-SHARING CHARGES ESTIMATOR AND COMPARISON SYSTEM"
				+ "\n\n");
			
		printStars();


		System.out.print("\n\nDeveloped by Archit\n"
			+ "OODP101 Object Oriented Design and Programming\n"
			+ date
			+ "\n\n\n");


		printStars();
		
		
		int option = printMenu();
		handleMenu(option);
		
	}

public static void printStars() {

	for(int i=0;i<100;i++) {
	 System.out.print("*");
			}
		
}
	

public static int printMenu() { 
	
	
	int userSelection;
	Scanner sc= new Scanner(System.in);
	
	System.out.println("\n\n1. Enter usage details");
	System.out.println("2. Display charges under UBER");
	System.out.println("3. Display charges under RAPIDO");
	System.out.println("4. Display Charges under OLA");
	System.out.println("5. Show Report");
	System.out.println("6. Exit");
	userSelection=sc.nextInt();
	
	
		while(userSelection<1||userSelection>6) {
			System.out.println("Error! ::::::::: Please Enter number 1 to 6 only");
			printMenu();
				}
			return userSelection;
}



public static double handleMenu(int userOption) {
	Scanner sc=new Scanner(System.in);
	int date;
	int month;
	double time;
	double charges=0;
	double kms=1;
	switch (userOption) {
	case 1: 
	{
		System.out.println("Enter your name");
		String name=sc.next();
		System.out.println("Enter the approximate Kms");
		kms=sc.nextDouble();
		System.out.println("Month of travel");
		month = sc.nextInt();
		
		while(month > 12 || month < 1) {
			System.out.println("Error!! Please enter the correct month");
			month = sc.nextInt();

		}
		
		
		
		System.out.println("On which date of this month, you would like to travel?");
		date = sc.nextInt();
		
		
		while(date < 1 || date > 31) {
			System.out.println("Error!! Please enter the correct Date");
			date = sc.nextInt();

		}
		
		
		System.out.println("Now enter the time of trave; using 24 hour clock just like 9.00 for 9am, 13.00 for 1pm, 14.30 for 2:30pm");
		time = sc.nextDouble();
	}
	
	case 2: {
		
		charges= kms*1.15;
		System.out.println("Your UBER fare is A$" + charges);
	}

	case 3: {
		
		charges= kms*1.08;
		System.out.println("Your RAPIDO fare is A$" + charges);
	}

	case 4: {
		
		charges= kms*1.35;
		System.out.println("Your OLA fare is A$" + charges);
	}

	case 5: {
		
		System.out.println("Report");
	}

	case 6: {
		
		System.out.println("Thank you for using our applcation and good bye>>>>>>");
	}
	}
	
	return charges;
	
}







	
}
