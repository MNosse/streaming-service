package br.com.udesc.ceavi.eso.ese.streamingservice.infrastructure.database.repository.streaming

import br.com.udesc.ceavi.eso.ese.streamingservice.infrastructure.database.schema.streaming.StreamingSchema
import org.springframework.data.jpa.repository.JpaRepository

interface StreamingRepository : JpaRepository<StreamingSchema, String> {
    fun findByImdb(imdb: String): StreamingSchema?
}