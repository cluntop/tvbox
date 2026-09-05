package com.github.catvod.spider.jdollar.desugar.sun.nio.fs;

import com.github.catvod.spider.jdollar.nio.file.FileSystem;
import com.github.catvod.spider.jdollar.nio.file.Path;
import com.github.catvod.spider.jdollar.nio.file.attribute.y;
import com.github.catvod.spider.jdollar.nio.file.m0;
import java.util.Set;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class h extends FileSystem {
    public final String a;
    public final String b;
    public final l c;

    public h(l lVar, String str, String str2) {
        this.c = lVar;
        this.a = str;
        this.b = str2;
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.FileSystem
    public final boolean C() {
        return false;
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.FileSystem
    public final m0 D() {
        throw new UnsupportedOperationException();
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.FileSystem
    public final com.github.catvod.spider.jdollar.nio.file.spi.d E() {
        return this.c;
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.FileSystem
    public final Set F() {
        return com.github.catvod.spider.jdollar.com.android.tools.r8.a.D(new Object[]{"basic"});
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.FileSystem, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new UnsupportedOperationException();
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.FileSystem
    public final Iterable g() {
        throw new UnsupportedOperationException(VideoStream.RESOLUTION_UNKNOWN);
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.FileSystem
    public final Path getPath(String str, String[] strArr) {
        if (strArr.length != 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            for (String str2 : strArr) {
                if (!str2.isEmpty()) {
                    if (sb.length() > 0) {
                        sb.append('/');
                    }
                    sb.append(str2);
                }
            }
            str = sb.toString();
        }
        return new n(this, str, this.a, this.b);
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.FileSystem
    public final String getSeparator() {
        return "/";
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.FileSystem
    public final boolean isOpen() {
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:82:0x011e, code lost:
    
        r4 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0134, code lost:
    
        if (r7 != ']') goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0136, code lost:
    
        r1.append("]]");
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0145, code lost:
    
        throw new java.util.regex.PatternSyntaxException("Missing ']", r0, r4 - 1);
     */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0126  */
    @Override // com.github.catvod.spider.jdollar.nio.file.FileSystem
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.github.catvod.spider.jdollar.nio.file.c0 k(java.lang.String r18) {
        /*
            Method dump skipped, instructions count: 491
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.catvod.spider.jdollar.desugar.sun.nio.fs.h.k(java.lang.String):com.github.catvod.spider.jdollar.nio.file.c0");
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.FileSystem
    public final Iterable n() {
        return com.github.catvod.spider.jdollar.com.android.tools.r8.a.B(new Object[]{new n(this, "/", this.a, this.b)});
    }

    @Override // com.github.catvod.spider.jdollar.nio.file.FileSystem
    public final y p() {
        throw new UnsupportedOperationException();
    }
}
