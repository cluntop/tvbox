package com.github.catvod.spider.merge.b;

import android.content.ContentProviderClient;
import android.content.res.TypedArray;
import android.drm.DrmManagerClient;
import android.media.MediaDrm;
import android.media.MediaMetadataRetriever;
import com.github.catvod.crawler.SpiderDebug;
import com.github.catvod.spider.merge.o1.n;
import com.github.catvod.spider.merge.o1.s;
import com.github.catvod.spider.merge.q1.u;
import com.github.catvod.spider.merge.u.c2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.IntRange;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract /* synthetic */ class b {
    public static String A(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    public static /* synthetic */ void B(AutoCloseable autoCloseable) throws Exception {
        if (autoCloseable instanceof AutoCloseable) {
            autoCloseable.close();
            return;
        }
        if (autoCloseable instanceof ExecutorService) {
            com.github.catvod.spider.merge.c0.a.b((ExecutorService) autoCloseable);
            return;
        }
        if (autoCloseable instanceof TypedArray) {
            ((TypedArray) autoCloseable).recycle();
            return;
        }
        if (autoCloseable instanceof MediaMetadataRetriever) {
            ((MediaMetadataRetriever) autoCloseable).release();
            return;
        }
        if (autoCloseable instanceof MediaDrm) {
            ((MediaDrm) autoCloseable).release();
        } else if (autoCloseable instanceof DrmManagerClient) {
            ((DrmManagerClient) autoCloseable).release();
        } else {
            if (!(autoCloseable instanceof ContentProviderClient)) {
                throw new IllegalArgumentException();
            }
            ((ContentProviderClient) autoCloseable).release();
        }
    }

    public static /* synthetic */ String C(int i) {
        switch (i) {
            case 1:
                return "Doctype";
            case 2:
                return "StartTag";
            case 3:
                return "EndTag";
            case 4:
                return "Comment";
            case 5:
                return "Character";
            case 6:
                return "XmlDecl";
            case 7:
                return "EOF";
            default:
                return "null";
        }
    }

    public static void a(u uVar, s sVar) {
        c2.R(sVar);
        s sVarQ = sVar.q();
        char c = 0;
        int i = 0;
        while (true) {
            if (c == 0) {
                n nVar = sVar.a;
                s sVarQ2 = sVar.q();
                int iC = nVar != null ? sVar.C() : 0;
                uVar.b(sVar, i);
                if (nVar != null && sVar.a != nVar) {
                    sVar = iC < nVar.e.size() ? nVar.f(iC) : null;
                    s sVar2 = i == 0 ? sVarQ : sVarQ2;
                    if (sVar == null || sVar == sVar2) {
                        if (i == 0) {
                            return;
                        }
                        if (sVarQ2 == null || sVarQ2.a != nVar) {
                            i--;
                            sVar = nVar;
                            c = 2;
                        } else {
                            sVar = sVarQ2;
                        }
                    }
                }
                c = 1;
            } else {
                if (c != 1 || sVar.g() <= 0) {
                    uVar.a(sVar, i);
                    s sVarQ3 = sVar.q();
                    if (i == 0) {
                        if (sVarQ3 == null || sVarQ3 == sVarQ) {
                            return;
                        }
                    } else if (sVarQ3 == null) {
                        sVar = sVar.a;
                        i--;
                        c = 2;
                    }
                    sVar = sVarQ3;
                } else {
                    sVar = sVar.f(0);
                    i++;
                }
                c = 0;
            }
        }
    }

    public static int b(int i, int i2, int i3, int i4) {
        return com.github.catvod.spider.merge.b1.b.l(i + i2 + i3, i4);
    }

    public static int c(int i, int i2, int i3, int i4, int i5) {
        int i6 = i + i2 + i3;
        return ((i6 >>> (32 - i4)) | (i6 << i4)) + i5;
    }

    public static int d(UInt uInt, int i) {
        return UInt.constructor-impl(uInt.unbox-impl() + i);
    }

    public static int e(IntRange intRange, int i) {
        return intRange.getEndInclusive().intValue() + i;
    }

    public static Object f(byte[] bArr, int i, Function1 function1) {
        return function1.invoke(UByte.box-impl(UByteArray.get-w2LRezQ(bArr, i)));
    }

    public static Object g(int[] iArr, int i, Function1 function1) {
        return function1.invoke(UInt.box-impl(UIntArray.get-pVg5ArA(iArr, i)));
    }

    public static Object h(long[] jArr, int i, Function1 function1) {
        return function1.invoke(ULong.box-impl(ULongArray.get-s-VKNKU(jArr, i)));
    }

    public static Object i(short[] sArr, int i, Function1 function1) {
        return function1.invoke(UShort.box-impl(UShortArray.get-Mh2AYeg(sArr, i)));
    }

    public static String j(int i, String str) {
        return str + i;
    }

    public static String k(int i, String str, String str2) {
        return str + i + str2;
    }

    public static String l(String str, int i, char c) {
        return str + i + c;
    }

    public static String m(String str, long j) {
        return str + j;
    }

    public static String n(String str, String str2) {
        return str + str2;
    }

    public static String o(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    public static String p(String str, String str2, String str3, String str4) {
        return str + str2 + str3 + str4;
    }

    public static String q(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    public static StringBuilder r(int i, String str, String str2) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(i);
        sb.append(str2);
        return sb;
    }

    public static StringBuilder s(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(str2);
        sb.append(str3);
        return sb;
    }

    public static ArrayList t(LinkedHashMap linkedHashMap, Object obj) {
        ArrayList arrayList = new ArrayList();
        linkedHashMap.put(obj, arrayList);
        return arrayList;
    }

    public static ArrayList u(Map map, Object obj) {
        ArrayList arrayList = new ArrayList();
        map.put(obj, arrayList);
        return arrayList;
    }

    public static Iterator v(Iterable iterable, Function1 function1) {
        iterable.getClass();
        function1.getClass();
        return iterable.iterator();
    }

    public static /* synthetic */ void w(AutoCloseable autoCloseable) throws Exception {
        if (autoCloseable instanceof AutoCloseable) {
            autoCloseable.close();
            return;
        }
        if (autoCloseable instanceof ExecutorService) {
            com.github.catvod.spider.merge.c0.a.a((ExecutorService) autoCloseable);
            return;
        }
        if (autoCloseable instanceof TypedArray) {
            ((TypedArray) autoCloseable).recycle();
            return;
        }
        if (autoCloseable instanceof MediaMetadataRetriever) {
            ((MediaMetadataRetriever) autoCloseable).release();
            return;
        }
        if (autoCloseable instanceof MediaDrm) {
            ((MediaDrm) autoCloseable).release();
        } else if (autoCloseable instanceof DrmManagerClient) {
            ((DrmManagerClient) autoCloseable).release();
        } else {
            if (!(autoCloseable instanceof ContentProviderClient)) {
                throw new IllegalArgumentException();
            }
            ((ContentProviderClient) autoCloseable).release();
        }
    }

    public static void x(Exception exc, StringBuilder sb) {
        sb.append(exc.getMessage());
        SpiderDebug.log(sb.toString());
    }

    public static int y(int i, int i2, int i3, int i4) {
        return i + i2 + i3 + i4;
    }

    public static String z(String str, String str2) {
        return str + str2;
    }
}
