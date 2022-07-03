package com.vti.service;


import com.vti.entity.Account;

import java.util.List;

public interface AccountService   {
    public List<Account> getAll();
    public List<Account> getByUserName(String userName);
//    List<Account> getByAccountId(Integer id);
    public void save(Account account);

    public void update(Account account);

    public void delete(Integer id);




//    public boolean isAccountExistsByEmail(String Email);
//
//    public boolean isAccountExistsByUserName(String username);
}
