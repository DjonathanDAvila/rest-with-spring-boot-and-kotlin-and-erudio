package br.com.erudio.services

import br.com.erudio.model.Person
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicLong

@Service
class PersonService {
    private val counter: AtomicLong = AtomicLong()
    private val logger = java.util.logging.Logger.getLogger(PersonService::class.java.name)

    fun findById(id: Long): Person {
        logger.info("Finding one person!")

        val person = Person()
        person.id = counter.incrementAndGet()
        person.firstName = "Djonathan"
        person.lasttName = "D'Avila"
        person.addrss = "Indaial - Santa Catarina - Brasil"
        person.gender = "Male"

        return person
    }
}