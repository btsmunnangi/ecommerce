package com.order.order;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface OrderRepository extends MongoRepository<Order, Integer>{

}
