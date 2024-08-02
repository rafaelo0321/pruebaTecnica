package com.latam.co.pruebaTecnica.client.service;

import com.latam.co.pruebaTecnica.client.dto.mostrar.RShowClient;
import com.latam.co.pruebaTecnica.client.dto.query.RQueryClient;
import com.latam.co.pruebaTecnica.client.entity.Client;
import com.latam.co.pruebaTecnica.client.enums.ETypoDocument;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IClientService {

    ResponseEntity<?> showClientForTypoAndNumber(RQueryClient client);

    ResponseEntity<List<?>> showAllClients();
    ResponseEntity<?> showOneClient(Long id);
    Client getClient(Long id);
    List<Client> getAllClient();
    Client getClientTypoAndNumber(ETypoDocument typoDocument, String numberDocument);
    void saveClient(Client client);
}
