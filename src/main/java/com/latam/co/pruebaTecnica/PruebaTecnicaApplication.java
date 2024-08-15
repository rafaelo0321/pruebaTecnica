package com.latam.co.pruebaTecnica;

import com.latam.co.pruebaTecnica.client.entity.Client;
import com.latam.co.pruebaTecnica.client.enums.ETypoDocument;
import com.latam.co.pruebaTecnica.client.service.IClientService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PruebaTecnicaApplication {

    public PruebaTecnicaApplication(IClientService iClientService) {
        this.iClientService = iClientService;
    }

    public static void main(String[] args) {
		SpringApplication.run(PruebaTecnicaApplication.class, args);
	}

	private final IClientService iClientService;

	@Bean
	public CommandLineRunner initData() {
		return (args) -> {

			/*Client client = new Client();
			client.setNumberDocument("23445322");
			client.setFirstName("Juan");
			client.setMiddleName("Antonio");
			client.setLastName("Perez");
			client.setSecondLastName("Arsuaga");
			client.setAddress("Av. Siempre Viva");
			client.setTypoDocument(ETypoDocument.CC);
			client.setPhone("3016903678");
			client.setCityOfResidence("Bogotá DC");

			iClientService.saveClient(client);*/
		};
	}
}
