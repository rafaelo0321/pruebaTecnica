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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class CImplClientTest {
    private final Logger LOG = LoggerFactory.getLogger(CImplClientTest.class);

    @Mock
    private IClientRepository iClientRepository;

    @InjectMocks
    private CImplClient cImplClient;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void testShowClientForTypoAndNumberClientNotFound() {
        MockitoAnnotations.openMocks(this);

        try {
            RQueryClient queryClient = new RQueryClient(ETypoDocument.CC, "23445322");

            when(iClientRepository.findByTypoDocumentAndNumberDocument((ETypoDocument.CC),("String.class")))
                    .thenReturn(Optional.empty());

            Client response = cImplClient.getClientTypoAndNumber(queryClient.typoDocument(), queryClient.numberDocument());

            assertNull(response, "El cliente debería ser nulo si no se encuentra en la base de datos");

        } catch (Exception e) {
            LOG.error("No se esperaba una excepción: " + e.getMessage());
        }
    }


    @Test
    void testSchowClientForTypoAndNumber(){
        try{
            RQueryClient queryClient = new RQueryClient(ETypoDocument.CC,"23445322");
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
            iClientRepository.save(client);
            when(iClientRepository.findByTypoDocumentAndNumberDocument(queryClient.typoDocument(),queryClient.numberDocument())).thenReturn(Optional.of(client));

            Client response = cImplClient.getClientTypoAndNumber(queryClient.typoDocument(),queryClient.numberDocument());

            assertNotNull(response);
            assertEquals(client,response);

        }catch (Exception e){
            fail(e.getMessage());
        }
    }
    @Test
    public void listClientIsEmpty(){
        List<Client> clients = cImplClient.getAllClient();

        assertFalse(clients.isEmpty());
        assertThat(clients.size(), greaterThan(0));
    }



}
