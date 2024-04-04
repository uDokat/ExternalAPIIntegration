package ua.dokat.entity.custom;

import lombok.Builder;
import lombok.Getter;
import ua.dokat.entity.enums.ResponseStatus;

import java.util.List;

@Getter
@Builder
public class CustomBuffOrderList {

    private List<CustomBuffOrder> orders;
    private ResponseStatus status = ResponseStatus.OK;

    //todo: этот метод должен быть либо в родительском классе JsonEntity, либо в Entity<T>.
    public static CustomBuffOrderList buildErrorResponse(){
        return CustomBuffOrderList.builder().orders(List.of()).status(ResponseStatus.ERROR).build();
    }

}
