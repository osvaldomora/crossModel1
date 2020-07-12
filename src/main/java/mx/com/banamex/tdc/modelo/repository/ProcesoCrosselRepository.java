package mx.com.banamex.tdc.modelo.repository;

import java.util.List;

import javax.transaction.Transactional;

import mx.com.banamex.tdc.modelo.entity.TdcProcesosEntity;

@Transactional
public interface ProcesoCrosselRepository {
	
	public boolean agregaProceso(TdcProcesosEntity entity);
	public int getCountTdcProcesosEntityAll();
	public List<TdcProcesosEntity> getTdcProcesosPaginado(int pag);
}
