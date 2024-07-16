package com.kk.language.ast

import java.lang.StringBuilder

class SyntaxNode constructor(var type:String=""):AstNode {
    val children: MutableList<AstNode> = mutableListOf<AstNode>()
    override fun getChild(): List<AstNode> {
        return children
    }

    override fun addChild(astNode: AstNode) {
        children.add(astNode)
    }

    override fun attrs(): String{
        if(this.children.size == 0){
            return this.type
        }
        //var sb = ""
        val sb = StringBuilder()
            //sb += this.type
        //sb.append(this.type)
        this.children.forEach {
            sb.append(it.attrs())
        }
        sb.append(this.type)
        //this.children.joinTo(sb, "", "", "", -1, "")
        return sb.toString()
    }

    override fun toString(): String {
        return super.toString()
    }
}