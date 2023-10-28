package com.mercadolivro.controller.request

import org.jetbrains.annotations.NotNull
import javax.validation.constraints.Positive

data class PostPurchaseRequest(
        @NotNull
        @Positive
        val customerId: Int,

        val booksIds: Set<Int>,
) {
}