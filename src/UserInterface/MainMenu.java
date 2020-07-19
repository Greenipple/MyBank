package UserInterface;

import UserInterface.Menus.MenuTypes.MainOptionsType;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;

public class MainMenu implements MyMenu {

    private UserInterface userInterface;
    private String name;

    public MainMenu(UserInterface userInterface){
        this.userInterface = userInterface;
        this.name = userInterface.getAccountOwner().getName();
    }

    public void start(){

        String[] options = {"Get balance", "Make a deposit",
                "Make a withdrawal", "Open an account", "Exit the application"};

        MenuInputScanner mainMenu = new MenuInputScanner(options);
        mainMenu.setMessage("What would you like to do, " + name + "?" );

        int answerIndex = MyMenu.prompt.getUserInput(mainMenu);
        MainOptionsType choice = MainOptionsType.values()[answerIndex-1];

        if (answerIndex == 5){
            System.out.println("Exiting...");
            System.exit(0);
        }

        MyMenu next = MenuFactory.create(choice,userInterface);
        next.start();

    }
}
