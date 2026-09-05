package com.grack.nanojson;

import com.grack.nanojson.JsonWriterBase;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.util.BitSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class JsonWriterBase<SELF extends JsonWriterBase<SELF>> implements JsonSink<SELF> {
    static final int BUFFER_SIZE = 10240;
    protected final Appendable appendable;
    private final byte[] bb;
    private int bo;
    private final StringBuilder buffer;
    private boolean first;
    private boolean inObject;
    private int indent;
    private String indentString;
    protected final OutputStream out;
    private int stateIndex;
    private BitSet states;
    protected final boolean utf8;
    private static final char[] NULL = {'n', 'u', 'l', 'l'};
    private static final char[] TRUE = {'t', 'r', 'u', 'e'};
    private static final char[] FALSE = {'f', 'a', 'l', 's', 'e'};
    private static final char[] HEX = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final char[] UNICODE_SMALL = {'\\', 'u', '0', '0'};
    private static final char[] UNICODE_LARGE = {'\\', 'u'};

    public JsonWriterBase(Appendable appendable, String str) {
        this.bo = 0;
        this.states = new BitSet();
        this.stateIndex = 0;
        this.first = true;
        this.indent = 0;
        this.appendable = appendable;
        this.out = null;
        this.indentString = str;
        this.utf8 = false;
        this.buffer = new StringBuilder(BUFFER_SIZE);
        this.bb = null;
    }

    private void appendIndent() throws IOException {
        for (int i = 0; i < this.indent; i++) {
            raw(this.indentString);
        }
    }

    private void appendNewLine() throws IOException {
        raw('\n');
    }

    private SELF castThis() {
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x0173  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void emitStringValue(java.lang.String r11) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 400
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.grack.nanojson.JsonWriterBase.emitStringValue(java.lang.String):void");
    }

    private void flush() throws IOException {
        try {
            if (this.utf8) {
                this.out.write(this.bb, 0, this.bo);
                this.bo = 0;
            } else {
                this.appendable.append(this.buffer.toString());
                this.buffer.setLength(0);
            }
        } catch (IOException e) {
            throw new JsonWriterException(e);
        }
    }

    private void pre() throws IOException {
        if (this.first) {
            this.first = false;
            return;
        }
        if (this.stateIndex == 0) {
            throw new JsonWriterException("Invalid call to emit a value in a finished JSON writer");
        }
        raw(',');
        if (this.indentString == null || !this.inObject) {
            return;
        }
        appendNewLine();
    }

    private void preValue(String str) throws IOException {
        if (!this.inObject) {
            throw new JsonWriterException("Invalid call to emit a key value while not writing an object");
        }
        pre();
        if (this.indentString != null) {
            appendIndent();
        }
        emitStringValue(str);
        raw(':');
    }

    private void raw(String str) throws IOException {
        if (!this.utf8) {
            this.buffer.append(str);
            if (this.buffer.length() > BUFFER_SIZE) {
                flush();
                return;
            }
            return;
        }
        int length = str.length();
        if (this.bo + length > BUFFER_SIZE) {
            flush();
        }
        for (int i = 0; i < length; i++) {
            byte[] bArr = this.bb;
            int i2 = this.bo;
            this.bo = i2 + 1;
            bArr[i2] = (byte) str.charAt(i);
        }
    }

    private boolean shouldBeEscaped(char c) {
        if (c < ' ') {
            return true;
        }
        if (c < 128 || c >= 160) {
            return c >= 8192 && c < 8448;
        }
        return true;
    }

    @Override // com.grack.nanojson.JsonSink
    public SELF array() throws IOException {
        preValue();
        BitSet bitSet = this.states;
        int i = this.stateIndex;
        this.stateIndex = i + 1;
        bitSet.set(i, this.inObject);
        this.inObject = false;
        this.first = true;
        raw('[');
        return (SELF) castThis();
    }

    public void doneInternal() throws IOException {
        if (this.stateIndex > 0) {
            throw new JsonWriterException("Unclosed JSON objects and/or arrays when closing writer");
        }
        if (this.first) {
            throw new JsonWriterException("Nothing was written to the JSON writer");
        }
        flush();
    }

    @Override // com.grack.nanojson.JsonSink
    public SELF end() throws IOException {
        char c;
        if (this.stateIndex == 0) {
            throw new JsonWriterException("Invalid call to end()");
        }
        if (this.inObject) {
            if (this.indentString != null) {
                this.indent--;
                appendNewLine();
                appendIndent();
            }
            c = '}';
        } else {
            c = ']';
        }
        raw(c);
        this.first = false;
        BitSet bitSet = this.states;
        int i = this.stateIndex - 1;
        this.stateIndex = i;
        this.inObject = bitSet.get(i);
        return (SELF) castThis();
    }

    @Override // com.grack.nanojson.JsonSink
    public SELF nul() throws IOException {
        preValue();
        raw(NULL);
        return (SELF) castThis();
    }

    @Override // com.grack.nanojson.JsonSink
    public SELF object(String str, Map<?, ?> map) throws IOException {
        if (str == null) {
            object();
        } else {
            object(str);
        }
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            Object value = entry.getValue();
            if (!(entry.getKey() instanceof String)) {
                StringBuilder sb = new StringBuilder("Invalid key type for map: ");
                sb.append(entry.getKey() == null ? "null" : entry.getKey().getClass());
                throw new JsonWriterException(sb.toString());
            }
            value((String) entry.getKey(), value);
        }
        return (SELF) end();
    }

    @Override // com.grack.nanojson.JsonSink
    public SELF value(Object obj) throws IOException {
        if (obj == null) {
            return (SELF) nul();
        }
        if (obj instanceof String) {
            return (SELF) value((String) obj);
        }
        if (obj instanceof Number) {
            return (SELF) value((Number) obj);
        }
        if (obj instanceof Boolean) {
            return (SELF) value(((Boolean) obj).booleanValue());
        }
        if (obj instanceof Collection) {
            return (SELF) array((Collection<?>) obj);
        }
        if (obj instanceof Map) {
            return (SELF) object((Map<?, ?>) obj);
        }
        if (!obj.getClass().isArray()) {
            throw new JsonWriterException("Unable to handle type: " + obj.getClass());
        }
        int length = Array.getLength(obj);
        array();
        for (int i = 0; i < length; i++) {
            value(Array.get(obj, i));
        }
        return (SELF) end();
    }

    @Override // com.grack.nanojson.JsonSink
    public SELF nul(String str) throws IOException {
        preValue(str);
        raw(NULL);
        return (SELF) castThis();
    }

    private void preValue() throws IOException {
        if (this.inObject) {
            throw new JsonWriterException("Invalid call to emit a keyless value while writing an object");
        }
        pre();
    }

    @Override // com.grack.nanojson.JsonSink
    public /* bridge */ /* synthetic */ JsonSink array(String str, Collection collection) {
        return array(str, (Collection<?>) collection);
    }

    @Override // com.grack.nanojson.JsonSink
    public /* bridge */ /* synthetic */ JsonSink array(Collection collection) {
        return array((Collection<?>) collection);
    }

    @Override // com.grack.nanojson.JsonSink
    public SELF array(String str) throws IOException {
        preValue(str);
        BitSet bitSet = this.states;
        int i = this.stateIndex;
        this.stateIndex = i + 1;
        bitSet.set(i, this.inObject);
        this.inObject = false;
        this.first = true;
        raw('[');
        return (SELF) castThis();
    }

    @Override // com.grack.nanojson.JsonSink
    public SELF array(String str, Collection<?> collection) throws IOException {
        if (str == null) {
            array();
        } else {
            array(str);
        }
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            value(it.next());
        }
        return (SELF) end();
    }

    @Override // com.grack.nanojson.JsonSink
    public SELF array(Collection<?> collection) {
        return (SELF) array((String) null, collection);
    }

    public JsonWriterBase(OutputStream outputStream, String str) {
        this.bo = 0;
        this.states = new BitSet();
        this.stateIndex = 0;
        this.first = true;
        this.indent = 0;
        this.appendable = null;
        this.out = outputStream;
        this.indentString = str;
        this.utf8 = true;
        this.buffer = null;
        this.bb = new byte[BUFFER_SIZE];
    }

    private void raw(char c) throws IOException {
        if (!this.utf8) {
            this.buffer.append(c);
            if (this.buffer.length() > BUFFER_SIZE) {
                flush();
                return;
            }
            return;
        }
        if (this.bo + 1 > BUFFER_SIZE) {
            flush();
        }
        byte[] bArr = this.bb;
        int i = this.bo;
        this.bo = i + 1;
        bArr[i] = (byte) c;
    }

    private void raw(char[] cArr) throws IOException {
        if (!this.utf8) {
            this.buffer.append(cArr);
            if (this.buffer.length() > BUFFER_SIZE) {
                flush();
                return;
            }
            return;
        }
        if (this.bo + cArr.length > BUFFER_SIZE) {
            flush();
        }
        for (char c : cArr) {
            byte[] bArr = this.bb;
            int i = this.bo;
            this.bo = i + 1;
            bArr[i] = (byte) c;
        }
    }

    @Override // com.grack.nanojson.JsonSink
    public /* bridge */ /* synthetic */ JsonSink object(String str, Map map) {
        return object(str, (Map<?, ?>) map);
    }

    @Override // com.grack.nanojson.JsonSink
    public /* bridge */ /* synthetic */ JsonSink object(Map map) {
        return object((Map<?, ?>) map);
    }

    @Override // com.grack.nanojson.JsonSink
    public SELF object() throws IOException {
        preValue();
        BitSet bitSet = this.states;
        int i = this.stateIndex;
        this.stateIndex = i + 1;
        bitSet.set(i, this.inObject);
        this.inObject = true;
        this.first = true;
        raw('{');
        if (this.indentString != null) {
            this.indent++;
            appendNewLine();
        }
        return (SELF) castThis();
    }

    @Override // com.grack.nanojson.JsonSink
    public SELF object(String str) throws IOException {
        preValue(str);
        BitSet bitSet = this.states;
        int i = this.stateIndex;
        this.stateIndex = i + 1;
        bitSet.set(i, this.inObject);
        this.inObject = true;
        this.first = true;
        raw('{');
        if (this.indentString != null) {
            this.indent++;
            appendNewLine();
        }
        return (SELF) castThis();
    }

    @Override // com.grack.nanojson.JsonSink
    public SELF object(Map<?, ?> map) {
        return (SELF) object((String) null, map);
    }

    @Override // com.grack.nanojson.JsonSink
    public SELF value(double d) throws IOException {
        preValue();
        raw(Double.toString(d));
        return (SELF) castThis();
    }

    @Override // com.grack.nanojson.JsonSink
    public SELF value(float f) throws IOException {
        preValue();
        raw(Float.toString(f));
        return (SELF) castThis();
    }

    @Override // com.grack.nanojson.JsonSink
    public SELF value(int i) throws IOException {
        preValue();
        raw(Integer.toString(i));
        return (SELF) castThis();
    }

    @Override // com.grack.nanojson.JsonSink
    public SELF value(long j) throws IOException {
        preValue();
        raw(Long.toString(j));
        return (SELF) castThis();
    }

    @Override // com.grack.nanojson.JsonSink
    public SELF value(Number number) throws IOException {
        preValue();
        if (number == null) {
            raw(NULL);
        } else {
            raw(number.toString());
        }
        return (SELF) castThis();
    }

    @Override // com.grack.nanojson.JsonSink
    public SELF value(String str) throws IOException {
        if (str == null) {
            return (SELF) nul();
        }
        preValue();
        emitStringValue(str);
        return (SELF) castThis();
    }

    @Override // com.grack.nanojson.JsonSink
    public SELF value(String str, double d) throws IOException {
        preValue(str);
        raw(Double.toString(d));
        return (SELF) castThis();
    }

    @Override // com.grack.nanojson.JsonSink
    public SELF value(String str, float f) throws IOException {
        preValue(str);
        raw(Float.toString(f));
        return (SELF) castThis();
    }

    @Override // com.grack.nanojson.JsonSink
    public SELF value(String str, int i) throws IOException {
        preValue(str);
        raw(Integer.toString(i));
        return (SELF) castThis();
    }

    @Override // com.grack.nanojson.JsonSink
    public SELF value(String str, long j) throws IOException {
        preValue(str);
        raw(Long.toString(j));
        return (SELF) castThis();
    }

    @Override // com.grack.nanojson.JsonSink
    public SELF value(String str, Number number) throws IOException {
        if (number == null) {
            return (SELF) nul(str);
        }
        preValue(str);
        raw(number.toString());
        return (SELF) castThis();
    }

    @Override // com.grack.nanojson.JsonSink
    public SELF value(String str, Object obj) throws IOException {
        if (obj == null) {
            return (SELF) nul(str);
        }
        if (obj instanceof String) {
            return (SELF) value(str, (String) obj);
        }
        if (obj instanceof Number) {
            return (SELF) value(str, (Number) obj);
        }
        if (obj instanceof Boolean) {
            return (SELF) value(str, ((Boolean) obj).booleanValue());
        }
        if (obj instanceof Collection) {
            return (SELF) array(str, (Collection<?>) obj);
        }
        if (obj instanceof Map) {
            return (SELF) object(str, (Map<?, ?>) obj);
        }
        if (!obj.getClass().isArray()) {
            throw new JsonWriterException("Unable to handle type: " + obj.getClass());
        }
        int length = Array.getLength(obj);
        array(str);
        for (int i = 0; i < length; i++) {
            value(Array.get(obj, i));
        }
        return (SELF) end();
    }

    @Override // com.grack.nanojson.JsonSink
    public SELF value(String str, String str2) throws IOException {
        if (str2 == null) {
            return (SELF) nul(str);
        }
        preValue(str);
        emitStringValue(str2);
        return (SELF) castThis();
    }

    @Override // com.grack.nanojson.JsonSink
    public SELF value(String str, boolean z) throws IOException {
        preValue(str);
        raw(z ? TRUE : FALSE);
        return (SELF) castThis();
    }

    @Override // com.grack.nanojson.JsonSink
    public SELF value(boolean z) throws IOException {
        preValue();
        raw(z ? TRUE : FALSE);
        return (SELF) castThis();
    }
}
