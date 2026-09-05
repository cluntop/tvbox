package com.grack.nanojson;

import com.github.catvod.spider.merge.s0.a;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public final class JsonWriter {
    private JsonWriter() {
    }

    public static String escape(String str) {
        String strString = string(str);
        return strString.substring(1, strString.length() - 1);
    }

    public static JsonWriterContext indent(String str) {
        String str2;
        if (str != null) {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) != ' ' && str.charAt(i) != '\t') {
                    str2 = "Only tabs and spaces are allowed for indent.";
                }
            }
            return new JsonWriterContext(str);
        }
        str2 = "indent must be non-null";
        a.r(str2);
        return null;
    }

    public static JsonAppendableWriter on(OutputStream outputStream) {
        return new JsonAppendableWriter(outputStream, (String) null);
    }

    public static String string(Object obj) {
        return new JsonStringWriter(null).value(obj).done();
    }

    public static JsonAppendableWriter on(PrintStream printStream) {
        return new JsonAppendableWriter((Appendable) printStream, (String) null);
    }

    public static JsonAppendableWriter on(Appendable appendable) {
        return new JsonAppendableWriter(appendable, (String) null);
    }

    public static JsonStringWriter string() {
        return new JsonStringWriter(null);
    }

    public final class JsonWriterContext {
        private final String indent;

        private JsonWriterContext(String str) {
            this.indent = str;
        }

        public JsonAppendableWriter on(OutputStream outputStream) {
            return new JsonAppendableWriter(new OutputStreamWriter(outputStream, Charset.forName("UTF-8")), this.indent);
        }

        public JsonStringWriter string() {
            return new JsonStringWriter(this.indent);
        }

        public JsonAppendableWriter on(PrintStream printStream) {
            return new JsonAppendableWriter((Appendable) printStream, this.indent);
        }

        public JsonAppendableWriter on(Appendable appendable) {
            return new JsonAppendableWriter(appendable, this.indent);
        }
    }
}
