package ku.cs.flowerManagement.controller;

import ku.cs.flowerManagement.adapter.DateTimeComparator;
import ku.cs.flowerManagement.model.OrderItemRequest;
import ku.cs.flowerManagement.service.FlowerService;
import ku.cs.flowerManagement.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private FlowerService flowerService;

    @Autowired
    private DateTimeComparator dateTimeComparator;

    @GetMapping("/order")
    private String showOrderPage(Model model, @RequestParam(name = "id", defaultValue = "0" ) int id) {
        model.addAttribute("order", new OrderItemRequest());
        model.addAttribute("orders" , orderService.getAllOrderItem(dateTimeComparator));
        model.addAttribute("options", flowerService.getAllFlower());
        if (id != 0) {
            model.addAttribute("canceledOrder",orderService.getOrderById(id));
        }
        else {
            model.addAttribute("canceledOrder", new OrderItemRequest());
        }
        return "order";
    }

    @PostMapping("/order")
    public String createOrder(@ModelAttribute OrderItemRequest orderFlower, Model model) {
        System.out.println(orderFlower);
        orderFlower.setFlowerPrice(orderFlower.getFlowerPrice() * orderFlower.getQuantity());
        orderService.addOrder(orderFlower);
        return "redirect:/order";
    }

    @PutMapping("/order/{id}")
    public String cancelOrder(@PathVariable int id, Model model){
        orderService.cancelOrderById(id);
        model.addAttribute("order", new OrderItemRequest());
        model.addAttribute("orders", orderService.getAllOrderItem(dateTimeComparator));
        model.addAttribute("options", flowerService.getAllFlower());
        model.addAttribute("canceledOrder",orderService.getOrderById(id));
        return "order";
    }


    //mint
//    @PostMapping("/add")
//    public String addOrder(@ModelAttribute OrderItemRequest orderItem, Model model){
//        orderService.addOrder(orderItem);
//        model.addAttribute("orderItems", orderService.getAllOrderItem(dateTimeComparator));
//        return "redirect:/orders";
//    }
//
//    @GetMapping
//    public String getAllOrder(Model model){
//        model.addAttribute("orderItems", orderService.getAllOrderItem(dateTimeComparator));
//        return "order-all";
//    }
//
//    @GetMapping("/form")
//    public String getOrderForm(Model model){
//        model.addAttribute("flowers", flowerService.getAllFlower());
//        return "order-form";
//    }


}
