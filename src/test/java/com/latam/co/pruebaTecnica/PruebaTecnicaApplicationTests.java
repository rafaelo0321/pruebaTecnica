package com.latam.co.pruebaTecnica;

import com.latam.co.pruebaTecnica.client.controller.CClientController;
import com.latam.co.pruebaTecnica.client.dto.query.RQueryClient;
import com.latam.co.pruebaTecnica.client.entity.Client;
import com.latam.co.pruebaTecnica.client.enums.ETypoDocument;
import com.latam.co.pruebaTecnica.client.repo.IClientRepository;
import com.latam.co.pruebaTecnica.client.service.IClientService;
import com.latam.co.pruebaTecnica.client.service.implement.CImplClient;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
class PruebaTecnicaApplicationTests {
	@Autowired
	private IClientRepository iClientRepository;

	@Autowired
	private CClientController controller;

	@Autowired
	private IClientService iClientService;

    @Test
	void contextLoads() {

		assertThat(iClientRepository).isNotNull();
		assertThat(controller).isNotNull();
		assertThat(iClientRepository).isNotNull();
	}

}
