package dao;

import java.util.List;

public interface FavoriteListDAO {
	public int findByParam(String queryString, String[] paramNames, Object[] values);
	public int findByEntity(Object o);
	public List<?> getByParam(String queryString, String[] paramNames, Object[] values);
	public List<?> getAll(String entity);
	public List<?> getColumnByParam(String queryString, String[] paramNames, Object[] values);
	public List<?> getColumnAll(String queryString);
	public void deleteByParam(String queryString, Object[] values);
	public void deleteByEntity(Object o);
	public void deleteAll(List<?> o);
	public void add(Object o);
	public void addAll(List<?> o);
	public void updateByParam(String queryString, Object[] values);
	public void update(Object o);
	public void updateAll(List<?> o);
}
