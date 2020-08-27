package com.microservice.traderegistrationservice.repository;


import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.microservice.traderegistrationservice.entity.AccountDetails;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TestCreateAccountRepository {

	
	@Autowired
    private CreateAccountJpaRepository createAccountJpaRepository;
	private AccountDetails accountDetails;

    @Test
    public void createAccountDetailsTest() {

    	accountDetails = new AccountDetails();
    	accountDetails.setAccountId(1);
    	accountDetails.setUserName("Gopi");
        accountDetails.setPassword("Gopireddy");
        accountDetails.setEmail("tenaligopireddy@gmail.com");
        accountDetails.setAccountType("seller"); 
        accountDetails.setState("tamilnadu");
        accountDetails.setCountry("India");
        accountDetails.setAddress("chennai");
        accountDetails.setPhoneNumber(8333882829L);
        
    	 createAccountJpaRepository.save(accountDetails);
    	AccountDetails fetchedDetails = createAccountJpaRepository.findById(1).get();
        Assert.assertEquals("1", fetchedDetails.getAccountId().toString());

    }
}
