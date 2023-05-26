package cryptowallet.tracker.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Component
public class PriceInformationTimestamp implements Serializable {
    private BigDecimal priceUsd;
    private Timestamp time;
    private LocalDateTime date;

    public PriceInformationTimestamp() {
    }

    public PriceInformationTimestamp(BigDecimal priceUsd, Timestamp time, LocalDateTime date) {
        this.priceUsd = priceUsd;
        this.time = time;
        this.date = date;
    }

    public BigDecimal getPriceUsd() {
        return priceUsd;
    }

    public void setPriceUsd(BigDecimal priceUsd) {
        this.priceUsd = priceUsd;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "PriceInformationTimestamp{" +
                "priceUsd=" + priceUsd +
                ", time=" + time +
                ", date=" + date +
                '}';
    }
}
