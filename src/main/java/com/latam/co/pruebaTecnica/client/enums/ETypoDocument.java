package com.latam.co.pruebaTecnica.client.enums;

public enum ETypoDocument {
    CC("Cédula de ciudadanía"),
    P("Pasaporte");

    private String typoDocument;
    private ETypoDocument(String typoDocument) {
        this.typoDocument = typoDocument;
    }


    public String getTxTypoDocument() {
        return typoDocument;
    }
    public void setTxTypoDocument(String typoDocument) {
        this.typoDocument = typoDocument;
    }
}
