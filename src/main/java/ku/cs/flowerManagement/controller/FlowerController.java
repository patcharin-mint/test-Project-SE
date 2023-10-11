package ku.cs.flowerManagement.controller;

import ku.cs.flowerManagement.model.FlowerRequest;
import ku.cs.flowerManagement.service.FlowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
public class FlowerController {

    @Autowired
    private FlowerService flowerService;

//    @GetMapping("/flower") ลองปรับ
//    public String showFlowerPage(Model model) {
//        model.addAttribute("flower", new FlowerRequest());
//        model.addAttribute("flowers", flowerService.getFlowers());
//        // ใช้ FlowerService getAllFlowers
////        model.addAttribute("options", flowerService.getFlowers());
//        return "flower";
//    }

    @GetMapping("/flower")
    public String showFlowerPage(Model model) {
        model.addAttribute("flowers", flowerService.getAllFlower());
        return "flower";
    }
//
//    @GetMapping("/flower{id}") ลองปรับ
//    public String showFlowerDetailPage(Model model, @PathVariable UUID id) {
//        model.addAttribute("flower", flowerService.getFlowerById(id));
//        model.addAttribute("method", "PUT");
//        return "flower-detail";
//    }

    @GetMapping("/flower{id}")
    public String showFlowerDetailPage(Model model, @PathVariable UUID id) {
        model.addAttribute("flower", flowerService.getFlowerById(id));
        return "flower-detail";
    }


    @GetMapping("/flower/create")
    public String showFlowerDetailPageCreate(Model model) {
        model.addAttribute("flower", new FlowerRequest());
//        model.addAttribute("method", "POST");
        return "flower-detail";
    }

    @PostMapping("/flower")
    public String createFlower(@ModelAttribute FlowerRequest flower) {
        flowerService.addFlower(flower);
        return "redirect:/flower";
    }
//
//    @PutMapping("/flower/{id}")
//    public String updateFlower(@ModelAttribute FlowerRequest flower, @PathVariable UUID id) {
//        flower.setFID(id);
//        flowerService.updateFlower(flower);
//        return "redirect:/flower";
//    }


    //mint
//    @GetMapping
//    public String getAllFlower(Model model){
//        model.addAttribute("flowers",flowerService.getAllFlower());
//        return "flower-all";
//    }

//    @GetMapping("/add")
//    public String getFlowerForm(){ //เหมือนดอกไม้แต่ละชนิดมันมีข้อมูลไม่เหมือนกันก็เลยไม่ได้เอาข้อมูลที่มีอยู่ส่งไปให้ = user ต้องกรอกเองทั้งหมด
//        return "flower-add";
//    }
//
//    @PostMapping("/add")
//    public String addFlower(@ModelAttribute FlowerRequest flower, Model model){ //error ที่เกิดขึ้นได้ คือ ค่าที่ใส่ไม่ตรงกับใน class ซึ่งอาจเกิดจากการกด enter 2 รอบโดยไม่ตั้งใจ
//        flowerService.addFlower(flower);
//        return "redirect:/flowers";
//    }


}
