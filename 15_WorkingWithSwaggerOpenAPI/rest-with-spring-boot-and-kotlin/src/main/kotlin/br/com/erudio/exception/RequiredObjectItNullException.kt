package br.com.erudio.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus
import java.lang.RuntimeException

@ResponseStatus(HttpStatus.NOT_FOUND)
class RequiredObjectItNullException : RuntimeException {
    constructor() : super("It is not allowed to persist a null object!")
    constructor(exception: String?) : super("It is not allowed to persist a null object!")
}