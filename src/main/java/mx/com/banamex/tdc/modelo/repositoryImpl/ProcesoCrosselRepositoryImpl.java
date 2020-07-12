package mx.com.banamex.tdc.modelo.repositoryImpl;

import java.util.List;

import org.hibernate.FlushMode;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;

import mx.com.banamex.tdc.modelo.entity.TdcProcesosEntity;
import mx.com.banamex.tdc.modelo.repository.ProcesoCrosselRepository;

public class ProcesoCrosselRepositoryImpl implements ProcesoCrosselRepository {

	@Autowired
	HibernateTemplate hTemp;
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean agregaProceso(TdcProcesosEntity entity) {
		hTemp.getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
		int s = getTamanoProceso() + 1;
		entity.setTdcProcsId(s);
		hTemp.save(entity);
		return true;
	}

	private int getTamanoProceso() {
		List<TdcProcesosEntity> lista = hTemp.loadAll(TdcProcesosEntity.class);
		return lista.size();
	}

	@Override
	public int getCountTdcProcesosEntityAll() {
		String query = "FROM TdcProcesosEntity order by tdcProcsId desc";
		Query queryGet = sessionFactory.getCurrentSession().createQuery(query);
		return queryGet.list().size();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TdcProcesosEntity> getTdcProcesosPaginado(int pag) {
		String query = "FROM TdcProcesosEntity order by tdcProcsId desc";
		Query queryGet = sessionFactory.getCurrentSession().createQuery(query);
		queryGet.setFirstResult(((pag - 1) * 10));
		queryGet.setMaxResults(pag * 10);
		List<TdcProcesosEntity> res = (List<TdcProcesosEntity>) queryGet.list();
		return res;
	}
}
