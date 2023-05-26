package cryptowallet.tracker;

import cryptowallet.tracker.service.CryptoPriceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CryptoWalletTrackerApplicationTests {

	@Autowired
	CryptoPriceService cryptoPriceService;

	@Test
	void getBitcoinCurrentPrice() {
		System.out.println(cryptoPriceService.getCurrentPrice("BTC", null, null));
	}

	@Test
	void getBitcoinPriceAtTimestamp() {
		System.out.println(cryptoPriceService.getPriceAtTimestamp("BTC", "1617753600000", "1617753601000"));
	}

}
