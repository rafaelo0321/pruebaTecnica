# pruebaTecnica
Probar graphiql en la Web
Interface Grafica: http://localhost:8090/graphiql?path=/graphql&wsPath=/graphql
Postman: http://localhost:8090/graphql

query{
    showClientForTypeDocumentAndNumberDocument(rQueryClient:{
    typoDocument:CC,
    numberDocument:"66554433"
    }){
        id
        firstName
    }
}