package mx.com.banamex.tdc.modelo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.NonUniqueObjectException;

import mx.com.banamex.tdc.modelo.entity.CrossellEntity;

@Transactional
public interface CrossellRepository {
	
	public boolean insertList(List<CrossellEntity> listado)	throws NonUniqueObjectException;
	public List<CrossellEntity> getAllCamposCrosselCTE();
	public int getcountcamposcrossel();
	public boolean vaciaTablaCrosselEnt();
	public boolean execute_actualiza();
	
}