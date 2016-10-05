import java.util.*;
import java.math.BigDecimal;
import java.math.*;
import java.text.NumberFormat;
import java.text.DecimalFormat;

class Receipt {

	ArrayList<Item> listOfItems = new ArrayList<Item>();
	ArrayList<BigDecimal> salesTaxes = new ArrayList<BigDecimal>();
	ArrayList<BigDecimal> finalPrices = new ArrayList<BigDecimal>();
	MathContext mc = new MathContext(3);

	public Receipt(){
	}

	public void addItemToReceipt(Item item) {
		this.listOfItems.add(item);
	}

	public ArrayList<Item> getItemsArray(){
		return listOfItems;
	}


	public void addSalesTax(BigDecimal salesTax){
		this.salesTaxes.add(salesTax);
	}

	public ArrayList<BigDecimal> getSalesTaxesArray(){
		return salesTaxes;
	}

	public BigDecimal totalSalesTax(){
		BigDecimal finalTax = new BigDecimal("0.0");
		BigDecimal twenty = new BigDecimal("20.0");
		for (int index = 0; index < this.getSalesTaxesArray().size(); index++){
			finalTax = finalTax.add(this.getSalesTaxesArray().get(index));
		}
		BigDecimal roundingOne = (finalTax.multiply(twenty)).round(mc);
		BigDecimal roundingFinal = roundingOne.divide(twenty);
		return roundingFinal.setScale(2);
	}

	public void addFinalItemPrice(BigDecimal price){
		BigDecimal roundedFinalPrice = price.setScale(2, BigDecimal.ROUND_UP);
		this.finalPrices.add(roundedFinalPrice);
	}

	public ArrayList<BigDecimal> getFinalPricesArray(){
		return finalPrices;
	}

	public BigDecimal totalFinalPrice(){
		BigDecimal finalPrice = new BigDecimal("0.0");
		for (int index = 0; index < this.getFinalPricesArray().size(); index++){
			finalPrice = finalPrice.add(this.getFinalPricesArray().get(index));
		}
		BigDecimal roundedFinalPrice = finalPrice.setScale(2, BigDecimal.ROUND_UP);
		return roundedFinalPrice;
	}


	public void displayFinalReceipt(){
		System.out.println();
		System.out.println( "Here are the details of your receipt. Please do shop with us again!");
		System.out.println();
		System.out.println("Output:"); 
		System.out.println();
		for (int index = 0; index < this.getItemsArray().size(); index++) {
		System.out.println( this.getItemsArray().get(index).getItemDescription() + ": " + this.getFinalPricesArray().get(index) );
		}
		System.out.println( "Sales Taxes: " + this.totalSalesTax() );
		System.out.println( "Total: " + this.totalFinalPrice() );
		System.out.println();
	}

}







