package com.vti.service;


import com.vti.entity.Account;
import com.vti.form.AccountFormForCreating;
import com.vti.form.AccountFormForCreatingRegister;
import com.vti.form.AccountFormForUpdating;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AccountService   {
//    public Page<Account> getListAccount(Pageable pageable, String search);

    public List<Account> getAll();
    public List<Account> getByUserName(String userName);

    public List<Account> getAccountById(Integer id);

    public void save(AccountFormForCreating accountFormForCreating);
    public void update(Integer id, AccountFormForUpdating form);

//    public void save(Account account);
//    public void update(Account account);

    public void delete(Integer id);
//    public void createAccountRegister(AccountFormForCreatingRegister accountCreateRegisterFormInput);



//    public boolean isAccountExistsByEmail(String Email);
//
//    public boolean isAccountExistsByUserName(String username);
}
