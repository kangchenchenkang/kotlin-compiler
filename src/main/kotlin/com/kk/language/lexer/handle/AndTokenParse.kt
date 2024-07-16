package com.kk.language.lexer.handle

import com.kk.language.lexer.Lexer
import com.kk.language.lexer.Token
import com.kk.language.lexer.TokenType

/**
 * 处理 & 和 &&
 */
object AndTokenParse:TokenParse {
    override fun parse(lexer: Lexer): Token {
        val nextChar = lexer.next()
        return if(nextChar == '&'){
            lexer.nextChar()
            return Token(TokenType.AND)
        }else {
            return Token(TokenType.AND_OPERATOR)
        }
    }


}