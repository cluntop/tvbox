package com.grack.nanojson;

import java.io.Flushable;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
public final class JsonAppendableWriter extends JsonWriterBase<JsonAppendableWriter> implements JsonSink<JsonAppendableWriter> {
    public JsonAppendableWriter(OutputStream outputStream, String str) {
        super(outputStream, str);
    }

    public void done() throws IOException {
        super.doneInternal();
        try {
            Appendable appendable = this.appendable;
            if (appendable instanceof Flushable) {
                ((Flushable) appendable).flush();
                return;
            }
            OutputStream outputStream = this.out;
            if (outputStream != null) {
                outputStream.flush();
            }
        } catch (IOException e) {
            throw new JsonWriterException(e);
        }
    }

    public JsonAppendableWriter(Appendable appendable, String str) {
        super(appendable, str);
    }
}
