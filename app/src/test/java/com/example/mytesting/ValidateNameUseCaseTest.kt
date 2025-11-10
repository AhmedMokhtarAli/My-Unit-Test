package com.example.mytesting

import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import org.junit.Before
import org.junit.Test

class ValidateNameUseCaseTest {
    private lateinit var validateNameUseCase: ValidateNameUseCase

    @Before
    fun setUp() {
        validateNameUseCase = ValidateNameUseCase()
    }

    @Test
    fun given_empty_name_when_validate_then_return_false() {
        val input=""
        val result = validateNameUseCase(input)
        assertFalse(result)
    }



    @Test
    fun given_name_less_than_2_characters_when_validate_then_return_false() {
        val input="t"
        val result = validateNameUseCase(input)
        assertFalse(result)
    }

    @Test
    fun given_name_equal_2_characters_when_validate_then_return_true() {
        val input="مي"
        val result = validateNameUseCase(input)
        assertTrue(result)
    }

    @Test
    fun given_name_more_than_2_characters_when_validate_then_return_true() {
        val input="ahmed"
        val result = validateNameUseCase(input)
        assertTrue(result)
    }
}