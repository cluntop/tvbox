package com.grack.nanojson;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* loaded from: classes.dex */
final class JsonTokener {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int BUFFER_ROOM = 256;
    static final int BUFFER_SIZE = 32768;
    static final int MAX_ESCAPE = 5;
    static final int TOKEN_ARRAY_END = 4;
    static final int TOKEN_ARRAY_START = 11;
    static final int TOKEN_COLON = 2;
    static final int TOKEN_COMMA = 1;
    static final int TOKEN_EOF = 0;
    static final int TOKEN_FALSE = 7;
    static final int TOKEN_NULL = 5;
    static final int TOKEN_NUMBER = 9;
    static final int TOKEN_OBJECT_END = 3;
    static final int TOKEN_OBJECT_START = 10;
    static final int TOKEN_SEMI_STRING = 12;
    static final int TOKEN_STRING = 8;
    static final int TOKEN_TRUE = 6;
    static final int TOKEN_VALUE_MIN = 5;
    private final char[] buffer;
    private int bufferLength;
    private int charOffset;
    private boolean eof;
    protected int index;
    protected boolean isDouble;
    private int linePos;
    private final Reader reader;
    protected StringBuilder reusableBuffer;
    private int rowPos;
    private int tokenCharOffset;
    private int tokenCharPos;
    private final boolean utf8;
    private int utf8adjust;
    static final char[] TRUE = {'r', 'u', 'e'};
    static final char[] FALSE = {'a', 'l', 's', 'e'};
    static final char[] NULL = {'u', 'l', 'l'};

    final class PseudoUtf8Reader extends Reader {
        private byte[] buf = new byte[JsonTokener.BUFFER_SIZE];
        private final InputStream buffered;

        public PseudoUtf8Reader(InputStream inputStream) {
            this.buffered = inputStream;
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws IOException {
            int i3 = this.buffered.read(this.buf, i, i2);
            for (int i4 = i; i4 < i + i3; i4++) {
                cArr[i4] = (char) this.buf[i4];
            }
            return i3;
        }
    }

    public JsonTokener(InputStream inputStream) throws JsonParserException, IOException {
        Charset charsetForName;
        this.linePos = 1;
        this.buffer = new char[BUFFER_SIZE];
        this.reusableBuffer = new StringBuilder();
        if (!(inputStream instanceof BufferedInputStream) && !(inputStream instanceof ByteArrayInputStream)) {
            inputStream = new BufferedInputStream(inputStream);
        }
        inputStream.mark(TOKEN_ARRAY_END);
        try {
            int[] iArr = {inputStream.read(), inputStream.read(), inputStream.read(), inputStream.read()};
            int i = iArr[0];
            if (i != 239 || iArr[1] != 187 || iArr[2] != 191) {
                if (i == 0 && iArr[1] == 0 && iArr[2] == 254 && iArr[3] == 255) {
                    charsetForName = Charset.forName("UTF-32BE");
                } else if (i == 255 && iArr[1] == 254 && iArr[2] == 0 && iArr[3] == 0) {
                    charsetForName = Charset.forName("UTF-32LE");
                } else {
                    if (i == 254 && iArr[1] == 255) {
                        charsetForName = StandardCharsets.UTF_16BE;
                        inputStream.reset();
                    } else if (i == 255 && iArr[1] == 254) {
                        charsetForName = StandardCharsets.UTF_16LE;
                        inputStream.reset();
                    } else {
                        if (i == 0 && iArr[1] == 0 && iArr[2] == 0 && iArr[3] != 0) {
                            charsetForName = Charset.forName("UTF-32BE");
                        } else if (i != 0 && iArr[1] == 0 && iArr[2] == 0 && iArr[3] == 0) {
                            charsetForName = Charset.forName("UTF-32LE");
                        } else if (i == 0 && iArr[1] != 0 && iArr[2] == 0 && iArr[3] != 0) {
                            charsetForName = StandardCharsets.UTF_16BE;
                        } else if (i == 0 || iArr[1] != 0 || iArr[2] == 0 || iArr[3] != 0) {
                            inputStream.reset();
                            this.reader = new PseudoUtf8Reader(inputStream);
                        } else {
                            charsetForName = StandardCharsets.UTF_16LE;
                        }
                        inputStream.reset();
                    }
                    inputStream.read();
                    inputStream.read();
                }
                this.reader = new InputStreamReader(inputStream, charsetForName);
                this.utf8 = $assertionsDisabled;
                init();
            }
            inputStream.reset();
            inputStream.read();
            inputStream.read();
            inputStream.read();
            this.reader = new PseudoUtf8Reader(inputStream);
            this.utf8 = true;
            init();
        } catch (IOException e) {
            throw new JsonParserException(e, "IOException while detecting charset", 1, 1, 0);
        }
    }

    private int advanceChar() {
        if (this.eof) {
            return -1;
        }
        char[] cArr = this.buffer;
        int i = this.index;
        char c = cArr[i];
        if (c == '\n') {
            this.linePos++;
            this.rowPos = i + 1 + this.charOffset;
            this.utf8adjust = 0;
        }
        int i2 = i + 1;
        this.index = i2;
        if (i2 >= this.bufferLength) {
            this.eof = refillBuffer();
        }
        return c;
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x01a2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void consumeTokenStringUtf8Char(char r10) throws com.grack.nanojson.JsonParserException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 474
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.grack.nanojson.JsonTokener.consumeTokenStringUtf8Char(char):void");
    }

    private void consumeWhitespace() throws JsonParserException, IOException {
        int iEnsureBuffer;
        do {
            iEnsureBuffer = ensureBuffer(BUFFER_ROOM);
            for (int i = 0; i < iEnsureBuffer; i++) {
                char c = this.buffer[this.index];
                if (!isWhitespace(c)) {
                    fixupAfterRawBufferRead();
                    return;
                }
                if (c == '\n') {
                    this.linePos++;
                    this.rowPos = this.index + 1 + this.charOffset;
                    this.utf8adjust = 0;
                }
                this.index++;
            }
        } while (iEnsureBuffer > 0);
        this.eof = true;
    }

    private void init() throws JsonParserException, IOException {
        this.eof = refillBuffer();
        consumeWhitespace();
    }

    private boolean isDigitCharacter(int i) {
        if ((i >= 48 && i <= 57) || i == 101 || i == 69 || i == 46 || i == 43 || i == 45) {
            return true;
        }
        return $assertionsDisabled;
    }

    private int peekChar() {
        if (this.eof) {
            return -1;
        }
        return this.buffer[this.index];
    }

    private boolean refillBuffer() throws JsonParserException, IOException {
        try {
            Reader reader = this.reader;
            char[] cArr = this.buffer;
            int i = reader.read(cArr, 0, cArr.length);
            if (i <= 0) {
                return true;
            }
            this.charOffset += this.bufferLength;
            this.index = 0;
            this.bufferLength = i;
            return $assertionsDisabled;
        } catch (IOException e) {
            throw createParseException(e, "IOException", true);
        }
    }

    private char stringChar() throws JsonParserException {
        char[] cArr = this.buffer;
        int i = this.index;
        this.index = i + 1;
        char c = cArr[i];
        if (c < ' ') {
            throwControlCharacterException(c);
        }
        return c;
    }

    private void throwControlCharacterException(char c) throws JsonParserException {
        if (c == '\n') {
            this.linePos++;
            this.rowPos = this.index + 1 + this.charOffset;
            this.utf8adjust = 0;
        }
        throw createParseException(null, "Strings may not contain control characters: 0x" + Integer.toString(c, 16), $assertionsDisabled);
    }

    public int advanceCharFast() {
        char[] cArr = this.buffer;
        int i = this.index;
        char c = cArr[i];
        if (c == '\n') {
            this.linePos++;
            this.rowPos = i + 1 + this.charOffset;
            this.utf8adjust = 0;
        }
        this.index = i + 1;
        return c;
    }

    public int advanceToToken(boolean z) throws JsonParserException, IOException {
        int iAdvanceChar;
        do {
            iAdvanceChar = advanceChar();
        } while (isWhitespace(iAdvanceChar));
        int i = this.index;
        int i2 = this.charOffset;
        this.tokenCharPos = ((i + i2) - this.rowPos) - this.utf8adjust;
        this.tokenCharOffset = i2 + i;
        if (iAdvanceChar == -1) {
            return 0;
        }
        if (iAdvanceChar == 34 || iAdvanceChar == 39) {
            consumeTokenString(iAdvanceChar);
            return TOKEN_STRING;
        }
        if (iAdvanceChar == 91) {
            return TOKEN_ARRAY_START;
        }
        if (iAdvanceChar == 93) {
            return TOKEN_ARRAY_END;
        }
        if (iAdvanceChar == 102) {
            try {
                consumeKeyword((char) iAdvanceChar, FALSE);
                return TOKEN_FALSE;
            } catch (JsonParserException e) {
                if (!z) {
                    throw e;
                }
            }
        } else if (iAdvanceChar == 110) {
            try {
                consumeKeyword((char) iAdvanceChar, NULL);
                return 5;
            } catch (JsonParserException e2) {
                if (!z) {
                    throw e2;
                }
            }
        } else {
            if (iAdvanceChar != 116) {
                if (iAdvanceChar == 123) {
                    return 10;
                }
                if (iAdvanceChar == 125) {
                    return 3;
                }
                switch (iAdvanceChar) {
                    case 43:
                    case 46:
                        throw createParseException(null, "Numbers may not start with '" + ((char) iAdvanceChar) + "'", true);
                    case 44:
                        return 1;
                    case 45:
                        break;
                    default:
                        switch (iAdvanceChar) {
                            case 48:
                            case 49:
                            case 50:
                            case 51:
                            case 52:
                            case 53:
                            case 54:
                            case 55:
                            case 56:
                            case 57:
                                break;
                            case 58:
                                return 2;
                            default:
                                if (z) {
                                    this.index = i - 1;
                                    consumeTokenSemiString();
                                    return 12;
                                }
                                if (isAsciiLetter(iAdvanceChar)) {
                                    throw createHelpfulException((char) iAdvanceChar, null, 0);
                                }
                                throw createParseException(null, "Unexpected character: " + ((char) iAdvanceChar), true);
                        }
                }
                consumeTokenNumber((char) iAdvanceChar);
                return TOKEN_NUMBER;
            }
            try {
                consumeKeyword((char) iAdvanceChar, TRUE);
                return TOKEN_TRUE;
            } catch (JsonParserException e3) {
                if (!z) {
                    throw e3;
                }
            }
        }
        this.index = i - 1;
        consumeTokenSemiString();
        return 12;
    }

    public void consumeKeyword(char c, char[] cArr) throws JsonParserException {
        if (ensureBuffer(cArr.length) < cArr.length) {
            throw createHelpfulException(c, cArr, 0);
        }
        for (int i = 0; i < cArr.length; i++) {
            char[] cArr2 = this.buffer;
            int i2 = this.index;
            this.index = i2 + 1;
            if (cArr2[i2] != cArr[i]) {
                throw createHelpfulException(c, cArr, i);
            }
        }
        fixupAfterRawBufferRead();
        int iPeekChar = peekChar();
        if (iPeekChar != TOKEN_NUMBER && iPeekChar != 10 && iPeekChar != 13 && iPeekChar != 32 && iPeekChar != 44 && iPeekChar != 58 && iPeekChar != 91 && iPeekChar != 93 && iPeekChar != 123 && iPeekChar != 125) {
            throw createHelpfulException(c, cArr, cArr.length);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00b7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void consumeTokenNumber(char r17) throws com.grack.nanojson.JsonParserException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 246
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.grack.nanojson.JsonTokener.consumeTokenNumber(char):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0153, code lost:
    
        throw createParseException(null, r1.toString(), com.grack.nanojson.JsonTokener.$assertionsDisabled);
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0154, code lost:
    
        r1 = r17.reusableBuffer;
        r3 = (char) r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x016b, code lost:
    
        throw createParseException(null, "Invalid escape: \\" + r1, com.grack.nanojson.JsonTokener.$assertionsDisabled);
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x016c, code lost:
    
        r17.reusableBuffer.append('\t');
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x0172, code lost:
    
        r17.reusableBuffer.append('\r');
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0178, code lost:
    
        r1 = r17.reusableBuffer;
        r3 = '\n';
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x017e, code lost:
    
        r1 = r17.reusableBuffer;
        r3 = '\f';
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0184, code lost:
    
        r1 = r17.reusableBuffer;
        r3 = '\b';
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x018a, code lost:
    
        r17.reusableBuffer.append(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x018f, code lost:
    
        r1 = com.grack.nanojson.JsonTokener.BUFFER_ROOM;
        r9 = ':';
        r11 = ',';
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x01a8, code lost:
    
        throw createParseException(null, "Invalid character in semi-string: " + r3, com.grack.nanojson.JsonTokener.$assertionsDisabled);
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x01a9, code lost:
    
        fixupAfterRawBufferRead();
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x01ac, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x01ad, code lost:
    
        r1 = r17.bufferLength;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x01af, code lost:
    
        if (r3 > r1) goto L154;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x01b1, code lost:
    
        r1 = com.grack.nanojson.JsonTokener.BUFFER_ROOM;
        r9 = ':';
        r11 = ',';
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x01ba, code lost:
    
        r17.index = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x01c0, code lost:
    
        throw createParseException(null, "EOF encountered in the middle of a string escape", com.grack.nanojson.JsonTokener.$assertionsDisabled);
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x01c6, code lost:
    
        throw createParseException(null, "String was not terminated before end of input", true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x01c7, code lost:
    
        r17.reusableBuffer.append(r17.buffer, (r17.index - r7) - 1, r7);
        fixupAfterRawBufferRead();
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x01d5, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x005f, code lost:
    
        r17.reusableBuffer.append(r17.buffer, (r17.index - r7) - 1, r7);
        r17.index--;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x006f, code lost:
    
        r3 = ensureBuffer(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0073, code lost:
    
        if (r3 == 0) goto L138;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0075, code lost:
    
        r7 = r17.index + r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0078, code lost:
    
        r3 = r17.index;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x007c, code lost:
    
        if (r3 >= r7) goto L139;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x007e, code lost:
    
        r3 = stringChar();
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0084, code lost:
    
        if (r17.utf8 == false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0088, code lost:
    
        if ((r3 & 128) == 0) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x008a, code lost:
    
        consumeTokenStringUtf8Char(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0090, code lost:
    
        if (r3 == com.grack.nanojson.JsonTokener.TOKEN_NUMBER) goto L140;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0094, code lost:
    
        if (r3 == '\n') goto L141;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0098, code lost:
    
        if (r3 == '\r') goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x009c, code lost:
    
        if (r3 == ' ') goto L143;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x009e, code lost:
    
        if (r3 == r11) goto L144;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00a0, code lost:
    
        if (r3 == r9) goto L145;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00a2, code lost:
    
        if (r3 == '{') goto L146;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00a4, code lost:
    
        if (r3 == '}') goto L147;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00a6, code lost:
    
        switch(r3) {
            case 91: goto L148;
            case 92: goto L55;
            case 93: goto L148;
            default: goto L53;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00a9, code lost:
    
        r1 = r17.reusableBuffer;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00ab, code lost:
    
        r1.append(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00b7, code lost:
    
        if ((r7 - r17.index) >= 5) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00b9, code lost:
    
        r1 = ensureBuffer(5);
        r7 = r17.index;
        r16 = r7 + r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00c5, code lost:
    
        if (r17.buffer[r7] != 'u') goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00c7, code lost:
    
        if (r1 < 5) goto L149;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00ca, code lost:
    
        r17.index = r17.bufferLength;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00d2, code lost:
    
        throw createParseException(null, "EOF encountered in the middle of a string escape", com.grack.nanojson.JsonTokener.$assertionsDisabled);
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00d3, code lost:
    
        r7 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00d5, code lost:
    
        r1 = r17.buffer;
        r8 = r17.index;
        r17.index = r8 + 1;
        r1 = r1[r8];
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00e1, code lost:
    
        if (r1 == '\"') goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00e5, code lost:
    
        if (r1 == '/') goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00e7, code lost:
    
        if (r1 == '\\') goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00eb, code lost:
    
        if (r1 == 'b') goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00ef, code lost:
    
        if (r1 == 'f') goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00f3, code lost:
    
        if (r1 == 'n') goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00f7, code lost:
    
        if (r1 == 'r') goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x00fb, code lost:
    
        if (r1 == 't') goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x00fd, code lost:
    
        if (r1 != 'u') goto L150;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x00ff, code lost:
    
        r1 = 0;
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0102, code lost:
    
        if (r1 >= com.grack.nanojson.JsonTokener.TOKEN_ARRAY_END) goto L162;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0104, code lost:
    
        r3 = r3 << com.grack.nanojson.JsonTokener.TOKEN_ARRAY_END;
        r6 = r17.buffer;
        r9 = r17.index;
        r17.index = r9 + 1;
        r6 = r6[r9];
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0112, code lost:
    
        if (r6 < '0') goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0116, code lost:
    
        if (r6 > '9') goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0118, code lost:
    
        r6 = r6 - '0';
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x011a, code lost:
    
        r3 = r3 | r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x011e, code lost:
    
        if (r6 < 'A') goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0122, code lost:
    
        if (r6 > 'F') goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0124, code lost:
    
        r6 = r6 - '7';
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0129, code lost:
    
        if (r6 < 'a') goto L151;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x012b, code lost:
    
        if (r6 > 'f') goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x012d, code lost:
    
        r6 = r6 - 'W';
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0130, code lost:
    
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0133, code lost:
    
        r1 = new java.lang.StringBuilder("Expected unicode hex escape character: ");
        r1.append(r6);
        r1.append(" (");
        r1.append((int) r6);
        r1.append(")");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void consumeTokenSemiString() throws com.grack.nanojson.JsonParserException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 498
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.grack.nanojson.JsonTokener.consumeTokenSemiString():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:81:0x0100, code lost:
    
        r1 = new java.lang.StringBuilder("Expected unicode hex escape character: ");
        r1.append(r11);
        r1.append(" (");
        r1.append((int) r11);
        r1.append(")");
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0120, code lost:
    
        throw createParseException(null, r1.toString(), com.grack.nanojson.JsonTokener.$assertionsDisabled);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void consumeTokenString(int r17) throws com.grack.nanojson.JsonParserException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 396
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.grack.nanojson.JsonTokener.consumeTokenString(int):void");
    }

    public JsonParserException createHelpfulException(char c, char[] cArr, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(c);
        String str = VideoStream.RESOLUTION_UNKNOWN;
        sb.append(cArr == null ? VideoStream.RESOLUTION_UNKNOWN : new String(cArr, 0, i));
        StringBuilder sb2 = new StringBuilder(sb.toString());
        while (isAsciiLetter(peekChar()) && sb2.length() < 15) {
            sb2.append((char) advanceChar());
        }
        StringBuilder sb3 = new StringBuilder("Unexpected token '");
        sb3.append((Object) sb2);
        sb3.append("'");
        if (cArr != null) {
            str = ". Did you mean '" + c + new String(cArr) + "'?";
        }
        sb3.append(str);
        return createParseException(null, sb3.toString(), true);
    }

    public JsonParserException createParseException(Exception exc, String str, boolean z) {
        if (z) {
            return new JsonParserException(exc, str + " on line " + this.linePos + ", char " + this.tokenCharPos, this.linePos, this.tokenCharPos, this.tokenCharOffset);
        }
        int iMax = Math.max(1, ((this.index + this.charOffset) - this.rowPos) - this.utf8adjust);
        return new JsonParserException(exc, str + " on line " + this.linePos + ", char " + iMax, this.linePos, iMax, this.index + this.charOffset);
    }

    public int ensureBuffer(int i) throws JsonParserException, IOException {
        int i2;
        int i3 = this.bufferLength;
        int i4 = i3 - i;
        int i5 = this.index;
        if (i4 >= i5) {
            return i;
        }
        if (i5 > 0) {
            this.charOffset += i5;
            int i6 = i3 - i5;
            this.bufferLength = i6;
            char[] cArr = this.buffer;
            System.arraycopy(cArr, i5, cArr, 0, i6);
            this.index = 0;
        }
        do {
            try {
                char[] cArr2 = this.buffer;
                int length = cArr2.length;
                int i7 = this.bufferLength;
                if (length <= i7) {
                    throw new IOException("Unexpected internal error");
                }
                int i8 = this.reader.read(cArr2, i7, cArr2.length - i7);
                int i9 = this.bufferLength;
                if (i8 <= 0) {
                    return i9 - this.index;
                }
                i2 = i9 + i8;
                this.bufferLength = i2;
            } catch (IOException e) {
                throw createParseException(e, "IOException", true);
            }
        } while (i2 <= i);
        return i2 - this.index;
    }

    public void fixupAfterRawBufferRead() {
        if (this.index >= this.bufferLength) {
            this.eof = refillBuffer();
        }
    }

    public boolean isAsciiLetter(int i) {
        if (i >= 65 && i <= 90) {
            return true;
        }
        if (i < 97 || i > 122) {
            return $assertionsDisabled;
        }
        return true;
    }

    public boolean isWhitespace(int i) {
        if (i == 32 || i == 10 || i == 13 || i == TOKEN_NUMBER) {
            return true;
        }
        return $assertionsDisabled;
    }

    public int tokenChar() {
        int iAdvanceChar;
        do {
            iAdvanceChar = advanceChar();
        } while (isWhitespace(iAdvanceChar));
        return iAdvanceChar;
    }

    public JsonTokener(Reader reader) throws JsonParserException, IOException {
        this.linePos = 1;
        this.buffer = new char[BUFFER_SIZE];
        this.reusableBuffer = new StringBuilder();
        this.reader = reader;
        this.utf8 = $assertionsDisabled;
        init();
    }
}
