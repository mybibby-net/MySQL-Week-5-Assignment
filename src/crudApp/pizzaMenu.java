package crudApp;

import java.sql.SQLException;
import java.util.Scanner;

import dao.PizzaDao;
import entity.Pizza;

import java.util.List;
import java.util.Arrays;

public class pizzaMenu {
	
	private PizzaDao pizzaDao = new PizzaDao();
	private Scanner scanner = new Scanner(System.in);
	private List<String> selections = Arrays.asList(
			"Create Pizza",
			"Display A Pizza (By ID)",
			"Display Pizzas List",
			"Edit Existing Pizza",
			"Remove Pizza"
			);
		
		public void programStart() {
			String selection = "";
			
			do {
				printPizzaMenu();
				selection = scanner.nextLine();
				
			try {
				if (selection.equals("1")) {
					createPizza();
				} else if (selection.equals("2")) {
					displayPizzaById(); //displays pizzas by id number
				} else if (selection.equals("3")) {
					displayPizzas();
				} else if (selection.equals("4")) {
					editExistingPizza();
				} else if (selection.equals("5")) {
					rmPizza();
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
				System.out.println("Press the Enter Key to Continue");
				scanner.hasNextLine();
				
			} while (!selection.equals("-1"));
			
		}
		
		private void printPizzaMenu() {
			System.out.println("Select An Option Below:\n ---------------------");
			for (int i = 0; i < selections.size(); i++) {
				System.out.println(i + 1 + ") " + selections.get(i));
			}
			System.out.println("\n------------------------");
		}
		
		private void createPizza() throws SQLException {
			System.out.print("Enter Pizza Name: ");
			String pizzaName = scanner.nextLine();
			pizzaDao.createNewPizza(pizzaName);
		}
		
		private void displayPizzaById() throws SQLException {
			System.out.print("Enter Pizza ID Number: ");
			int id = Integer.parseInt(scanner.nextLine()); 
			Pizza pizza = pizzaDao.getPizzaById(id);
			System.out.println(pizza.getPizzaId() + ": " + pizza.getPizzaName());
		}
		
		private void displayPizzas() throws SQLException {
			List<Pizza> pizzas = pizzaDao.getPizzas();
			for (Pizza pizza : pizzas) {
				System.out.println(pizza.getPizzaId() + ": " + pizza.getPizzaName());
			}
		}
		
		private void editExistingPizza() throws SQLException {
			System.out.print("Please Enter the ID Number of the Pizza You Wish to Edit: ");
			int id = Integer.parseInt(scanner.nextLine());
			System.out.print("Please Enter the New Pizza Name: ");
			String newPizzaName = scanner.nextLine();
			pizzaDao.editPizza(id, newPizzaName);
		}
		
		private void rmPizza() throws SQLException {
			System.out.println("Enter ID Number of Pizza to Remove: ");
			int id = Integer.parseInt(scanner.nextLine());
			pizzaDao.removePizza(id);
		}
		
		
}




























