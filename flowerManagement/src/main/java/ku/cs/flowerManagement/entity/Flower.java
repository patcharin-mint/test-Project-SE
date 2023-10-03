package ku.cs.flowerManagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;


import java.util.Date;
import java.util.UUID;


@Data
@Entity
public class Flower {


    @Id
    @GeneratedValue
    private UUID id;

    private int FID; //รหัสของดอกไม้
    private String FName; //ชื่อดอกไม้
    private String how_to_plant; //วิธีการปลูก
    private String how_to_take_care; //วิธีการดูแล
    private Date time; //ระยะเวลาในการเติบโต (วัน)
    private int how_to_harvest; //รูปแบบการเก็บดอกไม้ (เก็บครั้งเดียว=1, เก็บหลายครั้ง=ใส่จำนวนที่สามารถเก็บเกี่ยวได้)
    private String price; //ราคาของดอกไม้
    private String pic; //รูปภาพของดอกไม้
    private String quantity; //จำนวนดอกไม้
}
