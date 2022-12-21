package com.mercadolivro.exception

class BadResponseException(override val message: String?,val errorCode:String):Exception()  {
}