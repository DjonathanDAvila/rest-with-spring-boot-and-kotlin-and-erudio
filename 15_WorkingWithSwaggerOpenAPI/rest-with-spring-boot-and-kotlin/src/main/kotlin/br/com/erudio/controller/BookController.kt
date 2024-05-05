package br.com.erudio.controller

import br.com.erudio.data.vo.v1.BookVO
import br.com.erudio.services.BookService
import br.com.erudio.util.MediaType
import jakarta.websocket.server.PathParam
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/book/v1")
class BookController {

    @Autowired
    private lateinit var service: BookService

    @GetMapping(produces = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML])
    fun findAll(): List<BookVO> {
        return service.findAll()
    }

    @GetMapping(
        value = ["/{id}"],
        produces = [MediaType.APPLICATION_JSON]
    )
    fun findById(@PathVariable(value = "id") id: Long): BookVO {
        return service.findById(id)
    }

    @PostMapping(
        consumes = [MediaType.APPLICATION_JSON],
        produces = [MediaType.APPLICATION_JSON]
    )
    fun create(@RequestBody book: BookVO): BookVO {
        return service.create(book)
    }

    @PutMapping(
        consumes = [MediaType.APPLICATION_JSON],
        produces = [MediaType.APPLICATION_JSON]
    )
    fun update(@RequestBody book: BookVO): BookVO {
        return service.update(book)
    }

    @DeleteMapping(
        value = ["/{id}"],
        produces = [MediaType.APPLICATION_JSON]
    )
    fun delete(@PathVariable(value = "id") id: Long): ResponseEntity<*> {
        service.delete(id)
        return ResponseEntity.noContent().build<Any>()
    }
}