package ku.cs.flowerManagement.service;

import ku.cs.flowerManagement.entity.Flower;
import ku.cs.flowerManagement.model.FlowerRequest;
import ku.cs.flowerManagement.repository.FlowerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class FlowerService {

    @Autowired
    private FlowerRepository flowerRepository;

    @Autowired
    private ModelMapper modelMapper;

    // Get Flower ดูไม่ต่างกัน
//    public List<FlowerRequest> getFlowers() {
//        return flowerRepository.findAll().stream().map(flower -> modelMapper.map(flower, FlowerRequest.class)).collect(Collectors.toList());
//    }

    public List<Flower> getAllFlower(){ //แสดง flower ทั้งหมด
        return flowerRepository.findAll();
    }

    // Get Flower By ID  แปลกๆ ทำไมอยากได้ FlowerRequest >>> ลองปรับแล้ว
//    public FlowerRequest getFlowerById(UUID id) {
//        return  modelMapper.map(flowerRepository.findById(id).orElse(null), FlowerRequest.class);
//    }


//     Get Flower By ID
    public Flower getFlowerById(UUID id) {
        return flowerRepository.findById(id).get();
    }

    // Create Flower แปลกๆ ทำไมอยากได้ FlowerRequest
//    public FlowerRequest addFlower(FlowerRequest flowerRequest) {
//        Flower flower = modelMapper.map(flowerRequest, Flower.class);
//        return modelMapper.map(flowerRepository.save(flower), FlowerRequest.class);
//    }

    public void addFlower(FlowerRequest flower){
        Flower record = modelMapper.map(flower,Flower.class);
        flowerRepository.save(record);
    }

    // Update Flower
//    public FlowerRequest updateFlower(FlowerRequest flowerRequest) {
////        System.out.println(flowerRequest.getFID());
//        Flower flower1 =flowerRepository.findById(flowerRequest.getFID()).orElse(null);
//        if (flower1 == null) return null;
//        flower1.setFName(flowerRequest.getFName());
//        flower1.setPrice(flowerRequest.getPrice());
////        flower1.setTime(flowerRequest.getTime()); //แก้เป็นระยะ
//        flower1.setHow_to_plant(flowerRequest.getHow_to_plant());
//        flower1.setHow_to_harvest(flowerRequest.getHow_to_harvest());
//        flower1.setHow_to_take_care(flowerRequest.getHow_to_take_care());
//        flowerRepository.save(flower1);
////        System.out.println("Flower1");
////        System.out.println(flower1.getFID());
//        return modelMapper.map(flower1, FlowerRequest.class);
//    }
}
