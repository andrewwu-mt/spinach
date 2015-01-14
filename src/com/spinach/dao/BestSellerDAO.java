package com.spinach.dao;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.spinach.dbo.BestSeller;
import com.spinach.dbo.BestSellerId;

/**
 * A data access object (DAO) providing persistence and search support for
 * BestSeller entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see dbo.BestSeller
 * @author MyEclipse Persistence Tools
 */
public class BestSellerDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(BestSellerDAO.class);

	// property constants

	protected void initDao() {
		// do nothing
	}

	public void save(BestSeller transientInstance) {
		log.debug("saving BestSeller instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(BestSeller persistentInstance) {
		log.debug("deleting BestSeller instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public BestSeller findById(BestSellerId id) {
		log.debug("getting BestSeller instance with id: " + id);
		try {
			BestSeller instance = (BestSeller) getHibernateTemplate().get(
					"com.spinach.dbo.BestSeller", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(BestSeller instance) {
		log.debug("finding BestSeller instance by example");
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
		log.debug("finding BestSeller instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from BestSeller as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all BestSeller instances");
		try {
			String queryString = "from BestSeller";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public BestSeller merge(BestSeller detachedInstance) {
		log.debug("merging BestSeller instance");
		try {
			BestSeller result = (BestSeller) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(BestSeller instance) {
		log.debug("attaching dirty BestSeller instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(BestSeller instance) {
		log.debug("attaching clean BestSeller instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static BestSellerDAO getFromApplicationContext(ApplicationContext ctx) {
		return (BestSellerDAO) ctx.getBean("BestSellerDAO");
	}
}