import java.text.DecimalFormat;

public class Person {

    private String name;
    private int age;
    private String gender;
    private double weight;
    private double height;
    private double bmi;
    private double bmr;

    public Person() {
    }

    public Person(String name, int age, String gender, double weight, double height) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.weight = weight;
        this.height = height;
        this.bmi = calculateBmi();
        this.bmr = calculateBMR();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        updateBMR();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
        updateBMR();
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
        updateBmi();
        updateBMR();
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
        updateBmi();
        updateBMR();
    }

    public double getBmi() {
        return bmi;
    }

    public double calculateBmi() {
        if (height > 0) {
            return weight / (height * height);
        } else {
            return 0;
        }
    }

    public void updateBmi() {
        this.bmi = calculateBmi();
    }

    public String twoDecimalsBMI() {
        DecimalFormat df = new DecimalFormat("#.##");
        return df.format(bmi);
    }

    public String getBMIrange(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            return "Normal weight";
        } else if (bmi >= 25 && bmi <= 29.9) {
            return "Overweight";
        } else if (bmi >= 30 && bmi <= 39.9) {
            return "Obese";
        } else {
            return "Severely obese";
        }
    }

    public double getBMR(){
        return bmr;
    }

    public double calculateBMR() {
        if (gender != null && gender.equals("male")) {
            return (10 * weight) + (6.25 * height * 100) - (5 * age) + 5;
        } else  {
            return (10 * weight) + (6.25 * height * 100) - (5 * age) - 161;
    }
}

    public void updateBMR() {
        this.bmr = calculateBMR();
    }
}





