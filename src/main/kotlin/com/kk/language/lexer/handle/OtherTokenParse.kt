package com.kk.language.lexer.handle

import com.kk.language.lexer.Lexer
import com.kk.language.lexer.Token
import com.kk.language.lexer.TokenType
import com.kk.language.util.CharUtil
import java.lang.StringBuilder


object OtherTokenParse: TokenParse {

    override fun parse(lexer: Lexer): Token {
        var char:Char? = lexer.at() ?: return Token(TokenType.EOF)
        if(Character.isDigit(char!!)){
            var result = char.digitToInt()
            val sb:StringBuilder = StringBuilder(char.toString())
            char = lexer.nextChar()
            if(char == null){
                lexer.token = sb.toString()
                return Token(TokenType.EOF)
            }
            for (i in lexer.readIndex..<lexer.source.length){
                if(!Character.isDigit(char!!)){
                    lexer.backChar()
                    break;
                }
                result = result * 10 + char!!.digitToInt()
                sb.append(char)
                char = lexer.nextChar()
            }
            if( char == '.'){
                sb.append(".")
                char = lexer.nextChar()
                var double = result.toDouble()
                var hex = 10
                char = lexer.nextChar()
                if(char == null){
                    // 如果只有小数点后面零都没有应该直接报错
                    return Token(TokenType.EOF)
                }
                for (i in lexer.readIndex..<lexer.source.length){
                    if(!Character.isDigit(char!!)){
                        lexer.backChar()
                        break;
                    }
                    double += char!!.digitToInt().toDouble() / hex
                    hex *= 10
                    sb.append(char.toString())
                    char = lexer.nextChar()
                }
                lexer.token = sb.toString()
                return Token(TokenType.REAL8)
            }else {
                lexer.token = sb.toString()
                return Token(TokenType.NUM4)
            }
        }else if(CharUtil.isIdentifier(char!!)){
            val sb = StringBuilder(char!!.toString())
            char = lexer.nextChar()
           /* if(char==null){
                val word = sb.toString()
                // 判断是不是关键字,如果不是关键字就是标识符
                val tokenType = Token.getKeywords(word)
                if(tokenType!=null){
                    return Token(tokenType)
                }else {
                    return Token(TokenType.IDENTIFIER)
                }
            }*/
            for (i in lexer.readIndex..<lexer.source.length){
                if(!CharUtil.isIdentifier(char!!)){
                    lexer.backChar()
                    break;
                }else{
                    sb.append(char)
                    char = lexer.nextChar()
                }
            }
            val word = sb.toString()
            // 判断是不是关键字,如果不是关键字就是标识符
            val tokenType = Token.getKeywords(word)
            if(tokenType!=null){
                return Token(tokenType)
            }else {
                 return Token(TokenType.IDENTIFIER)
            }
        }
        val tokenType = Token.getKeywords(char!!.toString())
        if(tokenType!=null){
            return Token(tokenType)
        }
        return Token(TokenType.EOF)
    }
}