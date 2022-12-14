package com.mercadolivro.model

import com.mercadolivro.enums.BookStatus
import com.mercadolivro.enums.Errors
import com.mercadolivro.exception.BadResponseException
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
                                throw BadResponseException(Errors.ML102.message.format(id),Errors.ML102.code)
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