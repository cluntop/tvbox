package com.github.catvod.spider.jdollar.time.format;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class c implements e {
    public final char a;

    public c(char c) {
        this.a = c;
    }

    @Override // com.github.catvod.spider.jdollar.time.format.e
    public final boolean h(w wVar, StringBuilder sb) {
        sb.append(this.a);
        return true;
    }

    @Override // com.github.catvod.spider.jdollar.time.format.e
    public final int i(v vVar, CharSequence charSequence, int i) {
        if (i == charSequence.length()) {
            return ~i;
        }
        char cCharAt = charSequence.charAt(i);
        char c = this.a;
        return (cCharAt == c || (!vVar.b && (Character.toUpperCase(cCharAt) == Character.toUpperCase(c) || Character.toLowerCase(cCharAt) == Character.toLowerCase(c)))) ? i + 1 : ~i;
    }

    public final String toString() {
        char c = this.a;
        if (c == '\'') {
            return "''";
        }
        return "'" + c + "'";
    }
}
