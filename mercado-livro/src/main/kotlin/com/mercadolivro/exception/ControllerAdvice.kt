package com.mercadolivro.exception

import com.mercadolivro.controller.response.ErrorResponse
import com.mercadolivro.controller.response.FieldErrorResponse
import com.mercadolivro.enums.Errors
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest


@ControllerAdvice
class ControllerAdvice {

    @ExceptionHandler(NotFoundException::class)
    fun handleException(ex:NotFoundException,request:WebRequest): ResponseEntity<ErrorResponse> {
        val error =  ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                ex.message,
                ex.errorCode,
                null
        )
        return ResponseEntity(error, HttpStatus.BAD_REQUEST)
    }
    @ExceptionHandler(BadResponseException::class)
    fun handleException(ex:BadResponseException,request:WebRequest): ResponseEntity<ErrorResponse> {
        val error =  ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                ex.message,
                ex.errorCode,
                null
        )
        return ResponseEntity(error, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleException(ex:MethodArgumentNotValidException,request:WebRequest): ResponseEntity<ErrorResponse> {
        val error =  ErrorResponse(
                HttpStatus.UNPROCESSABLE_ENTITY.value(),
                ex.message,
                Errors.ML001.code,
                ex.bindingResult.fieldErrors.map {
                    FieldErrorResponse(it.defaultMessage ?: "invalid",it.field)
                }
        )
        return ResponseEntity(error, HttpStatus.UNPROCESSABLE_ENTITY)
    }


}