package ku.cs.flowerManagement.entity;

import jakarta.persistence.*;
import lombok.Data;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity
public class Flower {

//    private UUID id;
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private UUID FID; //รหัสของดอกไม้
//
//    private String FName; //ชื่อดอกไม้
//    private String how_to_plant; //วิธีการปลูก
//    private String how_to_take_care; //วิธีการดูแล
//
//    private int how_to_harvest; //รูปแบบการเก็บดอกไม้ (เก็บครั้งเดียว=1, เก็บหลายครั้ง=ใส่จำนวนที่สามารถเก็บเกี่ยวได้)
//    private double price; //ราคาของดอกไม้
//    private String pic; //รูปภาพของดอกไม้
//    private int quantity; //จำนวนดอกไม้
//
//    private int seedPeriod;
//    private int sproutPeriod;
//    private int growingPeriod;
//    private int fullyGrownPeriod;
//    private int harvestPeriod;
//
//    @OneToMany(mappedBy = "flower")
//    private List<OrderItem> orders = new ArrayList<>();


    @Id
    @GeneratedValue
    private UUID id;

    private String FName; //ชื่อดอกไม้
    private String how_to_plant; //วิธีการปลูก
    private String how_to_take_care; //วิธีการดูแล

    private int seedPeriod;
    private int sproutPeriod;
    private int growingPeriod;
    private int fullyGrownPeriod;
    private int harvestPeriod;

    private int how_to_harvest; //รูปแบบการเก็บดอกไม้ (เก็บครั้งเดียว=1, เก็บหลายครั้ง=ใส่จำนวนที่สามารถเก็บเกี่ยวได้)
    private double price; //ราคาของดอกไม้

//    private String pic; //รูปภาพของดอกไม้ //ต้องมีด้วยรึ ไว้ก่อน

    private int quantity; //จำนวนดอกไม้
}
