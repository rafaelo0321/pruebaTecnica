package com.latam.co.pruebaTecnica.client.controller;

import com.latam.co.pruebaTecnica.client.dto.query.RQueryClient;
import com.latam.co.pruebaTecnica.client.service.IClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/client")
public class CClientController {
    private final IClientService iClientService;

    public CClientController(IClientService iClientService) {
        this.iClientService = iClientService;
    }

    @GetMapping("/show/for/number/typoDocument")
    public ResponseEntity<?> showClientByNumberAndDocumentType(@RequestBody RQueryClient client){
        return iClientService.showClientForTypoAndNumber(client);
    }
    @GetMapping("/showAll")
    public ResponseEntity<?> showAllClients(){
        return iClientService.showAllClients();
    }
    @GetMapping("/show/for/{id}")
    public ResponseEntity<?> showOneClientForID(@PathVariable("id") Long id){
        return iClientService.showOneClient(id);
    }

}
