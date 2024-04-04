package ua.dokat.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import ua.dokat.entity.custom.CustomGoods;
import ua.dokat.entity.enums.ResponseStatus;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
public class Goods {

    private GoodsData data;
    private String extra = "OK";
    private String error = null;
    private ResponseStatus status = ResponseStatus.OK;

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

    /**
     * Returns true if the object is not valid
     * Returns false if there is nothing wrong with the object and there was no error when making the request.
     */
    public boolean isValid(){
        return error == null || status.equals(ResponseStatus.OK);
    }

    public CustomGoods toCustom(){
        return CustomGoods.builder()
                .data(CustomGoods.CustomGoodsData.builder()
                        .id(data.id)
                        .appid(data.appid)
                        .name(data.name)
                        .internal_name(data.goods_info.info.tags.type.internal_name)
                        .url("https://buff.market/market/goods/" + data.id +"?game=csgo")
                        .build())
                .status(status)
                .build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @Getter
    public static class GoodsData {

        private int appid;
        private String name;
        private GoodsInfo goods_info;
        private int id;

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
}
