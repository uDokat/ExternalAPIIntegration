package ua.dokat.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import ua.dokat.entity.custom.CustomInventoryItem;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
public class InventoryItem {

    private int appid;
    private String assetid;
    private String classid;
    private int contextid;
    private int goods_id;
    private String instanceid;
    private boolean tradable;

    public CustomInventoryItem toCustom(){
        return CustomInventoryItem.builder()
                .appid(appid)
                .assetid(assetid)
                .classid(classid)
                .contextid(contextid)
                .goods_id(goods_id)
                .instanceid(instanceid)
                .tradable(tradable)
                .build();
    }
}
