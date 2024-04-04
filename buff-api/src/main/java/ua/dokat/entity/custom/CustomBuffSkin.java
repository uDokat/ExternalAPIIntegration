package ua.dokat.entity.custom;

import lombok.Builder;
import lombok.Getter;
import ua.dokat.entity.enums.SkinRarity;
import ua.dokat.entity.enums.SkinType;

@Builder
@Getter
public class CustomBuffSkin {

    private int appid;
    private String assetid;
    private String classid;
    private int contextid;
    private int goods_id;
    private String instanceid;
    private String name;
    private String sell_order_id;
    private String sell_order_price;
    private boolean tradable;
    private String paintwear;
    private String inspect_url;

    private SkinType type;
    private SkinRarity rarity;
}
