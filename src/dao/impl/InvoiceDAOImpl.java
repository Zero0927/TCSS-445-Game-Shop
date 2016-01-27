package dao.impl;

import org.springframework.orm.hibernate3.HibernateTemplate;

import dao.DAOSupport;
import dao.InvoiceDAO;

public class InvoiceDAOImpl extends DAOSupport implements InvoiceDAO {

	public InvoiceDAOImpl(HibernateTemplate template) {
		super(template);
	}

}
