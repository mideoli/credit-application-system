package me.dio.creditapplicationsystem.repository

import me.dio.creditapplicationsystem.entity.Credit
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface CreditRepository: JpaRepository<Credit, Long> {
    fun findByCreditCode(creditCode: UUID): Credit? //pode retornar um credit ou nao

    @Query(value = "SELECT * FROM CREDIT WHERE CUSTOMER_ID =?1", nativeQuery = true)
    fun findAllByCustomerId(customerId: Long): List<Credit>
}