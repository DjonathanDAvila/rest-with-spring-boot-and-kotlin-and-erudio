package br.com.erudio.repository

import br.com.erudio.model.Person
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

interface PersonRepository : JpaRepository<Person, Long?> {
}