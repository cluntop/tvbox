package com.github.catvod.spider.jdollar.time.temporal;

import com.github.catvod.spider.jdollar.time.DateTimeException;
import com.github.catvod.spider.jdollar.time.format.b0;
import com.github.catvod.spider.jdollar.time.format.c0;
import java.util.Map;
import org.schabi.newpipe.extractor.stream.Stream;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'JULIAN_DAY' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class j implements p {
    public static final j JULIAN_DAY;
    public static final j MODIFIED_JULIAN_DAY;
    public static final j RATA_DIE;
    public static final /* synthetic */ j[] d;
    private static final long serialVersionUID = -7501623920830201812L;
    public final transient String a;
    public final transient s b;
    public final transient long c;

    static {
        ChronoUnit chronoUnit = ChronoUnit.DAYS;
        ChronoUnit chronoUnit2 = ChronoUnit.FOREVER;
        j jVar = new j("JULIAN_DAY", 0, "JulianDay", chronoUnit, chronoUnit2, 2440588L);
        JULIAN_DAY = jVar;
        j jVar2 = new j("MODIFIED_JULIAN_DAY", 1, "ModifiedJulianDay", chronoUnit, chronoUnit2, 40587L);
        MODIFIED_JULIAN_DAY = jVar2;
        j jVar3 = new j("RATA_DIE", 2, "RataDie", chronoUnit, chronoUnit2, 719163L);
        RATA_DIE = jVar3;
        d = new j[]{jVar, jVar2, jVar3};
    }

    public j(String str, int i, String str2, ChronoUnit chronoUnit, ChronoUnit chronoUnit2, long j) {
        this.a = str2;
        this.b = s.f((-365243219162L) + j, 365241780471L + j);
        this.c = j;
    }

    public static j valueOf(String str) {
        return (j) Enum.valueOf(j.class, str);
    }

    public static j[] values() {
        return (j[]) d.clone();
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.p
    public final l A(l lVar, long j) {
        if (this.b.e(j)) {
            return lVar.b(com.github.catvod.spider.jdollar.com.android.tools.r8.a.P(j, this.c), a.EPOCH_DAY);
        }
        throw new DateTimeException("Invalid value: " + this.a + Stream.ID_UNKNOWN + j);
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.p
    public final boolean h(TemporalAccessor temporalAccessor) {
        return temporalAccessor.d(a.EPOCH_DAY);
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.p
    public final s i(TemporalAccessor temporalAccessor) {
        if (temporalAccessor.d(a.EPOCH_DAY)) {
            return this.b;
        }
        com.github.catvod.spider.jdollar.nio.file.b.j(this, "Unsupported field: ");
        return null;
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.p
    public final boolean isDateBased() {
        return true;
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.p
    public final TemporalAccessor j(Map map, b0 b0Var, c0 c0Var) {
        long jLongValue = ((Long) map.remove(this)).longValue();
        com.github.catvod.spider.jdollar.time.chrono.l lVarW = com.github.catvod.spider.jdollar.com.android.tools.r8.a.w(b0Var);
        c0 c0Var2 = c0.LENIENT;
        long j = this.c;
        if (c0Var == c0Var2) {
            return lVarW.f(com.github.catvod.spider.jdollar.com.android.tools.r8.a.P(jLongValue, j));
        }
        this.b.b(jLongValue, this);
        return lVarW.f(jLongValue - j);
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.p
    public final s o() {
        return this.b;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.a;
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.p
    public final long y(TemporalAccessor temporalAccessor) {
        return temporalAccessor.E(a.EPOCH_DAY) + this.c;
    }
}
