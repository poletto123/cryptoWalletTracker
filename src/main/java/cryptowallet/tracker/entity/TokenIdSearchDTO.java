package cryptowallet.tracker.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TokenIdSearchDTO extends PriceResponseDTO {

    @JsonProperty("data")
    private List<PriceInformationSymbol> priceInformationSymbols;

    public TokenIdSearchDTO() {
    }

    public TokenIdSearchDTO(List<PriceInformationSymbol> priceInformationSymbols) {
        this.priceInformationSymbols = priceInformationSymbols;
    }

    public List<PriceInformationSymbol> getPriceInformationSymbols() {
        return priceInformationSymbols;
    }

    public void setPriceInformationSymbols(List<PriceInformationSymbol> priceInformationSymbols) {
        this.priceInformationSymbols = priceInformationSymbols;
    }

    @Override
    public String toString() {
        return "TokenIdSearchDTO{" +
                "priceInformationSymbols=" + priceInformationSymbols +
                '}';
    }
}
