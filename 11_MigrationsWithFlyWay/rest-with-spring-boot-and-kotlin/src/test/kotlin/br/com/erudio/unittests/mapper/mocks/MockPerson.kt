package br.com.erudio.unittests.mapper.mocks

import java.util.ArrayList
import br.com.erudio.data.vo.v1.PersonVO
import br.com.erudio.model.Person

class MockPerson {
    fun mockEntity(): Person {
        return mockEntity(0)
    }

    fun mockVO(): PersonVO {
        return mockVO(0)
    }

    fun mockEntityList(): ArrayList<Person> {
        val persons: ArrayList<Person> = ArrayList<Person>()
        for (i in 0..13) {
            persons.add(mockEntity(i))
        }
        return persons
    }

    fun mockVOList(): ArrayList<PersonVO> {
        val persons: ArrayList<PersonVO> = ArrayList()
        for (i in 0..13) {
            persons.add(mockVO(i))
        }
        return persons
    }

    fun mockEntity(number: Int): Person {
        val person = Person()
        person.id = number.toLong()
        person.firstName = "First Name Test$number"
        person.lastName = "Last Name Test$number"
        person.address = "Address Test$number"
        person.gender = if (number % 2 == 0) "Male" else "Female"
        return person
    }

    fun mockVO(number: Int): PersonVO {
        val person = PersonVO()
        person.id = number.toLong()
        person.firstName = "First Name Test$number"
        person.lastName = "Last Name Test$number"
        person.address = "Address Test$number"
        person.gender = if (number % 2 == 0) "Male" else "Female"

        return person
    }
}