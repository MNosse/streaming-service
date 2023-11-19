package br.com.udesc.ceavi.eso.ese.streamingservice.infrastructure.streaming.gateway

import br.com.udesc.ceavi.eso.ese.streamingservice.entity.streaming.gateway.StreamingGateway
import br.com.udesc.ceavi.eso.ese.streamingservice.entity.streaming.model.Streaming
import br.com.udesc.ceavi.eso.ese.streamingservice.infrastructure.database.repository.streaming.StreamingRepository
import br.com.udesc.ceavi.eso.ese.streamingservice.infrastructure.database.schema.streaming.StreamingSchema
import br.com.udesc.ceavi.eso.ese.streamingservice.infrastructure.streaming.gateway.converter.convert
import org.springframework.stereotype.Component

@Component
class StreamingDatabaseGateway(private val streamingRepository: StreamingRepository) : StreamingGateway {
    override fun create(imdb: String, avaliables: List<String>): Streaming {
        return convert(
            streamingRepository.save(
                StreamingSchema(
                    imdb = imdb,
                    avaliables = avaliables.joinToString(";")
                )
            )
        )
    }

    override fun getByImdb(imdb: String): Streaming? {
        return streamingRepository.findByImdb(imdb)?.let { streaming ->
            convert(streaming)
        }
    }

}