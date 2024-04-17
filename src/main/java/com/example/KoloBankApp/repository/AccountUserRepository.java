package com.example.KoloBankApp.repository;

import com.example.KoloBankApp.model.AccountUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountUserRepository extends JpaRepository<AccountUser, Integer > {
   AccountUser findByUsername(String username);
}
