package com.vti.repository;

import com.vti.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

  List<Account> findByUserName (String userName);

  List<Account> getAccountById(Integer id);

//  List<Account> findByAccountId (Integer id);


//    public boolean isAccountExistsByEmail(String Email);
//
//    public boolean isAccountExistsByUserName(String username);
}
