package com.github.catvod.spider.merge.u;

import android.R;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class b implements f1 {
    public static <T> void addAll(Iterable<T> iterable, List<? super T> list) {
        byte[] bArr = s0.a;
        iterable.getClass();
        if (iterable instanceof o1) {
            list.addAll((Collection) iterable);
            return;
        }
        if (iterable instanceof Collection) {
            int size = ((Collection) iterable).size();
            if (list instanceof ArrayList) {
                ((ArrayList) list).ensureCapacity(list.size() + size);
            } else if (list instanceof q1) {
                q1 q1Var = (q1) list;
                int i = q1Var.c + size;
                Object[] objArr = q1Var.b;
                if (i > objArr.length) {
                    if (objArr.length == 0) {
                        q1Var.b = new Object[Math.max(i, 10)];
                    } else {
                        int length = objArr.length;
                        while (length < i) {
                            length = o.b(length, 3, 2, 1, 10);
                        }
                        q1Var.b = Arrays.copyOf(q1Var.b, length);
                    }
                }
            }
        }
        int size2 = list.size();
        if (!(iterable instanceof List) || !(iterable instanceof RandomAccess)) {
            for (Object obj : iterable) {
                if (obj == null) {
                    b(size2, list);
                    throw null;
                }
                list.add(obj);
            }
            return;
        }
        List list2 = (List) iterable;
        int size3 = list2.size();
        for (int i2 = 0; i2 < size3; i2++) {
            R.bool boolVar = (Object) list2.get(i2);
            if (boolVar == null) {
                b(size2, list);
                throw null;
            }
            list.add(boolVar);
        }
    }

    public static void b(int i, List list) {
        String str = "Element at index " + (list.size() - i) + " is null.";
        for (int size = list.size() - 1; size >= i; size--) {
            list.remove(size);
        }
        throw new NullPointerException(str);
    }

    public static u1 newUninitializedMessageException(g1 g1Var) {
        return new u1();
    }

    public final String a() {
        return "Reading " + getClass().getName() + " from a ByteString threw an IOException (should never happen).";
    }

    public abstract b internalMergeFrom(c cVar);

    public boolean mergeDelimitedFrom(InputStream inputStream, y yVar) throws IOException {
        int i = inputStream.read();
        if (i == -1) {
            return false;
        }
        m13mergeFrom((InputStream) new a(p.s(i, inputStream), inputStream), yVar);
        return true;
    }

    /* renamed from: mergeFrom, reason: merged with bridge method [inline-methods] */
    public b m8mergeFrom(g1 g1Var) {
        if (getDefaultInstanceForType().getClass().isInstance(g1Var)) {
            return internalMergeFrom((c) g1Var);
        }
        com.github.catvod.spider.merge.s0.a.r("mergeFrom(MessageLite) can only merge messages of the same type.");
        return null;
    }

    /* renamed from: mergeFrom */
    public abstract b m21mergeFrom(p pVar, y yVar);

    /* renamed from: mergeFrom */
    public abstract b m22mergeFrom(byte[] bArr, int i, int i2);

    /* renamed from: mergeFrom */
    public abstract b m23mergeFrom(byte[] bArr, int i, int i2, y yVar);

    public boolean mergeDelimitedFrom(InputStream inputStream) {
        return mergeDelimitedFrom(inputStream, y.a());
    }

    /* renamed from: mergeFrom, reason: merged with bridge method [inline-methods] */
    public b m11mergeFrom(p pVar) {
        return m21mergeFrom(pVar, y.a());
    }

    /* renamed from: mergeFrom, reason: merged with bridge method [inline-methods] */
    public b m9mergeFrom(l lVar) throws u0 {
        try {
            m mVarK = lVar.k();
            m11mergeFrom((p) mVarK);
            mVarK.a(0);
            return this;
        } catch (u0 e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException(a(), e2);
        }
    }

    /* renamed from: mergeFrom, reason: merged with bridge method [inline-methods] */
    public b m10mergeFrom(l lVar, y yVar) throws u0 {
        try {
            m mVarK = lVar.k();
            m21mergeFrom(mVarK, yVar);
            mVarK.a(0);
            return this;
        } catch (u0 e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException(a(), e2);
        }
    }

    /* renamed from: mergeFrom, reason: merged with bridge method [inline-methods] */
    public b m14mergeFrom(byte[] bArr) {
        return m22mergeFrom(bArr, 0, bArr.length);
    }

    /* renamed from: mergeFrom, reason: merged with bridge method [inline-methods] */
    public b m15mergeFrom(byte[] bArr, y yVar) {
        return m23mergeFrom(bArr, 0, bArr.length, yVar);
    }

    /* renamed from: mergeFrom, reason: merged with bridge method [inline-methods] */
    public b m12mergeFrom(InputStream inputStream) {
        p pVarG = p.g(inputStream);
        m11mergeFrom(pVarG);
        pVarG.a(0);
        return this;
    }

    /* renamed from: mergeFrom, reason: merged with bridge method [inline-methods] */
    public b m13mergeFrom(InputStream inputStream, y yVar) {
        p pVarG = p.g(inputStream);
        m21mergeFrom(pVarG, yVar);
        pVarG.a(0);
        return this;
    }

    @Deprecated
    public static <T> void addAll(Iterable<T> iterable, Collection<? super T> collection) {
        addAll((Iterable) iterable, (List) collection);
    }
}
