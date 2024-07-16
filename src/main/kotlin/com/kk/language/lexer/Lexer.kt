package com.kk.language.lexer

import com.kk.language.lexer.handle.ParseToken
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.StringStack
import java.util.*

class Lexer(
    var lexemeStack: Stack<String> = Stack(),
    var source:String,
    var line:Int = 1,
    var readIndex: Int = 0) {

    var token: String? = null
    fun parseToken():Token{
        if(readIndex >= source.length){
            return Token(TokenType.EOF)
        }
        // 过滤无效字符
        for (i in readIndex..<source.length) {
            token = this.nextString()
            if(token == " "|| token == "\t"){
                continue
            }else if(token == "\\n"){
                line++;
                break;
            }else{
                break;
            }
        }
        if(token==null){
            return Token(TokenType.EOF)
        }
        when(token!!){
            "{" ->{
                lexemeStack.push(TokenType.LEFT_BRACE.symbol)
                return Token(TokenType.LEFT_BRACE)
            }
            "}" ->{
                lexemeStack.push(TokenType.RIGHT_BRACE.symbol)
                return Token(TokenType.RIGHT_BRACE)
            }
            "+" ->{
                lexemeStack.push(TokenType.PLUS.symbol)
                return Token(TokenType.PLUS)
            }
            "*" ->{
                lexemeStack.push(TokenType.MULTIPLY.symbol)
                return Token(TokenType.MULTIPLY)
            }
            "(" ->{
                lexemeStack.push(TokenType.LEFT_PARENTHESIS.symbol)
                return Token(TokenType.LEFT_PARENTHESIS)
            }
            ")" ->{
                lexemeStack.push(TokenType.RIGHT_PARENTHESIS.symbol)
                return Token(TokenType.RIGHT_PARENTHESIS)
            }
            else ->{
                val parseToken = ParseToken.parseToken(this, token!!)
                lexemeStack.push(parseToken.tokenType.symbol)
                return parseToken
            }
        }
    }

    fun nextChar():Char?{
        return if(readIndex < source.length){
            token = source[readIndex++].toString()
            token!![0]
        }else{
            readIndex
            null
        }
    }
    fun nextString():String?{
        return if(readIndex < source.length){
            token = source[readIndex++].toString()
            token
        }else{
            readIndex
            null
        }
    }
    fun backChar():Char{
        readIndex--
        token =  source[readIndex].toString()
        return token!![0]
    }

    fun at():Char{
        return token!![0]
    }
    fun atString():String{
        return token!!
    }
    fun next():Char?{
        return if(readIndex < source.length){
            source[readIndex]
        }else{
            null
        }
    }
    fun isSkip(): Boolean {
        val char = atString()
        return char == " " || char ==  "\n" || char ==  "\t"
    }
}