package com.example.mytesting

import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import org.junit.Before
import org.junit.Test
import kotlin.test.assertNull

class ValidatePhoneUseCaseTest {
    private lateinit var validatePhoneUseCase: ValidatePhoneUseCase

    @Before
    fun setUp() {
        validatePhoneUseCase = ValidatePhoneUseCase()
    }

    @Test
    fun given_empty_phone_number_when_validate_then_return_invalid_empty_phone_exception() {
        val phoneNumber = ""
        val result = validatePhoneUseCase.invoke(phoneNumber)
        assertFalse(result.isSuccess)
        assertTrue(result.exception is ValidationException.InvalidEmptyPhoneException)
    }

    @Test
    fun given_phone_length_less_then_10_number_when_validate_then_return_invalid_phone_length_exception() {
        val phoneNumber = "45646"
        val result = validatePhoneUseCase.invoke(phoneNumber)
        assertFalse(result.isSuccess)
        assertTrue(result.exception is ValidationException.InvalidPhoneLengthException)
    }


    @Test
    fun given_invalid_phone_input_type_when_validate_then_return_invalid_phone_pattern_exception() {
        val phoneNumber = "123456789s"
        val result = validatePhoneUseCase.invoke(phoneNumber)
        assertFalse(result.isSuccess)
        assertTrue(result.exception is ValidationException.InvalidPhoneInputTypeException)
    }

    @Test
    fun given_a_valid_phone_when_validate_then_passed() {
        val phoneNumber = "1231233699"
        val result = validatePhoneUseCase.invoke(phoneNumber)
        assertTrue(result.isSuccess)
        assertNull(result.exception)
    }

}