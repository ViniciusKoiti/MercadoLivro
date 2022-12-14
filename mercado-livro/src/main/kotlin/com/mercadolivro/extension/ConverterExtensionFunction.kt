package com.mercadolivro.extension

import com.mercadolivro.controller.request.PostBookRequest
import com.mercadolivro.controller.request.PostCustomerRequest
import com.mercadolivro.controller.request.PutBookRequest
import com.mercadolivro.controller.request.PutCustomerRequest
import com.mercadolivro.model.BookModel
import com.mercadolivro.model.CustomerModel
import enums.BookStatus

fun PostCustomerRequest.toCustomerModel():CustomerModel{
    return CustomerModel( name = this.name, email = this.email)
}

fun PutCustomerRequest.toCustomerModel(id:Int):CustomerModel{
    return CustomerModel(id = id ,name = this.name, email = this.email)
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