package com.microservice.tradedetails.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.tradedetails.dto.UpdateDetails;
import com.microservice.tradedetails.entity.TradeDetails;

public interface UpdateTradeDetailsJpaRepository extends JpaRepository<TradeDetails, Integer> {

}
