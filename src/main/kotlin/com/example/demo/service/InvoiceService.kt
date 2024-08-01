package com.example.demo.service

import com.example.demo.model.Invoice
import org.springframework.stereotype.Service
import java.util.concurrent.ConcurrentHashMap

@Service
class InvoiceService {
    private val invoices = ConcurrentHashMap<String, Invoice>()

    fun save(invoice: Invoice): Invoice {
        invoices[invoice.id] = invoice
        return invoice
    }

    fun findAll(): List<Invoice> = invoices.values.toList()

    fun deleteById(id: String): Boolean {
        return invoices.remove(id) != null
    }
}
