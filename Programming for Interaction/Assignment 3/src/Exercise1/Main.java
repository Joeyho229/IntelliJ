package Exercise1;

public class Main {
    public static void main(String[] args) {

        Account JoeysAccount = new Account(1122, 20000);
        JoeysAccount.annualInterestRate(4.5);

        JoeysAccount.withdraw(2500);
        JoeysAccount.deposit(5000);

        System.out.println(JoeysAccount.getBalance());
        System.out.println(JoeysAccount.getMonthlyInterest());
        System.out.println(JoeysAccount.dateCreated());

        System.out.println(JoeysAccount.getId());
    }
}
