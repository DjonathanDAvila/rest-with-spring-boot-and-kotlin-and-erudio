package br.com.erudio.services

import br.com.erudio.controller.BookController
import br.com.erudio.data.vo.v1.BookVO
import br.com.erudio.exception.ResourceNotFoundException
import br.com.erudio.mapper.DozerMapper
import br.com.erudio.model.Book
import br.com.erudio.repository.BookRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo
import org.springframework.stereotype.Service

@Service
class BookService {
    @Autowired
    private lateinit var repository: BookRepository

    fun findAll(): List<BookVO> {
        val book = repository.findAll()
        val vos = DozerMapper.parseListObjects(book, BookVO::class.java)

        for (book in vos) {
            val withSelRef = linkTo(BookController::class.java).slash(book.idBook).withSelfRel()
            book.add(withSelRef)
        }

        return vos
    }

    fun findById(id: Long): BookVO {
        val book = repository.findById(id).orElseThrow { ResourceNotFoundException("No records found for this ID") }
        val bookVO: BookVO = DozerMapper.parseObject(book, BookVO::class.java)

        return bookVO
    }

    fun create(book: BookVO): BookVO {
        val entity: Book = DozerMapper.parseObject(book, Book::class.java)
        val bookVO: BookVO = DozerMapper.parseObject(repository.save(entity), BookVO::class.java)

        return bookVO
    }

    fun update(book: BookVO): BookVO {
        val entity = repository.findById(book.idBook)
            .orElseThrow { ResourceNotFoundException("No records found for this ID") }

        entity.author = book.author
        entity.launch_date = book.launch_date
        entity.price = book.price
        entity.title = book.title

        val bookVO: BookVO = DozerMapper.parseObject(repository.save(entity), BookVO::class.java)

        return bookVO
    }

    fun delete(id: Long) {
        val entity = repository.findById(id)
            .orElseThrow { ResourceNotFoundException("No records found for this ID") }
        repository.delete(entity)
    }
}