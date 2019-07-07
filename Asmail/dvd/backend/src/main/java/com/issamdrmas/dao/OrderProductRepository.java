package com.issamdrmas.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.issamdrmas.model.OrderProduct;
import com.issamdrmas.model.OrderProductPK;

public interface OrderProductRepository extends JpaRepository<OrderProduct, OrderProductPK> {

}
