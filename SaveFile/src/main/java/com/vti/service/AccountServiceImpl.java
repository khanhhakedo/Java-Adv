package com.vti.service;

import com.vti.entity.Account;
import com.vti.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    private AccountRepository accountRepository;


    @Override
    public List<Account> getAll() {
        return accountRepository.findAll();
    }

    @Override
    public List<Account> getByUserName(String userName) {
        List<Account> accounts = accountRepository.findByUserName(userName);
        return accounts;
    }

//    @Override
//    public List<Account> getByAccountId(Integer id) {
//        List<Account> accounts = accountRepository.findByAccountId(id);
//        return accounts;
//    }

    @Override
    public void save(Account account) {
        accountRepository.save(account);
    }

    @Override
    public void update(Account account) {
        accountRepository.save(account);
    }

    @Override
    public void delete(Integer id) {
        Account account = accountRepository.findById(id).get();
        accountRepository.delete(account);
    }
}
