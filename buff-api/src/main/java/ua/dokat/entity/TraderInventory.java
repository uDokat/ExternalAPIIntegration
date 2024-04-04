package ua.dokat.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import ua.dokat.entity.custom.CustomBuffSkin;
import ua.dokat.entity.custom.CustomTraderInventory;
import ua.dokat.entity.enums.ResponseStatus;

import java.util.List;
import java.util.stream.Collectors;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
public class TraderInventory {

    private ItemData data;
    private ResponseStatus status = ResponseStatus.OK;

    public void setStatus(ResponseStatus status){
        this.status = status;
    }

    public boolean isValid(){
        return status.equals(ResponseStatus.OK);
    }

    public CustomTraderInventory toCustom(){
        List<CustomBuffSkin> skins = data.items.stream()
                .map(BuffSkin::toCustom)
                .collect(Collectors.toList());

        return CustomTraderInventory.builder()
                .skins(skins)
                .status(status)
                .build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @Getter
    public static class ItemData{

        List<BuffSkin> items;

    }
}
