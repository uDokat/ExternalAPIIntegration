package ua.dokat.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
public class BuffOrderList {

    private Data data;

    @JsonIgnoreProperties(ignoreUnknown = true)
    @Getter
    public static class Data{

        private List<BuffOrder> items;

    }
}
