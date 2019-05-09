package com.guys.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;

import com.guys.dao.impl.Page;

@SuppressWarnings("deprecation")
public interface BaseDao<T> {
	/**
	 * 根据ID加载PO实例
	 * 
	 * @param id
	 * @return 返回相应的持久化PO实例
	 */
	public T load(Serializable id);

	/**
	 * 根据ID获取PO实例
	 * 
	 * @param id
	 * @return 返回相应的持久化PO实例
	 */
	public T get(Serializable id);

	/**
	 * 获取PO的所有对象
	 * 
	 * @return PO对象List集
	 */
	public List<T> loadAll();

	/**
	 * 保存PO
	 * 
	 * @param entity
	 */
	public void save(T entity);

	/**
	 * 删除PO
	 * 
	 * @param entity
	 */
	public void remove(T entity);

	/**
	 * 删除tableNames数据
	 * 
	 * @param tableName
	 */
	public void removeAll(String tableName);

	/**
	 * 更改PO
	 * 
	 * @param entity
	 */
	public void update(T entity);

	/**
	 * 执行HQL查询
	 * 
	 * @param hql
	 * @return 查询结果List集
	 */
	@SuppressWarnings("rawtypes")
	public List find(String hql);

	/**
	 * 执行带参的HQL查询
	 * 
	 * @param hql
	 * @param params
	 * @return 查询结果List集
	 */
	@SuppressWarnings("rawtypes")
	public List find(String hql, Object... params);

	/**
	 * 对延迟加载的实体PO执行初始化
	 * 
	 * @param entity
	 */
	public void initialize(Object entity);

	/**
	 * 分页查询函数
	 * 
	 * @param hql
	 *            hql语句
	 * @param pageNo
	 *            页号（从1开始）
	 * @param pageSize
	 *            页显示数据条数
	 * @param values
	 *            可变参数
	 * @return Page对象
	 */
	public Page pagedQuery(String hql, int pageNo, int pageSize, Object... values);

	/**
	 * 创建Query对象。对于需要first,max,fetchsize,cache,cacheRegion等诸多设置的函数，
	 * 可以在返回Query后自行设置。 留意可以连续设置，如下：
	 * 
	 * <pre>
	 * dao.getQuery(hql).setMaxResult(100).setCacheable(true).list();
	 * </pre>
	 * 
	 * 调用方式如下：
	 * 
	 * <pre>
	 * 			dao.createQuery(hql)
	 * 			dao.createQuery(hql, arg0)
	 * 			dao.createQuery(hql, arg0, arg1)
	 * 			dao.createQuery(hql, new Object[arg0,arg1,arg2]
	 * </pre>
	 * 
	 * @param hql
	 *            hql语句
	 * @param values
	 *            可变参数
	 * @return Query对象
	 */
	@SuppressWarnings("rawtypes")
	public Query createQuery(String hql, Object... values);
}
