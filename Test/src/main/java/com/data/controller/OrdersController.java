package com.data.controller;

import com.data.dto.CreateOrdersDto;
import com.data.entity.Orders;
import com.data.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("orders")
public class OrdersController {
    @Autowired
    private OrdersRepository ordersRepo;

    @GetMapping
    public ResponseEntity<?> getAllOrders() {
        List<Orders> orders = ordersRepo.findAll();

        if(orders.isEmpty()) {
            return new ResponseEntity<>("Không có bất kỳ đơn đặt nào", HttpStatus.BAD_REQUEST);
        }

        for (Orders order : orders) {
            if(order.getOrderDate() == null || order.getUpdateDate() == null) {
                return new ResponseEntity<>("Ngày đặt hàng chưa có dữ liệu", HttpStatus.BAD_REQUEST);
            }

        }

        return ResponseEntity.ok(orders);
    }


    @PostMapping
    public ResponseEntity<?> createNewOrders(@RequestBody CreateOrdersDto createOrdersDto) {
        Orders orders = new Orders();
        orders.setProductName(createOrdersDto.getProductName());
        orders.setProductPrice(createOrdersDto.getProductPrice());
        orders.setQuantity(createOrdersDto.getQuantity());
        orders.setOrderDate(createOrdersDto.getOrderDate());
        orders.setUpdateDate(createOrdersDto.getUpdateDate());

        ordersRepo.save(orders);
        return new ResponseEntity<>("Tạo đơn hàng mới thành công với ID là: " + orders.getId(), HttpStatus.OK);
    }
}
