package cryptowallet.tracker.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.sql.Timestamp;

@Component
public class PriceResponseSymbolDTO extends PriceResponseDTO implements Serializable {

    @JsonProperty("data")
    private PriceInformationSymbol priceInformationSymbol;

    public PriceResponseSymbolDTO(PriceInformationSymbol priceInformationSymbol, Timestamp timestamp) {
        this.priceInformationSymbol = priceInformationSymbol;
    }

    public PriceResponseSymbolDTO() {
    }

    public PriceInformationSymbol getPriceInformationSymbol() {
        return priceInformationSymbol;
    }

    public void setPriceInformationSymbol(PriceInformationSymbol priceInformationSymbol) {
        this.priceInformationSymbol = priceInformationSymbol;
    }

    @Override
    public String toString() {
        return "PriceResponseSymbolDTO{" +
                "priceInformationSymbol=" + priceInformationSymbol +
                '}';
    }
}
