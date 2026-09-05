package com.github.catvod.spider.jdollar.time;

import com.github.catvod.spider.jdollar.util.Objects;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class o extends ZoneId {
    public static final /* synthetic */ int d = 0;
    private static final long serialVersionUID = 8386373296231747096L;
    public final String b;
    public final transient com.github.catvod.spider.jdollar.time.zone.f c;

    public o(String str, com.github.catvod.spider.jdollar.time.zone.f fVar) {
        this.b = str;
        this.c = fVar;
    }

    public static o Y(String str, boolean z) {
        Objects.requireNonNull(str, "zoneId");
        int length = str.length();
        com.github.catvod.spider.jdollar.time.zone.f fVarA = null;
        if (length < 2) {
            com.github.catvod.spider.jdollar.nio.file.b.k("Invalid ID for region-based ZoneId, invalid format: ".concat(str));
            return null;
        }
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if ((cCharAt < 'a' || cCharAt > 'z') && ((cCharAt < 'A' || cCharAt > 'Z') && ((cCharAt != '/' || i == 0) && ((cCharAt < '0' || cCharAt > '9' || i == 0) && ((cCharAt != '~' || i == 0) && ((cCharAt != '.' || i == 0) && ((cCharAt != '_' || i == 0) && ((cCharAt != '+' || i == 0) && (cCharAt != '-' || i == 0))))))))) {
                com.github.catvod.spider.jdollar.nio.file.b.k("Invalid ID for region-based ZoneId, invalid format: ".concat(str));
                return null;
            }
        }
        try {
            fVarA = com.github.catvod.spider.jdollar.time.zone.h.a(str);
        } catch (com.github.catvod.spider.jdollar.time.zone.g e) {
            if (z) {
                throw e;
            }
        }
        return new o(str, fVarA);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new l((byte) 7, this);
    }

    @Override // com.github.catvod.spider.jdollar.time.ZoneId
    public final com.github.catvod.spider.jdollar.time.zone.f T() {
        com.github.catvod.spider.jdollar.time.zone.f fVar = this.c;
        return fVar != null ? fVar : com.github.catvod.spider.jdollar.time.zone.h.a(this.b);
    }

    @Override // com.github.catvod.spider.jdollar.time.ZoneId
    public final void X(DataOutput dataOutput) throws IOException {
        dataOutput.writeByte(7);
        dataOutput.writeUTF(this.b);
    }

    @Override // com.github.catvod.spider.jdollar.time.ZoneId
    public final String getId() {
        return this.b;
    }
}
