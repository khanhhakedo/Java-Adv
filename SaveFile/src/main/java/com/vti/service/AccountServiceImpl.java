package com.vti.service;

import com.vti.entity.Account;
import com.vti.entity.Product;
import com.vti.form.AccountFormForCreating;
import com.vti.form.AccountFormForCreatingRegister;
import com.vti.form.AccountFormForUpdating;
import com.vti.repository.AccountRepository;
import com.vti.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ProductRepository productRepository;

//    @Autowired
//    private IRegistrationUserTokenRepository registrationUserTokenRepository;

//    @Autowired
//    private PasswordEncoder passwordEncoder;


    @Override
    public List<Account> getAll() {
        return accountRepository.findAll();
    }

    @Override
    public List<Account> getByUserName(String userName) {
        List<Account> accounts = accountRepository.findByUserName(userName);
        return accounts;
    }

    @Override
    public List<Account> getAccountById(Integer id) {
        List<Account> accounts =accountRepository.getAccountById(id);
        return accounts;
    }

    @Override
    public void save(AccountFormForCreating accountFormForCreating) {
     String newEmail = accountFormForCreating.getEmail();
     String newUserName = accountFormForCreating.getUsername();
     String newFullName = accountFormForCreating.getFullname();
     String newPassword = accountFormForCreating.getPassword();
     String newAddress = accountFormForCreating.getAddress();
     Integer newProductId = accountFormForCreating.getProductId();

     Account accountNew = new Account();
     accountNew.setEmail(newEmail);
     accountNew.setFullname(newFullName);
     accountNew.setUserName(newUserName);
     accountNew.setPassword(newPassword);
     accountNew.setAddress(newAddress);

     List<Product> product = productRepository.getProductById(newProductId);
     accountNew.setProducts(product);
     accountRepository.save(accountNew);
    }

    @Override
    public void update(Integer id, AccountFormForUpdating form) {
        Account account = accountRepository.getById(id);

        List<Product> product = productRepository.getProductById(form.getProductId());

        account.setEmail(form.getEmail());
        account.setFullname(form.getFullname());
        account.setProducts(product);

        accountRepository.save(account);
    }


//    @Override
//    public void save(Account account) {
//        accountRepository.save(account);
//    }

//    @Override
//    public void update(Account account) {
//        accountRepository.save(account);
//    }

    @Override
    public void delete(Integer id) {
        Account account = accountRepository.findById(id).get();
        accountRepository.delete(account);
    }
//
//    @Override
//    public void createAccountRegister(AccountFormForCreatingRegister accountCreateRegisterFormInput) {
//        //			T???o m???i Accont
//        Account account = new Account();
//        account.setEmail(accountCreateRegisterFormInput.getEmail());
//        account.setFullname(accountCreateRegisterFormInput.getFullname());
//        account.setUserName(accountCreateRegisterFormInput.getUsername());
//
//        Integer productId = accountCreateRegisterFormInput.getProductId();
//
//        List<Product> product = productRepository.getProductById(productId);
//
//        account.setProducts(product);
//
//        account.setPassword(passwordEncoder.encode(accountCreateRegisterFormInput.getPassword()));
//
////		L??u Account v???a t???o xu???ng DB
//        accountRepository.save(account);
//
////		T???o ra 1 ??o???n m?? ng???u nhi??n, token l??u th??ng tin token t????ng ???ng v???i Account xu???ng DB
//        String token = UUID.randomUUID().toString();
//
//        RegistrationUserToken registrationUserToken = new RegistrationUserToken();
//        registrationUserToken.setAccount(account);
//        registrationUserToken.setToken(token);
//
//        registrationUserTokenRepository.save(registrationUserToken);
//
////		G???i token v??? Email ng?????i d??ng ????ng k??
////		B???n ra event
//        applicationEventPublisher.publishEvent(new onConfirmRegistrationViaEmailEvent(account.getEmail()));
////
//    }
}
