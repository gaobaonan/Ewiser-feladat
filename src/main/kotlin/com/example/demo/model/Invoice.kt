package com.example.demo.model

data class Invoice(
    val id: String,
    val customerName: String,
    val issueDate: String,
    val dueDate: String,
    val itemName: String,
    val comment: String,
    val price: Double
)