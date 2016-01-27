package dao.impl;

import org.springframework.orm.hibernate3.HibernateTemplate;

import dao.DAOSupport;
import dao.RatingDAO;

public class RatingDAOImpl extends DAOSupport implements RatingDAO {

	public RatingDAOImpl(HibernateTemplate template) {
		super(template);
	}

}
