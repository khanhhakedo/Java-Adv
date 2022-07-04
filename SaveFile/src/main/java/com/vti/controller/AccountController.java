package com.vti.controller;


import com.vti.Dto.AccountDto;
import com.vti.entity.Account;
import com.vti.form.AccountFormForCreating;
import com.vti.form.AccountFormForUpdating;
import com.vti.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/v1/account")
public class AccountController {
	@Autowired
	private AccountService accountService;


//	@GetMapping()
//	public List<Account> getAllAccounts() {
//		List<Account> accounts = accountService.getAll();
//		return accounts;
//	}

	//Chuyển đổi DTO
	@GetMapping()
	public ResponseEntity<?> getAllAccounts() {
		List<Account> accounts = accountService.getAll();
		List<AccountDto> accountDtos = new ArrayList<>();
		for (Account account : accounts){
			AccountDto accountDto = new AccountDto();
			accountDto.setId(account.getId());
			accountDto.setFullname(account.getFullname());
			accountDto.setAddress(account.getAddress());
			accountDto.setUsername(account.getUserName());
			accountDto.setEmail(account.getEmail());
			accountDto.setPassword(account.getPassword());
			accountDto.setProduct(account.getProducts().toString());

			accountDtos.add(accountDto);

		}
		return new ResponseEntity<>(accountDtos, HttpStatus.OK);
	}

	@GetMapping( "listid")
	public List<Account> getAll(@RequestParam("id")Integer id){
		List<Account> accounts = accountService.getAccountById(id);
		return accounts;
	}


	@GetMapping("listuserName")
	public List<Account> getAll(@RequestParam("userName") String userName){
		List<Account> accounts= accountService.getByUserName(userName);
		return accounts;
	}

	@PostMapping()
	public ResponseEntity<?> createAccount(@RequestBody AccountFormForCreating accountFormForCreating) {
		accountService.save(accountFormForCreating);
		return new ResponseEntity<String>("Create successfully!", HttpStatus.CREATED);
	}

//	@PutMapping(value = "/{id}")
//	public void updateAccount(@PathVariable(name = "id") Integer id, @RequestBody Account account) {
//		account.setId(id);
//		accountService.update(account);
//	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updateProduct(@PathVariable(name = "id") Integer id, @RequestBody AccountFormForUpdating form) {
		accountService.update(id, form);
		return new ResponseEntity<String>("Update successfully!", HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public void deleteAccount(@PathVariable(name = "id") Integer id) {
		accountService.delete(id);
	}

}
