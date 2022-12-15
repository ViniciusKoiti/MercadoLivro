package com.mercadolivro.service

import com.mercadolivro.model.BookModel
import com.mercadolivro.model.CustomerModel
import com.mercadolivro.repository.BookRepository
import com.mercadolivro.enums.BookStatus
import org.springframework.stereotype.Service

@Service
class BookService(
        val bookRepository : BookRepository
) {
    fun getAll(name:String?): List<BookModel> {
        name?.let{
            bookRepository.findByNameContaining(name)
        }

        return bookRepository.findAll().toList()

    }

    fun create(book: BookModel){
        bookRepository.save(book)
    }

    fun getBookById(id:Int): BookModel {
        return bookRepository.findById(id).orElseThrow()
    }
    fun getActives(): List<BookModel>{
        return bookRepository.findByStatus(BookStatus.ATIVO)
    }

    fun update(book: BookModel){

        if(!bookRepository.existsById(book.id!!)){
            throw Exception()
        }
        else{
            bookRepository.save(book)
        }

    }
    fun delete(id:Int){
        val book = getBookById(id)
        book.status = BookStatus.CANCELADO

        bookRepository.save(book)
    }
    fun deleteByCustomer(customer: CustomerModel){

        val books = bookRepository.findByCustomer(customer)
        for(book in books){
            book.status = BookStatus.CANCELADO
        }
        bookRepository.saveAll(books)
    }
}