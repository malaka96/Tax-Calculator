import java.util.*;
class TaxCalculator{
	public static void main(String args[]){
		//Scanner scanner = new Scanner(System.in);
		
		//WithHoldingTaxCalculate("Value of Good or Service",0,0);
		System.out.println(CalculateLeasingValue(2500000,22,3,true));
	}
	
	///////////////////////////// method to calculate Withholding Tax//////////////////////////////////////////////////
	public static void WithHoldingTaxCalculate(String taxType,int startOfTax, double taxRate){
		Scanner scanner = new Scanner(System.in);
		
		boolean isContinueRentTax = false;
		do{
			isContinueRentTax = false;
			System.out.printf("Enter %s : ",taxType);
			double rentPrice = scanner.nextDouble();
			if(rentPrice < 0) {
				System.out.print("\tInvalid Input...\n\nDo you want to enter the correct value again(Y/N) : ");
				char doAgain = scanner.next().toUpperCase().charAt(0);
				if(doAgain == 'Y')isContinueRentTax = true;
				else isContinueRentTax = false;
			}else if(rentPrice > startOfTax){
				
				double taxAmount;
				if(taxType.equals("Payable Tax Per Month"))taxAmount = PayableTaxCalculate(rentPrice);
				else if(taxType.equals("Income Tax Per Year"))taxAmount = IncomeTaxCalculate(rentPrice);
				else if(taxType.equals("Value of Good or Service")){taxAmount = SsclTaxCalculate(rentPrice);taxType = "SSCL Tax";}
				else taxAmount = rentPrice*taxRate;
				
				System.out.print("\tYou have to pay "+taxType+" : "+taxAmount+"\n\nDo you want to calculate another tax or this(Y/N) : ");
				char calculateAgain = scanner.next().toUpperCase().charAt(0);
				if(calculateAgain ==  'Y'){
					System.out.print("Do want this tax calculation again(Y/N) : ");
					char calculateThisAgain = scanner.next().toUpperCase().charAt(0);
					if(calculateThisAgain == 'Y') isContinueRentTax = true;
				}
			}else if(rentPrice <= startOfTax && rentPrice >= 0){
				System.out.print("\tYou don't have to pay "+taxType+"...\n\nDo want this tax calculation again(Y/N) : ");
				char calculateThisAgain = scanner.next().toUpperCase().charAt(0);
				if(calculateThisAgain == 'Y') isContinueRentTax = true;
			}
			
			
		}while(isContinueRentTax);
	}
	

	/////////////////////////////////////Payable Tax //////////////////////////////////////////////////////////////
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


	////////////////////////////////////leasing payment/////////////////////////////////////////////////////////////
	public static void LeasingPayment(){
		Scanner scanner = new Scanner(System.in);
		
		boolean isContinue = false;
		do{
			
		}while(isContinue);
	}

	public static double CalculateLeasingValue(double value, double annualInterestRate, int years, boolean isMonthlyInstallment) {
		double monthlyInterestRate = annualInterestRate / (12 * 100);
		int totalMonths = years * 12;

		if (isMonthlyInstallment) {
			// Calculate Monthly Leasing Installment
			return (value * monthlyInterestRate) /
				(1 - Math.pow((1 + monthlyInterestRate), -totalMonths));
		} else {
			// Calculate Total Leasing Amount
			return (value * (1 - Math.pow(1 + monthlyInterestRate, -totalMonths))) / monthlyInterestRate;
		}
	}
}


