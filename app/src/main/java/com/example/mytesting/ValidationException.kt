package com.example.mytesting

sealed class ValidationException : Exception(){
    class InvalidEmptyPhoneException : ValidationException()
    class InvalidPhoneInputTypeException : ValidationException()
    class InvalidPhoneLengthException : ValidationException()

    class InvalidEmptyEmailException : ValidationException()
    class InvalidEmailPatternException : ValidationException()

}