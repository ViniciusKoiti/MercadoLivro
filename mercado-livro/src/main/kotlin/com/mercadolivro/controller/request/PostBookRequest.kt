package com.mercadolivro.controller.request

import com.fasterxml.jackson.annotation.JsonAlias
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class PostBookRequest(
        @field:NotEmpty(message = "Name can not be null")
        var name:String,
        @field:NotNull(message = "Price can not be null")
        var price:Float,
        @JsonAlias("customer_id")
        var customerId: Int
)
