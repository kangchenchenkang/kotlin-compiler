package com.kk.language

import com.kk.language.ast.AstNode
import com.kk.language.ast.SyntaxNode
import com.kk.language.lexer.Lexer
import com.kk.language.lexer.Token
import com.kk.language.lexer.TokenType
import java.util.*

class Parser constructor(val lexer: Lexer) {
    val parseStack: Stack<Token> = Stack()
    fun parse():AstNode {
        // 解析逻辑
        var token = lexer.parseToken()
        val node = SyntaxNode(lexer.token!!)
        while (true){
            //如果是左括号
            if(token.tokenType== TokenType.LEFT_PARENTHESIS){
                parseStack.push(token)
            }else if( token.tokenType == TokenType.RIGHT_PARENTHESIS){
                val pop = parseStack.pop()
            }
        }
        return node
    }
    fun recursionParse():AstNode {
        // 解析逻辑
        var token = lexer.parseToken()
        val node = SyntaxNode(lexer.token!!)
        //如果是左括号
        if(token.tokenType== TokenType.LEFT_PARENTHESIS){
            val recursionParse = this.recursionParse()
            node.addChild(recursionParse)
            val parseToken = lexer.parseToken()
            if(parseToken.tokenType!=TokenType.RIGHT_PARENTHESIS){
                throw Error("缺少右括号")
            }
            return node
        }
        if(token.tokenType == TokenType.NUM4){
            val curNode = SyntaxNode()
            curNode.addChild(SyntaxNode(lexer.token!!))
            node.addChild(curNode)
            //return node
        }
        token = lexer.parseToken()
        if(token.tokenType == TokenType.EOF){
            return node
        }
        if(token.tokenType == TokenType.PLUS
            || token.tokenType == TokenType.MINUS){
            node.type = lexer.token!!
            node.addChild(this.recursionParse())
            return node
        }else if(token.tokenType == TokenType.EOF){
            return node
        }else {
            reverse()
        }
        return node
    }
    /*private fun numberNode():AstNode{

    }*/
    private fun reverse(){
        this.lexer.readIndex = 0
        this.parseStack.pop()
        val preToken = this.parseStack.pop()
    }
}