package br.com.udesc.ceavi.eso.ese.streamingservice.infrastructure.streaming.controller

import br.com.udesc.ceavi.eso.ese.streamingservice.entity.streaming.model.Streaming
import br.com.udesc.ceavi.eso.ese.streamingservice.useCase.streaming.CreateStreamingUseCase
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/streaming-web-service/api/streamings")
class CreateStreamingController(private val createStreamingUseCase: CreateStreamingUseCase) {

    val logger: Logger = LoggerFactory.getLogger(CreateStreamingController::class.java)

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    fun createStreaming(@RequestBody request: Request): Response {
        val response = Response(
            createStreamingUseCase.execute(
                CreateStreamingUseCase.Input(
                    imdb = request.imdb,
                    avaliables = request.avaliables
                )
            ).streaming
        )
        logger.info("Streaming Created")
        return response
    }

    data class Request(
        val imdb: String,
        val avaliables: List<String>
    )

    data class Response(
        val streaming: Streaming
    )
}