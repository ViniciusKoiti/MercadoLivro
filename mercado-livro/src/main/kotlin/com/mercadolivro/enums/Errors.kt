package com.mercadolivro.enums

enum class Errors(val code:String,val message:String) {
    ML101("ML-101","Book [%s] not exists" ),
    ML102("ML-102","Book [%d] is [%s]"),
    ML201("ML-201","Customer [%] not exists"),

}