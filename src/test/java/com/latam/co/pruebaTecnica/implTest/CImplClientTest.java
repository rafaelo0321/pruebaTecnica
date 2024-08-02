package com.latam.co.pruebaTecnica.implTest;

import com.latam.co.pruebaTecnica.client.dto.query.RQueryClient;
import com.latam.co.pruebaTecnica.client.entity.Client;
import com.latam.co.pruebaTecnica.client.enums.ETypoDocument;
import com.latam.co.pruebaTecnica.client.repo.IClientRepository;
import com.latam.co.pruebaTecnica.client.service.implement.CImplClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class CImplClientTest {

    @Mock
    private IClientRepository iClientRepository;

    @InjectMocks
    private CImplClient cImplClient;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testShowClientForTypoAndNumberExitoso() {

        RQueryClient queryClient = new RQueryClient(ETypoDocument.CC, "23445322");
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

        when(iClientRepository.findByTypoDocumentAndNumberDocument(queryClient.typoDocument(), queryClient.numberDocument())).thenReturn(Optional.of(client));

        Client respuesta = cImplClient.getClientTypoAndNumber(queryClient.typoDocument(), queryClient.numberDocument());

        assertNotNull(respuesta);
        assertEquals(client, respuesta);
    }
}
