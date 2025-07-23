import java.util.*;

class BookCategory {
    String genre;

    public BookCategory(String genre) {
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }
}

class ClothingCategory {
    String size;

    public ClothingCategory(String size) {
        this.size = size;
    }

    public String getSize() {
        return size;
    }
}

class GadgetCategory {
    String brand;

    public GadgetCategory(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }
}

class Product<T> {
    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public T getCategory() {
        return category;
    }
}

class Marketplace {
    public static <T> void applyDiscount(Product<T> product, double percentage) {
        double discountedPrice = product.getPrice() - (product.getPrice() * percentage / 100);
        product.setPrice(discountedPrice);
    }

    public static void displayProduct(Product<?> product) {
        System.out.println("Product: " + product.getName());
        System.out.println("Price after discount: ₹" + product.getPrice());

        Object category = product.getCategory();
        if (category instanceof BookCategory) {
            System.out.println("Book Genre: " + ((BookCategory) category).getGenre());
        } else if (category instanceof ClothingCategory) {
            System.out.println("Clothing Size: " + ((ClothingCategory) category).getSize());
        } else if (category instanceof GadgetCategory) {
            System.out.println("Gadget Brand: " + ((GadgetCategory) category).getBrand());
        }
    }
}

public class OnlineMarketplace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose product type (1. Book 2. Clothing 3. Gadget): ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter product name: ");
        String name = scanner.nextLine();

        System.out.print("Enter product price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Enter book genre: ");
                String genre = scanner.nextLine();
                BookCategory book = new BookCategory(genre);
                Product<BookCategory> bookProduct = new Product<>(name, price, book);
                Marketplace.applyDiscount(bookProduct, 10);
                Marketplace.displayProduct(bookProduct);
                break;

            case 2:
                System.out.print("Enter clothing size: ");
                String size = scanner.nextLine();
                ClothingCategory clothing = new ClothingCategory(size);
                Product<ClothingCategory> clothingProduct = new Product<>(name, price, clothing);
                Marketplace.applyDiscount(clothingProduct, 15);
                Marketplace.displayProduct(clothingProduct);
                break;

            case 3:
                System.out.print("Enter gadget brand: ");
                String brand = scanner.nextLine();
                GadgetCategory gadget = new GadgetCategory(brand);
                Product<GadgetCategory> gadgetProduct = new Product<>(name, price, gadget);
                Marketplace.applyDiscount(gadgetProduct, 5);
                Marketplace.displayProduct(gadgetProduct);
                break;

            default:
                System.out.println("Invalid choice.");
        }

        scanner.close();
    }
}
