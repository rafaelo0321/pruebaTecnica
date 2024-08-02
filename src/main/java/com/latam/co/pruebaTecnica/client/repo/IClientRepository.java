package com.latam.co.pruebaTecnica.client.repo;

import com.latam.co.pruebaTecnica.client.entity.Client;
import com.latam.co.pruebaTecnica.client.enums.ETypoDocument;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IClientRepository extends JpaRepository<Client,Long> {
    Optional<Client> findByTypoDocumentAndNumberDocument(ETypoDocument typoDocument, String numberDocument);
}