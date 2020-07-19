package org.academiadecodigo.javabank.UserInterface.Menus;

import org.academiadecodigo.bootcamp.Prompt;

public interface MyMenu {

    Prompt prompt = new Prompt(System.in,System.out);

    void start();

}
