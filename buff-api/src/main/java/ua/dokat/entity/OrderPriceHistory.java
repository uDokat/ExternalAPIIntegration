package ua.dokat.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import ua.dokat.entity.enums.ResponseStatus;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
public class OrderPriceHistory {

    private Data data;
    private ResponseStatus status = ResponseStatus.OK;

    @JsonIgnoreProperties(ignoreUnknown = true)
    @Getter
    public static class Data{

        private final List<Double> price_history;

        public Data(@JsonProperty("price_history") List<List<Double>> priceHistory){
            this.price_history = priceHistory.stream()
                    .map(map -> map.get(1))
                    .collect(Collectors.toList());
        }
    }

    public boolean isValid(){
        return status == ResponseStatus.OK;
    }
}
