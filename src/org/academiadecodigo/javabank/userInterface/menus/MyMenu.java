package org.academiadecodigo.javabank.userInterface.menus;

import org.academiadecodigo.bootcamp.Prompt;

public interface MyMenu {

    Prompt prompt = new Prompt(System.in,System.out);

    void start();

}
