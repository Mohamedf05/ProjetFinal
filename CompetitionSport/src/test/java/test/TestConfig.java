package test;

import javax.persistence.EntityManagerFactory;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import CompetitionSport.config.AppConfig;


 @ExtendWith(SpringExtension.class)
 @ContextConfiguration(classes= {AppConfig.class})
 class TestConfig {
	
	@Autowired
	EntityManagerFactory entityManagerFactory;
	
	@Test
	void test(){
		assertNotNull(entityManagerFactory);
		
	}

}
