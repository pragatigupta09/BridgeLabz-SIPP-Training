package Generics;
import java.util.*;

abstract class WarehouseItem {
    private String name;
    private double weight;

    public WarehouseItem(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public abstract String getCategory();
}

class Electronics extends WarehouseItem {
    public Electronics(String name, double weight) {
        super(name, weight);
    }

    public String getCategory() {
        return "Electronics";
    }
}

class Groceries extends WarehouseItem {
    public Groceries(String name, double weight) {
        super(name, weight);
    }

    public String getCategory() {
        return "Groceries";
    }
}

class Furniture extends WarehouseItem {
    public Furniture(String name, double weight) {
        super(name, weight);
    }

    public String getCategory() {
        return "Furniture";
    }
}

class Storage<T extends WarehouseItem> {
    private List<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
    }

    public List<T> getItems() {
        return items;
    }

    public static void displayItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            System.out.println(item.getName() + " (" + item.getCategory() + ") - " + item.getWeight() + " kg");
        }
    }
}

public class SmartWarehouse {
    public static void main(String[] args) {
        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.addItem(new Electronics("Laptop", 2.5));
        electronicsStorage.addItem(new Electronics("Mobile", 0.3));

        Storage<Groceries> groceryStorage = new Storage<>();
        groceryStorage.addItem(new Groceries("Rice", 5));
        groceryStorage.addItem(new Groceries("Wheat", 10));

        Storage<Furniture> furnitureStorage = new Storage<>();
        furnitureStorage.addItem(new Furniture("Chair", 7));
        furnitureStorage.addItem(new Furniture("Table", 15));

        System.out.println("=== Electronics ===");
        Storage.displayItems(electronicsStorage.getItems());

        System.out.println("\n=== Groceries ===");
        Storage.displayItems(groceryStorage.getItems());

        System.out.println("\n=== Furniture ===");
        Storage.displayItems(furnitureStorage.getItems());
    }
}
