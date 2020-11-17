//package test;
//
//import java.util.Hashtable;
//
//import javax.naming.Context;
//import javax.naming.spi.InitialContextFactory;
//
//import org.springframework.data.util.ReflectionUtils;
//import org.springframework.mock.jndi.SimpleNamingContext;
//import org.springframework.util.ClassUtils;
//
//import com.sun.istack.Nullable;
//
//public class MockFactory {
//	@Override
//	@SuppressWarnings("unchecked")
//	public InitialContextFactory createInitialContextFactory(@Nullable Hashtable<?,?> environment) {
//		if (activated == null && environment != null) {
//			Object icf = environment.get(Context.INITIAL_CONTEXT_FACTORY);
//			if (icf != null) {
//				Class<?> icfClass;
//				if (icf instanceof Class) {
//					icfClass = (Class<?>) icf;
//				}
//				else if (icf instanceof String) {
//					icfClass = ClassUtils.resolveClassName((String) icf, getClass().getClassLoader());
//				}
//				else {
//					throw new IllegalArgumentException("Invalid value type for environment key [" +
//							Context.INITIAL_CONTEXT_FACTORY + "]: " + icf.getClass().getName());
//				}
//				if (!InitialContextFactory.class.isAssignableFrom(icfClass)) {
//					throw new IllegalArgumentException(
//							"Specified class does not implement [" + InitialContextFactory.class.getName() + "]: " + icf);
//				}
//				try {
//					return (InitialContextFactory) ReflectionUtils.accessibleConstructor(icfClass).newInstance();
//				}
//				catch (Throwable ex) {
//					throw new IllegalStateException("Unable to instantiate specified InitialContextFactory: " + icf, ex);
//				}
//			}
//		}
//
//		// Default case...
//		return env -> new SimpleNamingContext("", this.boundObjects, (Hashtable<String, Object>) env);
//	}
//}
