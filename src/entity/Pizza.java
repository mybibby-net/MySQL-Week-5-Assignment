package entity;

public class Pizza {
	private int pizzaId;
	private String pizzaName;
	
	public Pizza(int pizzaId, String pizzaName) {
		this.setPizzaId(pizzaId);
		this.setPizzaName(pizzaName);
	}
	
	public int getPizzaId() {
		return pizzaId;
	}
	
	public void setPizzaId(int pizzaId) {
		this.pizzaId = pizzaId;
	}
	
	public String getPizzaName() {
		return pizzaName;
	}
	
	public void setPizzaName(String pizzaName) {
		this.pizzaName = pizzaName;
	}
	
}
