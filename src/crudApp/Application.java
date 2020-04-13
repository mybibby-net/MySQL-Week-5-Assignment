package crudApp;

import java.sql.SQLException;


public class Application {
	
	public static void main(String[] args) {
		pizzaMenu menu = new pizzaMenu();
		menu.programStart();
	}

}

/*
 * create:
 * createPizza();
 * 
 * read:
 * displayPizza();
 * 
 * update:
 * editExistingPizza();
 * 
 * delete:
 * rmPizza(); 
 */
