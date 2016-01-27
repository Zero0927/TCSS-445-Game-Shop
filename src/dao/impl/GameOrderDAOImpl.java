package dao.impl;

import org.springframework.orm.hibernate3.HibernateTemplate;

import dao.DAOSupport;
import dao.GameOrderDAO;

public class GameOrderDAOImpl extends DAOSupport implements GameOrderDAO {

	public GameOrderDAOImpl(HibernateTemplate template) {
		super(template);
	}

}
