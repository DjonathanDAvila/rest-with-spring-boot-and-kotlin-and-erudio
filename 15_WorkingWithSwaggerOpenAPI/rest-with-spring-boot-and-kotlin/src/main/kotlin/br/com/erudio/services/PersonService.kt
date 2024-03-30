package br.com.erudio.services

import br.com.erudio.controller.PersonController
import br.com.erudio.data.vo.v1.PersonVO
import br.com.erudio.exception.RequiredObjectItNullException
import br.com.erudio.exception.ResourceNotFoundException
import br.com.erudio.mapper.DozerMapper
import br.com.erudio.model.Person
import br.com.erudio.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo
import org.springframework.stereotype.Service

@Service
class PersonService {

    @Autowired
    private lateinit var repository: PersonRepository

    private val logger = java.util.logging.Logger.getLogger(PersonService::class.java.name)

    fun findAll(): List<PersonVO> {
        logger.info("Finding all people!")

        val persons = repository.findAll()

        val vos = DozerMapper.parseListObjects(persons, PersonVO::class.java)
        for (person in vos) {
            val withSelfRel = linkTo(PersonController::class.java).slash(person.idPerson).withSelfRel()
            person.add(withSelfRel)
        }

        return vos
    }

    fun findById(id: Long): PersonVO {
        logger.info("Finding one person with ID $id!")

        var person = repository.findById(id).orElseThrow { ResourceNotFoundException("No records found for this ID") }
        val personVO: PersonVO = DozerMapper.parseObject(person, PersonVO::class.java)
        val withSelfRel = linkTo(PersonController::class.java).slash(personVO.idPerson).withSelfRel()
        personVO.add(withSelfRel)

        return personVO
    }

    fun create(person: PersonVO?): PersonVO {
        if (person == null) throw RequiredObjectItNullException()
        logger.info("Creating one person name ${person.firstName}")
        val entity: Person = DozerMapper.parseObject(person, Person::class.java)
        val personVO: PersonVO = DozerMapper.parseObject(repository.save(entity), PersonVO::class.java)
        val withSelfRel = linkTo(PersonController::class.java).slash(personVO.idPerson).withSelfRel()
        personVO.add(withSelfRel)

        return personVO
    }

    fun update(person: PersonVO?): PersonVO {
        if (person == null) throw RequiredObjectItNullException()
        logger.info("Updatin one person with ID ${person.idPerson}")

        val entity = repository.findById(person.idPerson)
                .orElseThrow { ResourceNotFoundException("No records found for this ID") }

        entity.firstName = person.firstName
        entity.lastName = person.lastName
        entity.address = person.address
        entity.gender = person.gender

        val personVO: PersonVO = DozerMapper.parseObject(repository.save(entity), PersonVO::class.java)
        val withSelfRel = linkTo(PersonController::class.java).slash(personVO.idPerson).withSelfRel()
        personVO.add(withSelfRel)

        return personVO
    }

    fun delete(id: Long) {
        logger.info("Deleting one person with ID $id")

        val entity = repository.findById(id)
                .orElseThrow { ResourceNotFoundException("No records found for this ID") }
        repository.delete(entity)
    }
}