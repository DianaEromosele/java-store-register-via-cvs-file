import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.math.BigDecimal;

class Controller {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(args[0]));
		String row = null;
		Receipt receipt = new Receipt();
		String header = reader.readLine();

		while ((row = reader.readLine()) != null) {
			BigDecimal taxRate = new BigDecimal("0.0");
			String description = "";
			BigDecimal price = null;

			Scanner scanner = new Scanner(row);
			scanner.useDelimiter(",");
			int index = 0;
			
			while (scanner.hasNext()) {
				String data = scanner.next();

				if (index == 0) {
					description = data;
				} else if  (index == 1) {
					price = new BigDecimal(data);
				} else if (index == 2) {
						taxRate = taxRate.add(getTaxRateBasedOnExemptStatus(data));
				} else if (index == 3) {
						if ( data.equals("yes") ) {
							TaxRates taxRates = new TaxRates();
							taxRate = taxRate.add(taxRates.getImportedSalesTax());
						} 
				} else {
					System.out.println("Invalid Data: " + data);
				}
				index++;
			}

			index = 0;
			Item item = new Item(description, price);
			BigDecimal finalSalesTax = item.computeSalesTax(taxRate);
			BigDecimal finalItemPrice = item.getItemPriceIncludingTax(finalSalesTax);
	
			receipt.addSalesTax(finalSalesTax);
			receipt.addFinalItemPrice(finalItemPrice);
			receipt.addItemToReceipt(item);

		}

		reader.close();
		receipt.displayFinalReceipt();
	}

	public static BigDecimal getTaxRateBasedOnExemptStatus(String exemptStatusString) {
		if ( exemptStatusString.equals("yes") ) {
			return new BigDecimal ("0.0");
		} else  {
			return new BigDecimal ("0.10");
		}
	}
}