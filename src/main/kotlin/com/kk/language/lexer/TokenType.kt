package com.kk.language.lexer

enum class TokenType constructor( val symbol: String = "") {
    /**
     * 错误
     */
    ERROR("err"),
    /**
     * 结束
     */
    EOF("eof"),
    /**
     * &&
     */
    AND("&&"),

    /**
     * !
     */
    NEGATE_OPERATOR("!"),
    /** < */
    LESS_OPERATOR("<"),
    /** > */
    GREATER_OPERATOR(">"),
    /**
     * |
     */
    OR_OPERATOR("|"),
    /**
     * =
     */
    ASSIGN_OPERATOR("="),

    /**
     * &
     */
    AND_OPERATOR("&"),
    IF("if"),ELSE("else"),

    /**
     * +
     */
    PLUS("+"),

    /**
     * -
     */
    MINUS("-"),

    /**
     * /
     */
    DIVIDED("/"),
    /**
     * *
     */
    MULTIPLY("*"),

    /**
     * boolean
     */
    BOOL("boolean"),
    /**
     * byte
     */
    NUM1("byte"),
    /**
     * SHORT
     */
    NUM2("short"),
    /**
     * int
     */
    NUM4("int"),

    /**
     * string
     */
    STRING("string"),
    /**
     * long
     */
    NUM8("long"),
    /**
     * float
     */
    REAL4("float"),

    /**
     * double
     */
    REAL8("double"),

    /**
     * 变量
     */
    IDENTIFIER("identifier"),
    /**
     * 小于等于
     */
    LE("<="),
    /**
     * >=
     */
    GE(">="),
    /**
     * true
     */
    TRUE("true"),
    /**
     * false
     */
    FALSE("false"),

    /**
     * (
     */
    LEFT_PARENTHESIS("("),
    /**
     * )
     */
    RIGHT_PARENTHESIS(")"),

    /**
     * []
     */
    LEFT_BRACKET("["),
    /**
     * []
     */
    RIGHT_BRACKET("]"),
    /**
     * {}
     */
    LEFT_BRACE("{"),
    /**
     * {}
     */
    RIGHT_BRACE("}"),
    /**
     * =
     */
    EQUAL("=="),

    /**
     * !=
     */
    NE("!="),
    /**
     * ==
     */
    EQ("=="),
    /**
     * do while 的 do
     */
    DO("do"),

    /**
     * while
     */
    WHILE("while"),
    /**
     * OR
     */
    OR("or"),

    /**
     * break;
     */
    BREAK("break"),;

    override fun toString(): String {
        return this.symbol
    }

}