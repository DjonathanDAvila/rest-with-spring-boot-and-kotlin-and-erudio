package br.com.erudio.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime
import java.util.Currency
import java.util.Date

@Entity
@Table(name = "books")
data class Book(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,
    @Column(name = "author", nullable = false, length = 180)
    var author: String = "",
    @Column(name = "launch_date")
    var launch_date: Date? = null,
    @Column(name = "price")
    var price: Double = 0.0,
    @Column(name = "title", nullable = false, length = 250)
    var title: String = ""
)