package ua.dokat.service.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
public class TraderInventory {

    private ItemData data;

    @JsonIgnoreProperties(ignoreUnknown = true)
    @Getter
    public static class ItemData{

        List<InventoryItem> items;

    }
}
