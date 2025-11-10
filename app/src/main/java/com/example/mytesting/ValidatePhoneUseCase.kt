package com.example.mytesting

class ValidatePhoneUseCase {
    operator fun invoke(phone: String): ValidationResult {
        if (phone.isBlank())
            return ValidationResult(false, ValidationException.InvalidEmptyPhoneException())
        else if (!phone.matches(Regex("^[0-9]+$")))
            return ValidationResult(false, ValidationException.InvalidPhoneInputTypeException())
        else if (phone.length != 10)
            return ValidationResult(false, ValidationException.InvalidPhoneLengthException())
         else
            return ValidationResult(isSuccess = true)
    }
}


