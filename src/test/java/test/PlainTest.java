//package test;
//
//import java.io.IOException;
//import java.util.Hashtable;
//
//import javax.naming.InitialContext;
//import javax.naming.NamingException;
//import javax.naming.spi.InitialContextFactory;
//
//import org.junit.Before;
//import org.mockito.MockitoAnnotations;
//
//import com.oracle.common.internal.net.ipclw.mql.Context;
//import com.tangosol.coherence.memcached.server.ConnectionFactory;
//
//public class PlainTest {
//
//	 public static class MyContextFactory implements InitialContextFactory
//	  {
//	    @Override
//	    public Context getInitialContext(Hashtable<?, ?> environment) throws NamingException {
//	      ConnectionFactory mockConnFact = mock(ConnectionFactory.class);
//	      InitialContext mockCtx = mock(InitialContext.class);
//	      when(mockCtx.lookup("jms1")).thenReturn(mockConnFact);
//	      return mockCtx;
//	    }
//	    
//	  }
//
//	  @Before
//	  public void setupClass() throws IOException
//	  {
//	    MockitoAnnotations.initMocks(this);
//	    System.setProperty("java.naming.factory.initial",
//	      this.getClass().getCanonicalName() + "$MyContextFactory");
//	  }
//}
