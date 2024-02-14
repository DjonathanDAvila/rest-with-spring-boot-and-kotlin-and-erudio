package br.com.erudio.services

import br.com.erudio.model.Person
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicLong

@Service
class PersonService {
    private val counter: AtomicLong = AtomicLong()
    private val logger = java.util.logging.Logger.getLogger(PersonService::class.java.name)

    fun findAll(): List<Person> {
        logger.info("Finding all people!")

        val persons: MutableList<Person> = ArrayList()

        for (i in 0..7) {
            val person = mockPerson(i)
            persons.add(person)
        }
        return persons
    }

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

    fun create(person: Person) = person

    fun update(person: Person) = person

    fun delete(id: Long) {}

    private fun mockPerson(i: Int): Person {
        val person = Person()

        person.id = counter.incrementAndGet()
        person.firstName = "Person name $i"
        person.lasttName = "Las name $i"
        person.addrss = "Address $i"
        person.gender = "Gender $i"

        return person
    }
}