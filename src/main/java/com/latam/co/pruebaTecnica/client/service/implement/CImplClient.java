package com.latam.co.pruebaTecnica.client.service.implement;

import com.latam.co.pruebaTecnica.client.dto.mostrar.RShowClient;
import com.latam.co.pruebaTecnica.client.dto.query.RQueryClient;
import com.latam.co.pruebaTecnica.client.entity.Client;
import com.latam.co.pruebaTecnica.client.enums.ETypoDocument;
import com.latam.co.pruebaTecnica.client.repo.IClientRepository;
import com.latam.co.pruebaTecnica.client.service.IClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CImplClient implements IClientService {
    private final Logger LOG = LoggerFactory.getLogger(CImplClient.class);
    private final IClientRepository iClientRepository;

    public CImplClient(IClientRepository iClientRepository) {
        this.iClientRepository = iClientRepository;
    }


    @Override
    public ResponseEntity<?> showClientForTypoAndNumber(RQueryClient client) {
        try{
            LOG.info("A client is shown according to the document number and document type");
            return new ResponseEntity<>(new RShowClient(getClientTypoAndNumber(client.typoDocument(),client.numberDocument())),HttpStatus.OK);
        }catch (Exception e){
            LOG.error("Error: {}",e.getMessage());

            return new ResponseEntity<>(new Error(e.getMessage()),HttpStatus.BAD_REQUEST);
        }
    }
    @Override
    public ResponseEntity<List<?>> showAllClients() {
        try{
            LOG.info("A list of clients is displayed normally with their attributes");
            return new ResponseEntity<>(getAllClient().stream().map(RShowClient::new).collect(Collectors.toList()),HttpStatus.OK);
        }catch (RuntimeException e){
            LOG.error("Error: {}",e.getMessage());
            return new ResponseEntity<>(List.of(new Error(e.getMessage())),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> showOneClient(Long id) {
        try{
            LOG.info("A client is shown with its attributes according to its id");
            return new ResponseEntity<>(new RShowClient(getClient(id)),HttpStatus.OK);
        }catch (RuntimeException e){
            LOG.error("Error: {}",e.getMessage());
            return new ResponseEntity<>(new Error(e.getMessage()),HttpStatus.BAD_REQUEST);
        }
    }


    @Override
    public Client getClient(Long id) {
        return iClientRepository.findById(id).orElseThrow(()-> new RuntimeException("Could not find that customer based on their ID"));
    }

    @Override
    public List<Client> getAllClient() {
        return iClientRepository.findAll();
    }

    @Override
    public Client getClientTypoAndNumber(ETypoDocument typoDocument, String numberDocument) {
        return iClientRepository.findByTypoDocumentAndNumberDocument(typoDocument, numberDocument)
                .orElseThrow(()-> new RuntimeException("Could not find that client based on their document type and number"));
    }

    @Override
    public void saveClient(Client client) {
        iClientRepository.save(client);
    }
}
