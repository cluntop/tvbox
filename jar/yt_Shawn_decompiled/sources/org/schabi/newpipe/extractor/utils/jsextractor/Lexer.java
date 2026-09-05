package org.schabi.newpipe.extractor.utils.jsextractor;

import com.github.catvod.spider.merge.b.b;
import java.util.Stack;
import org.schabi.newpipe.extractor.exceptions.ParsingException;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class Lexer {
    private final EcmaScriptTokenStream stream;
    private final LookBehind lastThree = new LookBehind();
    private final Stack<Brace> braceStack = new Stack<>();
    private final Stack<Paren> parenStack = new Stack<>();

    /* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
    /* renamed from: org.schabi.newpipe.extractor.utils.jsextractor.Lexer$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$schabi$newpipe$extractor$utils$jsextractor$Token;

        static {
            int[] iArr = new int[Token.values().length];
            $SwitchMap$org$schabi$newpipe$extractor$utils$jsextractor$Token = iArr;
            try {
                iArr[Token.LP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$schabi$newpipe$extractor$utils$jsextractor$Token[Token.LC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$schabi$newpipe$extractor$utils$jsextractor$Token[Token.RP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$schabi$newpipe$extractor$utils$jsextractor$Token[Token.RC.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$schabi$newpipe$extractor$utils$jsextractor$Token[Token.CASE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$schabi$newpipe$extractor$utils$jsextractor$Token[Token.COLON.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$schabi$newpipe$extractor$utils$jsextractor$Token[Token.RETURN.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$org$schabi$newpipe$extractor$utils$jsextractor$Token[Token.YIELD.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$org$schabi$newpipe$extractor$utils$jsextractor$Token[Token.YIELD_STAR.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    /* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
    class Brace {
        public final boolean isBlock;
        public final Paren paren;

        public Brace(boolean z, Paren paren) {
            this.isBlock = z;
            this.paren = paren;
        }
    }

    /* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
    class BraceMetaToken extends MetaToken {
        public final Brace brace;

        public BraceMetaToken(Token token, int i, Brace brace) {
            super(token, i);
            this.brace = brace;
        }
    }

    /* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
    class LookBehind {
        private final MetaToken[] list = new MetaToken[3];

        public MetaToken one() {
            return this.list[0];
        }

        public boolean oneIs(Token token) {
            MetaToken metaToken = this.list[0];
            return metaToken != null && metaToken.token == token;
        }

        public void push(MetaToken metaToken) {
            int i = 0;
            while (i < 3) {
                MetaToken[] metaTokenArr = this.list;
                MetaToken metaToken2 = metaTokenArr[i];
                metaTokenArr[i] = metaToken;
                i++;
                metaToken = metaToken2;
            }
        }

        public MetaToken three() {
            return this.list[2];
        }

        public boolean threeIs(Token token) {
            MetaToken metaToken = this.list[2];
            return metaToken != null && metaToken.token == token;
        }

        public MetaToken two() {
            return this.list[1];
        }

        public boolean twoIs(Token token) {
            MetaToken metaToken = this.list[1];
            return metaToken != null && metaToken.token == token;
        }
    }

    /* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
    class MetaToken {
        public final int lineno;
        public final Token token;

        public MetaToken(Token token, int i) {
            this.token = token;
            this.lineno = i;
        }
    }

    /* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
    class Paren {
        public final boolean conditional;
        public final boolean funcExpr;

        public Paren(boolean z, boolean z2) {
            this.funcExpr = z;
            this.conditional = z2;
        }
    }

    /* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
    class ParenMetaToken extends MetaToken {
        public final Paren paren;

        public ParenMetaToken(Token token, int i, Paren paren) {
            super(token, i);
            this.paren = paren;
        }
    }

    /* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
    public class ParsedToken {
        public final int end;
        public final int start;
        public final Token token;

        public ParsedToken(Token token, int i, int i2) {
            this.token = token;
            this.start = i;
            this.end = i2;
        }
    }

    public Lexer(String str) {
        this.stream = new EcmaScriptTokenStream(str, 0, false);
    }

    public boolean checkForExpression(Token token) {
        return token.isOp || token == Token.RETURN || token == Token.CASE;
    }

    public ParsedToken getNextToken() throws ParsingException {
        Token tokenNextToken = this.stream.nextToken();
        if ((tokenNextToken == Token.DIV || tokenNextToken == Token.ASSIGN_DIV) && isRegexStart()) {
            this.stream.readRegExp(tokenNextToken);
            tokenNextToken = Token.REGEXP;
        }
        EcmaScriptTokenStream ecmaScriptTokenStream = this.stream;
        ParsedToken parsedToken = new ParsedToken(tokenNextToken, ecmaScriptTokenStream.tokenBeg, ecmaScriptTokenStream.tokenEnd);
        keepBooks(parsedToken);
        return parsedToken;
    }

    public void handleCloseBraceBooks(int i) throws ParsingException {
        if (this.braceStack.isEmpty()) {
            throw new ParsingException(b.j(i, "unmatched closing brace at "));
        }
        this.lastThree.push(new BraceMetaToken(Token.RC, this.stream.lineno, this.braceStack.pop()));
    }

    public void handleCloseParenBooks(int i) throws ParsingException {
        if (this.parenStack.isEmpty()) {
            throw new ParsingException(b.j(i, "unmatched closing paren at "));
        }
        this.lastThree.push(new ParenMetaToken(Token.RP, this.stream.lineno, this.parenStack.pop()));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void handleOpenBraceBooks() {
        /*
            r5 = this;
            org.schabi.newpipe.extractor.utils.jsextractor.Lexer$LookBehind r0 = r5.lastThree
            org.schabi.newpipe.extractor.utils.jsextractor.Lexer$MetaToken r0 = r0.one()
            r1 = 1
            if (r0 == 0) goto L5b
            int[] r0 = org.schabi.newpipe.extractor.utils.jsextractor.Lexer.AnonymousClass1.$SwitchMap$org$schabi$newpipe$extractor$utils$jsextractor$Token
            org.schabi.newpipe.extractor.utils.jsextractor.Lexer$LookBehind r2 = r5.lastThree
            org.schabi.newpipe.extractor.utils.jsextractor.Lexer$MetaToken r2 = r2.one()
            org.schabi.newpipe.extractor.utils.jsextractor.Token r2 = r2.token
            int r2 = r2.ordinal()
            r0 = r0[r2]
            r2 = 0
            if (r0 == r1) goto L5a
            r3 = 2
            if (r0 == r3) goto L5a
            switch(r0) {
                case 5: goto L5a;
                case 6: goto L45;
                case 7: goto L2e;
                case 8: goto L2e;
                case 9: goto L2e;
                default: goto L22;
            }
        L22:
            org.schabi.newpipe.extractor.utils.jsextractor.Lexer$LookBehind r0 = r5.lastThree
            org.schabi.newpipe.extractor.utils.jsextractor.Lexer$MetaToken r0 = r0.one()
            org.schabi.newpipe.extractor.utils.jsextractor.Token r0 = r0.token
            boolean r0 = r0.isOp
            r1 = r1 ^ r0
            goto L5b
        L2e:
            org.schabi.newpipe.extractor.utils.jsextractor.Lexer$LookBehind r0 = r5.lastThree
            org.schabi.newpipe.extractor.utils.jsextractor.Lexer$MetaToken r0 = r0.two()
            if (r0 == 0) goto L5a
            org.schabi.newpipe.extractor.utils.jsextractor.Lexer$LookBehind r0 = r5.lastThree
            org.schabi.newpipe.extractor.utils.jsextractor.Lexer$MetaToken r0 = r0.two()
            int r0 = r0.lineno
            org.schabi.newpipe.extractor.utils.jsextractor.EcmaScriptTokenStream r3 = r5.stream
            int r3 = r3.lineno
            if (r0 == r3) goto L5a
            goto L5b
        L45:
            java.util.Stack<org.schabi.newpipe.extractor.utils.jsextractor.Lexer$Brace> r0 = r5.braceStack
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L5a
            java.util.Stack<org.schabi.newpipe.extractor.utils.jsextractor.Lexer$Brace> r0 = r5.braceStack
            java.lang.Object r0 = r0.lastElement()
            org.schabi.newpipe.extractor.utils.jsextractor.Lexer$Brace r0 = (org.schabi.newpipe.extractor.utils.jsextractor.Lexer.Brace) r0
            boolean r0 = r0.isBlock
            if (r0 == 0) goto L5a
            goto L5b
        L5a:
            r1 = 0
        L5b:
            org.schabi.newpipe.extractor.utils.jsextractor.Lexer$LookBehind r0 = r5.lastThree
            org.schabi.newpipe.extractor.utils.jsextractor.Lexer$MetaToken r0 = r0.one()
            boolean r0 = r0 instanceof org.schabi.newpipe.extractor.utils.jsextractor.Lexer.ParenMetaToken
            if (r0 == 0) goto L7c
            org.schabi.newpipe.extractor.utils.jsextractor.Lexer$LookBehind r0 = r5.lastThree
            org.schabi.newpipe.extractor.utils.jsextractor.Lexer$MetaToken r0 = r0.one()
            org.schabi.newpipe.extractor.utils.jsextractor.Token r0 = r0.token
            org.schabi.newpipe.extractor.utils.jsextractor.Token r2 = org.schabi.newpipe.extractor.utils.jsextractor.Token.RP
            if (r0 != r2) goto L7c
            org.schabi.newpipe.extractor.utils.jsextractor.Lexer$LookBehind r0 = r5.lastThree
            org.schabi.newpipe.extractor.utils.jsextractor.Lexer$MetaToken r0 = r0.one()
            org.schabi.newpipe.extractor.utils.jsextractor.Lexer$ParenMetaToken r0 = (org.schabi.newpipe.extractor.utils.jsextractor.Lexer.ParenMetaToken) r0
            org.schabi.newpipe.extractor.utils.jsextractor.Lexer$Paren r0 = r0.paren
            goto L7d
        L7c:
            r0 = 0
        L7d:
            org.schabi.newpipe.extractor.utils.jsextractor.Lexer$Brace r2 = new org.schabi.newpipe.extractor.utils.jsextractor.Lexer$Brace
            r2.<init>(r1, r0)
            java.util.Stack<org.schabi.newpipe.extractor.utils.jsextractor.Lexer$Brace> r0 = r5.braceStack
            r0.push(r2)
            org.schabi.newpipe.extractor.utils.jsextractor.Lexer$LookBehind r0 = r5.lastThree
            org.schabi.newpipe.extractor.utils.jsextractor.Lexer$BraceMetaToken r1 = new org.schabi.newpipe.extractor.utils.jsextractor.Lexer$BraceMetaToken
            org.schabi.newpipe.extractor.utils.jsextractor.Token r3 = org.schabi.newpipe.extractor.utils.jsextractor.Token.LC
            org.schabi.newpipe.extractor.utils.jsextractor.EcmaScriptTokenStream r4 = r5.stream
            int r4 = r4.lineno
            r1.<init>(r3, r4, r2)
            r0.push(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.schabi.newpipe.extractor.utils.jsextractor.Lexer.handleOpenBraceBooks():void");
    }

    public void handleOpenParenBooks() {
        LookBehind lookBehind = this.lastThree;
        Token token = Token.FUNCTION;
        boolean zOneIs = lookBehind.oneIs(token);
        LookBehind lookBehind2 = this.lastThree;
        Paren paren = new Paren(!zOneIs ? !(lookBehind2.twoIs(token) && this.lastThree.three() != null && checkForExpression(this.lastThree.three().token)) : lookBehind2.two() == null || !checkForExpression(this.lastThree.two().token), this.lastThree.one() != null && this.lastThree.one().token.isConditional());
        this.parenStack.push(paren);
        this.lastThree.push(new ParenMetaToken(Token.LP, this.stream.lineno, paren));
    }

    public boolean isBalanced() {
        return this.braceStack.isEmpty() && this.parenStack.isEmpty();
    }

    public boolean isRegexStart() {
        if (this.lastThree.one() == null) {
            return true;
        }
        Token token = this.lastThree.one().token;
        if (token.isKeyw) {
            return token != Token.THIS;
        }
        if (token == Token.RP && (this.lastThree.one() instanceof ParenMetaToken)) {
            return ((ParenMetaToken) this.lastThree.one()).paren.conditional;
        }
        if (token != Token.RC || !(this.lastThree.one() instanceof BraceMetaToken)) {
            return token.isPunct && token != Token.RB;
        }
        Brace brace = ((BraceMetaToken) this.lastThree.one()).brace;
        if (!brace.isBlock) {
            return false;
        }
        if (brace.paren != null) {
            return !r0.funcExpr;
        }
        return true;
    }

    public void keepBooks(ParsedToken parsedToken) throws ParsingException {
        Token token = parsedToken.token;
        if (token.isPunct) {
            int i = AnonymousClass1.$SwitchMap$org$schabi$newpipe$extractor$utils$jsextractor$Token[token.ordinal()];
            if (i == 1) {
                handleOpenParenBooks();
                return;
            }
            if (i == 2) {
                handleOpenBraceBooks();
                return;
            } else if (i == 3) {
                handleCloseParenBooks(parsedToken.start);
                return;
            } else if (i == 4) {
                handleCloseBraceBooks(parsedToken.start);
                return;
            }
        }
        Token token2 = parsedToken.token;
        if (token2 != Token.COMMENT) {
            this.lastThree.push(new MetaToken(token2, this.stream.lineno));
        }
    }
}
