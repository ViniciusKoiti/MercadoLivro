package com.mercadolivro.repository

import com.mercadolivro.model.BookModel
import com.mercadolivro.model.CustomerModel
import com.mercadolivro.enums.BookStatus
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface BookRepository : JpaRepository<BookModel,Int> {

    fun findByNameContaining(name:String,pageable: Pageable):Page<BookModel>

    fun findByStatus(status: BookStatus,pageable: Pageable):Page<BookModel>

    fun findByCustomer(customerModel: CustomerModel):List<BookModel>
}