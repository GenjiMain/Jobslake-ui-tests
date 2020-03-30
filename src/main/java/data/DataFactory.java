package data;

import java.util.Locale;

import org.aeonbits.owner.ConfigCache;

import com.github.javafaker.Faker;

import config.Configuration;
import lombok.extern.log4j.Log4j2;
import model.Consultant;

@Log4j2
public class DataFactory {

	 private final Faker faker;
	 
	 public DataFactory() {
		 Configuration configuration = ConfigCache.getOrCreate(Configuration.class);
	        faker = new Faker(new Locale(configuration.faker()));
	 }
	 
	 public Consultant createConsultantData() {
		 Consultant consultant = Consultant.builder().
								 prenom(faker.name().
								 firstName()).
								 nom(faker.name().
								 lastName()).
								 email(faker.internet().
								 emailAddress()).
								 motDePasse(faker.internet().password()).
								 build();
		 log.info(consultant);		               
		 return consultant;
	 }
}
