package com.microservice.tradedetails.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.microservice.tradedetails.entity.TradeDetails;

@Repository
public interface TradeDetailsJpaRepository extends JpaRepository<TradeDetails, Integer> {

	List<TradeDetails> findByAccountId(Integer id);
}
