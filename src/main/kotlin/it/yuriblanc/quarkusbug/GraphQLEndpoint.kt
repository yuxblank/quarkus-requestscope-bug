package com.rgigroup.quarkuscve

import it.yuriblanc.quarkusbug.ResponseModel
import org.eclipse.microprofile.graphql.GraphQLApi
import org.eclipse.microprofile.graphql.Name
import org.eclipse.microprofile.graphql.Query
import org.eclipse.microprofile.graphql.Source


@GraphQLApi
class GraphQLEndpoint {

    @org.eclipse.microprofile.rest.client.inject.RestClient lateinit var client: RestClient
    @org.eclipse.microprofile.rest.client.inject.RestClient lateinit var client2: RestClient2


    @Query
    fun exampleQuery(): ResponseModel {
        return ResponseModel(this.client.getExample());
    }

    @Name("hello2")
    fun exampleSource(@Source responseModel: ResponseModel): String {
        return client2.getExample()
    }
}
