import java.util.Scanner;

public class Main {

    private Person p;
    private EnergyNeedsCalculator e;
    private Scanner sc;

    public Main() {
        p = new Person();
        e = new EnergyNeedsCalculator(p);
        sc = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to PNutrition, a program designed to help you achieve your goals! May I ask...");
            e.promptForUserName();
            System.out.println("Welcome " + p.getName() + "! Before we start I need you to answer a few questions");
            e.getUserAge();
            e.userGender();
            e.getUserWeight();
            e.getUserHeight();
            System.out.println("Thank you so much for the information");
            System.out.println("DEBUG — Weight: " + p.getWeight() + ", Height: " + p.getHeight() + ", BMI: " + p.calculateBmi());
            displayMenu();
            String input = sc.nextLine();

            switch (input) {
                case "1": System.out.println(("Your BMI is " + p.twoDecimalsBMI() + " and you are " + p.getBMIrange(p.getBmi()) + ", however, BMI is not always the best tool to estimate body constitution on an individual level and results should be taken with precaution"));
                break;
                case "2": System.out.println("Your Basal Metabolic Rate is " + p.calculateBMR() +" kcal/day");
                break;
                case "3": e.calculateTDEE();
                break;
                default:
                    System.out.println("Invalid option. Please choose 1, 2, or 3.");
                    break;

            }
            System.out.print("\nPress enter to return to the main menu.");
            sc.nextLine();
        }

    }
    public void displayMenu() {
        System.out.println("What would you like to know?");
        System.out.println("1. My BMI");
        System.out.println("2. My calorie needs (BMR)");
        System.out.println("3. My energy expenditure");
    }

        public static void main (String[]args){
            Main main = new Main();

        }
    }
