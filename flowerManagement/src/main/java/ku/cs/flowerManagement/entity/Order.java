package ku.cs.flowerManagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int OID; //รหัส Order
    private int FID; //รหัสดอกไม้
    private int quantity; //จำนวนดอกไม้
    private String status = "สั่งสำเร็จ"; // ตั้งค่าสถานะเริ่มต้น

    // Constructors, getters, and setters
}

