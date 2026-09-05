package com.grack.nanojson;

/* loaded from: classes.dex */
public class JsonParserException extends Exception {
    private static final long serialVersionUID = 1;
    private final int charOffset;
    private final int charPos;
    private final int linePos;

    public JsonParserException(Exception exc, String str, int i, int i2, int i3) {
        super(str, exc);
        this.linePos = i;
        this.charPos = i2;
        this.charOffset = i3;
    }

    public int getCharOffset() {
        return this.charOffset;
    }

    public int getCharPosition() {
        return this.charPos;
    }

    public int getLinePosition() {
        return this.linePos;
    }
}
