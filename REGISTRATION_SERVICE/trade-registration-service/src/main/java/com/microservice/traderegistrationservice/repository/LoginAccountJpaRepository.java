package com.microservice.traderegistrationservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.traderegistrationservice.entity.AccountDetails;

public interface LoginAccountJpaRepository extends JpaRepository<AccountDetails, Integer> {

	AccountDetails findByEmailIgnoreCaseAndPasswordIgnoreCaseAndAccountId(String email,String password,Integer id);
}
