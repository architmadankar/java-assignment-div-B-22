import java.util.Scanner;
import java.text.DateFormatSymbols;
import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Comparision {
	// Year to use calculating is fixed at 2021 because of the below note.
	// Note: We will use these to find out if it is falling in weekend category or
	// not and We will use 2021 as a default year.
	public static final int year = 2021;

	// Main logic.
	public static void main(String[] args) {
		// Declaration and initialising.
		int userSelection = 0;
		String name = "";
		double kms = 0.0;
		int month = 0;
		int date = 0;
		double time = 0.0;
		double[] chargesList = { 0.0, 0.0, 0.0 };
		final String[] companyNameList = { "UBER", "RAPIDO", "OLA" };
		final String haveNotEnteredUsageDetailsMessage = "Please enter usage details first!!!\n";

		// Display welcome message.
		displayWelcomeMessage();
		printStars();

		// Display the menu and enter user selection.
		userSelection = enterMenuOption();

		while (userSelection != 6) {
			switch (userSelection) {
			case 1: {
				// Enter usage details.
				name = enterName();
				kms = enterKiloMeters();
				month = enterTravelMonth();
				date = enterTravelDate(month);
				time = enterTravelTime();

				// Calculate charges.
				chargesList[0] = calculateCharges(kms, month, date, time, 1);
				chargesList[1] = calculateCharges(kms, month, date, time, 2);
				chargesList[2] = calculateCharges(kms, month, date, time, 3);

				break;
			}
			case 2: {
				if (name == "") {
					System.out.println(haveNotEnteredUsageDetailsMessage);
				} else {
					displayTravelDetails(companyNameList[0], chargesList[0], month, date, time);
				}
				break;
			}

			case 3: {
				if (name == "") {
					System.out.println(haveNotEnteredUsageDetailsMessage);
				} else {
					displayTravelDetails(companyNameList[1], chargesList[1], month, date, time);
				}
				break;
			}

			case 4: {
				if (name == "") {
					System.out.println(haveNotEnteredUsageDetailsMessage);
				} else {
					displayTravelDetails(companyNameList[2], chargesList[2], month, date, time);
				}
				break;
			}

			case 5: {
				if (name == "") {
					System.out.println(haveNotEnteredUsageDetailsMessage);
				} else {
					displayMostExpensiveAndCheapestCompanyInfo(chargesList, companyNameList);
				}
			}
			}
			// Display the menu and enter user selection again.
			userSelection = enterMenuOption();
		}

		if (name == "") {
			System.out.println("Thank you for using our system and good bye>>>>>> ");
			System.out.println("Developed by Archit Madankar, 1132220243");
		} else {
			System.out.println("Thank you " + name + " for using our system and good bye>>>>>> ");
			System.out.println("Developed by Archit Madankar, 1132220243");
		}
	}

	// Display the welcome message.
	public static void displayWelcomeMessage() {
		// Declaration and initialising.
		Date date = java.util.Calendar.getInstance().getTime();

		// Display the welcome message.
		printStars();
		System.out.println("WELCOME TO RIDE-SHARING CHARGES ESTIMATOR AND COMPARISON SYSTEM\n");
		System.out.println("Developed by Archit Madankar, 1132220243");
		System.out.println("OODP101 Object Oriented Design and Programming");
		System.out.println(date + "\n");
	}

	// Printing star line.
	public static void printStars() {
		for (int i = 0; i < 80; i++) {
			System.out.print("*");
		}
		System.out.print("\n");
	}

	// Enter name.
	public static String enterName() {
		// Declaration and initialising.
		String name = "";
		Scanner sc = new Scanner(System.in);

		// Enter name.
		System.out.println("Enter your name");
		name = sc.nextLine();

		return name;
	}

	// Enter distance.
	public static int enterKiloMeters() {
		// Declaration and initialising.
		int kms = 0;
		Scanner sc = new Scanner(System.in);

		// Enter killometers by user.
		System.out.println("Enter the travel distance in kilometers(KM) :");
		kms = sc.nextInt();

		// Check user entered killometers is valid or invalid.
		// If the killometers is invalid, prompt the user to enter again until entering
		// valid killometers.
		while (kms < 1) {
			System.out.println("Error!! Please enter the number more than 0KM :");
			kms = sc.nextInt();
		}

		return kms;
	}

	// Enter travel month.
	public static int enterTravelMonth() {
		// Declaration and initialising.
		int month = 0;
		Scanner sc = new Scanner(System.in);

		// Enter month by user first time.
		System.out.println("Month of travel in numbers, January is 1 and June is 6");
		month = sc.nextInt();

		// Check user entered month is valid or invalid.
		// If the date is invalid, prompt the user to enter again until entering valid
		// month.
		while (month < 1 || month > 12) {
			System.out.println("Error!! Please enter the correct Month");
			month = sc.nextInt();
		}

		return month;
	}

	// Enter travel date.
	public static int enterTravelDate(int month) {
		// Declaration and initialising.
		int maxDateOfMonth = 0;
		int date = 0;

		// Get maximum date of month.
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month - 1);
		maxDateOfMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

		// Enter travel date by user first time.
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the date in number between 1 - " + maxDateOfMonth);
		date = sc.nextInt();

		// Check user entered date is valid or invalid.
		// If the date is invalid, prompt the user to enter again until entering valid
		// date.
		while (date < 1 || date > maxDateOfMonth) {
			System.out.println("Error!! Please enter the correct Date");
			date = sc.nextInt();
		}

		return date;
	}

	// Enter travel time in 24 hour "peak"&"normal" season.
	public static double enterTravelTime() {
		// Declaration and initialising.
		Scanner sc = new Scanner(System.in);
		double time = 0.0;

		// Enter travel time by user first time.
		System.out.println(
				"Now enter the time in 24 hour clock notation (7am for 7.00, 1pm for 13.00 or 9pm for 21.00) ");
		time = sc.nextDouble();

		// Check user entered date is valid or invalid.
		// If the date is invalid, prompt the user to enter again until entering valid
		// time.
		while (time < 0.00 || time > 23.59) {
			System.out.println("Error! ::::::::: Please time using 24 hour clock notation");
			time = sc.nextDouble();
		}

		return time;
	}

	// Calculate charges.
	public static double calculateCharges(double kilometers, int month, int date, double time, int companyNumber) {
		// Declaration and initialising.
		// The data order is first one is company 1, next one is company 2...
		final double[] baseChargesList = { 5.50, 4.50, 6.0 };
		final double[] distanceChargesList = { 0.75, 0.85, 0.95 };
		final double[] peaktimeSurchargesList = { 2.50, 2.00, 1.50 };
		final double[] weekendSurchargesList = { 3.00, 2.50, 2.00 };
		double peaktimeSurcharges = 0.0;
		double weekendSurcharges = 0.0;
		int useChargesIndex = companyNumber - 1; // setting use data index because company number does not start from zero.

		// Initialising.
		if (isPeakTime(time)) {
			peaktimeSurcharges = peaktimeSurchargesList[useChargesIndex];
		}
		if (isWeekend(month, date)) {
			weekendSurcharges = weekendSurchargesList[useChargesIndex];
		}

		// Calculate and return total charges.
		return baseChargesList[useChargesIndex] + (distanceChargesList[useChargesIndex] * kilometers)
				+ peaktimeSurcharges + weekendSurcharges;
	}

	// Display travel details.
	public static void displayTravelDetails(String companyName, double charges, int month, int date, double time) {
		// Declaration and initialising.
		String dayOfWeekString = getDayOfWeekString(month, date);
		String monthString = getMonthString(month);

		// Display travel details.
		printStars();
		System.out.println();
		System.out.println("Your travel details:- Day of the Week on " + date + " of the month - " + monthString
				+ " is " + dayOfWeekString);
		if (isWeekend(month, date)) {
			System.out.println("Your day of travel falls under weekend category");
		} else {
			System.out.println("Your day of travel does not falls under weekend category");
		}
		System.out.println();
		if (isPeakTime(time)) {
			System.out.println("Time falls in peaktime category");
		} else {
			System.out.println("Time does not falls in peaktime category");
		}
		System.out.println();
		System.out.println("So charges will be applied accordingly");
		System.out.println();
		System.out.println("The final charges under " + companyName + " is: " + charges);
		printStars();
	}

	// Check if time is peak time.
	public static boolean isPeakTime(double time) {
		return (7.00 <= time && time <= 9.00) || (16.00 <= time && time <= 18.00);
	}

	// Check if day of week by month and date is weekend.
	public static boolean isWeekend(int month, int date) {
		// Declaration and initialising.
		int dayOfWeek = LocalDate.of(year, month, date).getDayOfWeek().getValue();

		return dayOfWeek == DayOfWeek.SATURDAY.getValue() || dayOfWeek == DayOfWeek.SUNDAY.getValue();
	}

	// Getting day of week string by month number and date number.
	public static String getDayOfWeekString(int month, int date) {
		return LocalDate.of(year, month, date).getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.getDefault())
				.toUpperCase();
	}

	// Getting month string by month number.
	public static String getMonthString(int month) {
		return new DateFormatSymbols().getMonths()[month - 1].toUpperCase();
	}

	// Print menu.
	public static void printMenu() {
		// Printing the menu.
		System.out.println("1. Enter User Details");
		System.out.println("2. Display charges under UBER");
		System.out.println("3. Display charges under RAPIDO");
		System.out.println("4. Display Charges under OLA");
		System.out.println("5. Show Report");
		System.out.println("6. Exit");
	}

	// Enter user selection menu option.
	public static int enterMenuOption() {
		// Declaration and initialising.
		int userSelection = 0;
		Scanner sc = new Scanner(System.in);

		// Printing the menu.
		printMenu();

		// Enter user selection.
		userSelection = sc.nextInt();

		// Check user entered option is valid or invalid.
		// If the option is invalid, prompt the user to enter again until entering valid
		// option.
		while (userSelection < 1 || userSelection > 6) {
			System.out.println("Error! ::::::::: Please Enter number 1 to 6 only\n");
			printMenu();
			userSelection = sc.nextInt();
		}

		return userSelection;
	}

	// Display most expensive and the cheapest company information.
	public static void displayMostExpensiveAndCheapestCompanyInfo(double[] chargesList, String[] companyNameList) {
		// Declaration and initialising.
		double cheapestCharges = 0.0;
		double mostExpensiveCharges = 0.0;
		int cheapestInfoIndex = 0;
		int mostExpensiveInfoIndex = 0;

		// Get most expensive and the cheapest company information.
		for (int i = 0; i < chargesList.length; i++) {
			if (chargesList[i] <= cheapestCharges || cheapestCharges == 0.0) {
				cheapestCharges = chargesList[i];
				cheapestInfoIndex = i;
			}
			if (mostExpensiveCharges <= chargesList[i] || mostExpensiveCharges == 0.0) {
				mostExpensiveCharges = chargesList[i];
				mostExpensiveInfoIndex = i;
			}
		}

		// Display the most expensive and cheapest company information.
		printStars();
		System.out.println("The cheapest company is " + companyNameList[cheapestInfoIndex]);
		System.out.println("Most expensive company is " + companyNameList[mostExpensiveInfoIndex]);
		printStars();
	}
}
