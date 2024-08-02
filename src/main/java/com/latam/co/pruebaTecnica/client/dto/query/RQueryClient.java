package com.latam.co.pruebaTecnica.client.dto.query;

import com.latam.co.pruebaTecnica.client.enums.ETypoDocument;

public record RQueryClient(ETypoDocument typoDocument, String numberDocument) {
}
