package com.kk.language.lexer

import org.junit.jupiter.api.Test

class LexerTest {
    @Test
    fun test(){
        val lexer = Lexer(source = "{a==1} if abc == 10.32  {a=1} else {a=2} != ")
        for (i in lexer.readIndex..lexer.source.length){
            val parseToken = lexer.parseToken()
            println(parseToken)
            if(parseToken.tokenType == TokenType.EOF){
                break;
            }
        }
    }
}