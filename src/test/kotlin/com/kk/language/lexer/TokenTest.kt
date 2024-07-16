package com.kk.language.lexer

import org.junit.jupiter.api.Test


class TokenTest {

    @Test
    fun test() {

        val tokens = arrayOf(
            Token(TokenType.AND),
            Token(TokenType.TRUE)
        )
        for (token in tokens) {
            println(TokenType.RIGHT_BRACKET.ordinal)
            println(token)
            val tokenType = TokenType.entries[token.tokenType.ordinal]
            println(tokenType.toString())
        }
    }
}