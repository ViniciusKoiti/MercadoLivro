package com.mercadolivro.controller

import com.mercadolivro.controller.request.PostBookRequest
import com.mercadolivro.controller.request.PutBookRequest
import com.mercadolivro.controller.response.BookResponse
import com.mercadolivro.extension.toBookModel
import com.mercadolivro.extension.toResponse
import com.mercadolivro.model.BookModel
import com.mercadolivro.service.BookService
import com.mercadolivro.service.CustomerService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("book")
class BookController (
        val bookService : BookService,
        val customerService : CustomerService
        ){
    @GetMapping
    fun getAll(@RequestParam name:String?,pageable: Pageable): Page<BookResponse> {
        return bookService.getAll(name,pageable).map{
            it.toResponse(it)
        };
    }

    @GetMapping("/active")
    fun getActives():Page<BookModel>{
        return bookService.getActives();
    }

    @GetMapping("/{id}")
    fun getCustomer(@PathVariable id:Int): BookResponse {
        return bookService.getBookById(id).toResponse(bookService.getBookById(id));
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody book: PostBookRequest){
        val customer = customerService.getCustomerById(book.customerId)
        bookService.create(book.toBookModel(customer))
    }


    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id:Int, @RequestBody book: PutBookRequest){
        val bookSaved = bookService.getBookById(id)
        bookService.update(book.toBookModel(bookSaved))
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id:Int){
        return bookService.delete(id);
    }


}
