package dao.impl;

import org.springframework.orm.hibernate3.HibernateTemplate;

import dao.DAOSupport;
import dao.FavoriteListDAO;

public class FavoriteListDAOImpl extends DAOSupport implements FavoriteListDAO {

	public FavoriteListDAOImpl(HibernateTemplate template) {
		super(template);
	}

}
