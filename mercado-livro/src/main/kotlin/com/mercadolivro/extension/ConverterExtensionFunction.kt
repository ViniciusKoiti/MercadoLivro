package com.mercadolivro.extension

import com.mercadolivro.controller.request.PostBookRequest
import com.mercadolivro.controller.request.PostCustomerRequest
import com.mercadolivro.controller.request.PutBookRequest
import com.mercadolivro.controller.request.PutCustomerRequest
import com.mercadolivro.model.BookModel
import com.mercadolivro.model.CustomerModel
import com.mercadolivro.enums.BookStatus
import com.mercadolivro.enums.CustomerStatus

fun PostCustomerRequest.toCustomerModel():CustomerModel{
    return CustomerModel( name = this.name, email = this.email,status = CustomerStatus.ATIVO)
}

fun PutCustomerRequest.toCustomerModel(customer: CustomerModel):CustomerModel{
    return CustomerModel(id = customer.id ,name = customer.name, email = customer.email,status = customer.status)
}

fun PostBookRequest.toBookModel(customer: CustomerModel): BookModel {
    return BookModel(name = this.name,price = this.price, customer = customer, status = BookStatus.ATIVO)
}

fun PutBookRequest.toBookModel(book:BookModel): BookModel {
    return BookModel(
            id = book.id,
            name =  this.name ?: book.name,
            price = this.price ?: book.price,
            status = BookStatus.ATIVO,
            customer = book.customer
    )
}