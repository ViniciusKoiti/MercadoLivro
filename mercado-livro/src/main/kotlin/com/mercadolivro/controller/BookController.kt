package com.mercadolivro.controller

import com.mercadolivro.controller.request.PostBookRequest
import com.mercadolivro.controller.request.PutBookRequest
import com.mercadolivro.extension.toBookModel
import com.mercadolivro.model.BookModel
import com.mercadolivro.service.BookService
import com.mercadolivro.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("book")
class BookController (
        val bookService : BookService,
        val customerService : CustomerService
        ){
    @GetMapping
    fun getAll(@RequestParam name:String?): List<BookModel> {
        return bookService.getAll(name);
    }

    @GetMapping("/active")
    fun getActives():List<BookModel>{
        return bookService.getActives();
    }

    @GetMapping("/{id}")
    fun getCustomer(@PathVariable id:Int): BookModel {
        return bookService.getBookById(id);
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
