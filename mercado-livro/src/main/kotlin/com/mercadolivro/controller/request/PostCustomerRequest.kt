package com.mercadolivro.controller.request

import com.fasterxml.jackson.annotation.JsonAlias


data class PostCustomerRequest(
    var name:String,
    var email:String,
    @JsonAlias("customer_id")
    var customerId:Int
) {

}
