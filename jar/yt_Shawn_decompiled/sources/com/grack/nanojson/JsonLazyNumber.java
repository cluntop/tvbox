package com.grack.nanojson;

import java.math.BigDecimal;

/* loaded from: classes.dex */
class JsonLazyNumber extends Number {
    private boolean isDouble;
    private String value;

    public JsonLazyNumber(String str, boolean z) {
        this.value = str;
        this.isDouble = z;
    }

    private Object writeReplace() {
        return new BigDecimal(this.value);
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return Double.parseDouble(this.value);
    }

    @Override // java.lang.Number
    public float floatValue() {
        return Float.parseFloat(this.value);
    }

    @Override // java.lang.Number
    public int intValue() {
        boolean z = this.isDouble;
        String str = this.value;
        return z ? (int) Double.parseDouble(str) : Integer.parseInt(str);
    }

    @Override // java.lang.Number
    public long longValue() {
        boolean z = this.isDouble;
        String str = this.value;
        return z ? (long) Double.parseDouble(str) : Long.parseLong(str);
    }
}
