import java.util.*;
import java.math.BigDecimal;
import java.math.*; 

class Item {

	String description;
	BigDecimal price;
	MathContext mc = new MathContext(3);

	public Item(String description, BigDecimal price) {
		this.description = description;
		this.price = price;
	}

	public String getItemDescription(){
		return description;
	}

	public BigDecimal getItemPrice(){
		return price;
	}


	public BigDecimal computeSalesTax(BigDecimal taxRate){
		BigDecimal twenty = new BigDecimal("20.0");
		BigDecimal compute1 = this.getItemPrice().multiply(taxRate);
		BigDecimal compute2 = compute1.multiply(twenty);
		BigDecimal compute3 = compute2.setScale(0, RoundingMode.UP);
		BigDecimal finalSalesTax = compute3.divide(twenty);
		
		return finalSalesTax;
	}

	public BigDecimal getItemPriceIncludingTax(BigDecimal itemSalesTax){
		return this.getItemPrice().add(itemSalesTax);
	}






}




