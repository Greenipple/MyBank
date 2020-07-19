package UserInterface;

import UserInterface.Menus.MenuTypes.MenuType;
import org.academiadecodigo.bootcamp.scanners.precisiondouble.DoubleInputScanner;
import org.academiadecodigo.javabank.managers.AccountManager;

public class WithdrawalMenu implements MyMenu{

    private UserInterface userInterface;
    private AccountManager accountManager;

    public WithdrawalMenu(UserInterface userInterface){
        this.userInterface = userInterface;
        this.accountManager = userInterface.getAccountManager();
    }

    @Override
    public void start() {


        MyMenu whichAccount = MenuFactory.create(MenuType.WHICHACCOUNT,userInterface);
        whichAccount.start();
        int id = userInterface.getAccount().getId();

        DoubleInputScanner howMuch = new DoubleInputScanner();
        howMuch.setMessage("How much would you like to withdraw from account #" + userInterface.getAccount().getId());

        double amount = prompt.getUserInput(howMuch);
        accountManager.withdraw(id,amount);

    }
}
