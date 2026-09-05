package org.schabi.newpipe.extractor.localization;

import com.github.catvod.spider.jdollar.time.Instant;
import com.github.catvod.spider.jdollar.time.LocalDateTime;
import com.github.catvod.spider.jdollar.time.OffsetDateTime;
import com.github.catvod.spider.jdollar.time.ZoneId;
import com.github.catvod.spider.jdollar.time.ZoneOffset;
import com.github.catvod.spider.jdollar.time.format.DateTimeParseException;
import com.github.catvod.spider.merge.b.b;
import java.io.Serializable;
import org.schabi.newpipe.extractor.exceptions.ParsingException;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class DateWrapper implements Serializable {
    private final Instant instant;
    private final boolean isApproximation;

    public DateWrapper(LocalDateTime localDateTime, boolean z) {
        this(localDateTime.B(ZoneId.systemDefault()).toInstant(), z);
    }

    public static DateWrapper fromInstant(String str) throws ParsingException {
        if (str == null) {
            return null;
        }
        try {
            return new DateWrapper(Instant.parse(str));
        } catch (DateTimeParseException e) {
            throw new ParsingException(b.A("Could not parse date: \"", str, "\""), e);
        }
    }

    public static DateWrapper fromOffsetDateTime(String str) throws ParsingException {
        if (str == null) {
            return null;
        }
        try {
            return new DateWrapper(OffsetDateTime.parse(str));
        } catch (DateTimeParseException e) {
            throw new ParsingException(b.A("Could not parse date: \"", str, "\""), e);
        }
    }

    public Instant getInstant() {
        return this.instant;
    }

    public LocalDateTime getLocalDateTime() {
        return getLocalDateTime(ZoneId.systemDefault());
    }

    public boolean isApproximation() {
        return this.isApproximation;
    }

    public OffsetDateTime offsetDateTime() {
        return this.instant.atOffset(ZoneOffset.UTC);
    }

    public String toString() {
        return "DateWrapper{instant=" + this.instant + ", isApproximation=" + this.isApproximation + "}";
    }

    public LocalDateTime getLocalDateTime(ZoneId zoneId) {
        return LocalDateTime.ofInstant(this.instant, zoneId);
    }

    public DateWrapper(OffsetDateTime offsetDateTime, boolean z) {
        this(offsetDateTime.toInstant(), z);
    }

    public DateWrapper(Instant instant) {
        this(instant, false);
    }

    public DateWrapper(Instant instant, boolean z) {
        this.instant = instant;
        this.isApproximation = z;
    }

    public DateWrapper(OffsetDateTime offsetDateTime) {
        this(offsetDateTime, false);
    }
}
