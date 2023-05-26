package cryptowallet.tracker.service;

import cryptowallet.tracker.entity.PriceResponseTimestampDTO;
import cryptowallet.tracker.entity.PriceInformationSymbol;

public interface PriceService {
    public void getCurrentPrice();


    PriceResponseTimestampDTO getPriceAtUnixTimestamp(PriceInformationSymbol crypto, String startTimeStamp, String endTimeStamp);
}
