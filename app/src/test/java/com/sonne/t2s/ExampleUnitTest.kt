package com.sonne.t2s

import org.junit.Test

import org.junit.Assert.*
import org.junit.Ignore

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        // This test will pass
        assertEquals(4, 2 + 2)
    }

    @Test
    fun addition_shouldFail() {
        // This test will fail
        assertEquals(5, 2 + 2)
    }

    @Ignore("Test is intentionally skipped")
    @Test
    fun addition_skipped() {
        // This test will be skipped (ignored)
        assertEquals(4, 2 + 2)
    }
}