package com.github.catvod.spider.jdollar.time.format;

import com.github.catvod.spider.jdollar.time.DateTimeException;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class k implements e {
    public final e a;
    public final int b;
    public final char c;

    public k(e eVar, int i, char c) {
        this.a = eVar;
        this.b = i;
        this.c = c;
    }

    @Override // com.github.catvod.spider.jdollar.time.format.e
    public final boolean h(w wVar, StringBuilder sb) {
        int length = sb.length();
        if (!this.a.h(wVar, sb)) {
            return false;
        }
        int length2 = sb.length() - length;
        int i = this.b;
        if (length2 <= i) {
            for (int i2 = 0; i2 < i - length2; i2++) {
                sb.insert(length, this.c);
            }
            return true;
        }
        throw new DateTimeException("Cannot print as output of " + length2 + " characters exceeds pad width of " + i);
    }

    @Override // com.github.catvod.spider.jdollar.time.format.e
    public final int i(v vVar, CharSequence charSequence, int i) {
        boolean z = vVar.c;
        if (i > charSequence.length()) {
            throw new IndexOutOfBoundsException();
        }
        if (i == charSequence.length()) {
            return ~i;
        }
        int length = this.b + i;
        if (length > charSequence.length()) {
            if (z) {
                return ~i;
            }
            length = charSequence.length();
        }
        int i2 = i;
        while (i2 < length && vVar.a(charSequence.charAt(i2), this.c)) {
            i2++;
        }
        int i3 = this.a.i(vVar, charSequence.subSequence(0, length), i2);
        return (i3 == length || !z) ? i3 : ~(i + i2);
    }

    public final String toString() {
        String str;
        char c = this.c;
        if (c == ' ') {
            str = ")";
        } else {
            str = ",'" + c + "')";
        }
        return "Pad(" + this.a + "," + this.b + str;
    }
}
