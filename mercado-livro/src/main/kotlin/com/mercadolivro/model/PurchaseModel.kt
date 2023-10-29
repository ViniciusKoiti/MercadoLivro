package com.mercadolivro.model

import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.*

@Entity(name = "purchase")
data class PurchaseModel(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id:Int? = null,

        @ManyToOne
        @JoinColumn(name = "customer_id")
        val customerModel: CustomerModel,

        @ManyToMany
        @JoinTable( name = "purchase_books",
                joinColumns = [JoinColumn(name = "purchase_id")],
                inverseJoinColumns = [JoinColumn(name = "books_id")])
        val books: List<BookModel>,

        @Column
        val nfe: String,
        @Column
        val price: BigDecimal,

        @Column(name = "created_at")
        val createdAt: LocalDateTime


) {
}