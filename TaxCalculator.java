import java.util.*;
class TaxCalculator{
	public static void main(String args[]){
		Scanner scanner = new Scanner(System.in);
		
		boolean isContinueMainMenu = false;
		do{
			isContinueMainMenu = false;
			MainMenuSelect();
			
			System.out.print("Enter an option to continue : ");
			int option = scanner.nextInt();
			
			if(option <= 6 && option >= 1){
				switch(option){
					case 1:
						boolean isContinueWithHolding = false;
						do{
							clearConsole();
							
							isContinueWithHolding = false;
							WithHoldingMenuSelect();
							
							System.out.print("\nEnter an option to continue : ");
							int withHoldingOption = scanner.nextInt();
							
							if(withHoldingOption <= 5 && withHoldingOption >= 1){
								switch(withHoldingOption){
									case 1 :
										TaxCalculate("Rent Tax",100000,0.1);
										isContinueWithHolding = true;
										break;
									case 2 :
										TaxCalculate("Bank Interest Tax",0,0.05);
										isContinueWithHolding = true;
										break;
									case 3 :
										TaxCalculate("Dividend Tax Per Year",100000,0.14);
										isContinueWithHolding = true;
										break;
									case 4 :
										isContinueMainMenu = true;
										clearConsole();
										break;
									case 5 :
										return;
								}
							}else{
								System.out.print("\tInvalid Input...\n\nDo you want go to main menu(Y/N) : ");
								char doAgain = scanner.next().toUpperCase().charAt(0);
								if(doAgain == 'Y'){isContinueWithHolding = false; isContinueMainMenu = true;clearConsole();}
								else isContinueWithHolding = true;
							}
						}while(isContinueWithHolding);
						
						break;
					case 2 :
						clearConsole();
						
						DrawHeadingBox("PAYABLE TAX");
						System.out.println();
						System.out.println();
						TaxCalculate("Payable Tax Per Month",100000,0);
						isContinueMainMenu = true;
						
						clearConsole();
						break;
					case 3 :
						clearConsole();
						
						DrawHeadingBox("INCOME TAX");
						System.out.println();
						System.out.println();
						TaxCalculate("Income Tax Per Year",0,0);
						isContinueMainMenu = true;
						
						clearConsole();
						break;
					case 4 :
						clearConsole();
						
						DrawHeadingBox("Social Security Contribution Levy(SSCL) Tax");
						System.out.println();
						System.out.println();
						TaxCalculate("Value of Good or Service",0,0);
						isContinueMainMenu = true;
						
						clearConsole();
						break;
					case 5 :
						
						
						boolean isContinueLeasing = false;
						do{
							clearConsole();
							
							isContinueLeasing = false;
							LeasingPaymentSelect();
							
							System.out.print("\nEnter an option to continue : ");
							int leasingOption = scanner.nextInt();
							
							if(leasingOption <= 5 && leasingOption >= 1){
								switch(leasingOption){
									case 1:
										CalculateMonthlyInstallment();
										isContinueLeasing = true;
										break;
									case 2:
										SearchLeasingCategory();
										isContinueLeasing = true;
										break;
									case 3:
										FindTheLeasingAmount();
										isContinueLeasing = true;
										break;
									case 4:
										isContinueMainMenu = true;
										clearConsole();
										break;
									case 5:
										return;
								}
							}else{
								System.out.print("\tInvalid Input...\n\nDo you want go to main menu(Y/N) : ");
								char doAgain = scanner.next().toUpperCase().charAt(0);
								if(doAgain == 'Y'){isContinueLeasing = false; isContinueMainMenu = true;clearConsole();}
								else isContinueLeasing = true;
							}
						}while(isContinueLeasing);
						
						break;
					case 6 :
						return;
					}
			}else{
				System.out.print("\tInvalid Input...\n\nDo you want to exit(Y/N) : ");
				char doAgain = scanner.next().toUpperCase().charAt(0);
				if(doAgain == 'Y')isContinueMainMenu = false;
				else isContinueMainMenu = true;
			}
				
			 
		}while(isContinueMainMenu);
		
		
		//WithHoldingTaxCalculate("Value of Good or Service",0,0);
		//System.out.println(CalculateLeasingValue(2500000,22,3,true));
		//CalculateMonthlyInstallment();
		//SearchLeasingCategory();
		//DrawHeadingBox("Find The Leasing Amount");
		//FindTheLeasingAmount();
	}
	
	public static void MainMenuSelect(){
		
		DrawAsciiOfMainMenu();
		
		System.out.println("\t[1] Withholding Tax");
		System.out.println("\t[2] Payable Tax");
		System.out.println("\t[3] Income Tax");
		System.out.println("\t[4] Social Security Contribution Levy(SSCL) Tax");
		System.out.println("\t[5] Leasing Payment");
		System.out.println("\t[6] Exit\n\n");
	}
	
	public static void WithHoldingMenuSelect(){
		
		DrawHeadingBox("WITHHOLDING TAX");
		
		System.out.println();
		System.out.println();
		
		System.out.println("\t[1] Rent Tax");
		System.out.println("\t[2] Bank Interest Tax");
		System.out.println("\t[3] Dividend Tax");
		System.out.println("\t[4] Main Menu");
		System.out.println("\t[5] Exit");
	}
	
	public static void LeasingPaymentSelect(){
		
		DrawHeadingBox("LEASING PAYMENT");
		
		System.out.println();
		System.out.println();
		
		System.out.println("\t[1] Calculate Monthly Installment");
		System.out.println("\t[2] Serach Leasing Category");
		System.out.println("\t[3] Find Leasing Amount");
		System.out.println("\t[4] Main Menu");
		System.out.println("\t[5] Exit");
	}
	
	///////// method to calculate Withholding Taxes and handle Payable tax, Income tax , SSCL tax///////////
	public static void TaxCalculate(String taxType,int startOfTax, double taxRate){
		Scanner scanner = new Scanner(System.in);
		
		boolean isContinueTaxCal = false;
		do{
			isContinueTaxCal = false;
			System.out.printf("Enter %s : ",(taxType.equals("Income Tax Per Year")?"Total Income Per Year":(taxType.equals("Payable Tax Per Month")?"Employee Payment Per Month":taxType)));
			double taxPrice = scanner.nextDouble();
			if(taxPrice < 0) {
				System.out.print("\tInvalid Input...\n\nDo you want to enter the correct value again(Y/N) : ");
				char doAgain = scanner.next().toUpperCase().charAt(0);
				if(doAgain == 'Y')isContinueTaxCal = true;
				else isContinueTaxCal = false;
			}else if(taxPrice > startOfTax){
				
				double taxAmount;
				if(taxType.equals("Payable Tax Per Month"))taxAmount = PayableTaxCalculate(taxPrice);
				else if(taxType.equals("Income Tax Per Year"))taxAmount = IncomeTaxCalculate(taxPrice);
				else if(taxType.equals("Value of Good or Service")){taxAmount = SsclTaxCalculate(taxPrice);taxType = "SSCL Tax";}
				else if(taxType.equals("Dividend Tax Per Year")) taxAmount = (taxPrice-100000)*taxRate;
				else taxAmount = taxPrice*taxRate;
				
				System.out.print("\tYou have to pay "+taxType+" : "+taxAmount+"\n\nDo you want to calculate this again(Y/N) : ");
				char calculateAgain = scanner.next().toUpperCase().charAt(0);
				if(calculateAgain ==  'Y'){
					isContinueTaxCal = true;
				}
			}else if(taxPrice <= startOfTax && taxPrice >= 0){
				System.out.print("\tYou don't have to pay "+taxType+"...\n\nDo you want this tax calculation again(Y/N) : ");
				char calculateThisAgain = scanner.next().toUpperCase().charAt(0);
				if(calculateThisAgain == 'Y') isContinueTaxCal = true;
			}
			
			
		}while(isContinueTaxCal);
	}
	
	///// method to calculate payable tax///////
	public static double PayableTaxCalculate(double salary) {
        double tax = 0;

        if (salary > 308333) {
            tax += (salary - 308333) * 0.36;
            salary = 308333;
        }
        if (salary > 266667) {
            tax += (salary - 266667) * 0.30;
            salary = 266667;
        }
        if (salary > 225000) {
            tax += (salary - 225000) * 0.24;
            salary = 225000;
        }
        if (salary > 183333) {
            tax += (salary - 183333) * 0.18;
            salary = 183333;
        }
        if (salary > 141667) {
            tax += (salary - 141667) * 0.12;
            salary = 141667;
        }
        if (salary > 100000) {
            tax += (salary - 100000) * 0.06;
        }

        return tax;
    }
    
    ///// method to calculate income tax
    public static double IncomeTaxCalculate(double income) {
        double tax = 0;

        if (income > 3700000) {
            tax += (income - 3700000) * 0.36;
            income = 3700000;
        }
        if (income > 3200000) {
            tax += (income - 3200000) * 0.30;
            income = 3200000;
        }
        if (income > 2700000) {
            tax += (income - 2700000) * 0.24;
            income = 2700000;
        }
        if (income > 2200000) {
            tax += (income - 2200000) * 0.18;
            income = 2200000;
        }
        if (income > 1700000) {
            tax += (income - 1700000) * 0.12;
            income = 1700000;
        }
        if (income > 1200000) {
            tax += (income - 1200000) * 0.06;
        }

        return tax;
    }
	
	////// method to calculate SSCL tax////////
	public static double SsclTaxCalculate(double value){
		
		double valueOfGood = 0;
		double saleTax = 0;
		double vatTax = 0;
		double ssclTax = 0;
		
		saleTax = value*0.025;
		valueOfGood = saleTax + value;
		
		vatTax = valueOfGood*0.15;
		ssclTax = vatTax + saleTax;
		
		return ssclTax;
	}


	///////////////////method to handle monthly installment of leasing payment///////////////////
	public static void CalculateMonthlyInstallment(){
		Scanner scanner = new Scanner(System.in);
		
		boolean isContinue = false;
		do{
			isContinue = false;
			System.out.print("Enter lease amount : ");
			double leaseAmount = scanner.nextDouble();
			
			System.out.print("Enter annual interest rate : ");
			double annualInterest = scanner.nextDouble();
			
			System.out.print("Enter number of year(1-5) : ");
			int numberOfYears = scanner.nextInt();
			
			if(leaseAmount <= 0 || annualInterest <= 0 || numberOfYears > 5 || numberOfYears < 1) {
				System.out.print("\tInvalid Input...\n\nDo you want to enter the correct value again(Y/N) : ");
				char doAgain = scanner.next().toUpperCase().charAt(0);
				if(doAgain == 'Y')isContinue = true;
				else isContinue = false;
			}else if(leaseAmount > 0){
				System.out.print("\tYour monthly installment : " + CalculateLeasingValue(leaseAmount,annualInterest,numberOfYears,true)+"\n\nDo you want to calculate this again(Y/N) : ");
				char calculateAgain = scanner.next().toUpperCase().charAt(0);
				if(calculateAgain ==  'Y'){
					isContinue = true;
				}
			}
		}while(isContinue);
	}
	
	///////////////////method to handle search leasing category of leasing payment///////////////////
	public static void SearchLeasingCategory(){
		Scanner scanner = new Scanner(System.in);
		
		boolean isContinue = false;
		do{
			isContinue = false;
			System.out.print("Enter lease amount : ");
			double leaseAmount = scanner.nextDouble();
			
			System.out.print("Enter annual interest rate : ");
			double annualInterest = scanner.nextDouble();
			
			if(leaseAmount <= 0 || annualInterest <= 0) {
				System.out.print("\tInvalid Input...\n\nDo you want to enter the correct value again(Y/N) : ");
				char doAgain = scanner.next().toUpperCase().charAt(0);
				if(doAgain == 'Y')isContinue = true;
				else isContinue = false;
			}else if(leaseAmount > 0){
				for (int i = 3; i <= 5; i++)
				{
					System.out.println("\tYour monthly installment for "+i+" year leasing plan : " + CalculateLeasingValue(leaseAmount,annualInterest,i,true));
				}
				
				System.out.print("\nDo you want to calculate this again(Y/N) : ");
				char calculateAgain = scanner.next().toUpperCase().charAt(0);
				if(calculateAgain ==  'Y'){
					isContinue = true;
				}
			}
			
		}while(isContinue);
	}
	
	////////////////method to handle find the leasing amount by giving years and monthy installments////////////
	public static void FindTheLeasingAmount(){
		Scanner scanner = new Scanner(System.in);
		
		boolean isContinue = false;
		do{
			isContinue = false;
			System.out.print("Enter the monthly lease payment amount you can afford : ");
			double monthlyLeaseAmount = scanner.nextDouble();
			
			System.out.print("Enter annual interest rate : ");
			double annualInterest = scanner.nextDouble();
			
			System.out.print("Enter number of year(1-5) : ");
			int numberOfYears = scanner.nextInt();
			
			if(monthlyLeaseAmount <= 0 || annualInterest <= 0 || numberOfYears > 5 || numberOfYears < 1){
				System.out.print("\tInvalid Input...\n\nDo you want to enter the correct value again(Y/N) : ");
				char doAgain = scanner.next().toUpperCase().charAt(0);
				if(doAgain == 'Y')isContinue = true;
				else isContinue = false;
			}else if(monthlyLeaseAmount > 0){
				System.out.print("You can get lease Amount : "+CalculateLeasingValue(monthlyLeaseAmount,annualInterest,numberOfYears,false)+"\n\nDo you want to calculate this again(Y/N) : ");
				char calculateAgain = scanner.next().toUpperCase().charAt(0);
				if(calculateAgain ==  'Y'){
					isContinue = true;
				}
			}
		}while(isContinue);
	}

	//////// method to calculate leasing payment////////////////
	public static double CalculateLeasingValue(double value, double annualInterestRate, int years, boolean isMonthlyInstallment) {
		double monthlyInterestRate = annualInterestRate / (12 * 100);
		int totalMonths = years * 12;

		if (isMonthlyInstallment) {
			return (value * monthlyInterestRate) /
				(1 - Math.pow((1 + monthlyInterestRate), -totalMonths));
		} else {
			return (value * (1 - Math.pow(1 + monthlyInterestRate, -totalMonths))) / monthlyInterestRate;
		}
	}
	
	public static void DrawHeadingBox(String title){
		System.out.println("+-----------------------------------------------------------------------------------------+");
		System.out.printf("|%-89s|%n",title);
		System.out.println("+-----------------------------------------------------------------------------------------+");
	}
	
	public static void DrawAsciiOfMainMenu(){
		System.out.println("			 ______   ____     ____    ______   ");
		System.out.println("			/\\__  _\\ /\\  _`\\  /\\  _`\\ /\\__  _\\  ");
		System.out.println("			\\/_/\\ \\/ \\ \\ \\/\\_\\\\ \\ \\L\\_\\/_/\\ \\/  ");
		System.out.println("			   \\ \\ \\  \\ \\ \\/_/_\\ \\  _\\L  \\ \\ \\  ");
		System.out.println("			    \\_\\ \\__\\ \\ \\L\\ \\\\ \\ \\L\\ \\ \\ \\ \\ ");
		System.out.println("			    /\\_____\\\\ \\____/ \\ \\____/  \\ \\_\\ ");
		System.out.println("			    \\/_____/ \\/___/   \\/___/    \\/_/");
		
		System.out.println();
		System.out.println();
		
		System.out.println("	 _____  ____ ___  _   ____  ____  _     ____  _     _     ____  _____  ____  ____ ");
		System.out.println("	/__ __\\/  _ \\\\  \\//  /   _\\/  _ \\/ \\   /   _\\/ \\ /\\/ \\   /  _ \\/__ __\\/  _ \\/  __\\ ");
		System.out.println("	  / \\  | / \\| \\  /   |  /  | / \\|| |   |  /  | | ||| |   | / \\|  / \\  | / \\||  \\/|");
		System.out.println("	  | |  | |-|| /  \\   |  \\__| |-||| |_/\\|  \\__| \\_/|| |_/\\| |-||  | |  | \\_/||    /");
		System.out.println("	  \\_/  \\_/ \\|/__/\\\\  \\____/\\_/ \\|\\____/\\____/\\____/\\____/\\_/ \\|  \\_/  \\____/\\_/\\_\\ ");
		
		System.out.println();
		System.out.println();
		
		System.out.println("================================================================================================================");
		
		System.out.println();
		System.out.println();
	}
	
	public final static void clearConsole() {
		try {
			final String os = System.getProperty("os.name");
			if (os.contains("Windows")) {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			} else {
				System.out.print("\033[H\033[2J");
				System.out.flush();
			}
		} catch (final Exception e) {
			e.printStackTrace();
			// Handle any exceptions.
	}
 }
		
}


