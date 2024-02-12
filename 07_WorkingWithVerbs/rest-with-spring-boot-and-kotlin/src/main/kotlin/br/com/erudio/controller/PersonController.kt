package br.com.erudio.controller

import br.com.erudio.model.Person
import br.com.erudio.services.PersonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
@RequestMapping("/person")
class PersonController {

    val counter: AtomicLong = AtomicLong()

    @Autowired // Quem vai fazer a instanciação é o Spring
    private lateinit var service: PersonService

    /*Substitui ->
      var service: PersonService = PersonService()*/
    @RequestMapping(
        value = ["/{id}"], method = [RequestMethod.GET],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun sum(@PathVariable(value = "id") id: Long): Person {
        return service.findById(id)
    }
}