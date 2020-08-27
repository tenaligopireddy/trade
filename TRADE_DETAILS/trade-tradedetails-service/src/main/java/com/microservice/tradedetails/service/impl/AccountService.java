package com.microservice.tradedetails.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.microservice.tradedetails.dto.ServiceResponse;
import com.microservice.tradedetails.entity.TradeDetails;
import com.microservice.tradedetails.repository.TradeDetailsJpaRepository;
import com.microservice.tradedetails.repository.UpdateTradeDetailsJpaRepository;


@Component
public class AccountService {

	@Autowired
	private TradeDetailsJpaRepository tradeDetailsJpaRepository;
	
	@Autowired
	private UpdateTradeDetailsJpaRepository updateJpaRepository;
	
	@Autowired
	private ServiceResponse serviceResponse;
	
	@Autowired
	private TradeDetails tradeDetails;
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	
	public String saveUserDetails(TradeDetails tradingDetails) throws Exception {

		
		try {
				TradeDetails savedEntity = tradeDetailsJpaRepository.save(tradingDetails);
				if(savedEntity!=null) {
					return "Trade details Created Successfully";
				}
		}
		catch (Exception e) {
			new RuntimeException(e.getLocalizedMessage(), e.getCause());
		}
		return null;		
	}
	
	public Object updateTradeDetails(int id,TradeDetails detailsUpdate) {
		
		Optional<TradeDetails> idExists= tradeDetailsJpaRepository.findById(id);
		if(idExists.isPresent()) {
			detailsUpdate.setTradeId(id);
			tradeDetails = tradeDetailsJpaRepository.save(detailsUpdate);
			if(tradeDetails!=null) {
				return "Updated succesfully";
			}
		}
		return null;
		
	}
	
	public List<TradeDetails> getDetails(Integer id){
		
	List<TradeDetails> details=	tradeDetailsJpaRepository.findByAccountId(id);
		return details;
	}
	
}
