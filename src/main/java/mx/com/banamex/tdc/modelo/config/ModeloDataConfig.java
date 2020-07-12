package mx.com.banamex.tdc.modelo.config;

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

	@Bean
	public CrossellRepository crosselrepo() {
		return new CrossellRepositoryImpl();
	}

	@Bean
	public CrossellUserRepository crossellUserRepository() {
		return new CrossellUserRepositoryImpl();
	}

	@Bean
	public ProcesoCrosselRepository procesoCrosselRepository() {
		return new ProcesoCrosselRepositoryImpl();
	}

	@Bean
	public DominioRepository dominioRepository() {
		return new DominioRepositoryImpl();
	}
}
