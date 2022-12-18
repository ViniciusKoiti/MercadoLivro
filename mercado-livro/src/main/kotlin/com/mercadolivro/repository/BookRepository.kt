package com.mercadolivro.repository

import com.mercadolivro.model.BookModel
import com.mercadolivro.model.CustomerModel
import com.mercadolivro.enums.BookStatus
import org.springframework.data.domain.Page
import org.springframework.data.jpa.repository.JpaRepository

interface BookRepository : JpaRepository<BookModel,Int> {

    fun findByNameContaining(name:String):List<BookModel>

    fun findByStatus(status: BookStatus):Page<BookModel>

    fun findByCustomer(customerModel: CustomerModel):List<BookModel>
}