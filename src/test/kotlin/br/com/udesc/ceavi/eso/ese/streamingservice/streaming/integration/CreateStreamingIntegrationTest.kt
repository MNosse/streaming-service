package br.com.udesc.ceavi.eso.ese.streamingservice.streaming.integration

import br.com.udesc.ceavi.eso.ese.streamingservice.infrastructure.streaming.controller.CreateStreamingController
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class CreateStreamingIntegrationTest @Autowired constructor(
    private val createStreamingController: CreateStreamingController
) {
    private val imdb = "tt1375670"
    private val avaliables = listOf("Amazon Prime", "HBO Max", "Netflix")

    @Test
    fun test() {
        assertDoesNotThrow {
            createStreamingController.createStreaming(
                CreateStreamingController.Request(
                    imdb = imdb,
                    avaliables = avaliables
                )
            ).streaming.let { streaming ->
                assert(
                    streaming.imdb == imdb
                            && streaming.avaliables == avaliables
                )
            }
        }
    }
}