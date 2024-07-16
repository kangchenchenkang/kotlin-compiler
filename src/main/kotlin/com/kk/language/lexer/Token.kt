package com.kk.language.lexer

class Token  {
    val tokenType: TokenType
    var value:String = ""
    constructor(tokenType:TokenType,value:String? = null){
        this.tokenType = tokenType
        this.value = value?:tokenType.symbol
    }
    companion object{
        val TOKEN_TYPE_MAP : Map<String, TokenType> = TokenType.entries.associateBy(
            { it.symbol },
            { it }
        )
        fun isKeywords(token: String): Boolean {
            return TOKEN_TYPE_MAP.containsKey(token)
        }
        fun getKeywords(token: String): TokenType? {
            return TOKEN_TYPE_MAP[token]
        }
    }

    override fun toString(): String {
        return value//this.tokenType.symbol
    }
}