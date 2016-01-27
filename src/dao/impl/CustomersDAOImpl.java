package dao.impl;

import org.springframework.orm.hibernate3.HibernateTemplate;

import dao.CustomersDAO;
import dao.DAOSupport;

public class CustomersDAOImpl extends DAOSupport implements CustomersDAO {

	public CustomersDAOImpl(HibernateTemplate template) {
		super(template);
	}

}
