package com.github.catvod.spider.jdollar.time.chrono;

import com.github.catvod.spider.jdollar.time.DateTimeException;
import com.github.catvod.spider.jdollar.time.LocalDate;
import com.github.catvod.spider.jdollar.time.LocalTime;
import com.github.catvod.spider.jdollar.time.temporal.ChronoUnit;
import com.github.catvod.spider.jdollar.time.temporal.TemporalUnit;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Arrays;
import org.schabi.newpipe.extractor.services.peertube.PeertubeParsingHelper;
import org.schabi.newpipe.extractor.services.soundcloud.linkHandler.SoundcloudSearchQueryHandlerFactory;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class r extends d {
    private static final long serialVersionUID = -5207853542612002020L;
    public final transient p a;
    public final transient int b;
    public final transient int c;
    public final transient int d;

    public r(p pVar, long j) {
        int i = (int) j;
        pVar.S();
        if (i < pVar.e || i >= pVar.f) {
            com.github.catvod.spider.jdollar.nio.file.b.k("Hijrah date out of range");
            throw null;
        }
        int iBinarySearch = Arrays.binarySearch(pVar.d, i);
        iBinarySearch = iBinarySearch < 0 ? (-iBinarySearch) - 2 : iBinarySearch;
        int[] iArr = {pVar.U(iBinarySearch), ((pVar.g + iBinarySearch) % 12) + 1, (i - pVar.d[iBinarySearch]) + 1};
        this.a = pVar;
        this.b = iArr[0];
        this.c = iArr[1];
        this.d = iArr[2];
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new f0((byte) 6, this);
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.d, com.github.catvod.spider.jdollar.time.temporal.l
    /* renamed from: A */
    public final com.github.catvod.spider.jdollar.time.temporal.l t(long j, ChronoUnit chronoUnit) {
        return (r) super.t(j, chronoUnit);
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final long E(com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        if (!(pVar instanceof com.github.catvod.spider.jdollar.time.temporal.a)) {
            return pVar.y(this);
        }
        switch (q.a[((com.github.catvod.spider.jdollar.time.temporal.a) pVar).ordinal()]) {
            case 1:
                return this.d;
            case 2:
                return W();
            case 3:
                return ((this.d - 1) / 7) + 1;
            case 4:
                return ((int) com.github.catvod.spider.jdollar.com.android.tools.r8.a.M(F() + 3, 7L)) + 1;
            case 5:
                return ((this.d - 1) % 7) + 1;
            case 6:
                return ((W() - 1) % 7) + 1;
            case 7:
                return F();
            case 8:
                return ((W() - 1) / 7) + 1;
            case 9:
                return this.c;
            case SoundcloudSearchQueryHandlerFactory.ITEMS_PER_PAGE /* 10 */:
                return ((this.b * 12) + this.c) - 1;
            case 11:
                return this.b;
            case PeertubeParsingHelper.ITEMS_PER_PAGE /* 12 */:
                return this.b;
            case 13:
                return this.b <= 1 ? 0 : 1;
            default:
                throw new com.github.catvod.spider.jdollar.time.temporal.r(com.github.catvod.spider.jdollar.time.b.a("Unsupported field: ", pVar));
        }
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.d, com.github.catvod.spider.jdollar.time.chrono.b
    public final long F() {
        return this.a.V(this.b, this.c, this.d);
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.d, com.github.catvod.spider.jdollar.time.chrono.b
    public final e G(LocalTime localTime) {
        return new g(this, localTime);
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.d, com.github.catvod.spider.jdollar.time.chrono.b
    public final n H() {
        return s.AH;
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.d, com.github.catvod.spider.jdollar.time.chrono.b
    public final b L(com.github.catvod.spider.jdollar.time.temporal.o oVar) {
        return (r) super.L(oVar);
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.d, com.github.catvod.spider.jdollar.time.chrono.b
    public final int O() {
        return this.a.Y(this.b, 12);
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.d
    public final b V(long j) {
        if (j == 0) {
            return this;
        }
        long j2 = this.b + ((int) j);
        int i = (int) j2;
        if (j2 == i) {
            return Z(i, this.c, this.d);
        }
        throw new ArithmeticException();
    }

    public final int W() {
        return this.a.Y(this.b, this.c - 1) + this.d;
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.d
    /* renamed from: X, reason: merged with bridge method [inline-methods] */
    public final r T(long j) {
        return new r(this.a, F() + j);
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.d
    /* renamed from: Y, reason: merged with bridge method [inline-methods] */
    public final r U(long j) {
        if (j == 0) {
            return this;
        }
        long j2 = (this.b * 12) + (this.c - 1) + j;
        p pVar = this.a;
        long jZ = com.github.catvod.spider.jdollar.com.android.tools.r8.a.z(j2, 12L);
        if (jZ >= pVar.U(0) && jZ <= pVar.U(pVar.d.length - 1) - 1) {
            return Z((int) jZ, ((int) com.github.catvod.spider.jdollar.com.android.tools.r8.a.M(j2, 12L)) + 1, this.d);
        }
        throw new DateTimeException("Invalid Hijrah year: " + jZ);
    }

    public final r Z(int i, int i2, int i3) {
        int iW = this.a.W(i, i2);
        if (i3 > iW) {
            i3 = iW;
        }
        return new r(this.a, i, i2, i3);
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.b
    public final l a() {
        return this.a;
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.d, com.github.catvod.spider.jdollar.time.temporal.l
    /* renamed from: a0, reason: merged with bridge method [inline-methods] */
    public final r b(long j, com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        if (!(pVar instanceof com.github.catvod.spider.jdollar.time.temporal.a)) {
            return (r) super.b(j, pVar);
        }
        com.github.catvod.spider.jdollar.time.temporal.a aVar = (com.github.catvod.spider.jdollar.time.temporal.a) pVar;
        this.a.s(aVar).b(j, aVar);
        int i = (int) j;
        switch (q.a[aVar.ordinal()]) {
            case 1:
                return Z(this.b, this.c, i);
            case 2:
                return T(Math.min(i, O()) - W());
            case 3:
                return T((j - E(com.github.catvod.spider.jdollar.time.temporal.a.ALIGNED_WEEK_OF_MONTH)) * 7);
            case 4:
                return T(j - (((int) com.github.catvod.spider.jdollar.com.android.tools.r8.a.M(F() + 3, 7L)) + 1));
            case 5:
                return T(j - E(com.github.catvod.spider.jdollar.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_MONTH));
            case 6:
                return T(j - E(com.github.catvod.spider.jdollar.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_YEAR));
            case 7:
                return new r(this.a, j);
            case 8:
                return T((j - E(com.github.catvod.spider.jdollar.time.temporal.a.ALIGNED_WEEK_OF_YEAR)) * 7);
            case 9:
                return Z(this.b, i, this.d);
            case SoundcloudSearchQueryHandlerFactory.ITEMS_PER_PAGE /* 10 */:
                return U(j - (((this.b * 12) + this.c) - 1));
            case 11:
                if (this.b < 1) {
                    i = 1 - i;
                }
                return Z(i, this.c, this.d);
            case PeertubeParsingHelper.ITEMS_PER_PAGE /* 12 */:
                return Z(i, this.c, this.d);
            case 13:
                return Z(1 - this.b, this.c, this.d);
            default:
                throw new com.github.catvod.spider.jdollar.time.temporal.r(com.github.catvod.spider.jdollar.time.b.a("Unsupported field: ", pVar));
        }
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.d, com.github.catvod.spider.jdollar.time.chrono.b, com.github.catvod.spider.jdollar.time.temporal.l
    public final b c(long j, TemporalUnit temporalUnit) {
        return (r) super.c(j, temporalUnit);
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.d, com.github.catvod.spider.jdollar.time.chrono.b
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof r) {
            r rVar = (r) obj;
            if (this.b == rVar.b && this.c == rVar.c && this.d == rVar.d && this.a.equals(rVar.a)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.d, com.github.catvod.spider.jdollar.time.chrono.b
    public final int hashCode() {
        int i = this.b;
        int i2 = this.c;
        int i3 = this.d;
        this.a.getClass();
        return (((i << 11) + (i2 << 6)) + i3) ^ ((i & (-2048)) ^ 2100100019);
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.d, com.github.catvod.spider.jdollar.time.temporal.l
    /* renamed from: i */
    public final com.github.catvod.spider.jdollar.time.temporal.l z(LocalDate localDate) {
        return (r) super.z(localDate);
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.d, com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor
    public final com.github.catvod.spider.jdollar.time.temporal.s j(com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        if (!(pVar instanceof com.github.catvod.spider.jdollar.time.temporal.a)) {
            return pVar.i(this);
        }
        if (!com.github.catvod.spider.jdollar.com.android.tools.r8.a.f(this, pVar)) {
            throw new com.github.catvod.spider.jdollar.time.temporal.r(com.github.catvod.spider.jdollar.time.b.a("Unsupported field: ", pVar));
        }
        com.github.catvod.spider.jdollar.time.temporal.a aVar = (com.github.catvod.spider.jdollar.time.temporal.a) pVar;
        int i = q.a[aVar.ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? this.a.s(aVar) : com.github.catvod.spider.jdollar.time.temporal.s.f(1L, 5L) : com.github.catvod.spider.jdollar.time.temporal.s.f(1L, O()) : com.github.catvod.spider.jdollar.time.temporal.s.f(1L, this.a.W(this.b, this.c));
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.d, com.github.catvod.spider.jdollar.time.chrono.b
    public final boolean r() {
        return this.a.Q(this.b);
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.d, com.github.catvod.spider.jdollar.time.chrono.b
    public final b t(long j, TemporalUnit temporalUnit) {
        return (r) super.t(j, temporalUnit);
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.d, com.github.catvod.spider.jdollar.time.chrono.b
    public final b z(com.github.catvod.spider.jdollar.time.temporal.m mVar) {
        return (r) super.z(mVar);
    }

    @Override // com.github.catvod.spider.jdollar.time.chrono.d, com.github.catvod.spider.jdollar.time.temporal.l
    public final com.github.catvod.spider.jdollar.time.temporal.l c(long j, TemporalUnit temporalUnit) {
        return (r) super.c(j, temporalUnit);
    }

    public r(p pVar, int i, int i2, int i3) {
        pVar.V(i, i2, i3);
        this.a = pVar;
        this.b = i;
        this.c = i2;
        this.d = i3;
    }
}
