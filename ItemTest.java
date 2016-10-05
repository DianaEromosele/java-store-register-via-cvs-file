// import org.junit.*;
// import java.math.BigDecimal;


// public class ItemTest {
// 	@Test
// 	public void shouldComputeTaxForMusicCDWithTenPercentTax() {
// 		Item musicCD = new Item("musicCD", new BigDecimal ("14.99"));

// 		Assert.assertEquals(new BigDecimal("1.5"), musicCD.computeSalesTax(new BigDecimal ("0.10")));
// 	}

// 	@Test
// 	public void shouldComputeTaxForImportedBottleOfPerfumeWithFivePercentTax() {
// 		Item importedBottleOfPerfume = new Item("bottle of perfume", new BigDecimal("27.99"));

// 		Assert.assertEquals(new BigDecimal("1.4"), importedBottleOfPerfume.computeSalesTax(importedBottleOfPerfume.getImportedSalesTax()));
// 	}
// }