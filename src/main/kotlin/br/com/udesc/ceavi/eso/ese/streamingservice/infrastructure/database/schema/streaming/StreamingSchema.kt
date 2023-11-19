package br.com.udesc.ceavi.eso.ese.streamingservice.infrastructure.database.schema.streaming

import jakarta.persistence.*

@Entity
@Table(name = "streaming")
data class StreamingSchema(
    @Id
    val imdb: String,
    val avaliables: String
) {
    constructor() : this("", "")
}
