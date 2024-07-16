package com.kk.language.lexer.handle

import com.kk.language.lexer.Lexer
import com.kk.language.lexer.Token
import com.kk.language.lexer.TokenType

object CompareTokenParse : TokenParse {
    override fun parse(lexer: Lexer): Token {
        val nextChar = lexer.next()
        val token = lexer.token
        return if(nextChar == '='){
            lexer.nextChar()
            return Token(if(token=="<"){TokenType.LE} else TokenType.GE)
        }else {
            
            return Token(if(token==">"){TokenType.LESS_OPERATOR} else TokenType.GREATER_OPERATOR)
        }
    }
}