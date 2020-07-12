package mx.com.banamex.tdc.modelo.config;

import java.util.Hashtable;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

//import org.apache.log4j.Logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource(value = "classpath:data/jdbconf.properties")
@EnableTransactionManagement
public class RepositoryConfig {

	private static Logger log = LogManager.getLogger(RepositoryConfig.class);

	@Autowired
	Environment env;
	private HibernateTemplate ht;
	private DataSource ds;

	/*
	 * @Bean public DataSource getDatasourceConfiguration() {
	 * 
	 * DriverManagerDataSource dataSource = new DriverManagerDataSource();
	 * dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
	 * dataSource.setUrl(env.getProperty("jdbc.url"));
	 * dataSource.setUsername(env.getProperty("jdbc.username"));
	 * dataSource.setPassword(env.getProperty("jdbc.password"));
	 * 
	 * return dataSource; }
	 */

	@Bean(name = "dataSource", destroyMethod = "")
	public DataSource getDatasourceConfiguration() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {	}		
		Hashtable<String, String> h = new Hashtable<String, String>();
		h.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
		InitialContext context = null;
		DataSource dataSource = null;
		try {
			context = new InitialContext(h);
			dataSource = (javax.sql.DataSource) context.lookup("ds_c719_002");
			this.ds = dataSource;
			context.close();
			return dataSource;
		} catch (NamingException e) {
			log.error("[ NamingException ]", e);
			try {
				dataSource = (javax.sql.DataSource) context.lookup("java:comp/env/ds_c719_002");
			} catch (NamingException e1) {
				log.error("[ NamingException ]", e1);
				System.exit(1);
			}
		} finally {
			try {
				context.close();
			} catch (Exception e) {
				log.error("[ Exception ]", e);
			}
		}
		return null;
	}

	@Bean(name = "sessionFactoryBean", destroyMethod = "")
	public LocalSessionFactoryBean sessionFactoryBean() {
		LocalSessionFactoryBean asfb = new LocalSessionFactoryBean();
		asfb.setHibernateProperties(getHibernateProperties());
		asfb.setDataSource(getDatasourceConfiguration());
		asfb.setPackagesToScan(new String[] { "mx.com.banamex.tdc.modelo" });
		return asfb;
	}

	@Bean
	public SessionFactory sessionFactory() {
		return sessionFactoryBean().getObject();
	}

	private Properties getHibernateProperties() {

		Properties hibernateProperties = new Properties();
		hibernateProperties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
		hibernateProperties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		hibernateProperties.put("hibernate.generate_statistics", env.getProperty("hibernate.generate_statistics"));
		// hibernateProperties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
		// hibernateProperties.put("hibernate.connection.provider_class", "org.hibernate.connection.C3P0ConnectionProvider");
		hibernateProperties.put("hibernate.jndi.class", "weblogic.jndi.WLInitialContextFactory");
		hibernateProperties.put("hibernate.c3p0.min_size", env.getProperty("hibernate.c3p0.min_size"));
		hibernateProperties.put("hibernate.c3p0.max_size", env.getProperty("hibernate.c3p0.max_size"));
		hibernateProperties.put("hibernate.c3p0.timeout", env.getProperty("hibernate.c3p0.timeout"));
		hibernateProperties.put("hibernate.c3p0.max_statements", env.getProperty("hibernate.c3p0.max_statements"));
		hibernateProperties.put("hibernate.c3p0.idle_test_period", env.getProperty("hibernate.c3p0.idle_test_period"));
		hibernateProperties.put("hibernate.c3p0.testConnectionOnCheckout", "true");
		hibernateProperties.put("hibernate.jdbc.batch_size", "20");
		hibernateProperties.put("hibernate.cache.use_second_level_cache", "false");
		// hibernateProperties.put("hibernate.connection.provider_class", "org.hibernate.service.jdbc.connections.internal.C3P0ConnectionProvider");
		return hibernateProperties;
	}

	@Bean(name = "hibernateTemplate", destroyMethod = "")
	public HibernateTemplate hibernateTemplate(SessionFactory sessionFactory) {
		HibernateTemplate hibernateTemplate = new HibernateTemplate(sessionFactory);
		this.ht = hibernateTemplate;
		return hibernateTemplate;
	}

	@Bean(name = "txManager", destroyMethod = "")
	public PlatformTransactionManager txManager() throws Exception {
		HibernateTransactionManager txManager = new HibernateTransactionManager(sessionFactory());
		txManager.setNestedTransactionAllowed(true);
		return txManager;
	}

}
