package service;

import pojo.Customers;

public interface AccountService {
	public boolean login(String id, String pw);
	public boolean checkId(String id);
	public boolean register(String id, String pw, Customers customers);
}
