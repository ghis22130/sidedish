package com.team10.banchan.repository;

import com.team10.banchan.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
