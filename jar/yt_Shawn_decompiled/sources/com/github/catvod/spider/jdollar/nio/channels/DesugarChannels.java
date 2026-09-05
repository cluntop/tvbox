package com.github.catvod.spider.jdollar.nio.channels;

import com.github.catvod.spider.jdollar.desugar.sun.nio.fs.e;
import com.github.catvod.spider.jdollar.nio.file.OpenOption;
import com.github.catvod.spider.jdollar.nio.file.Path;
import com.github.catvod.spider.jdollar.nio.file.attribute.FileAttribute;
import com.github.catvod.spider.jdollar.nio.file.v;
import java.nio.channels.FileChannel;
import java.util.Collections;
import java.util.HashSet;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class DesugarChannels {
    public static FileChannel convertMaybeLegacyFileChannelFromLibrary(FileChannel fileChannel) {
        if (fileChannel == null) {
            return null;
        }
        if (com.github.catvod.spider.jdollar.adapter.a.a) {
            return fileChannel;
        }
        int i = e.e;
        return fileChannel instanceof e ? (e) fileChannel : new e(fileChannel, false, false, null);
    }

    public static FileChannel open(Path path, OpenOption... openOptionArr) {
        HashSet hashSet = new HashSet();
        Collections.addAll(hashSet, openOptionArr);
        return com.github.catvod.spider.jdollar.adapter.a.b ? FileChannel.open(v.h(path), com.github.catvod.spider.jdollar.com.android.tools.r8.a.u(hashSet), com.github.catvod.spider.jdollar.com.android.tools.r8.a.L(new FileAttribute[0])) : com.github.catvod.spider.jdollar.com.android.tools.r8.a.S(path, hashSet);
    }
}
