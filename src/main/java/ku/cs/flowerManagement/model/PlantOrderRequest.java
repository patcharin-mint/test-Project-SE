package ku.cs.flowerManagement.model;


import lombok.Data;

import java.util.UUID;

@Data
public class PlantOrderRequest { //จะปลูกดอกนี้นะ
    // กดเลือก id ดอกไม้
    private UUID flowerID;
}
