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

			Client client = new Client();
			client.setNumberDocument("23445322");
			client.setFirstName("Juan");
			client.setMiddleName("Antonio");
			client.setLastName("Perez");
			client.setSecondLastName("Arsuaga");
			client.setAddress("Av. Siempre Viva");
			client.setTypoDocument(ETypoDocument.CC);
			client.setPhone("3016903678");
			client.setCityOfResidence("Bogotá DC");

			iClientService.saveClient(client);
			Client client1 = new Client();
			client1.setNumberDocument("98765432");
			client1.setFirstName("Maria");
			client1.setMiddleName("Luisa");
			client1.setLastName("Gomez");
			client1.setSecondLastName("Martinez");
			client1.setAddress("Calle 123");
			client1.setTypoDocument(ETypoDocument.CC);
			client1.setPhone("3123456789");
			client1.setCityOfResidence("Medellín");

			iClientService.saveClient(client1);

			Client client2 = new Client();
			client2.setNumberDocument("45678901");
			client2.setFirstName("Carlos");
			client2.setMiddleName("Eduardo");
			client2.setLastName("Rodriguez");
			client2.setSecondLastName("Hernandez");
			client2.setAddress("Carrera 45");
			client2.setTypoDocument(ETypoDocument.P);
			client2.setPhone("3145678901");
			client2.setCityOfResidence("Cali");

			iClientService.saveClient(client2);

			Client client3 = new Client();
			client3.setNumberDocument("11223344");
			client3.setFirstName("Laura");
			client3.setMiddleName("Isabel");
			client3.setLastName("Lopez");
			client3.setSecondLastName("Vargas");
			client3.setAddress("Avenida Las Americas");
			client3.setTypoDocument(ETypoDocument.CC);
			client3.setPhone("3167890123");
			client3.setCityOfResidence("Barranquilla");

			iClientService.saveClient(client3);

			Client client4 = new Client();
			client4.setNumberDocument("66554433");
			client4.setFirstName("Jorge");
			client4.setMiddleName("Mario");
			client4.setLastName("Sanchez");
			client4.setSecondLastName("Perez");
			client4.setAddress("Calle Falsa 456");
			client4.setTypoDocument(ETypoDocument.CC);
			client4.setPhone("3189012345");
			client4.setCityOfResidence("Cartagena");

			iClientService.saveClient(client4);

			Client client5 = new Client();
			client5.setNumberDocument("77889900");
			client5.setFirstName("Sofia");
			client5.setMiddleName("Catalina");
			client5.setLastName("Ramirez");
			client5.setSecondLastName("Diaz");
			client5.setAddress("Diagonal 34");
			client5.setTypoDocument(ETypoDocument.CC);
			client5.setPhone("3201234567");
			client5.setCityOfResidence("Bucaramanga");

			iClientService.saveClient(client5);

		};
	}
}
