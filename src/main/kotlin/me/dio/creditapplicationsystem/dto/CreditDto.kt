package me.dio.creditapplicationsystem.dto

import jakarta.validation.constraints.Future
import jakarta.validation.constraints.NotNull
import me.dio.creditapplicationsystem.entity.Credit
import me.dio.creditapplicationsystem.entity.Customer
import java.math.BigDecimal
import java.time.LocalDate

data class CreditDto(
    @field:NotNull(message = "Credit cannot be null!") val creditValue: BigDecimal,
    @Future(message = "It must be a date in the future.") val dayFirstInstallment: LocalDate, // TODO: Desafio(Validar  a data da primeira parcela)
    val numberOfInstallments: Int, // TODO: Desafio( Validar aa quantidade de parcelas)
    @field:NotNull(message = "ID cannot be null!")val customerId: Long
) {

    fun toEntity(): Credit = Credit(

        creditValue = this.creditValue,
        dayFirstInstallment = this.dayFirstInstallment,
        numberOfInstallments = this.numberOfInstallments,
        customer = Customer(id = this.customerId)
    )

}
