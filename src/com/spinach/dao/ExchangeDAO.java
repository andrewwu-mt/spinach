package com.spinach.dao;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.spinach.dbo.Exchange;

/**
 * A data access object (DAO) providing persistence and search support for
 * Exchange entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.spinach.dbo.Exchange
 * @author MyEclipse Persistence Tools
 */
public class ExchangeDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(ExchangeDAO.class);
	// property constants
	public static final String NAME = "name";

	protected void initDao() {
		// do nothing
	}

	public void save(Exchange transientInstance) {
		log.debug("saving Exchange instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Exchange persistentInstance) {
		log.debug("deleting Exchange instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Exchange findById(java.lang.Integer id) {
		log.debug("getting Exchange instance with id: " + id);
		try {
			Exchange instance = (Exchange) getHibernateTemplate().get(
					"com.spinach.dbo.Exchange", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Exchange instance) {
		log.debug("finding Exchange instance by example");
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
		log.debug("finding Exchange instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Exchange as model where model."
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
		log.debug("finding all Exchange instances");
		try {
			String queryString = "from Exchange";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Exchange merge(Exchange detachedInstance) {
		log.debug("merging Exchange instance");
		try {
			Exchange result = (Exchange) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Exchange instance) {
		log.debug("attaching dirty Exchange instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Exchange instance) {
		log.debug("attaching clean Exchange instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ExchangeDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ExchangeDAO) ctx.getBean("ExchangeDAO");
	}
}