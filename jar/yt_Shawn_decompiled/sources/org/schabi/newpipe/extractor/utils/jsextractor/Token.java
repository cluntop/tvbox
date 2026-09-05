package org.schabi.newpipe.extractor.utils.jsextractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public enum Token {
    ERROR,
    EOF,
    EOL,
    RETURN(false, false, true),
    BITOR(true, true, false),
    BITXOR(true, true, false),
    BITAND(true, true, false),
    EQ(true, true, false),
    NE(true, true, false),
    LT(true, true, false),
    LE(true, true, false),
    GT(true, true, false),
    GE(true, true, false),
    LSH(true, true, false),
    RSH(true, true, false),
    URSH(true, true, false),
    ADD(true, true, false),
    SUB(true, true, false),
    MUL(true, true, false),
    DIV(true, true, false),
    MOD(true, true, false),
    NOT(true, true, false),
    BITNOT(true, true, false),
    NEW(true, false, true),
    DELPROP(true, false, true),
    TYPEOF(true, false, true),
    NAME,
    NUMBER,
    STRING,
    NULL(false, false, true),
    THIS(false, false, true),
    FALSE(false, false, true),
    TRUE(false, false, true),
    SHEQ(true, true, false),
    SHNE(true, true, false),
    REGEXP,
    THROW(true, false, true),
    IN(true, false, true),
    INSTANCEOF(true, false, true),
    YIELD(false, false, true),
    EXP(true, true, false),
    BIGINT,
    TRY(false, false, true),
    SEMI(false, true, false),
    LB(false, true, false),
    RB(false, true, false),
    LC(false, true, false),
    RC(false, true, false),
    LP(false, true, false),
    RP(false, true, false),
    COMMA(false, true, false),
    ASSIGN(true, true, false),
    ASSIGN_BITOR(true, true, false),
    ASSIGN_BITXOR(true, true, false),
    ASSIGN_BITAND(true, true, false),
    ASSIGN_LSH(true, true, false),
    ASSIGN_RSH(true, true, false),
    ASSIGN_URSH(true, true, false),
    ASSIGN_ADD(true, true, false),
    ASSIGN_SUB(true, true, false),
    ASSIGN_MUL(true, true, false),
    ASSIGN_DIV(true, true, false),
    ASSIGN_MOD(true, true, false),
    ASSIGN_EXP(true, true, false),
    HOOK(true, true, false),
    COLON(true, true, false),
    OR(true, true, false),
    AND(true, true, false),
    INC(true, true, false),
    DEC(true, true, false),
    DOT(false, true, false),
    FUNCTION(false, false, true),
    EXPORT(false, false, true),
    IMPORT(false, false, true),
    IF(false, false, true),
    ELSE(false, false, true),
    SWITCH(false, false, true),
    CASE(false, false, true),
    DEFAULT(false, false, true),
    WHILE(false, false, true),
    DO(false, false, true),
    FOR(false, false, true),
    BREAK(false, false, true),
    CONTINUE(false, false, true),
    VAR(false, false, true),
    WITH(false, false, true),
    CATCH(false, false, true),
    FINALLY(false, false, true),
    VOID(true, false, true),
    RESERVED(false, false, true),
    LET(false, false, true),
    CONST(false, false, true),
    DEBUGGER(false, false, true),
    COMMENT,
    ARROW(false, true, false),
    YIELD_STAR(false, false, true),
    TEMPLATE_LITERAL;

    public final boolean isKeyw;
    public final boolean isOp;
    public final boolean isPunct;

    Token() {
        this.isOp = false;
        this.isPunct = false;
        this.isKeyw = false;
    }

    public boolean isConditional() {
        return this == IF || this == FOR || this == WHILE || this == WITH;
    }

    Token(boolean z, boolean z2, boolean z3) {
        this.isOp = z;
        this.isPunct = z2;
        this.isKeyw = z3;
    }
}
