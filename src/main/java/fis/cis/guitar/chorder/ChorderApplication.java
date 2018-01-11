package fis.cis.guitar.chorder;

import fis.cis.guitar.chorder.init.InitialDataSet;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ChorderApplication {

	@Autowired
	private InitialDataSet initialDataSet;

	public static void main(String[] args) {
		SpringApplication.run(ChorderApplication.class, args);
	}

	@Bean
	InitializingBean init() {
		return initialDataSet.load();
	}
}
