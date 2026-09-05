package com.github.catvod.spider.jdollar.time;

import com.github.catvod.spider.jdollar.util.Objects;
import java.io.Externalizable;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.StreamCorruptedException;
import org.schabi.newpipe.extractor.services.peertube.PeertubeParsingHelper;
import org.schabi.newpipe.extractor.services.soundcloud.linkHandler.SoundcloudSearchQueryHandlerFactory;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class l implements Externalizable {
    private static final long serialVersionUID = -7683839454370182990L;
    public byte a;
    public Object b;

    public l(byte b, Object obj) {
        this.a = b;
        this.b = obj;
    }

    public static Object a(byte b, ObjectInput objectInput) throws IOException {
        switch (b) {
            case 1:
                Duration duration = Duration.c;
                return Duration.ofSeconds(objectInput.readLong(), objectInput.readInt());
            case 2:
                Instant instant = Instant.c;
                return Instant.ofEpochSecond(objectInput.readLong(), objectInput.readInt());
            case 3:
                LocalDate localDate = LocalDate.d;
                return LocalDate.of(objectInput.readInt(), objectInput.readByte(), objectInput.readByte());
            case 4:
                return LocalTime.c0(objectInput);
            case 5:
                LocalDateTime localDateTime = LocalDateTime.c;
                LocalDate localDate2 = LocalDate.d;
                return LocalDateTime.of(LocalDate.of(objectInput.readInt(), objectInput.readByte(), objectInput.readByte()), LocalTime.c0(objectInput));
            case 6:
                LocalDateTime localDateTime2 = LocalDateTime.c;
                LocalDate localDate3 = LocalDate.d;
                LocalDateTime localDateTimeOf = LocalDateTime.of(LocalDate.of(objectInput.readInt(), objectInput.readByte(), objectInput.readByte()), LocalTime.c0(objectInput));
                ZoneOffset zoneOffsetC0 = ZoneOffset.c0(objectInput);
                ZoneId zoneId = (ZoneId) a(objectInput.readByte(), objectInput);
                Objects.requireNonNull(localDateTimeOf, "localDateTime");
                Objects.requireNonNull(zoneOffsetC0, "offset");
                Objects.requireNonNull(zoneId, "zone");
                if (!(zoneId instanceof ZoneOffset) || zoneOffsetC0.equals(zoneId)) {
                    return new ZonedDateTime(localDateTimeOf, zoneOffsetC0, zoneId);
                }
                com.github.catvod.spider.jdollar.nio.file.b.c("ZoneId must match ZoneOffset");
                return null;
            case 7:
                int i = o.d;
                return ZoneId.U(objectInput.readUTF(), false);
            case 8:
                return ZoneOffset.c0(objectInput);
            case 9:
                int i2 = OffsetTime.c;
                return OffsetTime.of(LocalTime.c0(objectInput), ZoneOffset.c0(objectInput));
            case SoundcloudSearchQueryHandlerFactory.ITEMS_PER_PAGE /* 10 */:
                int i3 = OffsetDateTime.c;
                LocalDate localDate4 = LocalDate.d;
                return OffsetDateTime.of(LocalDateTime.of(LocalDate.of(objectInput.readInt(), objectInput.readByte(), objectInput.readByte()), LocalTime.c0(objectInput)), ZoneOffset.c0(objectInput));
            case 11:
                int i4 = Year.b;
                return Year.of(objectInput.readInt());
            case PeertubeParsingHelper.ITEMS_PER_PAGE /* 12 */:
                int i5 = YearMonth.c;
                return YearMonth.of(objectInput.readInt(), objectInput.readByte());
            case 13:
                int i6 = MonthDay.c;
                return MonthDay.of(objectInput.readByte(), objectInput.readByte());
            case 14:
                Period period = Period.d;
                return Period.of(objectInput.readInt(), objectInput.readInt(), objectInput.readInt());
            default:
                throw new StreamCorruptedException("Unknown serialized type");
        }
    }

    private Object readResolve() {
        return this.b;
    }

    @Override // java.io.Externalizable
    public final void readExternal(ObjectInput objectInput) {
        byte b = objectInput.readByte();
        this.a = b;
        this.b = a(b, objectInput);
    }

    @Override // java.io.Externalizable
    public final void writeExternal(ObjectOutput objectOutput) throws IOException {
        byte b = this.a;
        Object obj = this.b;
        objectOutput.writeByte(b);
        switch (b) {
            case 1:
                Duration duration = (Duration) obj;
                objectOutput.writeLong(duration.a);
                objectOutput.writeInt(duration.b);
                return;
            case 2:
                Instant instant = (Instant) obj;
                objectOutput.writeLong(instant.a);
                objectOutput.writeInt(instant.b);
                return;
            case 3:
                LocalDate localDate = (LocalDate) obj;
                objectOutput.writeInt(localDate.a);
                objectOutput.writeByte(localDate.b);
                objectOutput.writeByte(localDate.c);
                return;
            case 4:
                ((LocalTime) obj).h0(objectOutput);
                return;
            case 5:
                LocalDateTime localDateTime = (LocalDateTime) obj;
                LocalDate localDate2 = localDateTime.a;
                objectOutput.writeInt(localDate2.a);
                objectOutput.writeByte(localDate2.b);
                objectOutput.writeByte(localDate2.c);
                localDateTime.b.h0(objectOutput);
                return;
            case 6:
                ZonedDateTime zonedDateTime = (ZonedDateTime) obj;
                LocalDateTime localDateTime2 = zonedDateTime.a;
                LocalDate localDate3 = localDateTime2.a;
                objectOutput.writeInt(localDate3.a);
                objectOutput.writeByte(localDate3.b);
                objectOutput.writeByte(localDate3.c);
                localDateTime2.b.h0(objectOutput);
                zonedDateTime.b.d0(objectOutput);
                zonedDateTime.c.X(objectOutput);
                return;
            case 7:
                objectOutput.writeUTF(((o) obj).b);
                return;
            case 8:
                ((ZoneOffset) obj).d0(objectOutput);
                return;
            case 9:
                OffsetTime offsetTime = (OffsetTime) obj;
                offsetTime.a.h0(objectOutput);
                offsetTime.b.d0(objectOutput);
                return;
            case SoundcloudSearchQueryHandlerFactory.ITEMS_PER_PAGE /* 10 */:
                OffsetDateTime offsetDateTime = (OffsetDateTime) obj;
                LocalDateTime localDateTime3 = offsetDateTime.a;
                LocalDate localDate4 = localDateTime3.a;
                objectOutput.writeInt(localDate4.a);
                objectOutput.writeByte(localDate4.b);
                objectOutput.writeByte(localDate4.c);
                localDateTime3.b.h0(objectOutput);
                offsetDateTime.b.d0(objectOutput);
                return;
            case 11:
                objectOutput.writeInt(((Year) obj).a);
                return;
            case PeertubeParsingHelper.ITEMS_PER_PAGE /* 12 */:
                YearMonth yearMonth = (YearMonth) obj;
                objectOutput.writeInt(yearMonth.a);
                objectOutput.writeByte(yearMonth.b);
                return;
            case 13:
                MonthDay monthDay = (MonthDay) obj;
                objectOutput.writeByte(monthDay.a);
                objectOutput.writeByte(monthDay.b);
                return;
            case 14:
                Period period = (Period) obj;
                objectOutput.writeInt(period.a);
                objectOutput.writeInt(period.b);
                objectOutput.writeInt(period.c);
                return;
            default:
                throw new InvalidClassException("Unknown serialized type");
        }
    }

    public l() {
    }
}
