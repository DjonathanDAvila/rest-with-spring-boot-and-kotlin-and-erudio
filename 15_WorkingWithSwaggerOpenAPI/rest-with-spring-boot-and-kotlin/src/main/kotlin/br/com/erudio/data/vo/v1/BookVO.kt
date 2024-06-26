package br.com.erudio.data.vo.v1

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyOrder
import com.github.dozermapper.core.Mapping
import org.springframework.hateoas.RepresentationModel
import java.util.*

@JsonPropertyOrder("id","author","launch_date","price","title")
data class BookVO(
    @Mapping("id")
    @field:JsonProperty("id")
    var idBook: Long = 0,
    var author: String = "",
    var launch_date: Date? = null,
    var price: Double = 0.0,
    var title: String = ""
) : RepresentationModel<BookVO>()
