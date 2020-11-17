package mx.com.banamex.tdc.modelo.repositoryImpl;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import mx.com.banamex.tdc.modelo.entity.CrosselUserEntity;
import mx.com.banamex.tdc.modelo.repository.CrossellUserRepository;
import mx.com.banamex.tdc.modelo.serviceImpl.CrossellAdminServicesImpl;

@Repository
@Transactional
public class CrossellUserRepositoryImpl implements CrossellUserRepository {
	private static final Logger logger = LogManager.getLogger(CrossellUserRepositoryImpl.class);
	@Autowired
	HibernateTemplate hibernateTemplate;
	@Autowired
	SessionFactory sessionFactory;

	public boolean insertUser(CrosselUserEntity user) throws NoSuchAlgorithmException, ConstraintViolationException {
		user.setCrossellUserPwd(getEncryptedPWD(user.getCrossellUserPwd()));
//		user.setCrossellUserPwd("1");
		hibernateTemplate.save(user);
		return true;
	}

	public boolean updateUser(CrosselUserEntity user) throws NoSuchAlgorithmException {
		try {
		user.setCrossellUserPwd(getEncryptedPWD(user.getCrossellUserPwd()));
		logger.info("encripto la contraseña que se guardara"+user.getCrossellUserPwd());
		hibernateTemplate.update(user);
		
		logger.info("guardo en DB ");
		return true;
	}catch (Exception e) {
		logger.info(e);
		return false;
	}
	}
	
	
	public boolean deleteUser(CrosselUserEntity user) throws NoSuchAlgorithmException {
		try {
		
		hibernateTemplate.delete(user);
		
		logger.info("elimino en DB ");
		return true;
	}catch (Exception e) {
		logger.info(e);
		return false;
	}
	}
	
//CrosselUserEntity
	@SuppressWarnings("unchecked")//verifica si alguien ya se registro
	public boolean login(CrosselUserEntity user) throws NoSuchAlgorithmException {
		String query = "FROM CrosselUserEntity where crossellUserSoeid=? and crossellUserPwd=? and crosselUserEstatus=?";
//		String query = "FROM CrosselUserEntity where crossellUserSoeid=?  and crosselUserEstatus=?";
//		System.out.println("antes de fROM CrosselUserEntity where crossellUserSoeid=? and crossellUserPwd=? and crosselUserEstatus=?");
		logger.info("pass without encript: " + user.getCrossellUserPwd());
		user.setCrossellUserPwd(getEncryptedPWD(user.getCrossellUserPwd()));//establece la contra encriptada del loging
		logger.info("pass encript: " +user.getCrossellUserPwd());//pass encript
	
		
		Query queryGet = sessionFactory.getCurrentSession().createQuery(query);
		queryGet.setString(0, user.getCrossellUserSoeid());
	    queryGet.setParameter(1, user.getCrossellUserPwd());//queryGet.setParameter(1,getEncryptedPWD(user.getCrossellUserPwd()));  
		queryGet.setInteger(2, 1);
		logger.info("despues de query valores almacenados en la tabla");
		logger.info(queryGet.list());
		
		List<CrosselUserEntity> lista = (List<CrosselUserEntity>) queryGet.list();
		
	
	
		if (lista.size() > 0) {
			System.out.println("entro tamanio lista:" + lista.size());
			for(CrosselUserEntity v:lista)
				System.out.println(v.getCrossellUserNombre() +v.getCrosselUserEstatus());
			return true;
		}
		System.out.println("la contraseña no coindice");
		return false;  
		
		
	}

	@SuppressWarnings("unchecked")//regresa el user encriptado
	public CrosselUserEntity getUserBySOEID(String soeid) {
		String query = "FROM CrosselUserEntity where crossellUserSoeid=? ";
		Query queryGet = sessionFactory.getCurrentSession().createQuery(query);
		queryGet.setString(0, soeid);
		List<CrosselUserEntity> lista = (List<CrosselUserEntity>) queryGet.list();
		if (lista.size() > 0) {
			//System.out.println(lista.get(0));
			return lista.get(0);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<CrosselUserEntity> getAllUsers() {
		String query = "FROM CrosselUserEntity where crosselUserEstatus=?";
		Query queryGet = sessionFactory.getCurrentSession().createQuery(query);
		queryGet.setInteger(0, 1);
		return (List<CrosselUserEntity>) queryGet.list();
	}

	private String getEncryptedPWD(String pwd) throws NoSuchAlgorithmException {
		MessageDigest digest = MessageDigest.getInstance("SHA-1");
		digest.reset();
		digest.update(pwd.getBytes(StandardCharsets.UTF_8));
		byte[] md = digest.digest();
		String res = String.format("%064x", new java.math.BigInteger(1, md));
		return res;
	}

	public boolean existeSOEID(String soeid) {
		if (getUserBySOEID(soeid) != null) {
			return true;
		}
		return false;
	}
}
