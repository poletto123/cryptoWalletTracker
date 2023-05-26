package cryptowallet.tracker.entity;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class PriceResponseDTO {
    private Timestamp timestamp;

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
