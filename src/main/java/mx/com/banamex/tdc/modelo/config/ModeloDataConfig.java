package mx.com.banamex.tdc.modelo.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import mx.com.banamex.tdc.modelo.repository.CrossellRepository;
import mx.com.banamex.tdc.modelo.repository.CrossellUserRepository;
import mx.com.banamex.tdc.modelo.repository.DominioRepository;
import mx.com.banamex.tdc.modelo.repository.ProcesoCrosselRepository;
import mx.com.banamex.tdc.modelo.repositoryImpl.CrossellRepositoryImpl;
import mx.com.banamex.tdc.modelo.repositoryImpl.CrossellUserRepositoryImpl;
import mx.com.banamex.tdc.modelo.repositoryImpl.DominioRepositoryImpl;
import mx.com.banamex.tdc.modelo.repositoryImpl.ProcesoCrosselRepositoryImpl;

@Configuration
public class ModeloDataConfig {

	private static Logger log = LogManager.getLogger(ModeloDataConfig.class);
	
	
	@Bean
	public CrossellRepository crosselrepo() {
		log.info("clase ModeloDataConfig crosselrepo");
		return new CrossellRepositoryImpl();
	}

	@Bean
	public CrossellUserRepository crossellUserRepository() {
		log.info("clase ModeloDataConfig crossellUserRepository");
		return new CrossellUserRepositoryImpl();
	}

	@Bean
	public ProcesoCrosselRepository procesoCrosselRepository() {
		log.info("clase ModeloDataConfig procesoCrosselRepository");
		return new ProcesoCrosselRepositoryImpl();
	}

	@Bean
	public DominioRepository dominioRepository() {
		log.info("ProcesoCrosselRepositoryImpl");
		return new DominioRepositoryImpl();
	}
}
