package ku.cs.flowerManagement.entity;

import jakarta.persistence.*;
import ku.cs.flowerManagement.common.FlowerStatus;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
public class PlantOrder { //คำสั่งปลูก == แปลงที่ปลูกแล้ว

    @Id
    @GeneratedValue
    private UUID id;

    private int PID; //รหัสของแปลงปลูก

    @ManyToOne
    private Flower flower; //จากคำสั่งปลูกอันนี้ เราจะหาได้ว่ามันปลูกอะไร


    private int quantity; //จำนวนที่ปลูก
    private int total; //จำนวนปัจจุบัน = จำนวนดอกไม้ที่คงเหลืออยู่

    private LocalDateTime timePlant; //วันที่ปลูก

    @OneToOne
    private OrderItem order;

    private FlowerStatus flowerStatus; //ปลูกไปได้ระยะไหนแล้ว

}
