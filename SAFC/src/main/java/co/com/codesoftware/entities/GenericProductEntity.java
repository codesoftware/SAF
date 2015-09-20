package co.com.codesoftware.entities;

import java.io.Serializable;
import java.math.BigDecimal;

public class GenericProductEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	private String code;
	private int amount;
	private String name;
	private BigDecimal price;
	private BigDecimal totalPrice;
	private int id;
	private int type;
	private String routImage;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getRoutImage() {
		return routImage;
	}

	public void setRoutImage(String routImage) {
		this.routImage = routImage;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getPrice() {
		return price;
	}

}
