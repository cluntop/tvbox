package com.github.catvod.spider.merge.h0;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class g {
    public final File a;
    public final FileOutputStream b;

    public g(File file) throws IOException {
        File fileCreateTempFile = File.createTempFile("NanoHTTPD-", VideoStream.RESOLUTION_UNKNOWN, file);
        this.a = fileCreateTempFile;
        this.b = new FileOutputStream(fileCreateTempFile);
    }
}
