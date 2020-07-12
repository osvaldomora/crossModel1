package mx.com.banamex.tdc.modelo.service;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.hibernate.NonUniqueObjectException;
import org.hibernate.exception.ConstraintViolationException;

import mx.com.banamex.tdc.modelo.entity.CrosselUserEntity;
import mx.com.banamex.tdc.modelo.entity.CrossellEntity;
import mx.com.banamex.tdc.modelo.entity.TdcDomBnmx;
//import com.banamex.tdc.modelo.entity.TdcProcesosEntity;
import mx.com.banamex.tdc.modelo.entity.TdcProcesosEntity;

public interface CrossellAdminService {

	public boolean insertUser(CrosselUserEntity user) throws NoSuchAlgorithmException, ConstraintViolationException;
	public boolean updateUser(CrosselUserEntity user) throws NoSuchAlgorithmException;
	public boolean login(CrosselUserEntity user) throws NoSuchAlgorithmException;
	public CrosselUserEntity getUserBySOEID(String soeid);
	public List<CrosselUserEntity> getAllUsers();
	public boolean existSOEID(String soeid);
	public boolean insertList(List<CrossellEntity> listado)	throws NonUniqueObjectException;
	public boolean execute_actualiza();
	public List<CrossellEntity> getAllCamposCrosselCTE();
	public int getcountcamposcrossel();
	public boolean vaciaTablaCrosselEnt();
	//public boolean agregaProceso(TdcProcesosEntity entity);
	boolean agregaProceso(TdcProcesosEntity entity);
	public int getCountTdcProcesosEntityAll();
	public List<TdcProcesosEntity> getTdcProcesosPaginado(int pag);
	public List<TdcDomBnmx> getAllDominios();
	public List<TdcDomBnmx> getAllDominiosActivos();
	public boolean insertDominioBmx(TdcDomBnmx dom);
	public boolean updateDominioBmx(TdcDomBnmx dom);
}
