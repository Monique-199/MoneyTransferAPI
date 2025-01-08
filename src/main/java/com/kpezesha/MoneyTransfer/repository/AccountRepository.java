package com.kpezesha.MoneyTransfer.repository;

import com.kpezesha.MoneyTransfer.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
