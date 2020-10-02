package mx.com.banamex.tdc.modelo.repositoryImpl;

import java.util.List;

//import org.apache.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.FlushMode;
import org.hibernate.NonUniqueObjectException;
import org.hibernate.Query;
//import org.hibernate.query.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import mx.com.banamex.tdc.modelo.entity.CrossellEntity;
import mx.com.banamex.tdc.modelo.repository.CrossellRepository;

@Repository
public class CrossellRepositoryImpl implements CrossellRepository {

	private static Logger log = LogManager.getLogger(CrossellRepositoryImpl.class);
	@Autowired
	private HibernateTemplate hibernateTemplate;//parra ahorrarse pasos sirve como session
	@Autowired
	SessionFactory sessionFactory;

	
	//guarda el crosselEntity
	public boolean insertList(List<CrossellEntity> listado)	throws NonUniqueObjectException {
		Session session = sessionFactory.openSession();
		hibernateTemplate.getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
		Transaction tx = session.beginTransaction();
		log.info("[ Se esta insertando en base el contenido del archivo: " + listado.size() + " ]");
		int count = 0;
		for (CrossellEntity cEnt : listado) {
			// log.debug("Cliente que se instalara:" + cEnt.getCrossellClteFolio() + "contador: " + count);
			try {
				hibernateTemplate.save(cEnt);//guarda el crosselEntity
			} catch (DuplicateKeyException e) {
				log.error("[ Error en el cliente:" + cEnt.getCrossellClteFolio() + " ]",	e);
			}
			if (++count % 20 == 0 || count == listado.size()) {//una lista de CrossellEntity max 20 despues limpia session
				// flush a batch of updates and release memory:
				session.flush();
				session.clear();
			}
			/*
			 * if ( count % 1000 == 0 ) { //flush a batch of updates and release
			 * memory: log.info(session.getStatistics());
			 * //session.getTransaction().commit(); tx.commit(); tx =
			 * session.beginTransaction(); }
			 */
		}
		try {
			tx.commit();
			session.flush();
			session.clear();
			session.close();
		} catch (DuplicateKeyException e) {
			log.debug("[ Error en duplicado ]\n", e);
		}
		return false;
	}

	public List<CrossellEntity> getAllCamposCrosselCTE() {
		// return (Number)
		// session.createCriteria("CrossellEntity").setProjection(Projections.rowCount()).uniqueResult();
		return hibernateTemplate.loadAll(CrossellEntity.class);
	}

	public int getcountcamposcrossel() {
		//Session session = sessionFactory.openSession();
		Session session = sessionFactory.getCurrentSession();
		int count = ((int) (long) session.createQuery("select count(*) from CrossellEntity").iterate().next());
		log.debug("[ count de la base de datos:" + count + " ]");
		//session.flush();
		//session.clear();
		//session.close();
		return count;
	}

	public boolean vaciaTablaCrosselEnt() {
		//Session session = sessionFactory.openSession();
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete from CrossellEntity");
		query.executeUpdate();
		//session.flush();
		//session.clear();
		//session.close();
		return true;
	}

	public boolean execute_actualiza() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("delete from TarjetasEntity where TDC_FECHA < ( sysdate - 31)");
		query.executeUpdate();
		session.flush();
		session.clear();
		session.close();
		return true;
	}

}