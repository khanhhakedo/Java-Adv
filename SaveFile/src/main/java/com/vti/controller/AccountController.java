package com.vti.controller;


import com.vti.entity.Account;
import com.vti.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/account")
public class AccountController {
	@Autowired
	private AccountService accountService;


	@GetMapping()
	public List<Account> getAllAccounts() {
		return accountService.getAll();
	}

	@GetMapping("list")
	public List<Account> getAll(@RequestParam("userName") String userName){
		List<Account> accounts= accountService.getByUserName(userName);
		return accounts;
	}

	@PostMapping()
	public void createAccount(@RequestBody Account account) {
		accountService.save(account);
	}

	@PutMapping(value = "/{id}")
	public void updateAccount(@PathVariable(name = "id") Integer id, @RequestBody Account account) {
		account.setId(id);
		accountService.update(account);
	}

	@DeleteMapping(value = "/{id}")
	public void deleteAccount(@PathVariable(name = "id") Integer id) {
		accountService.delete(id);
	}

}
