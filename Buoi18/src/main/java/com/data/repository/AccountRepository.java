package com.data.repository;

import com.data.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    List<Account> findByUsername(String username);

    List<Account> findByPassword(String password);

    List<Account> findByFullName(String fullName);

    List<Account> findByUsernameAndPassword(String username, String password);

    List<Account> findByUsernameOrPassword(String username, String password);

    @Query(value = "FROM Account  WHERE username = :username OR fullName = :fullName")
    List<Account> getData2(String username, String fullName);
}
