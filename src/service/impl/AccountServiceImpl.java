package service.impl;

import pojo.Account;
import pojo.Customers;
import dao.AccountDAO;
import dao.CustomersDAO;
import service.AccountService;

public class AccountServiceImpl implements AccountService {

	private AccountDAO accountDAO;
	private CustomersDAO customersDAO;
	
	public AccountServiceImpl(AccountDAO accountDAO, CustomersDAO customersDAO) {
		this.accountDAO = accountDAO;
		this.customersDAO = customersDAO;
	}
	
	@Override
	public boolean login(String id, String pw) {
		int num = accountDAO.findByParam(
				"from Account where userId=:userId and password=:password",
				new String[]{"userId", "password"},
				new Object[]{id, pw});
		if (num == 1)
			return true;
		return false;
	}

	@Override
	public boolean checkId(String id) {
		int num = accountDAO.findByParam(
				"from Account where userId=:userId",
				new String[]{"userId"},
				new Object[]{id});
		if (num > 0)
			return true;
		return false;
	}

	@Override
	public boolean register(String id, String pw, Customers customers) {
		customers.setCustomerId(id);
		customersDAO.add(customers);
		accountDAO.add(new Account(id, pw, id));
		return true;
	}

}
