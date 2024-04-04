package ua.dokat.entity.custom;

import lombok.Builder;
import lombok.Getter;
import ua.dokat.entity.enums.ResponseStatus;

@Builder
@Getter
public class CustomGoods {

    private CustomGoodsData data;
    private ResponseStatus status;

    @Builder
    @Getter
    public static class CustomGoodsData{

        private int id;
        private int appid;
        private String name;
        private String internal_name;
        private final String url;
    }
}
