package br.com.erudio.mockito.services

import br.com.erudio.repository.PersonRepository
import br.com.erudio.services.PersonService
import br.com.erudio.unittests.mapper.mocks.MockPerson
import org.hibernate.service.spi.InjectService
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock

import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.mockito.junit.jupiter.MockitoExtension
import java.util.*

@ExtendWith(MockitoExtension::class)
internal class PersonServiceTest {

    private lateinit var inputObject: MockPerson

    @InjectMocks
    private lateinit var service: PersonService

    @Mock
    private lateinit var repository: PersonRepository

    @BeforeEach
    fun setUpMock() {
        inputObject = MockPerson()
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun findAll() {
    }

    @Test
    fun findById() {
        val person = inputObject.mockEntity(1)
        person.id = 1L
        `when`(repository.findById(1)).thenReturn(Optional.of(person))

        val result = service.findById(1)

        assertNotNull(result)
        assertNotNull(result.idPerson)
        assertNotNull(result.links)
        println(result.links)
        assertTrue(result.links.toString().contains("</api/person/v1/1>;rel=\"self\""))
        assertEquals("Address Test1", result.address)
        assertEquals("First Name Test1", result.firstName)
        assertEquals("Last Name Test1", result.lastName)
        assertEquals("Female", result.gender)
    }

    @Test
    fun create() {
        val entity = inputObject.mockEntity(1)

        val persisted = entity.copy()
        persisted.id = 1

        `when`(repository.save(entity)).thenReturn(persisted)

        val vo = inputObject.mockVO(1)
        val result = service.create(vo)

        assertNotNull(result)
        assertNotNull(result.idPerson)
        assertNotNull(result.links)
        println(result.links)
        assertTrue(result.links.toString().contains("</api/person/v1/1>;rel=\"self\""))
        assertEquals("Address Test1", result.address)
        assertEquals("First Name Test1", result.firstName)
        assertEquals("Last Name Test1", result.lastName)
        assertEquals("Female", result.gender)
    }

    @Test
    fun update() {
        val entity = inputObject.mockEntity(1)

        val persisted = entity.copy()
        persisted.id = 1

        `when`(repository.findById(1)).thenReturn(Optional.of(entity))
        `when`(repository.save(entity)).thenReturn(persisted)

        val vo = inputObject.mockVO(1)
        val result = service.update(vo)

        assertNotNull(result)
        assertNotNull(result.idPerson)
        assertNotNull(result.links)
        println(result.links)
        assertTrue(result.links.toString().contains("</api/person/v1/1>;rel=\"self\""))
        assertEquals("Address Test1", result.address)
        assertEquals("First Name Test1", result.firstName)
        assertEquals("Last Name Test1", result.lastName)
        assertEquals("Female", result.gender)
    }

    @Test
    fun delete() {
        val entity = inputObject.mockEntity(1)
        `when`(repository.findById(1)).thenReturn(Optional.of(entity))
        service.delete(1)
    }
}