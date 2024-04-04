package ua.dokat.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import ua.dokat.entity.custom.CustomBuffSkin;
import ua.dokat.entity.enums.SkinRarity;
import ua.dokat.entity.enums.SkinType;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
public class BuffSkin {

    private int appid;

    private AssetInfo asset_info;
    private Tags tags;

    private String assetid;
    private String classid;
    private int contextid;
    private int goods_id;
    private String instanceid;
    private String name;
    private String sell_order_id;
    private String sell_order_price;
    private boolean tradable;

    public CustomBuffSkin toCustom(){
        return CustomBuffSkin.builder()
                .appid(appid)
                .assetid(assetid)
                .classid(classid)
                .contextid(contextid)
                .goods_id(goods_id)
                .instanceid(instanceid)
                .name(name)
                .sell_order_id(sell_order_id)
                .sell_order_price(sell_order_price)
                .tradable(tradable)
                .paintwear(asset_info.paintwear)
                .inspect_url(asset_info.info.inspect_url)
                .rarity(SkinRarity.getRarityByName(tags.rarity.internal_name))
                .type(SkinType.getType(tags.type.internal_name))
                .build();
    }


    @JsonIgnoreProperties(ignoreUnknown = true)
    @Getter
    public static class AssetInfo{

        private Info info;
        private String paintwear;

        @JsonIgnoreProperties(ignoreUnknown = true)
        @Getter
        public static class Info{

            private String inspect_url;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @Getter
    public static class Tags{

        private Rarity rarity;
        private Type type;

        @JsonIgnoreProperties(ignoreUnknown = true)
        @Getter
        public static class Rarity{

            private String internal_name;

        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        @Getter
        public static class Type{

            private String internal_name;

        }

    }
}
