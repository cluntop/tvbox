package com.github.catvod.spider.jdollar.desugar.sun.nio.fs;

import com.github.catvod.spider.jdollar.time.DateTimeException;
import com.github.catvod.spider.jdollar.time.Instant;
import com.github.catvod.spider.jdollar.time.LocalDate;
import com.github.catvod.spider.jdollar.time.LocalDateTime;
import com.github.catvod.spider.jdollar.time.LocalTime;
import com.github.catvod.spider.jdollar.time.OffsetDateTime;
import com.github.catvod.spider.jdollar.time.ZoneId;
import com.github.catvod.spider.jdollar.time.ZoneOffset;
import com.github.catvod.spider.jdollar.time.ZonedDateTime;
import com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor;
import com.github.catvod.spider.jdollar.time.temporal.TemporalUnit;
import com.github.catvod.spider.jdollar.time.temporal.q;
import com.github.catvod.spider.jdollar.util.Objects;
import com.github.catvod.spider.jdollar.util.a0;
import com.github.catvod.spider.jdollar.util.function.BiConsumer$CC;
import com.github.catvod.spider.jdollar.util.function.BiFunction$CC;
import com.github.catvod.spider.jdollar.util.function.Function$CC;
import com.github.catvod.spider.jdollar.util.function.Predicate$CC;
import com.github.catvod.spider.jdollar.util.p1;
import com.github.catvod.spider.jdollar.util.stream.Collectors;
import com.github.catvod.spider.jdollar.util.x;
import com.github.catvod.spider.jdollar.util.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;
import org.schabi.newpipe.extractor.services.peertube.PeertubeParsingHelper;
import org.schabi.newpipe.extractor.services.soundcloud.linkHandler.SoundcloudSearchQueryHandlerFactory;
import org.schabi.newpipe.extractor.services.youtube.dashmanifestcreators.YoutubeDashManifestCreatorsUtils;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class m implements Predicate, com.github.catvod.spider.jdollar.time.temporal.m, IntFunction, Supplier, BiConsumer, BinaryOperator, Function {
    public final /* synthetic */ int a;

    public /* synthetic */ m(int i) {
        this.a = i;
    }

    @Override // java.util.function.BiConsumer
    public void accept(Object obj, Object obj2) {
        switch (this.a) {
            case 17:
                ((Collection) obj).add(obj2);
                break;
            case YoutubeDashManifestCreatorsUtils.MAXIMUM_REDIRECT_COUNT /* 20 */:
                ((List) obj).add(obj2);
                break;
            default:
                ((p1) obj).a((CharSequence) obj2);
                break;
        }
    }

    @Override // java.util.function.Predicate
    public /* synthetic */ Predicate and(Predicate predicate) {
        return Predicate$CC.$default$and(this, predicate);
    }

    @Override // java.util.function.BiFunction, java.util.function.Function
    public /* synthetic */ BiFunction andThen(Function function) {
        switch (this.a) {
            case 18:
                break;
            case 21:
                break;
            case 25:
                break;
        }
        return BiFunction$CC.$default$andThen(this, function);
    }

    @Override // java.util.function.BiFunction
    public Object apply(Object obj, Object obj2) {
        switch (this.a) {
            case 18:
                Collection collection = (Collection) obj;
                Set set = Collectors.a;
                collection.addAll((Collection) obj2);
                return collection;
            case 21:
                List list = (List) obj;
                Set set2 = Collectors.a;
                list.addAll((List) obj2);
                return list;
            case 25:
                List list2 = (List) obj;
                Set set3 = Collectors.a;
                list2.addAll((List) obj2);
                return list2;
            default:
                p1 p1Var = (p1) obj;
                p1 p1Var2 = (p1) obj2;
                p1Var.getClass();
                Objects.requireNonNull(p1Var2);
                if (p1Var2.d != null) {
                    p1Var2.b();
                    p1Var.a(p1Var2.d[0]);
                }
                return p1Var;
        }
    }

    @Override // java.util.function.Function
    public /* synthetic */ Function compose(Function function) {
        switch (this.a) {
            case 22:
                break;
            case 26:
                break;
        }
        return Function$CC.$default$compose(this, function);
    }

    public Object f(TemporalAccessor temporalAccessor) {
        int i = this.a;
        m mVar = q.a;
        Object objS = null;
        switch (i) {
            case 1:
                return Instant.T(temporalAccessor);
            case 2:
                return LocalDate.U(temporalAccessor);
            case 3:
                return LocalDateTime.T(temporalAccessor);
            case 4:
                int i2 = OffsetDateTime.c;
                if (temporalAccessor instanceof OffsetDateTime) {
                    return (OffsetDateTime) temporalAccessor;
                }
                try {
                    ZoneOffset zoneOffsetY = ZoneOffset.Y(temporalAccessor);
                    LocalDate localDate = (LocalDate) temporalAccessor.y(q.f);
                    LocalTime localTime = (LocalTime) temporalAccessor.y(q.g);
                    objS = (localDate == null || localTime == null) ? OffsetDateTime.S(Instant.T(temporalAccessor), zoneOffsetY) : new OffsetDateTime(LocalDateTime.of(localDate, localTime), zoneOffsetY);
                    return objS;
                } catch (DateTimeException e) {
                    com.github.catvod.spider.jdollar.nio.file.b.h("Unable to obtain OffsetDateTime from TemporalAccessor: ", temporalAccessor, temporalAccessor.getClass().getName(), e);
                    return objS;
                }
            case 5:
                if (temporalAccessor instanceof ZonedDateTime) {
                    return (ZonedDateTime) temporalAccessor;
                }
                try {
                    ZoneId zoneIdS = ZoneId.S(temporalAccessor);
                    com.github.catvod.spider.jdollar.time.temporal.a aVar = com.github.catvod.spider.jdollar.time.temporal.a.INSTANT_SECONDS;
                    objS = temporalAccessor.d(aVar) ? ZonedDateTime.o(temporalAccessor.E(aVar), temporalAccessor.h(com.github.catvod.spider.jdollar.time.temporal.a.NANO_OF_SECOND), zoneIdS) : ZonedDateTime.S(LocalDateTime.of(LocalDate.U(temporalAccessor), LocalTime.U(temporalAccessor)), null, zoneIdS);
                    return objS;
                } catch (DateTimeException e2) {
                    com.github.catvod.spider.jdollar.nio.file.b.h("Unable to obtain ZonedDateTime from TemporalAccessor: ", temporalAccessor, temporalAccessor.getClass().getName(), e2);
                    return objS;
                }
            case 6:
                ZoneId zoneId = (ZoneId) temporalAccessor.y(mVar);
                if (zoneId == null || (zoneId instanceof ZoneOffset)) {
                    return null;
                }
                return zoneId;
            case 7:
            default:
                com.github.catvod.spider.jdollar.time.temporal.a aVar2 = com.github.catvod.spider.jdollar.time.temporal.a.NANO_OF_DAY;
                if (temporalAccessor.d(aVar2)) {
                    return LocalTime.W(temporalAccessor.E(aVar2));
                }
                return null;
            case 8:
                return (ZoneId) temporalAccessor.y(mVar);
            case 9:
                return (com.github.catvod.spider.jdollar.time.chrono.l) temporalAccessor.y(q.b);
            case SoundcloudSearchQueryHandlerFactory.ITEMS_PER_PAGE /* 10 */:
                return (TemporalUnit) temporalAccessor.y(q.c);
            case 11:
                com.github.catvod.spider.jdollar.time.temporal.a aVar3 = com.github.catvod.spider.jdollar.time.temporal.a.OFFSET_SECONDS;
                if (temporalAccessor.d(aVar3)) {
                    return ZoneOffset.ofTotalSeconds(temporalAccessor.h(aVar3));
                }
                return null;
            case PeertubeParsingHelper.ITEMS_PER_PAGE /* 12 */:
                ZoneId zoneId2 = (ZoneId) temporalAccessor.y(mVar);
                return zoneId2 != null ? zoneId2 : (ZoneId) temporalAccessor.y(q.d);
            case 13:
                com.github.catvod.spider.jdollar.time.temporal.a aVar4 = com.github.catvod.spider.jdollar.time.temporal.a.EPOCH_DAY;
                if (temporalAccessor.d(aVar4)) {
                    return LocalDate.c0(temporalAccessor.E(aVar4));
                }
                return null;
        }
    }

    @Override // java.util.function.Supplier
    public Object get() {
        switch (this.a) {
            case 16:
                return new x();
            case 19:
                return new ArrayList();
            case 23:
                return new y();
            default:
                return new a0();
        }
    }

    @Override // java.util.function.Predicate
    public /* synthetic */ Predicate negate() {
        return Predicate$CC.$default$negate(this);
    }

    @Override // com.github.catvod.spider.jdollar.time.temporal.m
    public com.github.catvod.spider.jdollar.time.temporal.l o(com.github.catvod.spider.jdollar.time.temporal.l lVar) {
        com.github.catvod.spider.jdollar.time.temporal.a aVar = com.github.catvod.spider.jdollar.time.temporal.a.DAY_OF_MONTH;
        return lVar.b(lVar.j(aVar).d, aVar);
    }

    @Override // java.util.function.Predicate
    public /* synthetic */ Predicate or(Predicate predicate) {
        return Predicate$CC.$default$or(this, predicate);
    }

    @Override // java.util.function.Predicate
    public boolean test(Object obj) {
        return !((String) obj).isEmpty();
    }

    public String toString() {
        switch (this.a) {
            case 8:
                return "ZoneId";
            case 9:
                return "Chronology";
            case SoundcloudSearchQueryHandlerFactory.ITEMS_PER_PAGE /* 10 */:
                return "Precision";
            case 11:
                return "ZoneOffset";
            case PeertubeParsingHelper.ITEMS_PER_PAGE /* 12 */:
                return "Zone";
            case 13:
                return "LocalDate";
            case 14:
                return "LocalTime";
            default:
                return super.toString();
        }
    }

    @Override // java.util.function.BiConsumer
    public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
        switch (this.a) {
            case 17:
                break;
            case YoutubeDashManifestCreatorsUtils.MAXIMUM_REDIRECT_COUNT /* 20 */:
                break;
        }
        return BiConsumer$CC.$default$andThen(this, biConsumer);
    }

    @Override // java.util.function.BiFunction, java.util.function.Function
    public /* synthetic */ Function andThen(Function function) {
        switch (this.a) {
            case 22:
                break;
            case 26:
                break;
        }
        return Function$CC.$default$andThen(this, function);
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        switch (this.a) {
            case 22:
                Set set = Collectors.a;
                return com.github.catvod.spider.jdollar.com.android.tools.r8.a.B(((List) obj).toArray());
            case 26:
                Set set2 = Collectors.a;
                return obj;
            default:
                return ((p1) obj).toString();
        }
    }

    @Override // java.util.function.IntFunction
    public Object apply(int i) {
        return new Object[i];
    }
}
