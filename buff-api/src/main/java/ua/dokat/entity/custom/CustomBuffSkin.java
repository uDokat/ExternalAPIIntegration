package ua.dokat.entity.custom;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CustomInventoryItem {

    private int appid;
    private String assetid;
    private String classid;
    private int contextid;
    private int goods_id;
    private String instanceid;
    private boolean tradable;
}
