package br.com.udesc.ceavi.eso.ese.streamingservice.infrastructure.streaming.gateway.converter

import br.com.udesc.ceavi.eso.ese.streamingservice.entity.streaming.model.Streaming
import br.com.udesc.ceavi.eso.ese.streamingservice.infrastructure.database.schema.streaming.StreamingSchema

fun convert(streaming: StreamingSchema): Streaming {
    return Streaming(
        imdb = streaming.imdb,
        avaliables = streaming.avaliables.split(";").map { it }
    )
}