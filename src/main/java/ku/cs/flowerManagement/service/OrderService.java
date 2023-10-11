package ku.cs.flowerManagement.service;

import jakarta.persistence.EntityNotFoundException;
import ku.cs.flowerManagement.common.OrderStatus;
import ku.cs.flowerManagement.entity.OrderItem;
import ku.cs.flowerManagement.model.OrderItemRequest;
import ku.cs.flowerManagement.repository.FlowerRepository;
import ku.cs.flowerManagement.repository.OrderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private FlowerRepository flowerRepository;

    @Autowired
    private ModelMapper modelMapper;

    // Get Orders น่าจะไม่ได้ใช้
//    public List<OrderItemRequest> getOrders() {
//        List<OrderItem> orders = orderRepository.findAll();
//        List<OrderItemRequest> orderFlowerRequests = new ArrayList<>();
//        for (OrderItem ord:orders) {
//            OrderItemRequest orderFlowerRequest = modelMapper.map(ord, OrderItemRequest.class);
//            orderFlowerRequest.setFName(ord.getFlower().getFName());
//            orderFlowerRequest.setFID(ord.getFlower().getFID());
//            orderFlowerRequests.add(orderFlowerRequest);
//        }
//        return orderFlowerRequests;
//    }

    public List<OrderItem> getAllOrderItem(Comparator comparator){ //เอา order ที่ต้องปลูกทั้งหมดออกมา
        List<OrderItem> orders = orderRepository.findAll();
        Collections.sort(orders, comparator );
        return orders;
    }

    public List<OrderItem> getAllOrderStatus(Comparator comparator){ //เอา order ที่ต้องปลูกทั้งหมดออกมา = pending
        List<OrderItem> orders = orderRepository.findByStatus(OrderStatus.PENDING);
        Collections.sort(orders, comparator );
        return orders;
    }

//     Get order By Id ลองปรับ
//    public OrderItemRequest getOrderById(int id) {
//        OrderItem orderFlower = orderRepository.findById(id).orElse(null);
//        if (orderFlower == null) {
//            throw new EntityNotFoundException();
//        }
//        OrderItemRequest orderFlowerRequest = modelMapper.map(orderFlower, OrderItemRequest.class);
//        orderFlowerRequest.setFName(orderFlower.getFlower().getFName());
//        orderFlowerRequest.setFID(orderFlower.getFlower().getFID());
//        return orderFlowerRequest;
//    }

        public OrderItem getOrderById(int id) {
        OrderItem orderFlower = orderRepository.findById(id).orElse(null);
        if (orderFlower == null) {
            throw new EntityNotFoundException();
        }
        return orderFlower;
    }


    // Create Order เอาไปปรับแล้ว สงสัยตรง orderFlower.setPlant_status(PlantStatus.SEEDING) คืออะไร
//    public void createOrder(OrderItemRequest orderFlowerRequest) {
//        OrderItem orderFlower = modelMapper.map(orderFlowerRequest, OrderItem.class);
//        Flower flower = flowerRepository.findById(orderFlowerRequest.getFID()).orElse(null);
//        if(flower == null) return;
//        orderFlower.setFlower(flower);
//        orderFlower.setPrice(orderFlowerRequest.getFlowerPrice()*orderFlowerRequest.getOrderQuantity());
//        orderFlower.setStatus(OrderStatus.PENDING);
//        orderFlower.setPlant_status(PlantStatus.SEEDING);
//        orderFlower.setOrder_method(orderFlowerRequest.getOrder_method());
//        orderRepository.save(orderFlower);
//    }

    public void addOrder(OrderItemRequest orderItem){ //เพิ่ม order
        OrderItem record = modelMapper.map(orderItem, OrderItem.class);
        record.setFlower(flowerRepository.findById(orderItem.getFlowerID()).get());
        record.setStatus(OrderStatus.PENDING);
        record.setOrder_method(orderItem.getOrder_method());
        orderRepository.save(record);
    }

    public OrderItem getOldestOrderStatus(Comparator comparator){
        return getAllOrderStatus(comparator).get(0);
    }

    public void setIn_ProcessOrder(Comparator comparator){ // set status ของ order เป็น in_process
        OrderItem orderItem = getOldestOrderStatus(comparator);
        orderItem.setStatus(OrderStatus.IN_PROCESS);
        orderRepository.save(orderItem);
    }

    // Complete order
    public void completeOrderById(int id) {
        OrderItem orderFlower = orderRepository.findById(id).orElse(null);
        if (orderFlower == null) {
            System.out.println("Order not found.");
            return;
        }
        orderFlower.setStatus(OrderStatus.COMPLETED);
        orderRepository.save(orderFlower);
    }

    // Cancel Order
    public void cancelOrderById(int id) {
        OrderItem orderFlower = orderRepository.findById(id).orElse(null);
        if (orderFlower == null) {
            System.out.println("Order not found.");
            return;
        }
        orderFlower.setStatus(OrderStatus.CANCELED);
        orderRepository.save(orderFlower);
    }
}
