package br.com.udesc.ceavi.eso.ese.streamingservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class StreamingServiceApplication

fun main(args: Array<String>) {
	runApplication<StreamingServiceApplication>(*args)
}
