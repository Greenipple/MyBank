package org.academiadecodigo.javabank.userInterface.menus;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.javabank.domain.Customer;

public interface MyMenu {

    Prompt prompt = new Prompt(System.in,System.out);

   void start();

}
