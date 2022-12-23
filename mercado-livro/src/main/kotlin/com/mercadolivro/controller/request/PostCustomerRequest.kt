package com.mercadolivro.controller.request

import com.fasterxml.jackson.annotation.JsonAlias
import com.mercadolivro.validation.EmailAvailable
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty


data class PostCustomerRequest(
        @field:NotEmpty( message ="Name can not be empty")
        var name:String,
        @field:Email(message = "Send a email valid please")
        @EmailAvailable
    var email:String,
    @JsonAlias("customer_id")
    var customerId:Int
) {

}
