package com.kk.language.lexer.handle

import com.kk.language.lexer.Lexer
import com.kk.language.lexer.Token
import com.kk.language.lexer.TokenType

object NeTokenParse:TokenParse {
    override fun parse(lexer: Lexer): Token {
        val nextChar = lexer.next()
        return if(nextChar == '='){
            lexer.nextChar()
            return Token(TokenType.NE)
        }else {
            return Token(TokenType.NEGATE_OPERATOR)
        }
    }
}