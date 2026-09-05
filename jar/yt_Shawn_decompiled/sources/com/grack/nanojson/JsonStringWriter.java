package com.grack.nanojson;

import java.io.IOException;

/* loaded from: classes.dex */
public final class JsonStringWriter extends JsonWriterBase<JsonStringWriter> {
    public JsonStringWriter(String str) {
        super(new StringBuilder(), str);
    }

    public String done() throws IOException {
        super.doneInternal();
        return this.appendable.toString();
    }
}
