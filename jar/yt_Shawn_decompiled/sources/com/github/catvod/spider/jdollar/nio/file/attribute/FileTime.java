package com.github.catvod.spider.jdollar.nio.file.attribute;

import com.github.catvod.spider.jdollar.time.Instant;
import com.github.catvod.spider.jdollar.time.LocalDateTime;
import com.github.catvod.spider.jdollar.time.ZoneOffset;
import java.util.concurrent.TimeUnit;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class FileTime implements Comparable<FileTime> {
    public final long a;
    public Instant b = null;
    public String c;

    public FileTime(long j) {
        this.a = j;
    }

    public static void h(StringBuilder sb, int i, int i2) {
        while (i > 0) {
            sb.append((char) ((i2 / i) + 48));
            i2 %= i;
            i /= 10;
        }
    }

    public static long j(long j, long j2, long j3) {
        if (j > j3) {
            return Long.MAX_VALUE;
        }
        if (j < (-j3)) {
            return Long.MIN_VALUE;
        }
        return j * j2;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof FileTime) && compareTo((FileTime) obj) == 0;
    }

    public final int hashCode() {
        return toInstant().hashCode();
    }

    @Override // java.lang.Comparable
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public final int compareTo(FileTime fileTime) {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        if (timeUnit != null) {
            fileTime.getClass();
            return Long.compare(this.a, fileTime.a);
        }
        long epochSecond = toInstant().getEpochSecond();
        int iCompare = Long.compare(epochSecond, fileTime.toInstant().getEpochSecond());
        if (iCompare != 0) {
            return iCompare;
        }
        int iCompare2 = Long.compare(toInstant().getNano(), fileTime.toInstant().getNano());
        if (iCompare2 != 0) {
            return iCompare2;
        }
        if (epochSecond != 31556889864403199L && epochSecond != -31557014167219200L) {
            return 0;
        }
        long epochSecond2 = timeUnit != null ? this.a / 86400000 : toInstant().getEpochSecond() / 86400;
        long epochSecond3 = timeUnit != null ? fileTime.a / 86400000 : fileTime.toInstant().getEpochSecond() / 86400;
        return epochSecond2 == epochSecond3 ? Long.compare(o(epochSecond2), fileTime.o(epochSecond3)) : Long.compare(epochSecond2, epochSecond3);
    }

    public final long o(long j) {
        TimeUnit timeUnit = TimeUnit.DAYS;
        TimeUnit timeUnit2 = TimeUnit.MILLISECONDS;
        if (timeUnit2 != null) {
            return timeUnit2.toNanos(this.a - timeUnit2.convert(j, timeUnit));
        }
        return TimeUnit.SECONDS.toNanos(toInstant().getEpochSecond() - timeUnit.toSeconds(j));
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0092  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.github.catvod.spider.jdollar.time.Instant toInstant() {
        /*
            r10 = this;
            com.github.catvod.spider.jdollar.time.Instant r0 = r10.b
            if (r0 != 0) goto La7
            int[] r0 = com.github.catvod.spider.jdollar.nio.file.attribute.r.a
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.MILLISECONDS
            int r1 = r1.ordinal()
            r0 = r0[r1]
            r1 = 0
            switch(r0) {
                case 1: goto L75;
                case 2: goto L67;
                case 3: goto L59;
                case 4: goto L54;
                case 5: goto L3f;
                case 6: goto L2c;
                case 7: goto L1a;
                default: goto L12;
            }
        L12:
            java.lang.AssertionError r0 = new java.lang.AssertionError
            java.lang.String r1 = "Unit not handled"
            r0.<init>(r1)
            throw r0
        L1a:
            long r0 = r10.a
            r2 = 1000000000(0x3b9aca00, double:4.94065646E-315)
            long r0 = com.github.catvod.spider.jdollar.com.android.tools.r8.a.z(r0, r2)
            long r4 = r10.a
            long r2 = com.github.catvod.spider.jdollar.com.android.tools.r8.a.M(r4, r2)
            int r3 = (int) r2
            r2 = r3
            goto L84
        L2c:
            long r0 = r10.a
            r2 = 1000000(0xf4240, double:4.940656E-318)
            long r0 = com.github.catvod.spider.jdollar.com.android.tools.r8.a.z(r0, r2)
            long r4 = r10.a
            long r2 = com.github.catvod.spider.jdollar.com.android.tools.r8.a.M(r4, r2)
            int r3 = (int) r2
            int r2 = r3 * 1000
            goto L84
        L3f:
            long r0 = r10.a
            r2 = 1000(0x3e8, double:4.94E-321)
            long r0 = com.github.catvod.spider.jdollar.com.android.tools.r8.a.z(r0, r2)
            long r4 = r10.a
            long r2 = com.github.catvod.spider.jdollar.com.android.tools.r8.a.M(r4, r2)
            int r3 = (int) r2
            r2 = 1000000(0xf4240, float:1.401298E-39)
            int r2 = r2 * r3
            goto L84
        L54:
            long r2 = r10.a
        L56:
            r0 = r2
            r2 = 0
            goto L84
        L59:
            long r4 = r10.a
            r6 = 60
            r8 = 153722867280912930(0x222222222222222, double:2.166167076120538E-298)
            long r2 = j(r4, r6, r8)
            goto L56
        L67:
            long r4 = r10.a
            r6 = 3600(0xe10, double:1.7786E-320)
            r8 = 2562047788015215(0x91a2b3c4d5e6f, double:1.2658197950618743E-308)
            long r2 = j(r4, r6, r8)
            goto L56
        L75:
            long r4 = r10.a
            r6 = 86400(0x15180, double:4.26873E-319)
            r8 = 106751991167300(0x611722833944, double:5.2742491460911E-310)
            long r2 = j(r4, r6, r8)
            goto L56
        L84:
            r3 = -31557014167219200(0xff8fe31014641400, double:-2.7989734602046733E306)
            int r5 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r5 > 0) goto L92
            com.github.catvod.spider.jdollar.time.Instant r0 = com.github.catvod.spider.jdollar.time.Instant.d
            r10.b = r0
            goto La7
        L92:
            r3 = 31556889864403199(0x701cd2fa9578ff, double:1.434068493154717E-306)
            int r5 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r5 < 0) goto La0
            com.github.catvod.spider.jdollar.time.Instant r0 = com.github.catvod.spider.jdollar.time.Instant.e
            r10.b = r0
            goto La7
        La0:
            long r2 = (long) r2
            com.github.catvod.spider.jdollar.time.Instant r0 = com.github.catvod.spider.jdollar.time.Instant.ofEpochSecond(r0, r2)
            r10.b = r0
        La7:
            com.github.catvod.spider.jdollar.time.Instant r0 = r10.b
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.catvod.spider.jdollar.nio.file.attribute.FileTime.toInstant():com.github.catvod.spider.jdollar.time.Instant");
    }

    public long toMillis() {
        if (TimeUnit.MILLISECONDS != null) {
            return this.a;
        }
        long epochSecond = this.b.getEpochSecond();
        long j = epochSecond * 1000;
        return (((Math.abs(epochSecond) | 1000) >>> 31) == 0 || j / 1000 == epochSecond) ? j + (this.b.getNano() / 1000000) : epochSecond < 0 ? Long.MIN_VALUE : Long.MAX_VALUE;
    }

    public final String toString() {
        long epochSecond;
        int nano;
        long jZ;
        LocalDateTime localDateTimeV;
        int year;
        if (this.c == null) {
            if (this.b != null || TimeUnit.MILLISECONDS.compareTo(TimeUnit.SECONDS) < 0) {
                epochSecond = toInstant().getEpochSecond();
                nano = toInstant().getNano();
            } else {
                epochSecond = this.a / 1000;
                nano = 0;
            }
            if (epochSecond >= -62167219200L) {
                long j = epochSecond - 253402300800L;
                jZ = com.github.catvod.spider.jdollar.com.android.tools.r8.a.z(j, 315569520000L) + 1;
                localDateTimeV = LocalDateTime.V(com.github.catvod.spider.jdollar.com.android.tools.r8.a.M(j, 315569520000L) - 62167219200L, nano, ZoneOffset.UTC);
                year = localDateTimeV.a.getYear();
            } else {
                long j2 = epochSecond + 62167219200L;
                jZ = j2 / 315569520000L;
                localDateTimeV = LocalDateTime.V((j2 % 315569520000L) - 62167219200L, nano, ZoneOffset.UTC);
                year = localDateTimeV.a.getYear();
            }
            int i = (((int) jZ) * 10000) + year;
            if (i <= 0) {
                i--;
            }
            int nano2 = localDateTimeV.b.getNano();
            StringBuilder sb = new StringBuilder(64);
            sb.append(i < 0 ? "-" : VideoStream.RESOLUTION_UNKNOWN);
            int iAbs = Math.abs(i);
            if (iAbs < 10000) {
                h(sb, 1000, Math.abs(iAbs));
            } else {
                sb.append(String.valueOf(iAbs));
            }
            sb.append('-');
            h(sb, 10, localDateTimeV.a.getMonthValue());
            sb.append('-');
            h(sb, 10, localDateTimeV.a.getDayOfMonth());
            sb.append('T');
            h(sb, 10, localDateTimeV.b.getHour());
            sb.append(':');
            h(sb, 10, localDateTimeV.b.getMinute());
            sb.append(':');
            h(sb, 10, localDateTimeV.b.getSecond());
            if (nano2 != 0) {
                sb.append('.');
                int i2 = 100000000;
                while (nano2 % 10 == 0) {
                    nano2 /= 10;
                    i2 /= 10;
                }
                h(sb, i2, nano2);
            }
            sb.append('Z');
            this.c = sb.toString();
        }
        return this.c;
    }
}
