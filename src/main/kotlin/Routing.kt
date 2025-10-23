package com.matt

import com.matt.about.AboutService
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hello World!")
        }

        get("/version") {
            call.respondText(AboutService.version())
        }
    }
}
