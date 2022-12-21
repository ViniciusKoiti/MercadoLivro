package com.mercadolivro.validation

import javax.validation.Constraint
import javax.validation.Payload
import kotlin.annotation.AnnotationRetention.*
import kotlin.reflect.KClass

@Constraint(validatedBy = [EmailAvailableValidator::class])
@Retention(RUNTIME)
@Target(AnnotationTarget.FIELD)
annotation class EmailAvailable(
    val message:String = "This email is already in use",
    val groups: Array<KClass<*>> = [],
    val payload:Array<KClass<out Payload>> = []

)