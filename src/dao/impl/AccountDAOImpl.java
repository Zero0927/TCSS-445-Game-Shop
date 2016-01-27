package dao.impl;

import org.springframework.orm.hibernate3.HibernateTemplate;

import dao.AccountDAO;
import dao.DAOSupport;

public class AccountDAOImpl extends DAOSupport implements AccountDAO {

	public AccountDAOImpl(HibernateTemplate template) {
		super(template);
	}

}
