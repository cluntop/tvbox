package org.schabi.newpipe.extractor.utils;

import com.github.catvod.spider.jdollar.util.Collection$EL;
import com.github.catvod.spider.jdollar.util.stream.Collectors;
import com.github.catvod.spider.merge.o1.h;
import com.github.catvod.spider.merge.u.c2;
import com.grack.nanojson.JsonArray;
import com.grack.nanojson.JsonObject;
import com.grack.nanojson.JsonParser;
import com.grack.nanojson.JsonParserException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.schabi.newpipe.extractor.exceptions.ParsingException;
import org.schabi.newpipe.extractor.services.youtube.extractors.n;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class JsonUtils {
    private JsonUtils() {
    }

    public static JsonArray getArray(JsonObject jsonObject, String str) {
        return (JsonArray) getInstanceOf(jsonObject, str, JsonArray.class);
    }

    public static Boolean getBoolean(JsonObject jsonObject, String str) {
        return (Boolean) getInstanceOf(jsonObject, str, Boolean.class);
    }

    private static <T> T getInstanceOf(JsonObject jsonObject, String str, Class<T> cls) throws ParsingException {
        Object value = getValue(jsonObject, str);
        if (cls.isInstance(value)) {
            return cls.cast(value);
        }
        throw new ParsingException(com.github.catvod.spider.merge.b.b.n("Wrong data type at path ", str));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static JsonObject getJsonData(String str, String str2) {
        h hVarT = c2.T(str);
        hVarT.getClass();
        c2.P(str2);
        return JsonParser.object().from(c2.k(new com.github.catvod.spider.merge.q1.h(str2.trim(), 0, 0 == true ? 1 : 0), hVarT).a(str2));
    }

    public static Number getNumber(JsonObject jsonObject, String str) {
        return (Number) getInstanceOf(jsonObject, str, Number.class);
    }

    private static JsonObject getObject(JsonObject jsonObject, List<String> list) {
        Iterator<String> it = list.iterator();
        while (it.hasNext() && (jsonObject = jsonObject.getObject(it.next())) != null) {
        }
        return jsonObject;
    }

    public static String getString(JsonObject jsonObject, String str) {
        return (String) getInstanceOf(jsonObject, str, String.class);
    }

    public static List<String> getStringListFromJsonArray(JsonArray jsonArray) {
        return (List) Collection$EL.stream(jsonArray).filter(new n(2)).map(new org.schabi.newpipe.extractor.services.youtube.extractors.h(7)).collect(Collectors.toList());
    }

    public static Object getValue(JsonObject jsonObject, String str) throws ParsingException {
        List listAsList = Arrays.asList(str.split("\\."));
        JsonObject object = getObject(jsonObject, (List<String>) listAsList.subList(0, listAsList.size() - 1));
        if (object == null) {
            throw new ParsingException("Unable to get ".concat(str));
        }
        Object obj = object.get(listAsList.get(listAsList.size() - 1));
        if (obj != null) {
            return obj;
        }
        throw new ParsingException("Unable to get ".concat(str));
    }

    public static List<Object> getValues(JsonArray jsonArray, String str) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jsonArray.size(); i++) {
            arrayList.add(getValue(jsonArray.getObject(i), str));
        }
        return arrayList;
    }

    public static JsonArray toJsonArray(String str) throws ParsingException {
        try {
            return JsonParser.array().from(str);
        } catch (JsonParserException e) {
            com.github.catvod.spider.merge.s0.a.m("Could not parse JSON", e);
            return null;
        }
    }

    public static JsonObject toJsonObject(String str) {
        try {
            return JsonParser.object().from(str);
        } catch (JsonParserException e) {
            com.github.catvod.spider.merge.s0.a.m("Could not parse JSON", e);
            return null;
        }
    }

    public static JsonObject getObject(JsonObject jsonObject, String str) {
        return (JsonObject) getInstanceOf(jsonObject, str, JsonObject.class);
    }
}
