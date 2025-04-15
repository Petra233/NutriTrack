import java.util.Scanner;

public class EnergyNeedsCalculator {
    private Person p;
    Scanner sc;

    public EnergyNeedsCalculator(Person person) {
        p = person;
        sc = new Scanner(System.in);
    }

    public String promptForUserName() {
        while (true) {

            System.out.println("What's your name");
            String name = sc.nextLine();

            if (name != null && !name.trim().isEmpty()) {
                p.setName(name);
                return p.getName();

            } else {
                System.out.println("Wrong input, try again");
            }

        }
    }

    public int getUserAge() {
        while (true) {
            System.out.println("What's your age");
            int age = sc.nextInt();

            if (age > 0) {
                p.setAge(age);
                sc.nextLine();
                return p.getAge();

            } else {
                System.out.println("Wrong input, try again");
                sc.nextLine();
            }
            System.out.println(age + " years old");
        }
    }

    public String userGender(){
        while (true) {
            System.out.println("What's your gender? ");
            String gender = sc.nextLine().trim();

            if (gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("female")){
                p.setGender(gender);
                return p.getGender();

            } else {
                System.out.println("Wrong input, try again");

            }
        }
    }

    public double getUserWeight() {
        while (true) {
            System.out.println("What's your weight?");
            double weight = sc.nextDouble();
            sc.nextLine();

            if (weight > 0) {
                p.setWeight(weight);
                return p.getWeight();

            } else {
                System.out.println("Wrong input, try again");
                sc.nextLine();
            }
        }
    }

    public double getUserHeight() {
        while (true) {
            System.out.println("What's your height in metres?");
            double height = sc.nextDouble();
            sc.nextLine();

            if (height > 0) {
                p.setHeight(height);
                return p.getHeight();

            } else {
                System.out.println("Wrong input, try again");

            }
        }

    }

    public void displayTDEE(){
        System.out.println("1. Sedentary (little/no exercise)");
        System.out.println("2. Light activity (1-3 days/week)");
        System.out.println("3. Moderate activity (3-5 days/week)");
        System.out.println("4. Very active (6-7 days/week)");
        System.out.println("5. Super active (athlete, physical job)");
    }

    public void calculateTDEE(){
        System.out.println("Choose the activity level that matches your lifestyle ");
        displayTDEE();

        if (sc.hasNextLine()) sc.nextLine();
        String input = sc.nextLine();
        double TDEE;

        switch (input) {
            case "1": TDEE = 1.2* p.calculateBMR();
                break;
            case "2": TDEE = 1.375 * p.calculateBMR();
                break;
            case "3":  TDEE = 1.55 * p.calculateBMR();
                break;
            case "4": TDEE = 1.725 * p.calculateBMR();
                break;
            case "5": TDEE = 1.9 * p.calculateBMR();
            break;

            default:
                System.out.println("Invalid input! Please choose a valid activity level.");
                return;

        }
        System.out.println("Your  Total Daily Energy Expenditure (TDEE) is " + Math.round(TDEE) + " kcal/day.");

        System.out.print("\nPress enter to return to the main menu.");
        sc.nextLine();

    }
}


