package com.microservice.traderegistrationservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.microservice.traderegistrationservice.entity.AccountDetails;

@Repository
public interface CreateAccountJpaRepository extends JpaRepository<AccountDetails, Integer> {

	Optional<AccountDetails> findByEmailIgnoreCase(String email);
}
