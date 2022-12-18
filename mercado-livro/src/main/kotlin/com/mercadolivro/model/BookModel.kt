package com.mercadolivro.model

import com.mercadolivro.enums.BookStatus
import javax.persistence.*

@Entity(name = "book")
data class BookModel(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id : Int? = null,
        @Column
        var name : String,
        @Column
        var price : Float,


        @ManyToOne
        @JoinColumn(name = "customer_id" )
        var customer : CustomerModel? = null
){

        @Column
        @Enumerated(EnumType.STRING)
        var status: BookStatus? = null
                set(value){
                        if(field == BookStatus.CANCELADO || field == BookStatus.DELETADO){
                                throw Exception("")
                        }

                        field = value
                }

        constructor(id: Int? = null,
                    name:String,
                        price:Float,
                        customer:CustomerModel? = null,
                        status:BookStatus?): this(id,name,price,customer){
                                this.status =  status
                        }

}