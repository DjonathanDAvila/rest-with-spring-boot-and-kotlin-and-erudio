package br.com.erudio.services

import br.com.erudio.exception.ResourceNotFoundException
import br.com.erudio.model.Person
import br.com.erudio.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PersonService {

    @Autowired
    private lateinit var repository: PersonRepository

    private val logger = java.util.logging.Logger.getLogger(PersonService::class.java.name)

    fun findAll(): List<Person> {
        logger.info("Finding all people!")

        return repository.findAll()
    }

    fun findById(id: Long): Person {
        logger.info("Finding one person!")

        return repository.findById(id).orElseThrow { ResourceNotFoundException("No records found for this ID") }
    }

    fun create(person: Person): Person {
        logger.info("Creating one person name ${person.firstName}")
        return repository.save(person)
    }

    fun update(person: Person): Person {
        logger.info("Updatin one person with ID ${person.id}")

        val entity = repository.findById(person.id)
            .orElseThrow { ResourceNotFoundException("No records found for this ID") }

        entity.firstName = person.firstName
        entity.lasttName = person.lasttName
        entity.addrss = person.addrss
        entity.gender = person.gender

        return repository.save(entity)
    }

    fun delete(id: Long) {
        logger.info("Deleting one person with ID $id")

        val entity = repository.findById(id)
            .orElseThrow { ResourceNotFoundException("No records found for this ID") }
        repository.delete(entity)
    }
}