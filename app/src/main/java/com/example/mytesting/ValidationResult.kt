package com.example.mytesting

data class ValidationResult(
    val isSuccess: Boolean,
    val exception: ValidationException? = null
)
