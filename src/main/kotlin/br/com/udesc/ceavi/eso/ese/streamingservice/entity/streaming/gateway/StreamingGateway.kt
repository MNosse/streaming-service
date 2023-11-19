package br.com.udesc.ceavi.eso.ese.streamingservice.entity.streaming.gateway

import br.com.udesc.ceavi.eso.ese.streamingservice.entity.streaming.model.Streaming

interface StreamingGateway {
    fun create(imdb: String, avaliables: List<String>): Streaming
    fun getByImdb(imdb: String): Streaming?
}