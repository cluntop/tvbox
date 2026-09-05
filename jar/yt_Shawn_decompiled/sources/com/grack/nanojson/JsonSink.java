package com.grack.nanojson;

import com.grack.nanojson.JsonSink;
import java.util.Collection;
import java.util.Map;

/* loaded from: classes.dex */
public interface JsonSink<SELF extends JsonSink<SELF>> {
    SELF array();

    SELF array(String str);

    SELF array(String str, Collection<?> collection);

    SELF array(Collection<?> collection);

    SELF end();

    SELF nul();

    SELF nul(String str);

    SELF object();

    SELF object(String str);

    SELF object(String str, Map<?, ?> map);

    SELF object(Map<?, ?> map);

    SELF value(double d);

    SELF value(float f);

    SELF value(int i);

    SELF value(long j);

    SELF value(Number number);

    SELF value(Object obj);

    SELF value(String str);

    SELF value(String str, double d);

    SELF value(String str, float f);

    SELF value(String str, int i);

    SELF value(String str, long j);

    SELF value(String str, Number number);

    SELF value(String str, Object obj);

    SELF value(String str, String str2);

    SELF value(String str, boolean z);

    SELF value(boolean z);
}
