package cryptowallet.tracker;

import cryptowallet.tracker.service.CryptoPriceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

@SpringBootTest
class CryptoWalletTrackerApplicationTests {

	@Autowired
	CryptoPriceService cryptoPriceService;

	@Test
	void getBitcoinCurrentPrice() {
		String tokenSymbol = "BTC";

		BigDecimal price = cryptoPriceService.getCurrentPrice(tokenSymbol, null, null)
				.getPriceInformationSymbol()
				.getPriceUsd();

		assertEquals(price.scale(), 16, "Incorrect scale on price");
		assertEquals(price.precision(), 21, "Incorrect precision on price");
	}

	@Test
	void getBitcoinPriceAtTimestamp() {
		String tokenSymbol = "BTC";
		String startTimestamp = "1617753600000";
		String endTimestamp = "1617753601000";

		BigDecimal price = cryptoPriceService.getPriceAtTimestamp(tokenSymbol, startTimestamp, endTimestamp)
				.getPriceInformationTimestamp().get(0)
				.getPriceUsd();

		assertEquals(price, new BigDecimal("56999.9728252053067291"), "Incorrect timestamp price");
	}

}
