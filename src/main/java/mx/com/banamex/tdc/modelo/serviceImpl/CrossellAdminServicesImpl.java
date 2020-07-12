package mx.com.banamex.tdc.modelo.serviceImpl;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.hibernate.NonUniqueObjectException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;

import mx.com.banamex.tdc.modelo.entity.CrosselUserEntity;
import mx.com.banamex.tdc.modelo.entity.CrossellEntity;
import mx.com.banamex.tdc.modelo.entity.TdcDomBnmx;
import mx.com.banamex.tdc.modelo.entity.TdcProcesosEntity;
import mx.com.banamex.tdc.modelo.repository.CrossellRepository;
import mx.com.banamex.tdc.modelo.repository.CrossellUserRepository;
import mx.com.banamex.tdc.modelo.repository.DominioRepository;
import mx.com.banamex.tdc.modelo.repository.ProcesoCrosselRepository;
import mx.com.banamex.tdc.modelo.service.CrossellAdminService;

public class CrossellAdminServicesImpl implements CrossellAdminService {
	
	@Autowired
	CrossellUserRepository crossellUserRepository;
	@Autowired
	CrossellRepository crosselRepository;
	@Autowired
	ProcesoCrosselRepository procesoCrosselRepository;
	@Autowired
	DominioRepository dominioRepository;

	public boolean insertUser(CrosselUserEntity user) throws NoSuchAlgorithmException, ConstraintViolationException {
		return crossellUserRepository.insertUser(user);
	}

	public boolean updateUser(CrosselUserEntity user) throws NoSuchAlgorithmException {
		return crossellUserRepository.updateUser(user);
	}

	public boolean login(CrosselUserEntity user) throws NoSuchAlgorithmException {
		
		return crossellUserRepository.login(user);
	}

	public CrosselUserEntity getUserBySOEID(String soeid) {
		return crossellUserRepository.getUserBySOEID(soeid);
	}

	public List<CrosselUserEntity> getAllUsers() {
		return crossellUserRepository.getAllUsers();
	}

	public boolean existSOEID(String soeid) {
		return crossellUserRepository.existeSOEID(soeid);
	}

	public boolean insertList(List<CrossellEntity> listado) throws NonUniqueObjectException {
		return crosselRepository.insertList(listado);
	}

	public List<CrossellEntity> getAllCamposCrosselCTE() {
		return crosselRepository.getAllCamposCrosselCTE();
	}

	public int getcountcamposcrossel() {
		return crosselRepository.getcountcamposcrossel();
	}

	public boolean vaciaTablaCrosselEnt() {
		return crosselRepository.vaciaTablaCrosselEnt();
	}

	public boolean execute_actualiza() {
		return crosselRepository.execute_actualiza();
	}

	@Override
	public boolean agregaProceso(TdcProcesosEntity entity) {
		return procesoCrosselRepository.agregaProceso(entity);
	}

	@Override
	public int getCountTdcProcesosEntityAll() {
		return procesoCrosselRepository.getCountTdcProcesosEntityAll();
	}

	@Override
	public List<TdcProcesosEntity> getTdcProcesosPaginado(int pag) {
		return procesoCrosselRepository.getTdcProcesosPaginado(pag);
	}

	@Override
	public List<TdcDomBnmx> getAllDominios() {
		return dominioRepository.getAllDominios();
	}

	@Override
	public List<TdcDomBnmx> getAllDominiosActivos() {
		return dominioRepository.getAllDominiosActivos();
	}

	@Override
	public boolean insertDominioBmx(TdcDomBnmx dom) {
		return dominioRepository.insertDominioBmx(dom);
	}

	@Override
	public boolean updateDominioBmx(TdcDomBnmx dom) {
		return dominioRepository.updateDominioBmx(dom);
	}

}
