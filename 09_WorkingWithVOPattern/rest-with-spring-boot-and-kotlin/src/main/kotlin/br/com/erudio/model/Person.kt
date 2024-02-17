package br.com.erudio.model

import jakarta.persistence.*

@Entity
@Table(name = "person")
data class Person(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @Column(name = "first_name", nullable = false, length = 80)
    var firstName: String = "",
    @Column(name = "last_name", nullable = false, length = 80)
    var lasttName: String = "",
    @Column(nullable = false, length = 80)
    var addrss: String = "",
    @Column(nullable = false, length = 80)
    var gender: String = "",
)