package mx.com.banamex.tdc.modelo.repository;

import java.util.List;

import mx.com.banamex.tdc.modelo.entity.TdcDomBnmx;

public interface DominioRepository {
	
	public List<TdcDomBnmx> getAllDominios();
	public List<TdcDomBnmx> getAllDominiosActivos();
	public boolean insertDominioBmx(TdcDomBnmx dom);
	public boolean updateDominioBmx(TdcDomBnmx dom);
	
}
