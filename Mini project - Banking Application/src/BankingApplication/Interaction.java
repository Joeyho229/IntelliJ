package BankingApplication;

import java.util.Scanner;

public class Interaction {

    // Datatypes for the class Interaction
    int userIdx;
    Account[] accounts;
    Account currentUser;
    Account otherUser;
    Scanner userInput;
    Bank bank;
    Administrator admin;
    int numberOfAccounts = 0;


    public Interaction(){

        userInput = new Scanner(System.in);
        userIdx = 0;
        accounts = new Account[100];
        bank = new Bank("Aalborg University Bank");
        admin = new Administrator("AAU","1234");
    }

    protected void administratorMenu(){     // The administrator menu
        char adminMenu;

        System.out.println("welcome to the administrator menu");
        System.out.println("Choose one of the following options: ");
        System.out.println("1. Edit bank information");
        System.out.println("2. Show list of all accounts");
        System.out.println("3. Logout and continue to customer login");

        do {        // A do while function
            adminMenu = userInput.next().charAt(0);

            switch (adminMenu) {                  // The switch is related to the adminMenu which then uses a scanner to receive inputs
                case '1':                         // The following code will be run if the case 1 is entered, this applies to all the cases.
                    adminEditBankMenu();          // Loading the adminEditBankMenu method
                    break;

                case '2':
                    adminAllAccountsMenu();
                    break;
            }
        } while (adminMenu != '3');
        System.out.println("Administration logout successful");
        loginMenu();                  // Displaying login menu

    }

    public void loginMenu(){         // Method for the login menu
        char loginOption;

        System.out.println("Welcome to your banking application ");       // Welcome message
        System.out.printf("Are you a returning costumer of %s?\n", bank.getBankName());
        System.out.println("1. Yes");
        System.out.println("2. No");
        System.out.println("3. Exit");
        System.out.println("\n");

        System.out.println("4. Administrator login");

        do {                             // Do while function
            loginOption = userInput.next().charAt(0);

            switch(loginOption) {       // The switch is related to the loginOption which then uses a scanner to receive inputs
                case '1':               // The following code will be run if the case 1 is entered, this applies to all the cases.
                    customerLogin();
                    break;

                case '2':
                    registrationMenu();
                    break;

                case '4':
                    administratorLogin();
                    break;
            }
        } while (loginOption != '3');
        System.out.println("Exit application successful");

    }

    protected void userMenu(){             // A method to call the user menu
        char userOption;

        System.out.printf("Welcome to %s \nThis is your user menu \n", bank.getBankName());    // Welcome message
        System.out.println("Please choose one of the following options:");                     // Menu choices
        System.out.println("A. Account Information");
        System.out.println("B. Check Balance");
        System.out.println("C. Deposit");
        System.out.println("D. Withdraw");
        System.out.println("E. Transfer");
        System.out.println("F. Logout");
        System.out.println("\n");

        System.out.println("G. Edit Account Information");

        if (currentUser.getBalance() < 0){        // If statement to display if the user account balance is negative
            System.out.println("Please be aware that your balance is negative");
        }

        do {                                      // Do while function
            userOption = userInput.next().charAt(0);

            switch(userOption) {                  // The switch is related to the userOption which then uses a scanner to receive inputs
                case 'A':
                case 'a':                         // The following code will be run if the case A is entered, this applies to all the cases.
                    accountInformation();
                    break;

                case 'B':
                case 'b':
                    balanceInformation();
                    break;

                case 'C':
                    depositMenu();
                    break;

                case 'D':
                case 'd':
                    withdrawalMenu();
                    break;

                case 'E':
                case 'e':
                    transferMenu();
                    break;

                case 'G':
                case 'g':
                    editAccountInformation();
                    break;
            }

        } while(userOption != 'F');
        System.out.println("Logout successful");

        loginMenu();
    }

    protected void adminEditBankMenu() {
        System.out.println("Please enter the wanted name for your bank");

        String bankName = userInput.next();
        bank.setBankName(bankName);

        System.out.println("Please enter the address of your new bank");
        String address = userInput.next();
        bank.setBankAddress(address);

        System.out.println("The name of your bank is now: " +bank.getBankName());
        System.out.println("At the location: " +bank.getBankAddress());

        System.out.println("Please choose another option from the administrator menu");
    }

    protected void adminAllAccountsMenu() {
        if (numberOfAccounts == 0){
            System.out.println("No accounts were found registered to your bank: " +bank.getBankName());
            System.out.println("Please choose another option from the administrator menu");

        } else {
            System.out.println("Displaying all registered account IDs with their account balance and names:");      // A code to load all the accounts in the accounts array, where after the information is then displayed accordingly to which account is loaded

            for (int i = 0; i < numberOfAccounts; i++)
                System.out.printf("Account ID: %d, balance: %f, registered name: %s %s\n", accounts[i].getID() , accounts[i].getBalance(), accounts[i].getFirstName(), accounts[i].getLastName());      // Displays all the accounts registered in the account array

            System.out.println("Please choose another option from the administrator menu");
        }
    }

    protected void administratorLogin() {
        System.out.println("Please enter administrator username: ");
        String username = userInput.next();

        if (username.equals(admin.getUsername())) {     // Checks if the entered username is the same as the admin username
            System.out.println("Please enter administrator password: ");
            String password = userInput.next();         // Checks if the entered password is the same as the admin password
            if (password.equals(admin.getPassword())){
                administratorMenu();                    // Brings the user into the admin menu
            }
        }
    }

    protected void customerLogin() {
        if (numberOfAccounts == 0) {        // Error message if no accounts have been saved to the accounts array
            System.out.println("Unfortunately no accounts are registered in this bank, please register");
            System.out.println("\n");

            loginMenu();

        } else if (numberOfAccounts >= 0) {     // Login message will be displayed if an account has been registered in the bank
            System.out.println("Welcome back");
            System.out.println("Please enter account ID");


            int verifyUser = userInput.nextInt();       // Takes the user input and stores it into the verifyUser

            for (int i = 0; i < numberOfAccounts; i++)      // Opens all the accounts so data can be read
                if (verifyUser == accounts[i].getID()) {    // The user input which was entered, if that number is the same as an account ID then it will prompt a login success message
                    currentUser = accounts[i];              // Transfers the specific account with a specific account ID to the currentUser so it can be edited

                    System.out.println("Login successful");
                    userMenu();

                }
        }
    }

    protected void registrationMenu() {        // Registration menu
        System.out.println("Welcome to your new bank");
        System.out.println("This is the registration process");
        System.out.println("Please enter your birthday, this will be your account ID");

        int userID = userInput.nextInt();
        Account tempAccount = new Account(userID);      // Constructs a temporary Account class which is made to store the information a user would like to register with
        System.out.println("\n");

        System.out.println("Please enter your first name");
        String firstName = userInput.next();
        tempAccount.setFirstName(firstName);
        System.out.println("\n");

        System.out.println("Please enter your last name");
        String lastName = userInput.next();
        tempAccount.setLastName(lastName);
        System.out.println("\n");

        System.out.println("Please enter account starting balance: ");
        double balance = userInput.nextInt();
        tempAccount.setBalance(balance);
        System.out.println("\n");

        accounts[userIdx] = tempAccount;                // After all information is stored into the temporary Account, it will then be put into the account class array

        System.out.println("Your account ID: " +accounts[userIdx].getID());
        System.out.println(accounts[userIdx].getDateCreated());
        System.out.printf("Registered name: %s %s\n", accounts[userIdx].getFirstName(), accounts[userIdx].getLastName());
        System.out.println("Your balance is: " + accounts[userIdx].getBalance());
        System.out.println('\n');

        currentUser = accounts[userIdx];                // The currentUser will load the specific account in the specific account array so information can be edited

        userIdx = (userIdx + 1) %accounts.length;                        // Increments the userIdx with 1, this means, if another user wants to register, their account in the array will be placed 1 after the first registered user

        numberOfAccounts = userIdx;                     // numberofaccounts gets the same value as userIdx, this is used to load the account for loop

        userMenu();
    }

    protected void accountInformation() {
        System.out.println("Account Information:");
        System.out.println("Account ID: " +currentUser.getID());
        System.out.printf("Registered name: %s %s \n", currentUser.getFirstName(), currentUser.getLastName());
        System.out.println("Date Created " + currentUser.getDateCreated());
        System.out.println("Account balance " + currentUser.getBalance());
        System.out.println("\n");

        System.out.println("Your account is registered at: " +bank.getBankName());
        System.out.println("Please choose another option from the user menu");
    }

    protected void editAccountInformation() {
        System.out.println("Which account information do you wish to edit?");
        System.out.println("1. First Name");
        System.out.println("2. Last name");
        System.out.println("3. Return to user menu");

        char accountInfoOption;
        accountInfoOption = userInput.next().charAt(0);

        switch (accountInfoOption) {
            case '1':
                System.out.println("Please enter the desired first name");
                String firstName = userInput.next();
                currentUser.setFirstName(firstName);

                System.out.println("Your first name is set to " +currentUser.getFirstName());
                System.out.println("Please choose a new option");
                editAccountInformation();
                break;

            case '2':
                System.out.println("Please enter the desired last name");
                String lastName = userInput.next();
                currentUser.setLastName(lastName);

                System.out.println("Your last name is set to " +currentUser.getLastName());
                System.out.println("Please choose a new option");
                editAccountInformation();
                break;

            case '3':
                System.out.println("Please choose another option from the user menu");
                userMenu();
                break;
        }
    }

    protected void balanceInformation(){
        System.out.println("Account balance: " +currentUser.getBalance());
        System.out.println("\n");
        System.out.println("Please choose another option from the user menu");
    }

    protected void depositMenu() {
        System.out.println("Enter the amount of money you wish to deposit: ");
        double depositAmount = userInput.nextDouble();
        currentUser.deposit(depositAmount);
        System.out.println("Deposit successful, your new balance is: " +currentUser.getBalance());
        System.out.println("\n");
        System.out.println("Please choose another option from the user menu");
    }

    protected void withdrawalMenu() {
        System.out.println("Your current balance is: " +currentUser.getBalance());
        System.out.println("Enter the amount of money you wish to withdraw: " );
        double withdrawAmount = userInput.nextDouble();
        currentUser.withdraw(withdrawAmount);
        System.out.println("Withdrawal successful, your new balance is " +currentUser.getBalance());
        System.out.println("\n");
        System.out.println("Please choose another option from the user menu");
    }

    protected void transferMenu() {
        System.out.println("Enter the account ID of the receiver: ");

        int verifyUser = userInput.nextInt();
        for (int i = 0; i < numberOfAccounts; i++)
            if (verifyUser == accounts[i].getID()) {

                System.out.printf("Enter the amount of money you wish to transfer to %s %s\n", accounts[i].getFirstName(), accounts[i].getLastName());

                double amount = userInput.nextInt();

                System.out.println(verifyUser);
                System.out.println(accounts[i].getID());

                currentUser.withdraw(amount);
                otherUser = accounts[i];
                otherUser.deposit(amount);

                System.out.printf("The amount %f has been successfully transferred to %s %s with account ID %d\n", amount, otherUser.getFirstName(), otherUser.getLastName(), otherUser.getID());
                System.out.println("Please choose another option from the user menu");

                break;      // A break function is needed when running a switch function, this means no further code will be read after this point

            }
    }
}
