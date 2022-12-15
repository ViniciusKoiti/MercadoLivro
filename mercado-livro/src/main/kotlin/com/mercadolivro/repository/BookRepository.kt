package com.mercadolivro.repository

import com.mercadolivro.model.BookModel
import com.mercadolivro.model.CustomerModel
import com.mercadolivro.enums.BookStatus
import org.springframework.data.repository.CrudRepository

interface BookRepository : CrudRepository<BookModel,Int> {

    fun findByNameContaining(name:String):List<BookModel>

    fun findByStatus(status: BookStatus):List<BookModel>

    fun findByCustomer(customerModel: CustomerModel):List<BookModel>
}