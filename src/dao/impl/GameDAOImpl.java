package dao.impl;

import org.springframework.orm.hibernate3.HibernateTemplate;

import dao.DAOSupport;
import dao.GameDAO;

public class GameDAOImpl extends DAOSupport implements GameDAO {

	public GameDAOImpl(HibernateTemplate template) {
		super(template);
	}

}
