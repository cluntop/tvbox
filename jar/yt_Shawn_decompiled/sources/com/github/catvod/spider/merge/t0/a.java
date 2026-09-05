package com.github.catvod.spider.merge.t0;

import com.github.catvod.spider.jdollar.util.DesugarCollections;
import com.github.catvod.spider.jdollar.util.Objects;
import com.github.catvod.spider.merge.y0.g0;
import com.grack.nanojson.JsonObject;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;
import org.slf4j.Logger;
import org.slf4j.event.Level;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract /* synthetic */ class a {
    public static boolean a(Logger logger, Level level) {
        int i = level.toInt();
        if (i == 0) {
            return logger.isTraceEnabled();
        }
        if (i == 10) {
            return logger.isDebugEnabled();
        }
        if (i == 20) {
            return logger.isInfoEnabled();
        }
        if (i == 30) {
            return logger.isWarnEnabled();
        }
        if (i == 40) {
            return logger.isErrorEnabled();
        }
        throw new IllegalArgumentException("Level [" + level + "] not recognized.");
    }

    public static int b(CharSequence charSequence, Function1 function1) {
        charSequence.getClass();
        function1.getClass();
        return charSequence.length();
    }

    public static JsonObject c(JsonObject jsonObject, String str, String str2, String str3, String str4) {
        return jsonObject.getObject(str).getObject(str2).getObject(str3).getObject(str4);
    }

    public static Object d(CharSequence charSequence, int i, Function1 function1) {
        return function1.invoke(Character.valueOf(charSequence.charAt(i)));
    }

    public static String e(g0 g0Var, String str) {
        return str + g0Var;
    }

    public static Iterator f(Sequence sequence, Function1 function1) {
        sequence.getClass();
        function1.getClass();
        return sequence.iterator();
    }

    public static List g(Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2) {
        Objects.requireNonNull(obj);
        arrayList.add(obj2);
        return DesugarCollections.unmodifiableList(arrayList2);
    }

    public static /* synthetic */ Map h(List list) {
        Map.Entry[] entryArr = {new AbstractMap.SimpleEntry("Range", list)};
        HashMap map = new HashMap(1);
        Map.Entry entry = entryArr[0];
        Object key = entry.getKey();
        Objects.requireNonNull(key);
        Object value = entry.getValue();
        Objects.requireNonNull(value);
        if (map.put(key, value) == null) {
            return DesugarCollections.unmodifiableMap(map);
        }
        com.github.catvod.spider.merge.b0.a.j("duplicate key: ", key);
        return null;
    }

    public static /* synthetic */ Map i(List list) {
        Map.Entry[] entryArr = {new AbstractMap.SimpleEntry("User-Agent", list)};
        HashMap map = new HashMap(1);
        Map.Entry entry = entryArr[0];
        Object key = entry.getKey();
        Objects.requireNonNull(key);
        Object value = entry.getValue();
        Objects.requireNonNull(value);
        if (map.put(key, value) == null) {
            return DesugarCollections.unmodifiableMap(map);
        }
        com.github.catvod.spider.merge.b0.a.j("duplicate key: ", key);
        return null;
    }
}
