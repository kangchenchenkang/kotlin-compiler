package com.kk.language.lexer.handle

import com.kk.language.lexer.Lexer
import com.kk.language.lexer.Token

interface TokenParse {
    fun parse(lexer: Lexer): Token
}