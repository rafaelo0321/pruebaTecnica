package com.latam.co.pruebaTecnica.client.dto.mostrar;

import com.latam.co.pruebaTecnica.client.entity.Client;

public record RShowClient(
        Long id,String firstName,String middleName,String lastName,String secondLastName,String phone,String address,String cityOfResidence) {
    public RShowClient(Client client){
        this(client.getId(),client.getFirstName(),client.getMiddleName(),client.getLastName(),client.getSecondLastName(), client.getPhone(), client.getAddress(),client.getCityOfResidence());
    }
}
