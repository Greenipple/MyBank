package UserInterface;


import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.javabank.domain.Customer;
import org.academiadecodigo.javabank.domain.account.AccountType;

public class OpenAccountMenu implements MyMenu {

    UserInterface userInterface;
    Customer customer;


    public OpenAccountMenu(UserInterface userInterface){
        this.userInterface = userInterface;
        this.customer = userInterface.getAccountOwner();
    }

    public void start(){

          String[] options = {"Checking", "Savings", "Go back"};
        MenuInputScanner whatKind = new MenuInputScanner(options);
        whatKind.setMessage("What kind of account would you like to open?");


        System.out.println(customer.getName());

        int answer = prompt.getUserInput(whatKind);

        switch (answer){
            case 1 ->{
                customer.openAccount(AccountType.CHECKING);
            }

            case 2 -> {
                customer.openAccount(AccountType.SAVINGS);
            }

            case 3 ->{
                userInterface.startMenu();
            }
        }
    }
}
