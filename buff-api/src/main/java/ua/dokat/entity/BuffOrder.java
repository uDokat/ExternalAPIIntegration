package ua.dokat.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import ua.dokat.entity.custom.CustomBuffOrder;
import ua.dokat.entity.enums.ResponseStatus;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
public class BuffOrder {

    private int appid;

    private AssetInfo asset_info;

    private int created_at;
    private String id;
    private String price;
    private int updated_at;
    private String user_id;

    @Setter
    private ResponseStatus status = ResponseStatus.OK;


    @JsonIgnoreProperties(ignoreUnknown = true)
    @Getter
    public static class AssetInfo{

        private String assetid;
        private String classid;
        private int contextid;
        private int goods_id;

        private Info info;

        private String instanceid;

        @JsonIgnoreProperties(ignoreUnknown = true)
        @Getter
        public static class Info{

            private int paintindex;
            private int paintseed;
            private String icon_url;
            private String inspect_url;

        }
    }

    public CustomBuffOrder toCustom(){
        return CustomBuffOrder.builder()
                .appid(appid)
                .created_at(created_at)
                .id(id)
                .price(price)
                .updated_at(updated_at)
                .user_id(user_id)
                .asset_id(asset_info.assetid)
                .class_id(asset_info.classid)
                .context_id(asset_info.contextid)
                .goods_id(asset_info.goods_id)
                .instance_id(asset_info.instanceid)
                .inspect_url(asset_info.info.inspect_url)
                .icon_url(asset_info.info.icon_url)
                .paintindex(asset_info.info.paintindex)
                .paintseed(asset_info.info.paintseed)
                .build();
    }

    public boolean isValid(){
        return status.equals(ResponseStatus.OK);
    }
}
