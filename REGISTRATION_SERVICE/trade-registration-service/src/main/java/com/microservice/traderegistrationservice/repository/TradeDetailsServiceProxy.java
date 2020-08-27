package com.microservice.traderegistrationservice.repository;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@FeignClient(name="trade-tradedetails-service",url = "localhost:8100")
@RibbonClient(name="trade-tradedetails-service")
public interface TradeDetailsServiceProxy {
	
	@PostMapping("/trade/display-tradedetails/{accountId}")
	public Object getTradeDetails(@PathVariable("accountId") Integer accountId);

}
