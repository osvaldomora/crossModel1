package test;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate4.HibernateTemplate;

import mx.com.banamex.tdc.modelo.entity.CrosselUserEntity;
import mx.com.banamex.tdc.modelo.entity.TdcDomBnmx;
import mx.com.banamex.tdc.modelo.entity.TdcProcesosEntity;
import mx.com.banamex.tdc.modelo.repositoryImpl.ProcesoCrosselRepositoryImpl;
import mx.com.banamex.tdc.modelo.service.CrossellAdminService;


//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class ControllerPrincipalTest extends Mockito {
	

	
	private static final CrosselUserEntity CROSSELL_USER_ENTITY= new CrosselUserEntity();
	
	private static final String CROSSELL_USER_SOEID="om55447";
	
	private static final String CROSSELL_USER_NOMBRE="osva";
	
	private static final String CROSSELL_USER_PWD="12";
	
	private static final int CROSSEL_USER_ESTATUS=1;

	private static final int TDC_CROSSELL_USER_PERFIL=1;

	

	
	
    
    
	private   TdcDomBnmx TDC_DOM_BNMX= new TdcDomBnmx();	
	private static final  List<TdcDomBnmx> TDC_DOM_BNMX_L = new ArrayList<TdcDomBnmx>();
    
	@Mock//la interfaz que deseamos burlar
	private CrossellAdminService crossellAdminService;
	

	
	@Mock
	private Environment env;
	
	@InjectMocks//inyecta las clases a testear
	private ProcesoCrosselRepositoryImpl procesoCrosselRepositoryImpl;

	@BeforeClass
	public static void log4j() {
		
		System.setProperty("log4j.configurationFile","mockito-log4j2.xml");
		
	}
	
	@Before
	public void init()
	{MockitoAnnotations.initMocks(this);
	
	CROSSELL_USER_ENTITY.setCrossellUserNombre(CROSSELL_USER_NOMBRE);
	CROSSELL_USER_ENTITY.setCrossellUserPwd(CROSSELL_USER_PWD);
	CROSSELL_USER_ENTITY.setCrossellUserSoeid(CROSSELL_USER_SOEID);
	CROSSELL_USER_ENTITY.setCrosselUserEstatus(CROSSEL_USER_ESTATUS);
	CROSSELL_USER_ENTITY.setTdcCrossellUserPerfil(TDC_CROSSELL_USER_PERFIL);
	
	
	TDC_DOM_BNMX.setDomEstatus(1);
	TDC_DOM_BNMX.setDomId(1);
	TDC_DOM_BNMX.setDomNombreUrl("WWW");
	TDC_DOM_BNMX_L.add(TDC_DOM_BNMX);
	
	
	
	
	}
	
	/* @Test
	 public void agregaProceso()
	 {
		 
		 
		 SessionFactory sFactory= Mockito.mock(SessionFactory.class);
		 Session session = PowerMockito.mock(Session.class);
		 
		 
		HibernateTemplate ht = Mockito.spy(new HibernateTemplate());
		
		 ht.setSessionFactory(sFactory);
		 when(ht.getSessionFactory().getCurrentSession()).thenReturn(session);
		 System.out.println(ht.getSessionFactory().getCurrentSession());
		 System.out.println(ht.getSessionFactory());
		 doNothing().when(ht).getSessionFactory().getCurrentSession().setFlushMode(any(FlushMode.class));
		 //ht.getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
	
		 procesoCrosselRepositoryImpl.agregaProceso(new TdcProcesosEntity());
	 
	 }*/
	
	 
	 @Test
	 public void login() throws Exception
	 {   
	 }
	 
	 
	 
/*	  @Test
public void agregaProceso_doAnswer_when() {
//    Customer customer = new Customer(6, "QQQ", "Mumbai");
     HibernateTemplate ht = new HibernateTemplate();
    doAnswer((arguments) -> {
        System.out.println("Inside doAnswer block");
       // assertEquals(customer, arguments.getArgument(0));
        return true;
    }).when(ht).getSessionFactory().getCurrentSession().setFlushMode(any(FlushMode.class));
    procesoCrosselRepositoryImpl.agregaProceso(new TdcProcesosEntity());
}
*/	  

	 

}
