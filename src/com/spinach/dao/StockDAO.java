package com.spinach.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.spinach.dbo.Stock;

/**
 * A data access object (DAO) providing persistence and search support for Stock
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.spinach.dbo.Stock
 * @author MyEclipse Persistence Tools
 */
public class StockDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(StockDAO.class);
	// property constants
	public static final String NUMBER = "number";

	protected void initDao() {
		// do nothing
	}

	public void save(Stock transientInstance) {
		log.debug("saving Stock instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	
	public void update(Stock transientInstance) {
		log.debug("saving Stock instance");
		try {
			getHibernateTemplate().update(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	
	public void updateAll(List<Stock> transientInstance) {
		log.debug("saving Stock instance");
		try {
			getHibernateTemplate().saveOrUpdateAll(transientInstance);
			log.debug("update all successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Stock persistentInstance) {
		log.debug("deleting Stock instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Stock findById(java.lang.Integer id) {
		log.debug("getting Stock instance with id: " + id);
		try {
			Stock instance = (Stock) getHibernateTemplate().get(
					"com.spinach.dbo.Stock", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Stock instance) {
		log.debug("finding Stock instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Stock instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Stock as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByNumber(Object number) {
		return findByProperty(NUMBER, number);
	}

	public List findAll() {
		log.debug("finding all Stock instances");
		try {
			String queryString = "from Stock as model left join fetch model.product as p order by p.name asc";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public List findByLike(String propertyName, Object value) {
		log.debug("finding Stock instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Stock as model left join fetch model.product as p where model."
					+ propertyName + " like '%"+ value + "%'";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public Stock merge(Stock detachedInstance) {
		log.debug("merging Stock instance");
		try {
			Stock result = (Stock) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Stock instance) {
		log.debug("attaching dirty Stock instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Stock instance) {
		log.debug("attaching clean Stock instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static StockDAO getFromApplicationContext(ApplicationContext ctx) {
		return (StockDAO) ctx.getBean("StockDAO");
	}
}