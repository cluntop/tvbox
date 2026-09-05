package com.github.catvod.spider.jdollar.com.android.tools.r8;

import com.github.catvod.spider.jdollar.desugar.sun.nio.fs.e;
import com.github.catvod.spider.jdollar.desugar.sun.nio.fs.g;
import com.github.catvod.spider.jdollar.desugar.sun.nio.fs.m;
import com.github.catvod.spider.jdollar.nio.channels.DesugarChannels;
import com.github.catvod.spider.jdollar.nio.file.Files;
import com.github.catvod.spider.jdollar.nio.file.LinkOption;
import com.github.catvod.spider.jdollar.nio.file.OpenOption;
import com.github.catvod.spider.jdollar.nio.file.Path;
import com.github.catvod.spider.jdollar.nio.file.StandardCopyOption;
import com.github.catvod.spider.jdollar.nio.file.StandardOpenOption;
import com.github.catvod.spider.jdollar.nio.file.attribute.BasicFileAttributeView;
import com.github.catvod.spider.jdollar.nio.file.attribute.BasicFileAttributes;
import com.github.catvod.spider.jdollar.nio.file.attribute.FileAttribute;
import com.github.catvod.spider.jdollar.nio.file.attribute.FileTime;
import com.github.catvod.spider.jdollar.nio.file.attribute.PosixFilePermission;
import com.github.catvod.spider.jdollar.nio.file.attribute.i;
import com.github.catvod.spider.jdollar.nio.file.attribute.j;
import com.github.catvod.spider.jdollar.nio.file.attribute.k;
import com.github.catvod.spider.jdollar.nio.file.b;
import com.github.catvod.spider.jdollar.nio.file.c;
import com.github.catvod.spider.jdollar.nio.file.d;
import com.github.catvod.spider.jdollar.nio.file.e0;
import com.github.catvod.spider.jdollar.nio.file.h0;
import com.github.catvod.spider.jdollar.nio.file.i0;
import com.github.catvod.spider.jdollar.nio.file.j0;
import com.github.catvod.spider.jdollar.nio.file.s;
import com.github.catvod.spider.jdollar.nio.file.u;
import com.github.catvod.spider.jdollar.nio.file.v;
import com.github.catvod.spider.jdollar.time.ZoneId;
import com.github.catvod.spider.jdollar.time.ZoneOffset;
import com.github.catvod.spider.jdollar.time.chrono.ChronoZonedDateTime;
import com.github.catvod.spider.jdollar.time.chrono.b0;
import com.github.catvod.spider.jdollar.time.chrono.p;
import com.github.catvod.spider.jdollar.time.chrono.t;
import com.github.catvod.spider.jdollar.time.chrono.w;
import com.github.catvod.spider.jdollar.time.temporal.ChronoUnit;
import com.github.catvod.spider.jdollar.time.temporal.TemporalAccessor;
import com.github.catvod.spider.jdollar.time.temporal.q;
import com.github.catvod.spider.jdollar.time.temporal.r;
import com.github.catvod.spider.jdollar.util.Objects;
import com.github.catvod.spider.jdollar.util.concurrent.ConcurrentHashMap;
import com.github.catvod.spider.jdollar.util.concurrent.l;
import com.github.catvod.spider.jdollar.util.h;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.file.CopyOption;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.NoSuchFileException;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.attribute.AclFileAttributeView;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.DosFileAttributes;
import java.nio.file.attribute.FileOwnerAttributeView;
import java.nio.file.attribute.PosixFileAttributeView;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.Set;
import sun.misc.Unsafe;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract /* synthetic */ class a {
    public static /* synthetic */ String A(Iterable iterable) {
        StringBuilder sb = new StringBuilder();
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            while (true) {
                sb.append((CharSequence) it.next());
                if (!it.hasNext()) {
                    break;
                }
                sb.append((CharSequence) "/");
            }
        }
        return sb.toString();
    }

    public static /* synthetic */ List B(Object[] objArr) {
        ArrayList arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            arrayList.add(Objects.requireNonNull(obj));
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static /* synthetic */ Map.Entry C(Object obj, Object obj2) {
        return new AbstractMap.SimpleImmutableEntry(Objects.requireNonNull(obj), Objects.requireNonNull(obj2));
    }

    public static /* synthetic */ Set D(Object[] objArr) {
        HashSet hashSet = new HashSet(objArr.length);
        for (Object obj : objArr) {
            if (!hashSet.add(Objects.requireNonNull(obj))) {
                throw new IllegalArgumentException("duplicate element: " + obj);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    public static /* synthetic */ boolean E(Unsafe unsafe, Object obj, long j, l lVar) {
        while (true) {
            Unsafe unsafe2 = unsafe;
            Object obj2 = obj;
            long j2 = j;
            l lVar2 = lVar;
            if (unsafe2.compareAndSwapObject(obj2, j2, (Object) null, lVar2)) {
                return true;
            }
            if (unsafe2.getObject(obj2, j2) != null) {
                return false;
            }
            unsafe = unsafe2;
            obj = obj2;
            j = j2;
            lVar = lVar2;
        }
    }

    public static /* synthetic */ LinkOption[] F(java.nio.file.LinkOption[] linkOptionArr) {
        if (linkOptionArr == null) {
            return null;
        }
        int length = linkOptionArr.length;
        LinkOption[] linkOptionArr2 = new LinkOption[length];
        for (int i = 0; i < length; i++) {
            linkOptionArr2[i] = linkOptionArr[i] == null ? null : LinkOption.NOFOLLOW_LINKS;
        }
        return linkOptionArr2;
    }

    public static j0[] G(WatchEvent.Kind[] kindArr) {
        if (kindArr == null) {
            return null;
        }
        int length = kindArr.length;
        j0[] j0VarArr = new j0[length];
        for (int i = 0; i < length; i++) {
            WatchEvent.Kind kind = kindArr[i];
            j0VarArr[i] = kind == null ? null : kind == StandardWatchEventKinds.ENTRY_CREATE ? e0.b : kind == StandardWatchEventKinds.ENTRY_DELETE ? e0.c : kind == StandardWatchEventKinds.ENTRY_MODIFY ? e0.d : kind == StandardWatchEventKinds.OVERFLOW ? e0.a : kind instanceof i0 ? ((i0) kind).a : new h0(kind);
        }
        return j0VarArr;
    }

    public static FileAttribute[] H(java.nio.file.attribute.FileAttribute[] fileAttributeArr) {
        if (fileAttributeArr == null) {
            return null;
        }
        int length = fileAttributeArr.length;
        FileAttribute[] fileAttributeArr2 = new FileAttribute[length];
        for (int i = 0; i < length; i++) {
            java.nio.file.attribute.FileAttribute fileAttribute = fileAttributeArr[i];
            fileAttributeArr2[i] = fileAttribute == null ? null : x(fileAttribute.value()) ? new g(3, fileAttribute) : fileAttribute instanceof j ? ((j) fileAttribute).a : new i(fileAttribute);
        }
        return fileAttributeArr2;
    }

    public static /* synthetic */ CopyOption[] I(com.github.catvod.spider.jdollar.nio.file.CopyOption[] copyOptionArr) {
        CopyOption dVar;
        if (copyOptionArr == null) {
            return null;
        }
        int length = copyOptionArr.length;
        CopyOption[] copyOptionArr2 = new CopyOption[length];
        for (int i = 0; i < length; i++) {
            com.github.catvod.spider.jdollar.nio.file.CopyOption copyOption = copyOptionArr[i];
            if (copyOption == null) {
                dVar = null;
            } else if (copyOption instanceof c) {
                dVar = ((c) copyOption).a;
            } else if (copyOption instanceof LinkOption) {
                dVar = java.nio.file.LinkOption.NOFOLLOW_LINKS;
            } else if (copyOption instanceof StandardCopyOption) {
                StandardCopyOption standardCopyOption = (StandardCopyOption) copyOption;
                dVar = standardCopyOption == StandardCopyOption.REPLACE_EXISTING ? java.nio.file.StandardCopyOption.REPLACE_EXISTING : standardCopyOption == StandardCopyOption.COPY_ATTRIBUTES ? java.nio.file.StandardCopyOption.COPY_ATTRIBUTES : java.nio.file.StandardCopyOption.ATOMIC_MOVE;
            } else {
                dVar = new d(copyOption);
            }
            copyOptionArr2[i] = dVar;
        }
        return copyOptionArr2;
    }

    public static /* synthetic */ java.nio.file.LinkOption[] J(LinkOption[] linkOptionArr) {
        if (linkOptionArr == null) {
            return null;
        }
        int length = linkOptionArr.length;
        java.nio.file.LinkOption[] linkOptionArr2 = new java.nio.file.LinkOption[length];
        for (int i = 0; i < length; i++) {
            linkOptionArr2[i] = linkOptionArr[i] == null ? null : java.nio.file.LinkOption.NOFOLLOW_LINKS;
        }
        return linkOptionArr2;
    }

    public static WatchEvent.Kind[] K(j0[] j0VarArr) {
        if (j0VarArr == null) {
            return null;
        }
        int length = j0VarArr.length;
        WatchEvent.Kind[] kindArr = new WatchEvent.Kind[length];
        for (int i = 0; i < length; i++) {
            j0 j0Var = j0VarArr[i];
            kindArr[i] = j0Var == null ? null : j0Var == e0.b ? StandardWatchEventKinds.ENTRY_CREATE : j0Var == e0.c ? StandardWatchEventKinds.ENTRY_DELETE : j0Var == e0.d ? StandardWatchEventKinds.ENTRY_MODIFY : j0Var == e0.a ? StandardWatchEventKinds.OVERFLOW : j0Var instanceof h0 ? ((h0) j0Var).a : new i0(j0Var);
        }
        return kindArr;
    }

    public static java.nio.file.attribute.FileAttribute[] L(FileAttribute[] fileAttributeArr) {
        if (fileAttributeArr == null) {
            return null;
        }
        int length = fileAttributeArr.length;
        java.nio.file.attribute.FileAttribute[] fileAttributeArr2 = new java.nio.file.attribute.FileAttribute[length];
        for (int i = 0; i < length; i++) {
            FileAttribute fileAttribute = fileAttributeArr[i];
            fileAttributeArr2[i] = fileAttribute == null ? null : x(fileAttribute.value()) ? new k(fileAttribute) : fileAttribute instanceof i ? ((i) fileAttribute).a : new j(fileAttribute);
        }
        return fileAttributeArr2;
    }

    public static /* synthetic */ long M(long j, long j2) {
        long j3 = j % j2;
        if (j3 == 0) {
            return 0L;
        }
        return (((j ^ j2) >> 63) | 1) > 0 ? j3 : j3 + j2;
    }

    public static /* synthetic */ long N(long j, long j2) {
        long j3 = j + j2;
        if (((j2 ^ j) < 0) || ((j ^ j3) >= 0)) {
            return j3;
        }
        throw new ArithmeticException();
    }

    public static /* synthetic */ long O(long j, long j2) {
        int iNumberOfLeadingZeros = Long.numberOfLeadingZeros(~j2) + Long.numberOfLeadingZeros(j2) + Long.numberOfLeadingZeros(~j) + Long.numberOfLeadingZeros(j);
        if (iNumberOfLeadingZeros > 65) {
            return j * j2;
        }
        if (iNumberOfLeadingZeros >= 64) {
            if ((j >= 0) | (j2 != Long.MIN_VALUE)) {
                long j3 = j * j2;
                if (j == 0 || j3 / j == j2) {
                    return j3;
                }
            }
        }
        throw new ArithmeticException();
    }

    public static /* synthetic */ long P(long j, long j2) {
        long j3 = j - j2;
        if (((j2 ^ j) >= 0) || ((j ^ j3) >= 0)) {
            return j3;
        }
        throw new ArithmeticException();
    }

    public static char Q(String str, int i) {
        if (i < str.length()) {
            return str.charAt(i);
        }
        return (char) 0;
    }

    public static com.github.catvod.spider.jdollar.time.chrono.l R(String str) {
        ConcurrentHashMap concurrentHashMap = com.github.catvod.spider.jdollar.time.chrono.a.a;
        Objects.requireNonNull(str, "id");
        while (true) {
            ConcurrentHashMap concurrentHashMap2 = com.github.catvod.spider.jdollar.time.chrono.a.a;
            com.github.catvod.spider.jdollar.time.chrono.l lVar = (com.github.catvod.spider.jdollar.time.chrono.l) concurrentHashMap2.get(str);
            if (lVar == null) {
                lVar = (com.github.catvod.spider.jdollar.time.chrono.l) com.github.catvod.spider.jdollar.time.chrono.a.b.get(str);
            }
            if (lVar != null) {
                return lVar;
            }
            if (concurrentHashMap2.get("ISO") != null) {
                Iterator it = ServiceLoader.load(com.github.catvod.spider.jdollar.time.chrono.l.class).iterator();
                while (it.hasNext()) {
                    com.github.catvod.spider.jdollar.time.chrono.l lVar2 = (com.github.catvod.spider.jdollar.time.chrono.l) it.next();
                    if (str.equals(lVar2.getId()) || str.equals(lVar2.l())) {
                        return lVar2;
                    }
                }
                b.j(str, "Unknown chronology: ");
                return null;
            }
            p pVar = p.l;
            pVar.getClass();
            com.github.catvod.spider.jdollar.time.chrono.a.j(pVar, "Hijrah-umalqura");
            w wVar = w.c;
            wVar.getClass();
            com.github.catvod.spider.jdollar.time.chrono.a.j(wVar, "Japanese");
            b0 b0Var = b0.c;
            b0Var.getClass();
            com.github.catvod.spider.jdollar.time.chrono.a.j(b0Var, "Minguo");
            com.github.catvod.spider.jdollar.time.chrono.h0 h0Var = com.github.catvod.spider.jdollar.time.chrono.h0.c;
            h0Var.getClass();
            com.github.catvod.spider.jdollar.time.chrono.a.j(h0Var, "ThaiBuddhist");
            try {
                for (com.github.catvod.spider.jdollar.time.chrono.a aVar : Arrays.asList(new com.github.catvod.spider.jdollar.time.chrono.a[0])) {
                    if (!aVar.getId().equals("ISO")) {
                        com.github.catvod.spider.jdollar.time.chrono.a.j(aVar, aVar.getId());
                    }
                }
                t tVar = t.c;
                tVar.getClass();
                com.github.catvod.spider.jdollar.time.chrono.a.j(tVar, "ISO");
            } catch (Throwable th) {
                throw new ServiceConfigurationError(th.getMessage(), th);
            }
        }
    }

    public static FileChannel S(Path path, Set set) throws IOException {
        Iterator it = set.iterator();
        while (it.hasNext()) {
            ((OpenOption) it.next()).getClass();
        }
        if (path.toFile().exists()) {
            if (set.contains(StandardOpenOption.CREATE_NEW) && set.contains(StandardOpenOption.WRITE)) {
                throw new FileAlreadyExistsException(path.toString());
            }
        } else if (!set.contains(StandardOpenOption.CREATE) && !set.contains(StandardOpenOption.CREATE_NEW)) {
            throw new NoSuchFileException(path.toString());
        }
        if (set.contains(StandardOpenOption.READ) && set.contains(StandardOpenOption.APPEND)) {
            b.c("READ + APPEND not allowed");
            return null;
        }
        StandardOpenOption standardOpenOption = StandardOpenOption.APPEND;
        if (set.contains(standardOpenOption) && set.contains(StandardOpenOption.TRUNCATE_EXISTING)) {
            b.c("APPEND + TRUNCATE_EXISTING not allowed");
            return null;
        }
        File file = path.toFile();
        StandardOpenOption standardOpenOption2 = StandardOpenOption.WRITE;
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, (set.contains(standardOpenOption2) || set.contains(standardOpenOption)) ? set.contains(StandardOpenOption.SYNC) ? "rws" : set.contains(StandardOpenOption.DSYNC) ? "rwd" : "rw" : "r");
        if (set.contains(StandardOpenOption.TRUNCATE_EXISTING) && set.contains(standardOpenOption2)) {
            randomAccessFile.setLength(0L);
        }
        if (!set.contains(standardOpenOption) && !set.contains(StandardOpenOption.DELETE_ON_CLOSE)) {
            return DesugarChannels.convertMaybeLegacyFileChannelFromLibrary(randomAccessFile.getChannel());
        }
        FileChannel fileChannelConvertMaybeLegacyFileChannelFromLibrary = DesugarChannels.convertMaybeLegacyFileChannelFromLibrary(randomAccessFile.getChannel());
        int i = e.e;
        if (fileChannelConvertMaybeLegacyFileChannelFromLibrary instanceof e) {
            fileChannelConvertMaybeLegacyFileChannelFromLibrary = ((e) fileChannelConvertMaybeLegacyFileChannelFromLibrary).a;
        }
        return new e(fileChannelConvertMaybeLegacyFileChannelFromLibrary, set.contains(StandardOpenOption.DELETE_ON_CLOSE), set.contains(standardOpenOption), path);
    }

    public static com.github.catvod.spider.jdollar.time.a T() {
        return new com.github.catvod.spider.jdollar.time.a(ZoneId.systemDefault());
    }

    public static com.github.catvod.spider.jdollar.time.temporal.l a(com.github.catvod.spider.jdollar.time.chrono.b bVar, com.github.catvod.spider.jdollar.time.temporal.l lVar) {
        return lVar.b(bVar.F(), com.github.catvod.spider.jdollar.time.temporal.a.EPOCH_DAY);
    }

    public static int b(com.github.catvod.spider.jdollar.time.chrono.b bVar, com.github.catvod.spider.jdollar.time.chrono.b bVar2) {
        int iCompare = Long.compare(bVar.F(), bVar2.F());
        if (iCompare != 0) {
            return iCompare;
        }
        return ((com.github.catvod.spider.jdollar.time.chrono.a) bVar.a()).getId().compareTo(bVar2.a().getId());
    }

    public static int c(com.github.catvod.spider.jdollar.time.chrono.e eVar, com.github.catvod.spider.jdollar.time.chrono.e eVar2) {
        int iP = eVar.e().compareTo(eVar2.e());
        return (iP == 0 && (iP = eVar.toLocalTime().compareTo(eVar2.toLocalTime())) == 0) ? ((com.github.catvod.spider.jdollar.time.chrono.a) eVar.a()).getId().compareTo(eVar2.a().getId()) : iP;
    }

    public static int d(ChronoZonedDateTime chronoZonedDateTime, ChronoZonedDateTime chronoZonedDateTime2) {
        int iCompare = Long.compare(chronoZonedDateTime.R(), chronoZonedDateTime2.R());
        return (iCompare == 0 && (iCompare = chronoZonedDateTime.toLocalTime().getNano() - chronoZonedDateTime2.toLocalTime().getNano()) == 0 && (iCompare = chronoZonedDateTime.q().compareTo(chronoZonedDateTime2.q())) == 0 && (iCompare = chronoZonedDateTime.getZone().getId().compareTo(chronoZonedDateTime2.getZone().getId())) == 0) ? ((com.github.catvod.spider.jdollar.time.chrono.a) chronoZonedDateTime.a()).getId().compareTo(chronoZonedDateTime2.a().getId()) : iCompare;
    }

    public static int e(ChronoZonedDateTime chronoZonedDateTime, com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        if (!(pVar instanceof com.github.catvod.spider.jdollar.time.temporal.a)) {
            return q.a(chronoZonedDateTime, pVar);
        }
        int i = com.github.catvod.spider.jdollar.time.chrono.i.a[((com.github.catvod.spider.jdollar.time.temporal.a) pVar).ordinal()];
        if (i != 1) {
            return i != 2 ? chronoZonedDateTime.q().h(pVar) : chronoZonedDateTime.getOffset().getTotalSeconds();
        }
        throw new r("Invalid field 'InstantSeconds' for get() method, use getLong() instead");
    }

    public static boolean f(com.github.catvod.spider.jdollar.time.chrono.b bVar, com.github.catvod.spider.jdollar.time.temporal.p pVar) {
        return pVar instanceof com.github.catvod.spider.jdollar.time.temporal.a ? ((com.github.catvod.spider.jdollar.time.temporal.a) pVar).isDateBased() : pVar != null && pVar.h(bVar);
    }

    public static Object g(com.github.catvod.spider.jdollar.time.chrono.b bVar, m mVar) {
        if (mVar == q.a || mVar == q.e || mVar == q.d || mVar == q.g) {
            return null;
        }
        return mVar == q.b ? bVar.a() : mVar == q.c ? ChronoUnit.DAYS : mVar.f(bVar);
    }

    public static Object h(com.github.catvod.spider.jdollar.time.chrono.e eVar, m mVar) {
        if (mVar == q.a || mVar == q.e || mVar == q.d) {
            return null;
        }
        return mVar == q.g ? eVar.toLocalTime() : mVar == q.b ? eVar.a() : mVar == q.c ? ChronoUnit.NANOS : mVar.f(eVar);
    }

    public static Object i(ChronoZonedDateTime chronoZonedDateTime, m mVar) {
        return (mVar == q.e || mVar == q.a) ? chronoZonedDateTime.getZone() : mVar == q.d ? chronoZonedDateTime.getOffset() : mVar == q.g ? chronoZonedDateTime.toLocalTime() : mVar == q.b ? chronoZonedDateTime.a() : mVar == q.c ? ChronoUnit.NANOS : mVar.f(chronoZonedDateTime);
    }

    public static long j(com.github.catvod.spider.jdollar.time.chrono.e eVar, ZoneOffset zoneOffset) {
        Objects.requireNonNull(zoneOffset, "offset");
        return ((eVar.e().F() * 86400) + eVar.toLocalTime().e0()) - zoneOffset.getTotalSeconds();
    }

    public static long k(ChronoZonedDateTime chronoZonedDateTime) {
        return ((chronoZonedDateTime.e().F() * 86400) + chronoZonedDateTime.toLocalTime().e0()) - chronoZonedDateTime.getOffset().getTotalSeconds();
    }

    public static FileTime l(java.nio.file.attribute.FileTime fileTime) {
        if (fileTime == null) {
            return null;
        }
        return new FileTime(fileTime.toMillis());
    }

    public static /* synthetic */ java.nio.file.StandardOpenOption m(StandardOpenOption standardOpenOption) {
        if (standardOpenOption == null) {
            return null;
        }
        return standardOpenOption == StandardOpenOption.READ ? java.nio.file.StandardOpenOption.READ : standardOpenOption == StandardOpenOption.WRITE ? java.nio.file.StandardOpenOption.WRITE : standardOpenOption == StandardOpenOption.APPEND ? java.nio.file.StandardOpenOption.APPEND : standardOpenOption == StandardOpenOption.TRUNCATE_EXISTING ? java.nio.file.StandardOpenOption.TRUNCATE_EXISTING : standardOpenOption == StandardOpenOption.CREATE ? java.nio.file.StandardOpenOption.CREATE : standardOpenOption == StandardOpenOption.CREATE_NEW ? java.nio.file.StandardOpenOption.CREATE_NEW : standardOpenOption == StandardOpenOption.DELETE_ON_CLOSE ? java.nio.file.StandardOpenOption.DELETE_ON_CLOSE : standardOpenOption == StandardOpenOption.SPARSE ? java.nio.file.StandardOpenOption.SPARSE : standardOpenOption == StandardOpenOption.SYNC ? java.nio.file.StandardOpenOption.SYNC : java.nio.file.StandardOpenOption.DSYNC;
    }

    public static java.nio.file.attribute.FileTime n(FileTime fileTime) {
        if (fileTime == null) {
            return null;
        }
        return java.nio.file.attribute.FileTime.fromMillis(fileTime.toMillis());
    }

    public static Object o(Object obj) {
        if (obj == null) {
            return null;
        }
        return obj instanceof Path ? v.h((Path) obj) : obj instanceof java.nio.file.Path ? u.h((java.nio.file.Path) obj) : obj;
    }

    public static void p(Path path, Path path2, com.github.catvod.spider.jdollar.nio.file.CopyOption... copyOptionArr) throws IOException {
        boolean z = true;
        boolean z2 = false;
        boolean z3 = false;
        for (com.github.catvod.spider.jdollar.nio.file.CopyOption copyOption : copyOptionArr) {
            if (copyOption == StandardCopyOption.REPLACE_EXISTING) {
                z2 = true;
            } else if (copyOption == LinkOption.NOFOLLOW_LINKS) {
                z = false;
            } else {
                if (copyOption != StandardCopyOption.COPY_ATTRIBUTES) {
                    copyOption.getClass();
                    b.f("'", copyOption, "' is not a recognized copy option");
                    return;
                }
                z3 = true;
            }
        }
        BasicFileAttributes attributes = Files.readAttributes(path, (Class<BasicFileAttributes>) BasicFileAttributes.class, z ? new LinkOption[0] : new LinkOption[]{LinkOption.NOFOLLOW_LINKS});
        if (attributes.isSymbolicLink()) {
            throw new IOException("Copying of symbolic links not supported");
        }
        if (z2) {
            Files.deleteIfExists(path2);
        } else if (Files.exists(path2, new LinkOption[0])) {
            throw new FileAlreadyExistsException(path2.toString());
        }
        if (attributes.isDirectory()) {
            Files.createDirectory(path2, new FileAttribute[0]);
        } else {
            InputStream inputStreamNewInputStream = Files.newInputStream(path, new OpenOption[0]);
            try {
                Files.a(inputStreamNewInputStream, path2, new com.github.catvod.spider.jdollar.nio.file.CopyOption[0]);
                if (inputStreamNewInputStream != null) {
                    inputStreamNewInputStream.close();
                }
            } catch (Throwable th) {
                if (inputStreamNewInputStream != null) {
                    try {
                        inputStreamNewInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
        if (z3) {
            try {
                ((BasicFileAttributeView) Files.getFileAttributeView(path2, BasicFileAttributeView.class, new LinkOption[0])).a(attributes.lastModifiedTime(), attributes.lastAccessTime(), attributes.creationTime());
            } catch (Throwable th3) {
                try {
                    Files.delete(path2);
                } catch (Throwable th4) {
                    th3.addSuppressed(th4);
                }
                throw th3;
            }
        }
    }

    public static Class q(Class cls) {
        if (cls == null) {
            return null;
        }
        if (cls == java.nio.file.attribute.BasicFileAttributeView.class) {
            return BasicFileAttributeView.class;
        }
        if (cls == BasicFileAttributeView.class) {
            return java.nio.file.attribute.BasicFileAttributeView.class;
        }
        if (cls == PosixFileAttributeView.class) {
            return com.github.catvod.spider.jdollar.nio.file.attribute.t.class;
        }
        if (cls == com.github.catvod.spider.jdollar.nio.file.attribute.t.class) {
            return PosixFileAttributeView.class;
        }
        if (cls == FileOwnerAttributeView.class) {
            return com.github.catvod.spider.jdollar.nio.file.attribute.p.class;
        }
        if (cls == com.github.catvod.spider.jdollar.nio.file.attribute.p.class) {
            return FileOwnerAttributeView.class;
        }
        if (cls == com.github.catvod.spider.jdollar.nio.file.attribute.g.class) {
            return DosFileAttributeView.class;
        }
        if (cls == DosFileAttributeView.class) {
            return com.github.catvod.spider.jdollar.nio.file.attribute.g.class;
        }
        if (cls == com.github.catvod.spider.jdollar.nio.file.attribute.v.class) {
            return UserDefinedFileAttributeView.class;
        }
        if (cls == UserDefinedFileAttributeView.class) {
            return com.github.catvod.spider.jdollar.nio.file.attribute.v.class;
        }
        if (cls == com.github.catvod.spider.jdollar.nio.file.attribute.a.class) {
            return AclFileAttributeView.class;
        }
        if (cls == AclFileAttributeView.class) {
            return com.github.catvod.spider.jdollar.nio.file.attribute.a.class;
        }
        h.a(cls, "java.nio.file.attribute.FileAttributeView");
        throw null;
    }

    public static Class r(Class cls) {
        if (cls == null) {
            return null;
        }
        if (cls == java.nio.file.attribute.BasicFileAttributes.class) {
            return BasicFileAttributes.class;
        }
        if (cls == BasicFileAttributes.class) {
            return java.nio.file.attribute.BasicFileAttributes.class;
        }
        if (cls == PosixFileAttributes.class) {
            return com.github.catvod.spider.jdollar.nio.file.attribute.u.class;
        }
        if (cls == com.github.catvod.spider.jdollar.nio.file.attribute.u.class) {
            return PosixFileAttributes.class;
        }
        if (cls == com.github.catvod.spider.jdollar.nio.file.attribute.h.class) {
            return DosFileAttributes.class;
        }
        if (cls == DosFileAttributes.class) {
            return com.github.catvod.spider.jdollar.nio.file.attribute.h.class;
        }
        h.a(cls, "java.nio.file.attribute.BasicFileAttributes");
        throw null;
    }

    public static Map s(Map map) {
        if (map == null || map.isEmpty()) {
            return map;
        }
        HashMap map2 = new HashMap();
        for (String str : map.keySet()) {
            map2.put(str, t(map.get(str)));
        }
        return map2;
    }

    public static Object t(Object obj) {
        if (obj instanceof java.nio.file.attribute.FileTime) {
            try {
                return l((java.nio.file.attribute.FileTime) obj);
            } catch (ClassCastException e) {
                h.a(e, "java.nio.file.attribute.FileTime");
                throw null;
            }
        }
        if (!(obj instanceof FileTime)) {
            return obj;
        }
        try {
            return n((FileTime) obj);
        } catch (ClassCastException e2) {
            h.a(e2, "java.nio.file.attribute.FileTime");
            throw null;
        }
    }

    public static Set u(Set set) {
        if (set == null || set.isEmpty()) {
            return set;
        }
        HashSet hashSet = new HashSet();
        Object next = set.iterator().next();
        if (next instanceof OpenOption) {
            Iterator it = set.iterator();
            while (it.hasNext()) {
                try {
                    hashSet.add(s.a((OpenOption) it.next()));
                } catch (ClassCastException e) {
                    h.a(e, "java.nio.file.OpenOption");
                    throw null;
                }
            }
        } else {
            if (!(next instanceof java.nio.file.OpenOption)) {
                h.a(next.getClass(), "java.nio.file.OpenOption");
                throw null;
            }
            Iterator it2 = set.iterator();
            while (it2.hasNext()) {
                try {
                    hashSet.add(com.github.catvod.spider.jdollar.nio.file.r.a((java.nio.file.OpenOption) it2.next()));
                } catch (ClassCastException e2) {
                    h.a(e2, "java.nio.file.OpenOption");
                    throw null;
                }
            }
        }
        return hashSet;
    }

    public static Set v(Set set) {
        if (set == null || set.isEmpty()) {
            return set;
        }
        HashSet hashSet = new HashSet();
        Object next = set.iterator().next();
        if (next instanceof PosixFilePermission) {
            Iterator it = set.iterator();
            while (it.hasNext()) {
                try {
                    PosixFilePermission posixFilePermission = (PosixFilePermission) it.next();
                    hashSet.add(posixFilePermission == null ? null : posixFilePermission == PosixFilePermission.OWNER_READ ? java.nio.file.attribute.PosixFilePermission.OWNER_READ : posixFilePermission == PosixFilePermission.OWNER_WRITE ? java.nio.file.attribute.PosixFilePermission.OWNER_WRITE : posixFilePermission == PosixFilePermission.OWNER_EXECUTE ? java.nio.file.attribute.PosixFilePermission.OWNER_EXECUTE : posixFilePermission == PosixFilePermission.GROUP_READ ? java.nio.file.attribute.PosixFilePermission.GROUP_READ : posixFilePermission == PosixFilePermission.GROUP_WRITE ? java.nio.file.attribute.PosixFilePermission.GROUP_WRITE : posixFilePermission == PosixFilePermission.GROUP_EXECUTE ? java.nio.file.attribute.PosixFilePermission.GROUP_EXECUTE : posixFilePermission == PosixFilePermission.OTHERS_READ ? java.nio.file.attribute.PosixFilePermission.OTHERS_READ : posixFilePermission == PosixFilePermission.OTHERS_WRITE ? java.nio.file.attribute.PosixFilePermission.OTHERS_WRITE : java.nio.file.attribute.PosixFilePermission.OTHERS_EXECUTE);
                } catch (ClassCastException e) {
                    h.a(e, "java.nio.file.attribute.PosixFilePermission");
                    throw null;
                }
            }
        } else {
            if (!(next instanceof java.nio.file.attribute.PosixFilePermission)) {
                h.a(next.getClass(), "java.nio.file.attribute.PosixFilePermission");
                throw null;
            }
            Iterator it2 = set.iterator();
            while (it2.hasNext()) {
                try {
                    java.nio.file.attribute.PosixFilePermission posixFilePermission2 = (java.nio.file.attribute.PosixFilePermission) it2.next();
                    hashSet.add(posixFilePermission2 == null ? null : posixFilePermission2 == java.nio.file.attribute.PosixFilePermission.OWNER_READ ? PosixFilePermission.OWNER_READ : posixFilePermission2 == java.nio.file.attribute.PosixFilePermission.OWNER_WRITE ? PosixFilePermission.OWNER_WRITE : posixFilePermission2 == java.nio.file.attribute.PosixFilePermission.OWNER_EXECUTE ? PosixFilePermission.OWNER_EXECUTE : posixFilePermission2 == java.nio.file.attribute.PosixFilePermission.GROUP_READ ? PosixFilePermission.GROUP_READ : posixFilePermission2 == java.nio.file.attribute.PosixFilePermission.GROUP_WRITE ? PosixFilePermission.GROUP_WRITE : posixFilePermission2 == java.nio.file.attribute.PosixFilePermission.GROUP_EXECUTE ? PosixFilePermission.GROUP_EXECUTE : posixFilePermission2 == java.nio.file.attribute.PosixFilePermission.OTHERS_READ ? PosixFilePermission.OTHERS_READ : posixFilePermission2 == java.nio.file.attribute.PosixFilePermission.OTHERS_WRITE ? PosixFilePermission.OTHERS_WRITE : PosixFilePermission.OTHERS_EXECUTE);
                } catch (ClassCastException e2) {
                    h.a(e2, "java.nio.file.attribute.PosixFilePermission");
                    throw null;
                }
            }
        }
        return hashSet;
    }

    public static com.github.catvod.spider.jdollar.time.chrono.l w(TemporalAccessor temporalAccessor) {
        Objects.requireNonNull(temporalAccessor, "temporal");
        return (com.github.catvod.spider.jdollar.time.chrono.l) Objects.requireNonNullElse((com.github.catvod.spider.jdollar.time.chrono.l) temporalAccessor.y(q.b), t.c);
    }

    public static boolean x(Object obj) {
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set = (Set) obj;
        if (set.isEmpty()) {
            return false;
        }
        Object next = set.iterator().next();
        return (next instanceof PosixFilePermission) || (next instanceof java.nio.file.attribute.PosixFilePermission);
    }

    public static /* synthetic */ int y(long j) {
        int i = (int) j;
        if (j == i) {
            return i;
        }
        throw new ArithmeticException();
    }

    public static /* synthetic */ long z(long j, long j2) {
        long j3 = j / j2;
        return (j - (j2 * j3) != 0 && (((j ^ j2) >> 63) | 1) < 0) ? j3 - 1 : j3;
    }
}
