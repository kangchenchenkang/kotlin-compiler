package com.kk.language.ast

interface AstNode {
    fun getChild():List<AstNode>
    fun addChild(astNode: AstNode)
    fun attrs():String
}