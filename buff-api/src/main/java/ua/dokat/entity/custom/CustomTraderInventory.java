package ua.dokat.entity.custom;

import lombok.Builder;
import lombok.Getter;
import ua.dokat.entity.enums.ResponseStatus;

import java.util.List;

@Builder
@Getter
public class CustomTraderInventory {

    private List<CustomBuffSkin> skins;
    private ResponseStatus status;
}
