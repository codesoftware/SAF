package co.com.codesoftware.logic;

public class FacturacionLogic {
	/**
	 * Funcion que hace la multiplicacion del precio del producto por la cantidad
	 * @param price
	 * @param amount
	 * @return
	 */
	public String updatePrice(String price, int amount) {
		String result = "";
		Double total = Double.parseDouble(price) * amount;
		result = String.valueOf(total);
		return result;
	}
}
