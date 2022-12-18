package com.mercadolivro.exception

import com.mercadolivro.controller.response.ErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest


@ControllerAdvice
class ControllerAdvice {

    @ExceptionHandler(Exception::class)
    fun handleException(ex:Exception,request:WebRequest): ResponseEntity<ErrorResponse> {
        var error =  ErrorResponse(
                400,
                "Esse Recurso não existe",
            "00001",
                null
        )
        return ResponseEntity(error, HttpStatus.BAD_REQUEST)
    }
}