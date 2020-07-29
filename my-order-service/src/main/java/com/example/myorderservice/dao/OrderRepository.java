package com.example.myorderservice.dao;
import com.example.myorderservice.dao.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {

}
