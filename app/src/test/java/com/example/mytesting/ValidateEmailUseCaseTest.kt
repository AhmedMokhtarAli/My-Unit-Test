package com.example.mytesting

import org.junit.Before
import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertNull
import kotlin.test.assertTrue

class ValidateEmailUseCaseTest {

    private lateinit var validateEmailUseCase: ValidateEmailUseCase

    @Before
    fun setUp() {
        validateEmailUseCase = ValidateEmailUseCase()
    }

    @Test
    fun give_empty_email_when_validate_then_empty_mail_exception() {
        val email=""
        val result=validateEmailUseCase.invoke(email)
        assertFalse(result.isSuccess)
        assertTrue(result.exception is ValidationException.InvalidEmptyEmailException)
    }

    @Test
    fun given_invalid_email_pattern_when_validate_then_invalid_email_pattern_exception() {
        val  email = "dfasfsa@asgks.123"
        val result=validateEmailUseCase.invoke(email)
        assertFalse(result.isSuccess)
        assertTrue(result.exception is ValidationException.InvalidEmailPatternException)
    }

    @Test
    fun given_a_valid_email_when_validate_then_success() {
        val email="william.henry.harrison@example-pet-store.com"
        val result=validateEmailUseCase.invoke(email)
        assertTrue(result.isSuccess)
        assertNull(result.exception)
    }
}