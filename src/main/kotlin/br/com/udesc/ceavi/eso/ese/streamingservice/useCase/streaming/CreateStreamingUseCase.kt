package br.com.udesc.ceavi.eso.ese.streamingservice.useCase.streaming

import br.com.udesc.ceavi.eso.ese.streamingservice.entity.streaming.gateway.StreamingGateway
import br.com.udesc.ceavi.eso.ese.streamingservice.entity.streaming.model.Streaming
import org.springframework.stereotype.Service

@Service
class CreateStreamingUseCase(
    private val streamingGateway: StreamingGateway
) {
    fun execute(input: Input): Output {
        return Output(
            streamingGateway.create(
                imdb = input.imdb,
                avaliables = input.avaliables
            )
        )
    }

    data class Input(
        val imdb: String,
        val avaliables: List<String>
    )

    data class Output(
        val streaming: Streaming
    )
}