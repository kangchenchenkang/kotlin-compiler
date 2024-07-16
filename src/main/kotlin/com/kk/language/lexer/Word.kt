package com.kk.language.lexer

class Word constructor(val lexeme:String, val token:Token) {

    fun getKeywords(): Array<TokenType>{
        return TokenType.entries.toTypedArray()
    }
}