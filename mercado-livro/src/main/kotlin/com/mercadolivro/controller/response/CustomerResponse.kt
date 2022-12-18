package com.mercadolivro.controller.response

import com.mercadolivro.enums.CustomerStatus

data class CustomerResponse(
        var name: String,
        var status: CustomerStatus
)