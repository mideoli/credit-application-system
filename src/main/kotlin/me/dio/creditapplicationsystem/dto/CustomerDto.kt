package me.dio.creditapplicationsystem.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import me.dio.creditapplicationsystem.entity.Address
import me.dio.creditapplicationsystem.entity.Customer
import org.hibernate.validator.constraints.br.CPF
import java.math.BigDecimal

data class CustomerDto (
    @field:NotEmpty(message = "Field cannot be empty!") val firstName: String,
    @field:NotEmpty(message = "Field cannot be empty!") val lastName: String,
    @field:NotEmpty(message = "Field cannot be empty!")
    @CPF(message = "Invalid CPF") val cpf: String,
    @field:NotNull(message = "Income cannot be null!") val income: BigDecimal,
    @field:Email(message = "Invalid E-mail.")
    @field:NotEmpty(message = "Field cannot be empty!") val email: String,
    @field:NotEmpty(message = "Field cannot be empty!") val password: String,
    @field:NotEmpty(message = "Field cannot be empty!") val zipCode: String,
    @field:NotEmpty(message = "Field cannot be empty!") val street: String
) {

    fun toEntity(): Customer = Customer(
        firstName = this.firstName,
        lastName = this.lastName,
        cpf = this.cpf,
        income = this.income,
        email = this.email,
        password = this.password,
        address = Address(
            zipCode = this.zipCode,
            street = this.street
        )
    )
}
