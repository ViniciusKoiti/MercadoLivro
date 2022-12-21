package com.mercadolivro.service

import com.mercadolivro.enums.Errors
import com.mercadolivro.exception.NotFoundException
import com.mercadolivro.model.CustomerModel
import com.mercadolivro.repository.CustomerRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class CustomerService(
        val customerRepository: CustomerRepository,
        val bookService: BookService
        ) {


    fun getAll(name:String?,pageable:Pageable): Page<CustomerModel> {
        name?.let{
            customerRepository.findByNameContaining(name,pageable)
        }

        return customerRepository.findAll(pageable)

    }

    fun create(customer: CustomerModel){
        customerRepository.save(customer)
    }

    fun getCustomerById(id:Int):CustomerModel{
        return customerRepository.findById(id).orElseThrow()
    }

    fun update(customer: CustomerModel){

        if(!customerRepository.existsById(customer.id!!)){
            throw NotFoundException(Errors.ML201.message.format(customer.id),Errors.ML201.code)
        }
        else{
            customerRepository.save(customer)
        }

    }

    fun delete(id:Int){
        val customer = getCustomerById(id)

        bookService.deleteByCustomer(customer)

        customerRepository.deleteById(id)
    }

    fun emailAvailable(email: String): Boolean {
        return !customerRepository.existsByEmail(email)
    }


}