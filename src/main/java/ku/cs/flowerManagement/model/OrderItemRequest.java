package ku.cs.flowerManagement.model;

import ku.cs.flowerManagement.common.OrderMethods;
import ku.cs.flowerManagement.common.PlantStatus;
import ku.cs.flowerManagement.common.OrderStatus;
import lombok.Data;

import java.util.UUID;

@Data
public class OrderFlowerRequest {

    private UUID FID;
    private String OID;
    private String FName;
    private double flowerPrice;
    private int orderQuantity;
    private OrderStatus status;
    private OrderMethods order_method;
    private PlantStatus plant_status;

}
