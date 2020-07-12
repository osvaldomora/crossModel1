package mx.com.banamex.tdc.modelo.repository;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.exception.ConstraintViolationException;

import mx.com.banamex.tdc.modelo.entity.CrosselUserEntity;

@Transactional
public interface CrossellUserRepository {

	public boolean insertUser(CrosselUserEntity user) throws NoSuchAlgorithmException, ConstraintViolationException;
	public boolean updateUser(CrosselUserEntity user) throws NoSuchAlgorithmException;
	public boolean login(CrosselUserEntity user) throws NoSuchAlgorithmException;
	public CrosselUserEntity getUserBySOEID(String soeid);
	public List<CrosselUserEntity> getAllUsers();
	public boolean existeSOEID(String soeid);

}
