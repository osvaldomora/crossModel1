package mx.com.banamex.tdc.modelo.repositoryImpl;

import java.util.List;

import javax.transaction.Transactional;

//import org.apache.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import mx.com.banamex.tdc.modelo.entity.TdcDomBnmx;
import mx.com.banamex.tdc.modelo.repository.DominioRepository;

@Repository
@Transactional
public class DominioRepositoryImpl implements DominioRepository{
	
	private static Logger log = LogManager.getLogger(DominioRepository.class);
	@Autowired
	private HibernateTemplate hibernateTemplate;
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<TdcDomBnmx> getAllDominios() {
		log.info("antes de regresar la lista");
		List<TdcDomBnmx> res = hibernateTemplate.loadAll(TdcDomBnmx.class);
		log.info("despues de regresar la lista");
		return res;
	}

	@Override
	public List<TdcDomBnmx> getAllDominiosActivos() {
		TdcDomBnmx t = new TdcDomBnmx();
		t.setDomEstatus(1);
		List<TdcDomBnmx> res = hibernateTemplate.findByExample(t);
		return res;
	}

	@Override
	public boolean insertDominioBmx(TdcDomBnmx dom) {
//		sessionFactory.close();
//		 sessionFactory.getCurrentSession().clear();
//		 sessionFactory.getCurrentSession().evict(TdcDomBnmx.class);
//		sessionFactory.getCurrentSession().refresh(TdcDomBnmx.class);
//		sessionFactory.getCurrentSession().merge(TdcDomBnmx.class);
//		System.out.println("AAAA");

		int domId = getAllDominios().size() + 1;
		System.out.println("antes de insertar");
		dom.setDomId(domId);
		System.out.println("despues de insertar");
		try{System.out.println("antes de try");
			sessionFactory.getCurrentSession().save(dom); 
			System.out.println("despue de try");
		}catch(Exception e){
			System.out.println("error de dominio");
			log.error("[ Exception ]", e);
			return false;
		}
		
		return true;
	}

	@Override
	public boolean updateDominioBmx(TdcDomBnmx dom) { 
		try{
			String query = "from TdcDomBnmx where domId=" + dom.getDomId();			
			TdcDomBnmx domUpdate = (TdcDomBnmx)sessionFactory.getCurrentSession().createQuery(query).list().get(0);
			domUpdate.setDomEstatus(dom.getDomEstatus());
			sessionFactory.getCurrentSession().update(domUpdate); 
		}catch(Exception e){
			log.error("[ Exception ]", e);
			return false;
		}
		return true;
	} 
}
