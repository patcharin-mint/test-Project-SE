package ku.cs.flowerManagement.entity;

import jakarta.persistence.*;
import ku.cs.flowerManagement.common.FlowerStatus;
import ku.cs.flowerManagement.common.OrderMethods;
import ku.cs.flowerManagement.common.OrderStatus;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Entity
public class OrderItem {

//    @Id
//    private UUID OID; //รหัส Order


//    @Enumerated(EnumType.STRING)
    private OrderStatus status; // ตั้งค่าสถานะเริ่มต้น Complete, Pending, Canceled;


//    @Enumerated(EnumType.STRING)
//    private FlowerStatus plant_status; // สถานะปลูก ไล่หาจาก FK ได้

    @Enumerated(EnumType.STRING)
    private OrderMethods order_method; // วิธีสั่งซื้อ ปลีก/ล็อต

//    @ManyToOne
//    @JoinColumn(name = "FID")
//    private Flower flower;



    //mint
    @Id
    @GeneratedValue
    private UUID id;

    @CreationTimestamp
    private LocalDateTime date;

    private double price;

    @ManyToOne
    private Flower flower; //ดอกไม้

    private int quantity; //จำนวนดอกไม้

    @OneToMany(mappedBy = "order") // JPA join ให้
    private List<Allocate> listAllocate;

    @OneToOne(mappedBy = "order")
    private PlantOrder plantOrder;
}

