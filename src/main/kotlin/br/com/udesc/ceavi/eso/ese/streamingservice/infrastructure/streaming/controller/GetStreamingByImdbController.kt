package br.com.udesc.ceavi.eso.ese.streamingservice.infrastructure.streaming.controller

import br.com.udesc.ceavi.eso.ese.streamingservice.entity.streaming.model.Streaming
import br.com.udesc.ceavi.eso.ese.streamingservice.useCase.streaming.GetStreamingByImdbUseCase
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/streaming-web-service/api/streamings")
class GetStreamingByImdbController(private val getStreamingByImdbUseCase: GetStreamingByImdbUseCase) {

    val logger: Logger = LoggerFactory.getLogger(GetStreamingByImdbController::class.java)

    @GetMapping("/{imdb}/")
    @ResponseStatus(HttpStatus.OK)
    fun getStreamingByImdb(@RequestParam imdb: String): Response {
        val response = Response(
            getStreamingByImdbUseCase.execute(
                input = GetStreamingByImdbUseCase.Input(
                    imdb = imdb
                )
            ).streaming
        )
        if (response.streaming != null) {
            logger.info("Streaming Retrieved")
        } else {
            logger.info("Streaming Not Found")
        }
        return response
    }

    data class Response(
        val streaming: Streaming?
    )
}