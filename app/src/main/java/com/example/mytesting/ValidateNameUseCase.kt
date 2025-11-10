package com.example.mytesting

class ValidateNameUseCase {
    operator fun invoke(name: String)  = name.length >= 2
}