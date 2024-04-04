package ua.dokat.entity.custom;

import lombok.Builder;
import lombok.Getter;
import ua.dokat.entity.enums.ResponseStatus;
import ua.dokat.entity.enums.SkinRarity;
import ua.dokat.entity.enums.SkinType;

@Builder
@Getter
public class CustomBuffOrder {

    private int appid;
    private int created_at;
    private String id;
    private String price;
    private int updated_at;
    private String user_id;
    private String asset_id;
    private String class_id;
    private int context_id;
    private int goods_id;
    private String instance_id;
    private String inspect_url;
    private String icon_url;
    private int paintindex;
    private int paintseed;

    private SkinType type;
    private SkinRarity rarity;

}
