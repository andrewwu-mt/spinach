package com.spinach.dao;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.spinach.dbo.Ship;

/**
 * A data access object (DAO) providing persistence and search support for Ship
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.spinach.dbo.Ship
 * @author MyEclipse Persistence Tools
 */
public class ShipDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(ShipDAO.class);

	// property constants

	protected void initDao() {
		// do nothing
	}

	public void save(Ship transientInstance) {
		log.debug("saving Ship instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	
	public void update(Ship transientInstance) {
		log.debug("saving Ship instance");
		try {
			getHibernateTemplate().update(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Ship persistentInstance) {
		log.debug("deleting Ship instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Ship findById(java.lang.Long id) {
		log.debug("getting Ship instance with id: " + id);
		try {
			Ship instance = (Ship) getHibernateTemplate().get(
					"com.spinach.dbo.Ship", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	public Ship findByIdJoin(java.lang.Long id) {
		try {
			String queryString = "from Ship as model left join fetch model.customer as c left join fetch c.kabupaten as k left join fetch k.provinsi as p left join fetch model.shipType as s where model.shipId = ?";
			List<Ship> list = getHibernateTemplate().find(queryString, id);
			if(list.size() > 0) {
				return list.get(0);
			} else {
				return null;
			}
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByExample(Ship instance) {
		log.debug("finding Ship instance by example");
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
		log.debug("finding Ship instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Ship as model left join fetch model.customer as c left join fetch c.kabupaten as k left join fetch k.provinsi as p left join fetch model.shipType as s where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all Ship instances");
		try {
			String queryString = 
					"from Ship as model " +
					"left join fetch model.customer as c " +
					"left join fetch c.kabupaten as k " +
					"left join fetch k.provinsi as p " +
					"left join fetch model.shipType as s " +
					"order by model.insertDate asc";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public List findByMonth(Integer month, Integer year) {
		log.debug("finding all Ship instances");
		try {
			String str = "";

			if(year != null){
				str += "where date_format(model.insertDate, '%Y') = "+year+" ";
			} else {
				str += "where date_format(model.insertDate, '%Y') = 2014 ";
			}
			
			if(month != null && month != 0){
				str += "and date_format(model.insertDate, '%m') = "+month+" ";
			}

			
			String queryString = 
					"from Ship as model " +
					str +
					"order by model.insertDate asc";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Long findPrice(Integer month, Integer year, String param) {
		log.debug("finding all Ship instances");
		try {
			String str = "";

			if(year != null){
				str += "where date_format(model.insertDate, '%Y') = "+year+" ";
			} else {
				str += "where date_format(model.insertDate, '%Y') = 2014 ";
			}
			
			if(month != null && month != 0){
				str += "and date_format(model.insertDate, '%m') = "+month+" ";
			}
			
			String queryString = 
					"select sum("+param+") " +
					"from Ship as model " +
					str;
			List<Long> list = getHibernateTemplate().find(queryString);
			
			if(list.size() != 0){
				return list.get(0);
			} else {
				return null;
			}
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public Long findAdminFee(Integer month, Integer year) {
		log.debug("finding all Ship instances");
		try {
			String str = "";

			if(year != null){
				str += "and date_format(insert_date, '%Y') = "+year+" ";
			} else {
				str += "and date_format(insert_date, '%Y') = 2014 ";
			}
			
			if(month != null && month != 0){
				str += "and date_format(insert_date, '%m') = "+month+" ";
			}
			
			String queryString = 
					"select count(*) * 10000 " +
					"from sp_ship " +
					"where payment_method_id = 3 " +
					str;

			Session session = getHibernateTemplate().getSessionFactory().openSession();
            SQLQuery query = session.createSQLQuery(queryString);
    		List<Object> result = query.list();
    		session.flush();
            session.clear();
    		session.close();

    		if(result.size() != 0){
    			Object obj = result.get(0);
    			return Long.valueOf(obj.toString());
    		} else {
    			return null;
    		}
    		
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public Ship merge(Ship detachedInstance) {
		log.debug("merging Ship instance");
		try {
			Ship result = (Ship) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Ship instance) {
		log.debug("attaching dirty Ship instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Ship instance) {
		log.debug("attaching clean Ship instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ShipDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ShipDAO) ctx.getBean("ShipDAO");
	}
}