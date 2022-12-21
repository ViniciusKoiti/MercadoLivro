package com.mercadolivro.controller.response

import com.mercadolivro.model.CustomerModel


data class BookResponse(

        var name : String,
        var price : Float,
        var customer : CustomerModel? = null
)