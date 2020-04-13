package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Pizza;

public class PizzaDao {
	
	private Connection connection;
	//private PizzaDao pizzaDao = new PizzaDao();
	private final String CREATE_NEW_PIZZA_QUERY = "INSERT INTO pizzas(pizzaName) VALUES(?)";//Create
	private final String GET_PIZZAS_QUERY = "SELECT * FROM pizzas";//Read/Retrieve 1
	private final String GET_PIZZA_BY_ID_QUERY = "SELECT * FROM pizzas WHERE id = ?"; //read/retrieve 2
	private final String UPDATE_EXISTING_PIZZA_QUERY = "UPDATE pizzas SET pizzaName = ? WHERE id = ?";
	private final String REMOVE_PIZZA_QUERY = "DELETE FROM pizzas WHERE id = ?";
	
	public PizzaDao() {
		connection = DBConnection.getConnection();
	}
	
	public void createNewPizza(String pizzaName) throws SQLException {
		PreparedStatement prepState = connection.prepareStatement(CREATE_NEW_PIZZA_QUERY);
		prepState.setString(1, pizzaName);
		prepState.executeUpdate();
		
	}
	
	public List<Pizza> getPizzas() throws SQLException {
		ResultSet res = connection.prepareStatement(GET_PIZZAS_QUERY).executeQuery();
		List<Pizza> pizzas = new ArrayList<Pizza>();
		while (res.next()) {
			pizzas.add(
					populatePizzas(res.getInt(1), res.getString(2))
					); //grabs pizza ID, Then Name and populates ArrayList
		}
		return pizzas; 
	}
	
	public Pizza getPizzaById(int id) throws SQLException {
		PreparedStatement prepState = connection.prepareStatement(GET_PIZZA_BY_ID_QUERY);
		prepState.setInt(1, id);
		ResultSet res = prepState.executeQuery();
		res.next();
		return populatePizzas(res.getInt(1), res.getString(2));
	}
	
	public void editPizza(int id, String pizzaName) throws SQLException {
		PreparedStatement prepState = connection.prepareStatement(UPDATE_EXISTING_PIZZA_QUERY);
		prepState.setInt(2, id);
		prepState.setString(1, pizzaName);
		prepState.executeUpdate();
	}
	
	public void removePizza(int id) throws SQLException {
		PreparedStatement prepState = connection.prepareStatement(REMOVE_PIZZA_QUERY);
		prepState.setInt(1, id);
		prepState.executeUpdate();
	}
	
	public Pizza populatePizzas(int id, String pizzaName) {
		return new Pizza(id, pizzaName);
	}
	
}

















