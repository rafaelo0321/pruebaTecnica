package com.latam.co.pruebaTecnica.client.controller;

import com.latam.co.pruebaTecnica.client.dto.query.RQueryClient;
import com.latam.co.pruebaTecnica.client.entity.Client;
import com.latam.co.pruebaTecnica.client.service.IClientService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.stereotype.Controller;
import org.springframework.graphql.data.method.annotation.QueryMapping;
@Controller
public class GClientController {
    private final IClientService iClientService;

    public GClientController(IClientService iClientService) {
        this.iClientService = iClientService;
    }

    @QueryMapping()
    public Client showClientForTypeDocumentAndNumberDocument(@Argument RQueryClient rQueryClient){
        return iClientService.getClientTypoAndNumber(rQueryClient.typoDocument(), rQueryClient.numberDocument());
    }
}
