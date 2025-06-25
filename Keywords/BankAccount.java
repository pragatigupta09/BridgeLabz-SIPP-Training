package Keywords;

class BankAccount {
    static String bankName = "State Bank of India";
    static int totalAccounts = 0;

    final String accountNumber;
    String accountHolderName;

    BankAccount(String accountHolderName, String accountNumber) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        totalAccounts++;
    }

    static void getTotalAccounts() {
        System.out.println("Total Accounts: " + totalAccounts);
    }

    void display() {
        if (this instanceof BankAccount) {
            System.out.println("Bank: " + bankName + ", Holder: " + accountHolderName + ", Acc No: " + accountNumber);
        }
    }
}
