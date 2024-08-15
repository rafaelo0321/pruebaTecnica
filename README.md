# pruebaTecnica
Probar graphiql en la Web
http://localhost:8090/graphiql?path=/graphql&wsPath=/graphql
query{
    showClientForTypeDocumentAndNumberDocument(rQueryClient:{
    typoDocument:CC,
    numberDocument:"66554433"
    }){
        id
        firstName
    }
}