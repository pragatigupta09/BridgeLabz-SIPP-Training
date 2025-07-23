package Generics;

import java.util.*;

interface MealPlan {
    String getType();
    List<String> getMeals();
}

class VegetarianMeal implements MealPlan {
    public String getType() {
        return "Vegetarian";
    }

    public List<String> getMeals() {
        return Arrays.asList("Paneer Curry", "Dal Tadka", "Mixed Veg", "Chapati", "Rice");
    }
}

class VeganMeal implements MealPlan {
    public String getType() {
        return "Vegan";
    }

    public List<String> getMeals() {
        return Arrays.asList("Quinoa Salad", "Tofu Stir Fry", "Lentil Soup", "Fruit Bowl");
    }
}

class KetoMeal implements MealPlan {
    public String getType() {
        return "Keto";
    }

    public List<String> getMeals() {
        return Arrays.asList("Grilled Chicken", "Avocado Salad", "Zucchini Noodles", "Boiled Eggs");
    }
}

class HighProteinMeal implements MealPlan {
    public String getType() {
        return "High Protein";
    }

    public List<String> getMeals() {
        return Arrays.asList("Egg White Omelette", "Grilled Fish", "Protein Shake", "Chicken Breast");
    }
}

class Meal<T extends MealPlan> {
    private T mealPlan;

    public Meal(T mealPlan) {
        this.mealPlan = mealPlan;
    }

    public void displayMealPlan() {
        System.out.println("\nMeal Plan Type: " + mealPlan.getType());
        System.out.println("Meals:");
        for (String meal : mealPlan.getMeals()) {
            System.out.println("- " + meal);
        }
    }
}

public class MealPlanGenerator {
    public static <T extends MealPlan> void generateMealPlan(Meal<T> meal) {
        meal.displayMealPlan();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose a Meal Plan: vegetarian / vegan / keto / highprotein");
        String choice = sc.nextLine().toLowerCase();

        switch (choice) {
            case "vegetarian":
                generateMealPlan(new Meal<>(new VegetarianMeal()));
                break;
            case "vegan":
                generateMealPlan(new Meal<>(new VeganMeal()));
                break;
            case "keto":
                generateMealPlan(new Meal<>(new KetoMeal()));
                break;
            case "highprotein":
                generateMealPlan(new Meal<>(new HighProteinMeal()));
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }
}

