package cryptowallet.tracker.service;

import cryptowallet.tracker.entity.*;
import cryptowallet.tracker.exception.ExternalApiException;
import cryptowallet.tracker.exception.InvalidAPICallException;
import cryptowallet.tracker.exception.TokenSymbolNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CryptoPriceService{

    @Autowired
    RestTemplate restTemplate;

    @Value("${coincap.baseurl}")
    private String baseUrl;

    @Value("${coincap.historyurl}")
    private String historyUrl;

    @Value("${coincap.tokensearchurl}")
    private String tokenSearchUrl;

    public PriceResponseSymbolDTO getCurrentPrice(String tokenSymbol, String startTimestamp, String endTimestamp) {
        String tokenId = getTokenId(tokenSymbol);
        String uri = buildUriForPriceDiscovery(tokenId, null, null);
        return (PriceResponseSymbolDTO) makeApiCall(uri, "symbol");
    }

    public PriceResponseTimestampDTO getPriceAtTimestamp(String tokenSymbol, String startTimestamp, String endTimestamp) {
        String tokenId = getTokenId(tokenSymbol);
        String uri = buildUriForPriceDiscovery(tokenId, startTimestamp, endTimestamp);
        return (PriceResponseTimestampDTO) makeApiCall(uri, "timestamp");
    }

    private String getTokenId(String tokenSymbol) {
        TokenIdSearchDTO dto = (TokenIdSearchDTO) makeApiCall(buildUriForTokenIdDiscovery(tokenSymbol), "tokenIdSearch");
        for (PriceInformationSymbol priceInformationSymbol : dto.getPriceInformationSymbols()) {
            if (priceInformationSymbol.getSymbol().equals(tokenSymbol)) {
                return priceInformationSymbol.getId();
            }
        }
        throw new TokenSymbolNotFoundException(new RuntimeException());
    }

    private PriceResponseDTO makeApiCall(String uri, String responseType) {
        PriceResponseDTO dto = null;
        if (responseType.equals("symbol")) {
            dto = new PriceResponseSymbolDTO();
        } else if (responseType.equals("timestamp")) {
            dto = new PriceResponseTimestampDTO();
        } else if (responseType.equals("tokenIdSearch")) {
            dto = new TokenIdSearchDTO();
        } else {
            throw new InvalidAPICallException(new RuntimeException());
        }
        try {
            dto = restTemplate.getForObject(uri, dto.getClass());
        } catch(Exception e) {
            throw new ExternalApiException(new RuntimeException());
        }
        return dto;
    }

    private String buildUriForPriceDiscovery(String tokenId, String startTimestamp, String endTimestamp) {
        StringBuffer sb = new StringBuffer();
        sb.append(baseUrl).append("/").append(tokenId);
        if (startTimestamp != null && endTimestamp != null) {
            sb.append(historyUrl.replace("{0}", startTimestamp).replace("{1}", endTimestamp));
        }
        return sb.toString();
    }

    private String buildUriForTokenIdDiscovery(String tokenName) {
        StringBuffer sb = new StringBuffer();
        sb.append(baseUrl).append(tokenSearchUrl).append(tokenName);
        return sb.toString();
    }



}
