package com.kk.language.parse

import com.kk.language.Parser
import com.kk.language.lexer.Lexer
import com.kk.language.lexer.TokenType
import org.junit.jupiter.api.Test

class ParseTest {
    @Test
    fun parseTest(){
        val source = "9-5+2"//"1+2-3"//"(1+2)-3"
        val lexer = Lexer(source = source)
        /*while (true){
            val parseToken = lexer.parseToken()
            println(parseToken)
            if(parseToken.tokenType == TokenType.EOF){
                return;
            }
        }*/
        val parser = Parser(lexer)
        val astNode = parser.recursionParse()
        println(astNode.attrs())
    }
}