package com.kk.language.util

object CharUtil {
    fun isIdentifier(char: Char): Boolean {
        return (char in 'a'..'z' || char in 'A'..'Z' || char in '0'..'9' || char == '_')
    }
}