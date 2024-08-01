package com.example.demo.controller

import com.example.demo.model.Invoice
import com.example.demo.service.InvoiceService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/invoices")
class InvoiceController(private val invoiceService: InvoiceService) {

    @PostMapping
    fun createInvoice(@RequestBody invoice: Invoice): ResponseEntity<Invoice> {
        return ResponseEntity(invoiceService.save(invoice), HttpStatus.CREATED)
    }

    @GetMapping
    fun getInvoices(): List<Invoice> {
        return invoiceService.findAll()
    }
    
    @DeleteMapping("/{id}")
    fun deleteInvoice(@PathVariable id: String): ResponseEntity<Void> {
        return if (invoiceService.deleteById(id)) {
            ResponseEntity(HttpStatus.NO_CONTENT)
        } else {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }

    }
}
