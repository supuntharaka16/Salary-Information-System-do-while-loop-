import java.util.Scanner;

class Demo {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in); // Create a single Scanner instance

        L: do {
            System.out.println("--------------------------------------------------------");
            System.out.println("|       SALARY INFORMATION SYSTEM                      |");
            System.out.println("--------------------------------------------------------");
            System.out.println();
            System.out.println("    [1] Calculate Income Tax");
            System.out.println("    [2] Calculate Annual Bonus");
            System.out.println("    [3] Calculate Loan amount");
            System.out.println("    [4] Exit");
            System.out.println();
            System.out.print("Enter an option to continue > ");
            
            int num1 = input.nextInt();

            switch (num1) {
                case 1: 
                    L1: do {
                        System.out.println("--------------------------------------------------------");
                        System.out.println("|            Calculate Income Tax                      |");
                        System.out.println("--------------------------------------------------------");
                        System.out.println();
                        System.out.print("Input Employee name   - ");
                        String name = input.next();
                        System.out.print("Input Employee salary - ");
                        int salary = input.nextInt();
                        System.out.println();

                        int tax = 0;
                        if (salary > 308333) {
                            tax += (salary - 308333) * 0.36;
                        } else if (salary > 266667) {
                            tax += (41667 * 0.30) + (41667 * 0.24) + (41667 * 0.18) + (41667 * 0.12) + (41667 * 0.06);
                        } else if (salary > 225000) {
                            tax += (41667 * 0.24) + (41667 * 0.18) + (41667 * 0.12) + (41667 * 0.06);
                        } else if (salary > 183333) {
                            tax += (41667 * 0.18) + (41667 * 0.12) + (41667 * 0.06);
                        } else if (salary > 141667) {
                            tax += (41667 * 0.12) + (41667 * 0.06);
                        } else if (salary > 100000) {
                            tax += 41667 * 0.06;
                        } else {
                            System.out.println("No tax is charged up to Rs.100000");
                        }
                        System.out.println("You have to pay Income Tax per month: Rs." + tax);

                        L2: do {
                            System.out.println("Do you want to calculate another income tax? (Y/N)");
                            String i = input.next();
                            if (i.equalsIgnoreCase("Y")) {
                                continue L1;
                            } else if (i.equalsIgnoreCase("N")) {
                                break L1; 
                            } else {
                                System.out.print("Invalid input. Try Again...");
                                continue L2;
                            }
                        } while (true);
                    } while (true);
                    break; 

                case 2: 
                    System.out.println("-------------------------------------------------");
                    System.out.println("|           Calculate Annual Bonus              |");
                    System.out.println("-------------------------------------------------");
                    System.out.println();
                    System.out.print("Input Employee name   - ");
                    String name2 = input.next();
                    System.out.print("Input Employee salary - ");
                    int salary2 = input.nextInt();
                    int bonus = 0;
                    if (salary2 > 400000) {
                        bonus = (int) (salary2 * 0.35);
                    } else if (salary2 > 299999) {
                        bonus = (int) (salary2 * 0.20);
                    } else if (salary2 > 199999) {
                        bonus = (int) (salary2 * 0.10);
                    } else {
                        bonus = 5000; 
                    }
                    System.out.println("Annual bonus: Rs. " + bonus);
                    break; 

                case 3: 
                    System.out.println("------------------------------------------------");
                    System.out.println("|          Calculate Loan Amount               |");
                    System.out.println("------------------------------------------------");
                    System.out.println();
                    System.out.print("Input Employee name   - ");
                    String name3 = input.next();
                    System.out.print("Input Employee salary - ");
                    double salary3 = input.nextDouble();
                    if (salary3 <= 50000) {
                        System.out.println("You cannot get a loan because your salary is less than Rs. 50,000.");
                        break; 
                    }
                    System.out.print("Enter number of years for the loan: ");
                    int years = input.nextInt();
                    if (years > 5) {
                        System.out.println("The maximum loan period is 5 years.");
                        break; 
                    }
                    double monthlyInstallment = salary3 * 0.60;
                    double annualInterestRate = 0.15;
                    double monthlyInterestRate = annualInterestRate / 12;
                    int totalMonths = years * 12;
                    double loanAmount = monthlyInstallment * (1 - (1 / Math.pow(1 + monthlyInterestRate, totalMonths))) / monthlyInterestRate;
                    loanAmount = Math.round(loanAmount / 1000) * 1000;
                    System.out.println("You can get a loan amount of: Rs. " + loanAmount);
                    break; 

                case 4: 
                    System.out.println("Exiting the program. ");
                    break L; 

                default: 
                    System.out.println("Invalid option. ");
                    break; 
            }
        } while (true); 
    }
}
