package UserInterface;

import UserInterface.UserInterface;
import org.academiadecodigo.bootcamp.InputScanner;
import org.academiadecodigo.bootcamp.Prompt;

interface MyMenu {
    UserInterface userInterface = null;
    Prompt prompt = new Prompt(System.in,System.out);

    default void start(){};


}
