package cryptowallet.tracker.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.math.BigDecimal;

@Component
public class PriceInformationSymbol implements Serializable {
    private String id;
    private String symbol;
    private String name;
    public BigDecimal priceUsd;

    public PriceInformationSymbol() {
    }

    public PriceInformationSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPriceUsd() {
        return priceUsd;
    }

    public void setPriceUsd(BigDecimal priceUsd) {
        this.priceUsd = priceUsd;
    }

    @Override
    public String toString() {
        return "PriceInformationSymbol{" +
                "id='" + id + '\'' +
                ", symbol='" + symbol + '\'' +
                ", name='" + name + '\'' +
                ", priceUsd=" + priceUsd +
                '}';
    }
}
