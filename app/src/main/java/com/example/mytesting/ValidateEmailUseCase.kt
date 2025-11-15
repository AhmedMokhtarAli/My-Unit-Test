package com.example.mytesting

class ValidateEmailUseCase {
    operator fun invoke(email: String) : ValidationResult {
     val emailRegex = Regex("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")

        if (email.isBlank())
            return ValidationResult(isSuccess = false, exception = ValidationException.InvalidEmptyEmailException())
        else if (email.matches(regex = emailRegex).not())
            return ValidationResult(isSuccess = false, exception = ValidationException.InvalidEmailPatternException())
        else
            return ValidationResult(isSuccess = true, exception = null)
    }
}