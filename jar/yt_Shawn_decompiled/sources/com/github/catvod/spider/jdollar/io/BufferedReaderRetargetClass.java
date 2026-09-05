package com.github.catvod.spider.jdollar.io;

import com.github.catvod.spider.jdollar.util.Spliterators;
import com.github.catvod.spider.jdollar.util.stream.Stream;
import com.github.catvod.spider.jdollar.util.stream.StreamSupport;
import java.io.BufferedReader;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class BufferedReaderRetargetClass {
    public static Stream lines(BufferedReader bufferedReader) {
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(new a(bufferedReader), 272), false);
    }
}
