package com.github.catvod.spider.jdollar.time.format;

import java.text.ParsePosition;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class m {
    public String a;
    public String b;
    public final char c;
    public m d;
    public m e;

    public m(String str, String str2, m mVar) {
        this.a = str;
        this.b = str2;
        this.d = mVar;
        if (str.isEmpty()) {
            this.c = (char) 65535;
        } else {
            this.c = this.a.charAt(0);
        }
    }

    public final boolean a(String str, String str2) {
        int i = 0;
        while (i < str.length() && i < this.a.length() && b(str.charAt(i), this.a.charAt(i))) {
            i++;
        }
        if (i != this.a.length()) {
            m mVarD = d(this.a.substring(i), this.b, this.d);
            this.a = str.substring(0, i);
            this.d = mVarD;
            if (i >= str.length()) {
                this.b = str2;
                return true;
            }
            this.d.e = d(str.substring(i), str2, null);
            this.b = null;
            return true;
        }
        if (i >= str.length()) {
            this.b = str2;
            return true;
        }
        String strSubstring = str.substring(i);
        for (m mVar = this.d; mVar != null; mVar = mVar.e) {
            if (b(mVar.c, strSubstring.charAt(0))) {
                return mVar.a(strSubstring, str2);
            }
        }
        m mVarD2 = d(strSubstring, str2, null);
        mVarD2.e = this.d;
        this.d = mVarD2;
        return true;
    }

    public boolean b(char c, char c2) {
        return c == c2;
    }

    public final String c(CharSequence charSequence, ParsePosition parsePosition) {
        int index = parsePosition.getIndex();
        int length = charSequence.length();
        if (!e(charSequence, index, length)) {
            return null;
        }
        int length2 = this.a.length() + index;
        m mVar = this.d;
        if (mVar != null && length2 != length) {
            while (true) {
                if (b(mVar.c, charSequence.charAt(length2))) {
                    parsePosition.setIndex(length2);
                    String strC = mVar.c(charSequence, parsePosition);
                    if (strC != null) {
                        return strC;
                    }
                } else {
                    mVar = mVar.e;
                    if (mVar == null) {
                        break;
                    }
                }
            }
        }
        parsePosition.setIndex(length2);
        return this.b;
    }

    public m d(String str, String str2, m mVar) {
        return new m(str, str2, mVar);
    }

    public boolean e(CharSequence charSequence, int i, int i2) {
        boolean z = charSequence instanceof String;
        String str = this.a;
        if (z) {
            return ((String) charSequence).startsWith(str, i);
        }
        int length = str.length();
        if (length > i2 - i) {
            return false;
        }
        int i3 = 0;
        while (true) {
            int i4 = length - 1;
            if (length <= 0) {
                return true;
            }
            int i5 = i3 + 1;
            int i6 = i + 1;
            if (!b(this.a.charAt(i3), charSequence.charAt(i))) {
                return false;
            }
            i = i6;
            length = i4;
            i3 = i5;
        }
    }
}
