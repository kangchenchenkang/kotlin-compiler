package com.kk.language.lexer.handle

import com.kk.language.lexer.Lexer
import com.kk.language.lexer.Token
import com.kk.language.lexer.TokenType

/**
 * 可以使用Kotlin的枚举特性每个实现这个接口，防止类太大影响阅读，还是分开
 * enum TokenEnums: ParseToken{
 *      AND {
 *      override fun parse(lexer: Lexer): Token {
 *
 *      }
 * }
 */
object ParseToken {
    val tokenHandleMap:MutableMap<String, TokenParse> = mutableMapOf<String, TokenParse>()
    val otherTokenParse: OtherTokenParse = OtherTokenParse
    init {
        tokenHandleMap["&"] = AndTokenParse
        tokenHandleMap["|"] = OrTokenParse
        tokenHandleMap["="] = EqualsTokenParse
        tokenHandleMap["!"] = NeTokenParse
        tokenHandleMap["<"] = CompareTokenParse
        tokenHandleMap[">"] = CompareTokenParse
    }
    fun parseToken(lexer: Lexer,chat:String):Token{
        if (tokenHandleMap.contains(chat)) {
            return tokenHandleMap[chat]!!.parse(lexer)
        }else {
            return otherTokenParse.parse(lexer)
        }
    }
}