package com.grack.nanojson;

import com.github.catvod.spider.jdollar.util.Collection$EL;
import com.github.catvod.spider.jdollar.util.stream.Stream;
import com.github.catvod.spider.merge.o1.j;
import com.github.catvod.spider.merge.o1.k;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/* loaded from: classes.dex */
public class JsonArray extends ArrayList<Object> {
    private static final long serialVersionUID = 1;

    public JsonArray() {
    }

    public static JsonBuilder<JsonArray> builder() {
        return new JsonBuilder<>(new JsonArray());
    }

    public static JsonArray from(Object... objArr) {
        return new JsonArray(Arrays.asList(objArr));
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public Object get(int i) {
        if (i < size()) {
            return super.get(i);
        }
        return null;
    }

    public JsonArray getArray(int i, JsonArray jsonArray) {
        Object obj = get(i);
        return obj instanceof JsonArray ? (JsonArray) obj : jsonArray;
    }

    public boolean getBoolean(int i, Boolean bool) {
        Object obj = get(i);
        return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : bool.booleanValue();
    }

    public double getDouble(int i, double d) {
        Object obj = get(i);
        return obj instanceof Number ? ((Number) obj).doubleValue() : d;
    }

    public float getFloat(int i, float f) {
        Object obj = get(i);
        return obj instanceof Number ? ((Number) obj).floatValue() : f;
    }

    public int getInt(int i, int i2) {
        Object obj = get(i);
        return obj instanceof Number ? ((Number) obj).intValue() : i2;
    }

    public long getLong(int i, long j) {
        Object obj = get(i);
        return obj instanceof Number ? ((Number) obj).longValue() : j;
    }

    public Number getNumber(int i, Number number) {
        Object obj = get(i);
        return obj instanceof Number ? (Number) obj : number;
    }

    public JsonObject getObject(int i, JsonObject jsonObject) {
        Object obj = get(i);
        return obj instanceof JsonObject ? (JsonObject) obj : jsonObject;
    }

    public String getString(int i, String str) {
        Object obj = get(i);
        return obj instanceof String ? (String) obj : str;
    }

    public boolean has(int i) {
        return i < size();
    }

    public boolean isBoolean(int i) {
        return get(i) instanceof Boolean;
    }

    public boolean isNull(int i) {
        return i < size() && get(i) == null;
    }

    public boolean isNumber(int i) {
        return get(i) instanceof Number;
    }

    public boolean isString(int i) {
        return get(i) instanceof String;
    }

    public <T> Stream<T> streamAs(Class<T> cls) {
        Stream stream = Collection$EL.stream(this);
        cls.getClass();
        int i = 1;
        return (Stream<T>) stream.filter(new j(cls, i)).map(new k(cls, i));
    }

    public Stream<JsonObject> streamAsJsonObjects() {
        return streamAs(JsonObject.class);
    }

    public JsonArray(int i) {
        super(i);
    }

    public JsonArray(Collection<?> collection) {
        super(collection);
    }

    public JsonArray getArray(int i) {
        return getArray(i, new JsonArray());
    }

    public Number getNumber(int i) {
        return getNumber(i, null);
    }

    public JsonObject getObject(int i) {
        return getObject(i, new JsonObject());
    }

    public String getString(int i) {
        return getString(i, null);
    }

    public double getDouble(int i) {
        return getDouble(i, 0.0d);
    }

    public float getFloat(int i) {
        return getFloat(i, 0.0f);
    }

    public int getInt(int i) {
        return getInt(i, 0);
    }

    public long getLong(int i) {
        return getLong(i, 0L);
    }

    public boolean getBoolean(int i) {
        return getBoolean(i, Boolean.FALSE);
    }
}
