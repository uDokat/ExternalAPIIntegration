package ua.dokat.service.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import ua.dokat.service.entity.custom.CustomGoods;
import ua.dokat.service.entity.enums.ResponseStatus;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
public class Goods {

    @JsonIgnoreProperties(ignoreUnknown = true)
    @Getter
    public static class GoodsData {

        private int appid;
        private String name;
        private GoodsInfo goods_info;

        @JsonIgnoreProperties(ignoreUnknown = true)
        @Getter
        public static class GoodsInfo {

            private Info info;

            @JsonIgnoreProperties(ignoreUnknown = true)
            @Getter
            public static class Info {

                private Tags tags;

                @JsonIgnoreProperties(ignoreUnknown = true)
                @Getter
                public static class Tags {

                    private Type type;

                    @JsonIgnoreProperties(ignoreUnknown = true)
                    @Getter
                    public static class Type {

                        private String internal_name;
                    }
                }
            }
        }
    }

    private GoodsData data;
    private String extra = "OK";
    private String error = null;
    private ResponseStatus status = ResponseStatus.OK;

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

    public boolean isValid(){
        return status.equals(ResponseStatus.OK) || error == null;
    }

    public CustomGoods toCustom(){
        return CustomGoods.builder()
                .data(CustomGoods.CustomGoodsData.builder()
                        .appid(data.appid)
                        .name(data.name)
                        .internal_name(data.goods_info.info.tags.type.internal_name)
                        .build())
                .status(status)
                .build();
    }
}
