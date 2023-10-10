package ku.cs.flowerManagement.service;

import jakarta.persistence.EntityNotFoundException;
import ku.cs.flowerManagement.common.PlantStatus;
import ku.cs.flowerManagement.common.Status;
import ku.cs.flowerManagement.entity.Flower;
import ku.cs.flowerManagement.entity.OrderFlower;
import ku.cs.flowerManagement.model.OrderFlowerRequest;
import ku.cs.flowerManagement.repository.FlowerRepository;
import ku.cs.flowerManagement.repository.OrderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private FlowerRepository flowerRepository;

    @Autowired
    private ModelMapper modelMapper;

    // Get Orders
    public List<OrderFlowerRequest> getOrders() {
        List<OrderFlower> orders = orderRepository.findAll();
        List<OrderFlowerRequest> orderFlowerRequests = new ArrayList<>();
        for (OrderFlower ord:orders) {
            OrderFlowerRequest orderFlowerRequest = modelMapper.map(ord, OrderFlowerRequest.class);
            orderFlowerRequest.setFName(ord.getFlower().getFName());
            orderFlowerRequest.setFID(ord.getFlower().getFID());
            orderFlowerRequests.add(orderFlowerRequest);
        }
        return orderFlowerRequests;
    }

    // Get order By Id
    public OrderFlowerRequest getOrderById(int id) {
        OrderFlower orderFlower = orderRepository.findById(id).orElse(null);
        if (orderFlower == null) {
            throw new EntityNotFoundException();
        }
        OrderFlowerRequest orderFlowerRequest = modelMapper.map(orderFlower, OrderFlowerRequest.class);
        orderFlowerRequest.setFName(orderFlower.getFlower().getFName());
        orderFlowerRequest.setFID(orderFlower.getFlower().getFID());
        return orderFlowerRequest;
    }

    // Create Order
    public void createOrder(OrderFlowerRequest orderFlowerRequest) {
        OrderFlower orderFlower = modelMapper.map(orderFlowerRequest, OrderFlower.class);
        Flower flower = flowerRepository.findById(orderFlowerRequest.getFID()).orElse(null);
        if(flower == null) return;
        orderFlower.setFlower(flower);
        orderFlower.setPrice(orderFlowerRequest.getFlowerPrice()*orderFlowerRequest.getOrderQuantity());
        orderFlower.setStatus(Status.PENDING);
        orderFlower.setPlant_status(PlantStatus.SEEDING);
        orderFlower.setOrder_method(orderFlowerRequest.getOrder_method());
        orderRepository.save(orderFlower);
    }

    // Complete order
    public void completeOrderById(int id) {
        OrderFlower orderFlower = orderRepository.findById(id).orElse(null);
        if (orderFlower == null) {
            System.out.println("Order not found.");
            return;
        }
        orderFlower.setStatus(Status.COMPLETED);
        orderRepository.save(orderFlower);
    }

    // Cancel Order
    public void cancelOrderById(int id) {
        OrderFlower orderFlower = orderRepository.findById(id).orElse(null);
        if (orderFlower == null) {
            System.out.println("Order not found.");
            return;
        }
        orderFlower.setStatus(Status.CANCELED);
        orderRepository.save(orderFlower);
    }
}
