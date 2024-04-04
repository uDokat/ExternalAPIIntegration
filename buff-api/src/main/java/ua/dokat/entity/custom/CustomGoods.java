package ua.dokat.service.entity.custom;

import lombok.Builder;
import lombok.Getter;
import ua.dokat.service.entity.enums.ResponseStatus;

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
    }
}
