package com.github.catvod.spider.jdollar.time;

import com.github.catvod.spider.jdollar.time.chrono.t;
import com.github.catvod.spider.jdollar.time.temporal.ChronoUnit;
import com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor;
import com.github.catvod.spider.jdollar.time.temporal.q;
import com.github.catvod.spider.jdollar.time.temporal.r;
import com.github.catvod.spider.jdollar.time.temporal.s;
import org.schabi.newpipe.extractor.services.soundcloud.linkHandler.SoundcloudSearchQueryHandlerFactory;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class i implements TemporalAccessor, com.github.catvod.spider.jdollar.time.temporal.m {
    public static final i APRIL;
    public static final i AUGUST;
    public static final i DECEMBER;
    public static final i FEBRUARY;
    public static final i JANUARY;
    public static final i JULY;
    public static final i JUNE;
    public static final i MARCH;
    public static final i MAY;
    public static final i NOVEMBER;
    public static final i OCTOBER;
    public static final i SEPTEMBER;
    public static final i[] a;
    public static final /* synthetic */ i[] b;

    static {
        i iVar = new i("JANUARY", 0);
        JANUARY = iVar;
        i iVar2 = new i("FEBRUARY", 1);
        FEBRUARY = iVar2;
        i iVar3 = new i("MARCH", 2);
        MARCH = iVar3;
        i iVar4 = new i("APRIL", 3);
        APRIL = iVar4;
        i iVar5 = new i("MAY", 4);
        MAY = iVar5;
        i iVar6 = new i("JUNE", 5);
        JUNE = iVar6;
        i iVar7 = new i("JULY", 6);
        JULY = iVar7;
        i iVar8 = new i("AUGUST", 7);
        AUGUST = iVar8;
        i iVar9 = new i("SEPTEMBER", 8);
        SEPTEMBER = iVar9;
        i iVar10 = new i("OCTOBER", 9);
        OCTOBER = iVar10;
        i iVar11 = new i("NOVEMBER", 10);
        NOVEMBER = iVar11;
        i iVar12 = new i("DECEMBER", 11);
        DECEMBER = iVar12;
        b = new i[]{iVar, iVar2, iVar3, iVar4, iVar5, iVar6, iVar7, iVar8, iVar9, iVar10, iVar11, iVar12};
        a = values();
    }

    public static i V(int i) {
        if (i >= 1 && i <= 12) {
            return a[i - 1];
        }
        com.github.catvod.spider.jdollar.nio.file.b.d("Invalid value for MonthOfYear: ", i);
        return null;
    }

    public static i valueOf(String str) {
        return (i) Enum.valueOf(i.class, str);
    }

    public static i[] values() {
        return (i[]) b.clone();
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final long E(com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        if (pVar == com.github.catvod.spider.jdollar.time.temporal.a.MONTH_OF_YEAR) {
            return getValue();
        }
        if (pVar instanceof com.github.catvod.spider.jdollar.time.temporal.a) {
            throw new r(b.a("Unsupported field: ", pVar));
        }
        return pVar.y(this);
    }

    public final int S(boolean z) {
        switch (h.a[ordinal()]) {
            case 1:
                return 32;
            case 2:
                return (z ? 1 : 0) + 91;
            case 3:
                return (z ? 1 : 0) + 152;
            case 4:
                return (z ? 1 : 0) + 244;
            case 5:
                return (z ? 1 : 0) + 305;
            case 6:
                return 1;
            case 7:
                return (z ? 1 : 0) + 60;
            case 8:
                return (z ? 1 : 0) + 121;
            case 9:
                return (z ? 1 : 0) + 182;
            case SoundcloudSearchQueryHandlerFactory.ITEMS_PER_PAGE /* 10 */:
                return (z ? 1 : 0) + 213;
            case 11:
                return (z ? 1 : 0) + 274;
            default:
                return (z ? 1 : 0) + 335;
        }
    }

    public final int T(boolean z) {
        int i = h.a[ordinal()];
        return i != 1 ? (i == 2 || i == 3 || i == 4 || i == 5) ? 30 : 31 : z ? 29 : 28;
    }

    public final int U() {
        int i = h.a[ordinal()];
        if (i != 1) {
            return (i == 2 || i == 3 || i == 4 || i == 5) ? 30 : 31;
        }
        return 29;
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final boolean d(com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        return pVar instanceof com.github.catvod.spider.jdollar.time.temporal.a ? pVar == com.github.catvod.spider.jdollar.time.temporal.a.MONTH_OF_YEAR : pVar != null && pVar.h(this);
    }

    public final int getValue() {
        return ordinal() + 1;
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final int h(com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        return pVar == com.github.catvod.spider.jdollar.time.temporal.a.MONTH_OF_YEAR ? getValue() : q.a(this, pVar);
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final s j(com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        return pVar == com.github.catvod.spider.jdollar.time.temporal.a.MONTH_OF_YEAR ? pVar.o() : q.d(this, pVar);
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.m
    public final com.github.catvod.spider.jdollar.time.temporal.l o(com.github.catvod.spider.jdollar.time.temporal.l lVar) {
        if (com.github.catvod.spider.jdollar.com.android.tools.r8.a.w(lVar).equals(t.c)) {
            return lVar.b(getValue(), com.github.catvod.spider.jdollar.time.temporal.a.MONTH_OF_YEAR);
        }
        com.github.catvod.spider.jdollar.nio.file.b.k("Adjustment only supported on ISO date-time");
        return null;
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final Object y(com.github.catvod.spider.jdollar.desugar.sun.nio.fs.m mVar) {
        return mVar == q.b ? t.c : mVar == q.c ? ChronoUnit.MONTHS : q.c(this, mVar);
    }
}
