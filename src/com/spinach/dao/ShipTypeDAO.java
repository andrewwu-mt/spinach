package com.spinach.dao;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.spinach.dbo.ShipType;

/**
 * A data access object (DAO) providing persistence and search support for
 * ShipType entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.spinach.dbo.ShipType
 * @author MyEclipse Persistence Tools
 */
public class ShipTypeDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(ShipTypeDAO.class);
	// property constants
	public static final String NAME = "name";

	protected void initDao() {
		// do nothing
	}

	public void save(ShipType transientInstance) {
		log.debug("saving ShipType instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(ShipType persistentInstance) {
		log.debug("deleting ShipType instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ShipType findById(java.lang.Integer id) {
		log.debug("getting ShipType instance with id: " + id);
		try {
			ShipType instance = (ShipType) getHibernateTemplate().get(
					"com.spinach.dbo.ShipType", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(ShipType instance) {
		log.debug("finding ShipType instance by example");
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
		log.debug("finding ShipType instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from ShipType as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findAll() {
		log.debug("finding all ShipType instances");
		try {
			String queryString = "from ShipType";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public ShipType merge(ShipType detachedInstance) {
		log.debug("merging ShipType instance");
		try {
			ShipType result = (ShipType) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ShipType instance) {
		log.debug("attaching dirty ShipType instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ShipType instance) {
		log.debug("attaching clean ShipType instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ShipTypeDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ShipTypeDAO) ctx.getBean("ShipTypeDAO");
	}
}