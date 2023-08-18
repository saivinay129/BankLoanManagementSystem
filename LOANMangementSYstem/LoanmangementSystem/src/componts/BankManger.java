package componts;

import java.util.Scanner;

public class BankManger {
    private long accno;
    private String name;
    private long phoneNo;
    protected double balance;
    protected final int K = 15000;
    protected final int Z = 25000;
    int visted = 0;
    int vistedloan = 0;

    String R = "yes";
    String V = "no";
    boolean loanTaken;
    boolean upgradeToPremium;

    public void checkUser() {
        Scanner Checker = new Scanner(System.in);
        boolean validChoice = false;
        System.out.println("-----------------------***-----------------------------");
        System.out.println("        ---------------***----------------             ");
        while (!validChoice) {

            System.out.println("------------------------------------------------------------------");
            System.out.println("Enter '1' to if you are a new user or '2' to for an existing user:");
            System.out.println("------------------------------------------------------------------");
            int choice = Checker.nextInt();

            if (choice == 1) {
                openAccount();
                addUser();
                validChoice = true;
            } else if (choice == 2) {
                CheckExistingUser check = new CheckExistingUser();
                check.checkexistinguser();
                accno = check.accno2;
                name = check.name2;
                phoneNo = check.phoneNo2;
                balance = check.balance2;
                loanTaken = check.loanTaken2;
                upgradeToPremium = check.upgradeToPremium2;
                if (loanTaken == true) {
                    visted = 1;
                }
                if (upgradeToPremium == true) {
                    vistedloan = 1;
                }

                validChoice = true;
            } else {
                System.out.println("------------------*---------------------");
                System.out.println("Invalid choice. Please enter '1' or '2'.");
                System.out.println("------------------*---------------------");
            }
        }
    }

    public void openAccount() {
        Scanner s = new Scanner(System.in);
        while (true) {
            System.out.println("-----------------------");
            System.out.println("Enter 16 digits Account No: ");
            System.out.println("-----------------------");
            accno = s.nextLong();
            String accnoStr = String.valueOf(accno);

            if (accnoStr.length() == 16) {
                break;
            } else if (accnoStr.length() < 16) {
                System.out.println("----------------------*---------------");
                System.out.println("You only typed " + accnoStr.length() + " digits. Please enter 16 digits.");
                System.out.println("-----------------------*--------------");
            } else if (accnoStr.length() > 16) {
                System.out.println("-----------------*---------------");
                System.out.println("You typed " + accnoStr.length() + " digits. Please enter exactly 16 digits.");
                System.out.println("-----------------*---------------");
            } else {
                System.out.println("-----------------*---------------");
                System.out.println("Invalid input. Please enter numeric digits.");
                System.out.println("-----------------*---------------");
            }
        }

        UniqueAccountNo it2 = new UniqueAccountNo();
        if (it2.uniqueACCountno(accno)) {
            System.out.println("--------------------*-------------------------");
            System.out.println("invaild user and your exited out for invaild accountnumber");
            System.out.println("        ------------***------------             ");
            System.out.println("--------------------***-------------------------");
            System.exit(0);

        } else {
            System.out.println("--------------------**-------------------------");
            System.out.println(" Welcome to BANK");
            System.out.println("--------------------**-------------------------");
        }

        while (true) {
            System.out.println("------------");
            System.out.println("Enter the name: ");
            System.out.println("-------------");
            name = s.nextLine();

            if (!name.trim().isEmpty()) {
                break;
            } else {
                System.out.println("--------------------*-----------------------");
                System.out.println("Name cannot be empty. Please enter a valid name.");
                System.out.println("---------------------*----------------------");
            }
        }

        while (true) {
            System.out.println("--------------------------");
            System.out.println("Enter 10 digits Account No: ");
            System.out.println("--------------------------");
            phoneNo = s.nextLong();
            String phnoStr = String.valueOf(phoneNo);

            if (phnoStr.length() == 10) {
                break;
            } else if (phnoStr.length() < 10) {
                System.out.println("-------------------------------*--------------------------------");
                System.out.println("You only typed " + phnoStr.length() + " digits. Please enter 16 digits.");
                System.out.println("-------------------------------*--------------------------------");
            } else if (phnoStr.length() > 10) {
                System.out.println("-------------------------------*--------------------------------");
                System.out.println("You typed " + phnoStr.length() + " digits. Please enter exactly 16 digits.");
                System.out.println("-------------------------------*--------------------------------");
            } else {
                System.out.println("---------------*------------------------");
                System.out.println("Invalid input. Please enter numeric digits.");
                System.out.println("---------------*------------------------");
            }
        }

        while (true) {
            System.out.println("------------");
            System.out.println("Enter Balance: ");
            System.out.println("------------");
            String input = s.nextLine();

            if (!input.trim().isEmpty()) {
                try {
                    balance = Long.parseLong(input);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("---------------*------------------------");
                    System.out.println("Invalid input. Please enter a valid number.");
                    System.out.println("---------------*------------------------");
                }
            } else {
                System.out.println("-------------------*----------------------------");
                System.out.println("Input cannot be empty. Please enter a valid number.");
                System.out.println("-------------------*----------------------------");
            }
        }
        System.out.println("---------------------------**------------------------------");

    }

    public void addUser() {
        CreateAccount newUser = new CreateAccount();
        newUser.createaccountToUser(accno, name, phoneNo, balance, false, false);

    }

    public void showAccount() {
        System.out.println("---------------------------------------------------------");
        System.out.println("-----------------Your account detials--------------------");
        System.out.println("Name of account holder: " + name);
        System.out.println("Account no.: " + accno);
        System.out.println("Phone number of account holder:" + phoneNo);
        System.out.println("Balance: Rs  " + balance);
        System.out.println("---------------------------------------------------------");
        System.out.println("---------------------------------------------------------");

    }

    public void createBankManger() {
        String V = "no";
        String eXit;

        checkUser();
        showAccount();

        do {
            System.out.println("There is an upgrade offer for regular users to upgrade their account to premium");
            System.out.println("---------------------------------------------");
            int access;
            Scanner P = new Scanner(System.in);
            System.out.print("enter 1 for upgrade your account to premium  2 for withdrawl 3 for deposit :: ");
            access = P.nextInt();
            System.out.println("---------------------------------------------");

            switch (access) {
                case 1: {

                    UpgradePremium d;
                    d = new UpgradePremium();

                    d.loanBalance = balance;
                    d.visted = visted;
                    d.vistedloan = vistedloan;

                    d.upgradePremium();

                    d.loan();
                    balance = d.loanBalance;

                    visted = d.visted;
                    vistedloan = d.vistedloan;
                    UpdateloanToUser user = new UpdateloanToUser();
                    user.updateloanToUser(accno, d.loanBalance, d.Takenloan, d.upgradedtopremium);
                    break;
                }

                case 2: {

                    Withdrawl g;
                    g = new Withdrawl();
                    g.withdrawBalance = balance;

                    g.withDrawl();
                    g.display();
                    balance = g.withdrawBalance;
                    UpdateBalance user = new UpdateBalance();
                    user.updatBalanceToUser(accno, g.withdrawBalance);
                    break;
                }

                case 3: {

                    Deposit f;
                    f = new Deposit();
                    f.depositBalance = balance;
                    f.deposit();
                    f.display();
                    balance = f.depositBalance;
                    UpdateBalance user = new UpdateBalance();
                    user.updatBalanceToUser(accno, f.depositBalance);
                    break;
                }
                default: {
                    System.out.println("Invalid");
                }
            }
            Scanner M = new Scanner(System.in);
            System.out.println("Do you want Exit : (type yes/no)");
            eXit = M.nextLine();
            System.out.println("        ------------***------------             ");
            System.out.println("--------------------***-------------------------");

        } while (eXit.equals(V));

    }

}
