package cryptowallet.tracker.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Component
public class PriceResponseTimestampDTO extends PriceResponseDTO implements Serializable {

    @JsonProperty("data")
    private List<PriceInformationTimestamp> priceInformationTimestamp;



    public PriceResponseTimestampDTO(List<PriceInformationTimestamp> priceInformationTimestamp, Timestamp timestamp) {
        this.priceInformationTimestamp = priceInformationTimestamp;
    }

    public PriceResponseTimestampDTO() {
    }

    public List<PriceInformationTimestamp> getPriceInformationTimestamp() {
        return priceInformationTimestamp;
    }

    public void setPriceInformationTimestamp(List<PriceInformationTimestamp> priceInformationTimestamp) {
        this.priceInformationTimestamp = priceInformationTimestamp;
    }

    @Override
    public Timestamp getTimestamp() {
        return super.getTimestamp();
    }

    @Override
    public void setTimestamp(Timestamp timestamp) {
        super.setTimestamp(timestamp);
    }

    @Override
    public String toString() {
        return "PriceResponseTimestampDTO{" +
                "priceInformationTimestamp=" + priceInformationTimestamp +
                '}' + super.getTimestamp().getTime();
    }


}
