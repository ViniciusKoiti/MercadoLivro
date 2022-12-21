package com.mercadolivro.controller.request

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class PutBookRequest(
        @field:NotEmpty(message = "Name can't be null")
        var name:String?,
        @field:NotNull
        var price:Float?
)
