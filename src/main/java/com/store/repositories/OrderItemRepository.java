package com.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.entities.OrderItem;
import com.store.entities.OrderItemPk;


public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPk> {

}
