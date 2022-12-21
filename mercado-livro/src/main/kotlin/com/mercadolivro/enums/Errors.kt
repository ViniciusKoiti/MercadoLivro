package com.mercadolivro.enums

enum class Errors(val code:String,val message:String) {
    ML001("ML001","Invallid request") ,
    ML101("ML-101","Book [%s] not exists" ),
    ML102("ML-102","Book [%d] is [%s] can by updated"),
    ML201("ML-201","Customer [%] not exists"),


}