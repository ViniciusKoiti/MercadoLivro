package com.mercadolivro.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity(name = "purchase")
data class PurchaseModel(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id:Int? = null,
) {
}