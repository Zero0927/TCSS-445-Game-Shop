package dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

/* 数据库访问层
 * HibernateTemplate传入
 * 父类*/

public class DAOSupport
{
	protected HibernateTemplate template;
	
	//通过spring注入
	public DAOSupport(HibernateTemplate template)
	{
		this.template = template;
	}
	
	
	public int findByParam(String queryString, String[] paramNames,
			Object[] values) {
		return template.findByNamedParam(queryString, paramNames, values).size();
	}
	
	public int findByEntity(Object o) {
		return template.findByExample(o).size();
	}
	
	public List<?> getByParam(String queryString, String[] paramNames,
			Object[] values) {
		return template.findByNamedParam(queryString, paramNames, values);
	}
	
	public List<?> getAll(String entity) {
		return template.find("from " + entity);
	}
	
	public List<?> getColumnByParam(String queryString, String[] paramNames,
			Object[] values) {
		return template.findByNamedParam(queryString, paramNames, values);
	}
	
	public List<?> getColumnAll(String queryString) {
		return template.find(queryString);
	}
	
	public void deleteByParam(String queryString, Object[] values) {
		template.bulkUpdate(queryString, values);
	}
	
	public void deleteByEntity(Object o) {
		template.delete(o);
	}
	
	public void deleteAll(List<?> o) {
		template.deleteAll(o);
	}
	
	public void add(Object o) {
		template.save(o);
	}
	
	public void addAll(List<?> o) {
		template.saveOrUpdateAll(o);
//		List<Staff> existStaffs = new ArrayList<Staff>();
//		Session session = template.getSessionFactory().openSession();
//		Transaction tx = session.beginTransaction();
//		for (Staff staff : staffs) {
//			if (findById(staff.getId()) > 0)
//				existStaffs.add(staff);
//			else
//				session.save(staff);
//		}
//		tx.commit();
//		session.close();
//		return existStaffs;
	}
	
	public void updateByParam(String queryString, Object[] values) {
		template.bulkUpdate(queryString, values);
	}
	
	public void update(Object o) {
		template.update(o);
	}
	
	public void updateAll(List<?> o) {
		template.saveOrUpdateAll(o);
	}
}