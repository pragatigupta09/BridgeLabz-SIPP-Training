import java.util.Scanner;

public class InventoryManagementSystem {
    static class Node {
        String itemName;
        String itemId;
        int quantity;
        double price;
        Node next;
        public Node(String itemName, String itemId, int quantity, double price) {
            this.itemName = itemName;
            this.itemId = itemId;
            this.quantity = quantity;
            this.price = price;
            this.next = null;
        }
    }

    static class InventoryLinkedList {
        Node head;
        public InventoryLinkedList() {
            this.head = null;
        }

        public void addAtBeginning(String itemName, String itemId, int quantity, double price) {
            Node newNode = new Node(itemName, itemId, quantity, price);
            newNode.next = head;
            head = newNode;
            System.out.println("Item added at the beginning successfully.");
        }

        public void addAtEnd(String itemName, String itemId, int quantity, double price) {
            Node newNode = new Node(itemName, itemId, quantity, price);
            if (head == null) {
                head = newNode;
                System.out.println("Item added at the end successfully.");
                return;
            }

            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            System.out.println("Item added at the end successfully.");
        }

        public void addAtPosition(int position, String itemName, String itemId, int quantity, double price) {
            if (position == 1) {
                addAtBeginning(itemName, itemId, quantity, price);
                return;
            }

            Node newNode = new Node(itemName, itemId, quantity, price);
            Node temp = head;
            int count = 1;
            while (temp != null && count < position - 1) {
                temp = temp.next;
                count++;
            }

            if (temp == null) {
                System.out.println("Position is beyond the length of the list.");
                return;
            }
            newNode.next = temp.next;
            temp.next = newNode;
            System.out.println("Item added at position " + position + " successfully.");
        }

        public void removeByItemId(String itemId) {
            if (head == null) {
                System.out.println("List is empty.");
                return;
            }
            if (head.itemId.equals(itemId)) {
                head = head.next;
                System.out.println("Item with ID '" + itemId + "' removed successfully.");
                return;
            }
            Node temp = head;
            Node prev = null;
            while (temp != null && !temp.itemId.equals(itemId)) {
                prev = temp;
                temp = temp.next;
            }
            if (temp == null) {
                System.out.println("Item with ID '" + itemId + "' not found.");
                return;
            }
            prev.next = temp.next;
            System.out.println("Item with ID '" + itemId + "' removed successfully.");
        }

        public void updateQuantity(String itemId, int newQuantity) {
            Node temp = head;
            boolean found = false;
            while (temp != null) {
                if (temp.itemId.equals(itemId)) {
                    temp.quantity = newQuantity;
                    System.out.println("Quantity updated successfully for item with ID '" + itemId + "'.");
                    found = true;
                    break;
                }
                temp = temp.next;
            }
            if (!found) {
                System.out.println("Item with ID '" + itemId + "' not found.");
            }
        }

        public void searchByItemId(String itemId) {
            Node temp = head;
            boolean found = false;
            while (temp != null) {
                if (temp.itemId.equals(itemId)) {
                    System.out.println("\nItem found:");
                    displayItem(temp);
                    found = true;
                    break;
                }
                temp = temp.next;
            }
            if (!found) {
                System.out.println("Item with ID '" + itemId + "' not found.");
            }
        }

        public void searchByItemName(String itemName) {
            Node temp = head;
            boolean found = false;

            System.out.println("\nItems with name '" + itemName + "':");
            while (temp != null) {
                if (temp.itemName.equalsIgnoreCase(itemName)) {
                    displayItem(temp);
                    found = true;
                }
                temp = temp.next;
            }
            if (!found) {
                System.out.println("No items found with name '" + itemName + "'.");
            }
        }

        public void calculateTotalValue() {
            if (head == null) {
                System.out.println("Inventory is empty.");
                return;
            }
            Node temp = head;
            double totalValue = 0;
            while (temp != null) {
                totalValue += temp.quantity * temp.price;
                temp = temp.next;
            }
            System.out.println("\nTotal Inventory Value: $" + String.format("%.2f", totalValue));
        }

        public void sortByNameAscending() {
            if (head == null || head.next == null) {
                return; 
            }
            head = mergeSort(head, true, true);
            System.out.println("Inventory sorted by Item Name (Ascending).");
        }

        public void sortByNameDescending() {
            if (head == null || head.next == null) {
                return; 
            }
            head = mergeSort(head, true, false);
            System.out.println("Inventory sorted by Item Name (Descending).");
        }

        public void sortByPriceAscending() {
            if (head == null || head.next == null) {
                return; 
            }
            head = mergeSort(head, false, true);
            System.out.println("Inventory sorted by Price (Ascending).");
        }

        public void sortByPriceDescending() {
            if (head == null || head.next == null) {
                return; 
            }
            head = mergeSort(head, false, false);
            System.out.println("Inventory sorted by Price (Descending).");
        }

        private Node mergeSort(Node head, boolean byName, boolean ascending) {
            if (head == null || head.next == null) {
                return head;
            }
            Node middle = getMiddle(head);
            Node nextOfMiddle = middle.next;
            middle.next = null;
            Node left = mergeSort(head, byName, ascending);
            Node right = mergeSort(nextOfMiddle, byName, ascending);
            Node sortedList = sortedMerge(left, right, byName, ascending);
            return sortedList;
        }

        private Node getMiddle(Node head) {
            if (head == null) {
                return head;
            }

            Node slow = head, fast = head;

            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            return slow;
        }

        private Node sortedMerge(Node a, Node b, boolean byName, boolean ascending) {
            Node result = null;
            if (a == null) {
                return b;
            }
            if (b == null) {
                return a;
            }
            boolean condition;
            if (byName) {
                condition = ascending ? a.itemName.compareToIgnoreCase(b.itemName) <= 0 : a.itemName.compareToIgnoreCase(b.itemName) >= 0;
            } else {
                condition = ascending ? a.price <= b.price : a.price >= b.price;
            }

            if (condition) {
                result = a;
                result.next = sortedMerge(a.next, b, byName, ascending);
            } else {
                result = b;
                result.next = sortedMerge(a, b.next, byName, ascending);
            }

            return result;
        }

        public void displayAll() {
            if (head == null) {
                System.out.println("Inventory is empty.");
                return;
            }
            Node temp = head;
            System.out.println("\nInventory Items:");
            while (temp != null) {
                displayItem(temp);
                temp = temp.next;
            }
        }

        private void displayItem(Node item) {
            System.out.println("Item Name: " + item.itemName);
            System.out.println("Item ID: " + item.itemId);
            System.out.println("Quantity: " + item.quantity);
            System.out.println("Price: $" + String.format("%.2f", item.price));
            System.out.println("Total Value: $" + String.format("%.2f", item.quantity * item.price));
            System.out.println("-----------");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InventoryLinkedList inventory = new InventoryLinkedList();
        int choice, quantity, position;
        String itemName, itemId;
        double price;

        do {
            System.out.println("\nInventory Management System");
            System.out.println("1. Add an item at the beginning");
            System.out.println("2. Add an item at the end");
            System.out.println("3. Add an item at a specific position");
            System.out.println("4. Remove an item by Item ID");
            System.out.println("5. Update quantity of an item");
            System.out.println("6. Search for an item by Item ID");
            System.out.println("7. Search for an item by Item Name");
            System.out.println("8. Calculate total inventory value");
            System.out.println("9. Sort inventory by Item Name (Ascending)");
            System.out.println("10. Sort inventory by Item Name (Descending)");
            System.out.println("11. Sort inventory by Price (Ascending)");
            System.out.println("12. Sort inventory by Price (Descending)");
            System.out.println("13. Display all items");
            System.out.println("14. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Item Name: ");
                    itemName = scanner.nextLine();
                    System.out.print("Enter Item ID: ");
                    itemId = scanner.nextLine();
                    System.out.print("Enter Quantity: ");
                    quantity = scanner.nextInt();
                    System.out.print("Enter Price: $");
                    price = scanner.nextDouble();
                    inventory.addAtBeginning(itemName, itemId, quantity, price);
                    break;

                case 2:
                    System.out.print("Enter Item Name: ");
                    itemName = scanner.nextLine();
                    System.out.print("Enter Item ID: ");
                    itemId = scanner.nextLine();
                    System.out.print("Enter Quantity: ");
                    quantity = scanner.nextInt();
                    System.out.print("Enter Price: $");
                    price = scanner.nextDouble();
                    inventory.addAtEnd(itemName, itemId, quantity, price);
                    break;

                case 3:
                    System.out.print("Enter position: ");
                    position = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter Item Name: ");
                    itemName = scanner.nextLine();
                    System.out.print("Enter Item ID: ");
                    itemId = scanner.nextLine();
                    System.out.print("Enter Quantity: ");
                    quantity = scanner.nextInt();
                    System.out.print("Enter Price: $");
                    price = scanner.nextDouble();
                    inventory.addAtPosition(position, itemName, itemId, quantity, price);
                    break;

                case 4:
                    System.out.print("Enter Item ID to remove: ");
                    itemId = scanner.nextLine();
                    inventory.removeByItemId(itemId);
                    break;

                case 5:
                    System.out.print("Enter Item ID to update quantity: ");
                    itemId = scanner.nextLine();
                    System.out.print("Enter new quantity: ");
                    quantity = scanner.nextInt();
                    inventory.updateQuantity(itemId, quantity);
                    break;

                case 6:
                    System.out.print("Enter Item ID to search: ");
                    itemId = scanner.nextLine();
                    inventory.searchByItemId(itemId);
                    break;

                case 7:
                    System.out.print("Enter Item Name to search: ");
                    itemName = scanner.nextLine();
                    inventory.searchByItemName(itemName);
                    break;

                case 8:
                    inventory.calculateTotalValue();
                    break;

                case 9:
                    inventory.sortByNameAscending();
                    inventory.displayAll();
                    break;

                case 10:
                    inventory.sortByNameDescending();
                    inventory.displayAll();
                    break;

                case 11:
                    inventory.sortByPriceAscending();
                    inventory.displayAll();
                    break;

                case 12:
                    inventory.sortByPriceDescending();
                    inventory.displayAll();
                    break;

                case 13:
                    inventory.displayAll();
                    break;

                case 14:
                    System.out.println("Exiting the program...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 14);
    }
}