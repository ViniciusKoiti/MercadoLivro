package com.mercadolivro.controller.request

import com.fasterxml.jackson.annotation.JsonAlias
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty


data class PostCustomerRequest(
        @field:NotEmpty( message ="Name can not be empty")
        var name:String,
        @field:Email(message = "Send a email valid please")
    var email:String,
    @JsonAlias("customer_id")
    var customerId:Int
) {

}
