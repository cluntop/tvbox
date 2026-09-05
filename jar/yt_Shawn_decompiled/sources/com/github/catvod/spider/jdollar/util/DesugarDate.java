package com.github.catvod.spider.jdollar.util;

import com.github.catvod.spider.jdollar.time.Instant;
import java.util.Date;

/* loaded from: classes.dex */
public final /* synthetic */ class DesugarDate {
    public static Date from(Instant instant) {
        try {
            return new Date(instant.toEpochMilli());
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
