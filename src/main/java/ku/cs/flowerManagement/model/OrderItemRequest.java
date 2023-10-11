package ku.cs.flowerManagement.model;

import ku.cs.flowerManagement.common.OrderMethods;
import lombok.Data;

import java.util.UUID;

@Data
public class OrderItemRequest {

//    private UUID FID;
//    private String OID;
//    private String FName;
    private double flowerPrice;
//    private int orderQuantity;
//    private OrderStatus status;
    private OrderMethods order_method;
//    private PlantStatus plant_status; //ไปไล่ดูจาก FK ได้

    //mint
    private UUID flowerID;
    private int quantity;

}
