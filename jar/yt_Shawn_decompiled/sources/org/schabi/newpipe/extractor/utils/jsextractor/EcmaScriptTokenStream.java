package org.schabi.newpipe.extractor.utils.jsextractor;

import com.github.catvod.spider.merge.r1.b;
import com.github.catvod.spider.merge.u.c2;
import org.schabi.newpipe.extractor.exceptions.ParsingException;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
class EcmaScriptTokenStream {
    private static final char BYTE_ORDER_MARK = 65279;
    private static final int EOF_CHAR = -1;
    private static final char NUMERIC_SEPARATOR = '_';
    private static final int REPORT_NUMBER_FORMAT_ERROR = -2;
    private boolean dirtyLine;
    int lineno;
    private final String sourceString;
    private final boolean strictMode;
    private int stringBufferTop;
    int tokenBeg;
    int tokenEnd;
    private int ungetCursor;
    private char[] stringBuffer = new char[128];
    private final int[] ungetBuffer = new int[3];
    private int lineEndChar = -1;
    private int sourceCursor = 0;
    private int cursor = 0;

    public EcmaScriptTokenStream(String str, int i, boolean z) {
        this.sourceString = str;
        this.lineno = i;
        this.strictMode = z;
    }

    private void addToString(int i) {
        int i2 = this.stringBufferTop;
        char[] cArr = this.stringBuffer;
        if (i2 == cArr.length) {
            char[] cArr2 = new char[cArr.length * 2];
            System.arraycopy(cArr, 0, cArr2, 0, i2);
            this.stringBuffer = cArr2;
        }
        this.stringBuffer[i2] = (char) i;
        this.stringBufferTop = i2 + 1;
    }

    private int getChar(boolean z, boolean z2) {
        int i;
        int i2 = this.ungetCursor;
        if (i2 != 0) {
            this.cursor++;
            int[] iArr = this.ungetBuffer;
            int i3 = i2 - 1;
            this.ungetCursor = i3;
            return iArr[i3];
        }
        while (this.sourceCursor != this.sourceString.length()) {
            this.cursor++;
            String str = this.sourceString;
            int i4 = this.sourceCursor;
            this.sourceCursor = i4 + 1;
            char cCharAt = str.charAt(i4);
            if (!z2 && (i = this.lineEndChar) >= 0) {
                if (i == 13 && cCharAt == '\n') {
                    this.lineEndChar = 10;
                } else {
                    this.lineEndChar = -1;
                    this.lineno++;
                }
            }
            if (cCharAt <= 127) {
                if (cCharAt == '\n' || cCharAt == '\r') {
                    this.lineEndChar = cCharAt;
                    return 10;
                }
            } else if (cCharAt != 65279) {
                if (!z || !isJSFormatChar(cCharAt)) {
                    if (b.a(cCharAt)) {
                        this.lineEndChar = cCharAt;
                        return 10;
                    }
                }
            }
            return cCharAt;
        }
        return -1;
    }

    private int getCharIgnoreLineEnd() {
        return getChar(true, true);
    }

    private String getStringFromBuffer() {
        this.tokenEnd = this.cursor;
        return new String(this.stringBuffer, 0, this.stringBufferTop);
    }

    private static boolean isAlpha(int i) {
        return i <= 90 ? 65 <= i : 97 <= i && i <= 122;
    }

    private static boolean isDigit(int i, int i2) {
        if (i == 10 && isDigit(i2)) {
            return true;
        }
        if (i == 16 && isHexDigit(i2)) {
            return true;
        }
        if (i == 8 && isOctalDigit(i2)) {
            return true;
        }
        return i == 2 && isDualDigit(i2);
    }

    private static boolean isDualDigit(int i) {
        return 48 == i || i == 49;
    }

    private static boolean isHexDigit(int i) {
        if (48 <= i && i <= 57) {
            return true;
        }
        if (97 > i || i > 102) {
            return 65 <= i && i <= 70;
        }
        return true;
    }

    private static boolean isJSFormatChar(int i) {
        return i > 127 && Character.getType((char) i) == 16;
    }

    private static boolean isJSSpace(int i) {
        return i <= 127 ? i == 32 || i == 9 || i == 12 || i == 11 : i == 160 || i == 65279 || Character.getType((char) i) == 12;
    }

    private static boolean isOctalDigit(int i) {
        return 48 <= i && i <= 55;
    }

    private boolean matchChar(int i) {
        int charIgnoreLineEnd = getCharIgnoreLineEnd();
        if (charIgnoreLineEnd == i) {
            this.tokenEnd = this.cursor;
            return true;
        }
        ungetCharIgnoreLineEnd(charIgnoreLineEnd);
        return false;
    }

    private int peekChar() {
        int i = getChar();
        ungetChar(i);
        return i;
    }

    private int readDigits(int i, int i2) {
        if (isDigit(i, i2)) {
            addToString(i2);
            i2 = getChar();
            if (i2 != -1) {
                while (true) {
                    if (i2 != 95) {
                        if (!isDigit(i, i2)) {
                            break;
                        }
                        addToString(i2);
                        i2 = getChar();
                        if (i2 == -1) {
                            return -1;
                        }
                    } else {
                        i2 = getChar();
                        if (i2 == 10 || i2 == -1) {
                            return REPORT_NUMBER_FORMAT_ERROR;
                        }
                        if (!isDigit(i, i2)) {
                            ungetChar(i2);
                            return 95;
                        }
                        addToString(95);
                    }
                }
            } else {
                return -1;
            }
        }
        return i2;
    }

    private void skipLine() {
        int i;
        do {
            i = getChar();
            if (i == -1) {
                break;
            }
        } while (i != 10);
        ungetChar(i);
        this.tokenEnd = this.cursor;
    }

    private Token stringToKeyword(String str) {
        return stringToKeywordForES(str, this.strictMode);
    }

    private static Token stringToKeywordForES(String str, boolean z) {
        str.getClass();
        switch (str) {
            case "delete":
                return Token.DELPROP;
            case "extends":
            case "enum":
            case "await":
            case "class":
            case "super":
                return Token.RESERVED;
            case "export":
                return Token.EXPORT;
            case "import":
                return Token.IMPORT;
            case "public":
            case "implements":
            case "static":
            case "package":
            case "protected":
            case "private":
            case "interface":
                if (z) {
                    return Token.RESERVED;
                }
                break;
            case "return":
                return Token.RETURN;
            case "switch":
                return Token.SWITCH;
            case "typeof":
                return Token.TYPEOF;
            case "finally":
                return Token.FINALLY;
            case "continue":
                return Token.CONTINUE;
            case "do":
                return Token.DO;
            case "if":
                return Token.IF;
            case "in":
                return Token.IN;
            case "for":
                return Token.FOR;
            case "let":
                return Token.LET;
            case "new":
                return Token.NEW;
            case "try":
                return Token.TRY;
            case "var":
                return Token.VAR;
            case "case":
                return Token.CASE;
            case "else":
                return Token.ELSE;
            case "null":
                return Token.NULL;
            case "this":
                return Token.THIS;
            case "true":
                return Token.TRUE;
            case "void":
                return Token.VOID;
            case "with":
                return Token.WITH;
            case "break":
                return Token.BREAK;
            case "catch":
                return Token.CATCH;
            case "const":
                return Token.CONST;
            case "false":
                return Token.FALSE;
            case "throw":
                return Token.THROW;
            case "while":
                return Token.WHILE;
            case "yield":
                return Token.YIELD;
            case "debugger":
                return Token.DEBUGGER;
            case "instanceof":
                return Token.INSTANCEOF;
            case "function":
                return Token.FUNCTION;
            case "default":
                return Token.DEFAULT;
        }
        return Token.EOF;
    }

    private void ungetChar(int i) {
        int i2 = this.ungetCursor;
        if (i2 != 0 && this.ungetBuffer[i2 - 1] == 10) {
            c2.j();
            throw null;
        }
        int[] iArr = this.ungetBuffer;
        this.ungetCursor = i2 + 1;
        iArr[i2] = i;
        this.cursor--;
    }

    private void ungetCharIgnoreLineEnd(int i) {
        int[] iArr = this.ungetBuffer;
        int i2 = this.ungetCursor;
        this.ungetCursor = i2 + 1;
        iArr[i2] = i;
        this.cursor--;
    }

    /* JADX WARN: Code restructure failed: missing block: B:180:0x021e, code lost:
    
        if (matchChar(42) != false) goto L181;
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x0220, code lost:
    
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x0222, code lost:
    
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x0223, code lost:
    
        r5 = getChar();
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x0227, code lost:
    
        if (r5 == (-1)) goto L461;
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x0229, code lost:
    
        if (r5 != 42) goto L187;
     */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x022c, code lost:
    
        if (r5 != 47) goto L463;
     */
    /* JADX WARN: Code restructure failed: missing block: B:188:0x022e, code lost:
    
        if (r3 == false) goto L468;
     */
    /* JADX WARN: Code restructure failed: missing block: B:189:0x0230, code lost:
    
        r19.tokenEnd = r19.cursor;
     */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x0236, code lost:
    
        return org.schabi.newpipe.extractor.utils.jsextractor.Token.COMMENT;
     */
    /* JADX WARN: Code restructure failed: missing block: B:191:0x0237, code lost:
    
        r19.tokenEnd = r19.cursor;
     */
    /* JADX WARN: Code restructure failed: missing block: B:192:0x023c, code lost:
    
        r19.tokenEnd = r19.cursor - 1;
        org.schabi.newpipe.extractor.utils.c.a("unterminated comment");
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x0246, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:441:0x0223, code lost:
    
        r3 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00d2  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:185:0x0229 -> B:181:0x0220). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final org.schabi.newpipe.extractor.utils.jsextractor.Token getToken() throws org.schabi.newpipe.extractor.exceptions.ParsingException {
        /*
            Method dump skipped, instructions count: 1300
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.schabi.newpipe.extractor.utils.jsextractor.EcmaScriptTokenStream.getToken():org.schabi.newpipe.extractor.utils.jsextractor.Token");
    }

    public Token nextToken() throws ParsingException {
        Token token = getToken();
        while (true) {
            if (token != Token.EOL && token != Token.COMMENT) {
                return token;
            }
            token = getToken();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x007b, code lost:
    
        org.schabi.newpipe.extractor.utils.c.a("msg.unterminated.re.lit");
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x007e, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void readRegExp(org.schabi.newpipe.extractor.utils.jsextractor.Token r9) throws org.schabi.newpipe.extractor.exceptions.ParsingException {
        /*
            r8 = this;
            int r0 = r8.tokenBeg
            r1 = 0
            r8.stringBufferTop = r1
            org.schabi.newpipe.extractor.utils.jsextractor.Token r2 = org.schabi.newpipe.extractor.utils.jsextractor.Token.ASSIGN_DIV
            r3 = 1
            java.lang.String r4 = "msg.unterminated.re.lit"
            if (r9 != r2) goto L12
            r9 = 61
            r8.addToString(r9)
            goto L1e
        L12:
            org.schabi.newpipe.extractor.utils.jsextractor.Token r2 = org.schabi.newpipe.extractor.utils.jsextractor.Token.DIV
            if (r9 != r2) goto L88
            int r9 = r8.peekChar()
            r2 = 42
            if (r9 == r2) goto L7f
        L1e:
            r9 = 0
        L1f:
            int r2 = r8.getChar()
            r5 = 47
            r6 = -1
            if (r2 != r5) goto L52
            if (r9 == 0) goto L2b
            goto L52
        L2b:
            int r9 = r8.getCharIgnoreLineEnd()
            java.lang.String r1 = "gimysu"
            int r1 = r1.indexOf(r9)
            if (r1 == r6) goto L3b
            r8.addToString(r9)
            goto L2b
        L3b:
            boolean r1 = isAlpha(r9)
            if (r1 != 0) goto L4c
            r8.ungetCharIgnoreLineEnd(r9)
            int r9 = r8.stringBufferTop
            int r0 = r0 + r9
            int r0 = r0 + 2
            r8.tokenEnd = r0
            return
        L4c:
            java.lang.String r9 = "msg.invalid.re.flag"
            org.schabi.newpipe.extractor.utils.c.a(r9)
            return
        L52:
            r5 = 10
            if (r2 == r5) goto L7b
            if (r2 == r6) goto L7b
            r7 = 92
            if (r2 != r7) goto L6c
            r8.addToString(r2)
            int r2 = r8.getChar()
            if (r2 == r5) goto L68
            if (r2 == r6) goto L68
            goto L77
        L68:
            org.schabi.newpipe.extractor.utils.c.a(r4)
            return
        L6c:
            r5 = 91
            if (r2 != r5) goto L72
            r9 = 1
            goto L77
        L72:
            r5 = 93
            if (r2 != r5) goto L77
            r9 = 0
        L77:
            r8.addToString(r2)
            goto L1f
        L7b:
            org.schabi.newpipe.extractor.utils.c.a(r4)
            return
        L7f:
            int r9 = r8.cursor
            int r9 = r9 - r3
            r8.tokenEnd = r9
            org.schabi.newpipe.extractor.utils.c.a(r4)
            return
        L88:
            com.github.catvod.spider.merge.u.c2.j()
            r9 = 0
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: org.schabi.newpipe.extractor.utils.jsextractor.EcmaScriptTokenStream.readRegExp(org.schabi.newpipe.extractor.utils.jsextractor.Token):void");
    }

    private int getCharIgnoreLineEnd(boolean z) {
        return getChar(z, true);
    }

    private static boolean isDigit(int i) {
        return 48 <= i && i <= 57;
    }

    private int getChar(boolean z) {
        return getChar(z, false);
    }

    private int getChar() {
        return getChar(true, false);
    }
}
