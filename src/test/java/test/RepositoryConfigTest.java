package test;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.naming.spi.NamingManager;
import javax.sql.DataSource;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.jndi.SimpleNamingContextBuilder;

import com.mchange.v2.c3p0.DriverManagerDataSource;

import mx.com.banamex.tdc.modelo.config.RepositoryConfig;

public class RepositoryConfigTest extends Mockito {
	

	
	@InjectMocks//inyecta las clases a testear
	private RepositoryConfig repositoryConfig;
	private InitialContext initContext;

	@BeforeClass
	public static void log4j() {
		
		System.setProperty("log4j.configurationFile","mockito-log4j2.xml");
//		System.setProperty(Context.INITIAL_CONTEXT_FACTORY, MockFactory.class.getName());

		
	}
	
	
	
	@Before
	public void init() throws NamingException
	{MockitoAnnotations.initMocks(this);
	SimpleNamingContextBuilder.emptyActivatedContextBuilder();
    this.initContext = new InitialContext();
	
	}
	
	


	  @After
	  public void after() throws NamingException {
//	    InitialContext ctx = new InitialContext();
//	    ctx.unbind( fullJndiName );
	  }
	  
	  @Test
	  public void whenMockJndiDataSource_thenReturnJndiDataSource() throws Exception {
//	      this.initContext.bind("java:comp/env/jdbc/datasource", 
//	        new DriverManagerDataSource("jdbc:h2:mem:testdb"));
//	      DataSource ds = (DataSource) this.initContext.lookup("java:comp/env/jdbc/datasource");

//	      assertNotNull(ds.getConnection());
	  }
	
	
	@Test
	public void getDatasourceConfiguration() throws NamingException, SQLException {

	      this.initContext.bind("ds_c719_002", 
        new DriverManagerDataSource());
//      DataSource ds = (DataSource) this.initContext.lookup("java:comp/env/jdbc/datasource");
	      DataSource resp=repositoryConfig.getDatasourceConfiguration();
	      System.out.println(resp);
	      System.out.println(resp.getClass());
	      assertEquals(resp.getClass(), new DriverManagerDataSource().getClass());
	      
	}
	
	
	@Test
	public void getDatasourceConfigurationFail() throws NamingException, SQLException {

	      this.initContext.bind("java:comp/env/ds_c719_002", 
        new DriverManagerDataSource());
//      DataSource ds = (DataSource) this.initContext.lookup("java:comp/env/jdbc/datasource");
	      DataSource resp=repositoryConfig.getDatasourceConfiguration();
	      System.out.println(resp);
	     
	      assertEquals(resp, null);
	      
	}
	
/*	@Test
	public void getDatasourceConfigurationFail2() throws NamingException, SQLException {

	      this.initContext.bind("ds_c719_002e", 
        new DriverManagerDataSource());
//      DataSource ds = (DataSource) this.initContext.lookup("java:comp/env/jdbc/datasource");
	      repositoryConfig.getDatasourceConfiguration();
	     
	      
	}
*/
}
