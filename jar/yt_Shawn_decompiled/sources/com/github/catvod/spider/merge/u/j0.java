package com.github.catvod.spider.merge.u;

import com.github.catvod.spider.jdollar.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Map;
import org.schabi.newpipe.extractor.utils.ManifestCreatorCache;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class j0 extends c {
    private static final int MEMOIZED_SERIALIZED_SIZE_MASK = Integer.MAX_VALUE;
    private static final int MUTABLE_FLAG_MASK = Integer.MIN_VALUE;
    static final int UNINITIALIZED_HASH_CODE = 0;
    static final int UNINITIALIZED_SERIALIZED_SIZE = Integer.MAX_VALUE;
    private static final Map<Class<?>, j0> defaultInstanceMap = new ConcurrentHashMap();
    private int memoizedSerializedSize;
    protected v1 unknownFields;

    public j0() {
        this.memoizedHashCode = 0;
        this.memoizedSerializedSize = -1;
        this.unknownFields = v1.f;
    }

    public static h0 access$100(w wVar) {
        wVar.getClass();
        return (h0) wVar;
    }

    public static void b(j0 j0Var) throws u0 {
        if (j0Var != null && !j0Var.isInitialized()) {
            throw new u0(j0Var.newUninitializedMessageException().getMessage());
        }
    }

    public static final boolean c(j0 j0Var, boolean z) {
        byte bByteValue = ((Byte) j0Var.dynamicMethod(i0.a, null, null)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        p1 p1Var = p1.c;
        p1Var.getClass();
        boolean zG = p1Var.a(j0Var.getClass()).g(j0Var);
        if (z) {
            j0Var.dynamicMethod(i0.b, zG ? j0Var : null, null);
        }
        return zG;
    }

    public static j0 d(j0 j0Var, InputStream inputStream, y yVar) throws IOException {
        try {
            int i = inputStream.read();
            if (i == -1) {
                return null;
            }
            p pVarG = p.g(new a(p.s(i, inputStream), inputStream));
            j0 partialFrom = parsePartialFrom(j0Var, pVarG, yVar);
            pVarG.a(0);
            return partialFrom;
        } catch (u0 e) {
            if (e.a) {
                throw new u0(e.getMessage(), e);
            }
            throw e;
        } catch (IOException e2) {
            throw new u0(e2.getMessage(), e2);
        }
    }

    public static j0 e(j0 j0Var, byte[] bArr, int i, int i2, y yVar) throws u0 {
        if (i2 == 0) {
            return j0Var;
        }
        j0 j0VarNewMutableInstance = j0Var.newMutableInstance();
        try {
            p1 p1Var = p1.c;
            p1Var.getClass();
            s1 s1VarA = p1Var.a(j0VarNewMutableInstance.getClass());
            s1VarA.f(j0VarNewMutableInstance, bArr, i, i + i2, new f(yVar));
            s1VarA.d(j0VarNewMutableInstance);
            return j0VarNewMutableInstance;
        } catch (u0 e) {
            if (e.a) {
                throw new u0(e.getMessage(), e);
            }
            throw e;
        } catch (u1 e2) {
            throw new u0(e2.getMessage());
        } catch (IOException e3) {
            if (e3.getCause() instanceof u0) {
                throw ((u0) e3.getCause());
            }
            throw new u0(e3.getMessage(), e3);
        } catch (IndexOutOfBoundsException unused) {
            throw u0.g();
        }
    }

    public static l0 emptyBooleanList() {
        return g.e;
    }

    public static m0 emptyDoubleList() {
        return v.e;
    }

    public static o0 emptyFloatList() {
        return c0.e;
    }

    public static p0 emptyIntList() {
        return k0.e;
    }

    public static q0 emptyLongList() {
        return y0.e;
    }

    public static <E> r0 emptyProtobufList() {
        return q1.e;
    }

    public static <T extends j0> T getDefaultInstance(Class<T> cls) throws ClassNotFoundException {
        Map<Class<?>, j0> map = defaultInstanceMap;
        T t = (T) map.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = (T) map.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (t != null) {
            return t;
        }
        T t2 = (T) ((j0) b2.b(cls)).getDefaultInstanceForType();
        if (t2 == null) {
            throw new IllegalStateException();
        }
        map.put(cls, t2);
        return t2;
    }

    public static Method getMethodOrDie(Class cls, String str, Class... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("Generated message class \"" + cls.getName() + "\" missing method \"" + str + "\".", e);
        }
    }

    public static Object invokeOrDie(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    public static p0 mutableCopy(p0 p0Var) {
        return ((k0) p0Var).j(((k0) p0Var).c * 2);
    }

    public static Object newMessageInfo(g1 g1Var, String str, Object[] objArr) {
        return new r1(g1Var, str, objArr);
    }

    public static <ContainingType extends g1, Type> h0 newRepeatedGeneratedExtension(ContainingType containingtype, g1 g1Var, n0 n0Var, int i, j2 j2Var, boolean z, Class<?> cls) {
        return new h0(containingtype, q1.e, g1Var, new g0(i, j2Var, true, z));
    }

    public static <ContainingType extends g1, Type> h0 newSingularGeneratedExtension(ContainingType containingtype, Type type, g1 g1Var, n0 n0Var, int i, j2 j2Var, Class<?> cls) {
        return new h0(containingtype, type, g1Var, new g0(i, j2Var, false, false));
    }

    public static <T extends j0> T parseDelimitedFrom(T t, InputStream inputStream) throws u0 {
        T t2 = (T) d(t, inputStream, y.a());
        b(t2);
        return t2;
    }

    public static <T extends j0> T parseFrom(T t, ByteBuffer byteBuffer, y yVar) throws u0 {
        m mVarF;
        if (byteBuffer.hasArray()) {
            mVarF = p.f(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), byteBuffer.remaining(), false);
        } else {
            int iRemaining = byteBuffer.remaining();
            byte[] bArr = new byte[iRemaining];
            byteBuffer.duplicate().get(bArr);
            mVarF = p.f(bArr, 0, iRemaining, true);
        }
        T t2 = (T) parseFrom(t, mVarF, yVar);
        b(t2);
        return t2;
    }

    public static <T extends j0> T parsePartialFrom(T t, p pVar, y yVar) throws u0 {
        T t2 = (T) t.newMutableInstance();
        try {
            p1 p1Var = p1.c;
            p1Var.getClass();
            s1 s1VarA = p1Var.a(t2.getClass());
            q qVar = pVar.b;
            if (qVar == null) {
                qVar = new q(pVar);
            }
            s1VarA.i(t2, qVar, yVar);
            s1VarA.d(t2);
            return t2;
        } catch (u0 e) {
            if (e.a) {
                throw new u0(e.getMessage(), e);
            }
            throw e;
        } catch (u1 e2) {
            throw new u0(e2.getMessage());
        } catch (IOException e3) {
            if (e3.getCause() instanceof u0) {
                throw ((u0) e3.getCause());
            }
            throw new u0(e3.getMessage(), e3);
        } catch (RuntimeException e4) {
            if (e4.getCause() instanceof u0) {
                throw ((u0) e4.getCause());
            }
            throw e4;
        }
    }

    public static <T extends j0> void registerDefaultInstance(Class<T> cls, T t) {
        t.markImmutable();
        defaultInstanceMap.put(cls, t);
    }

    public final Object buildMessageInfo() {
        return dynamicMethod(i0.c, null, null);
    }

    public final void clearMemoizedHashCode() {
        this.memoizedHashCode = 0;
    }

    public final void clearMemoizedSerializedSize() {
        setMemoizedSerializedSize(ManifestCreatorCache.DEFAULT_MAXIMUM_SIZE);
    }

    public final int computeHashCode() {
        p1 p1Var = p1.c;
        p1Var.getClass();
        return p1Var.a(getClass()).a(this);
    }

    public final <MessageType2 extends j0, BuilderType2 extends e0> BuilderType2 createBuilder() {
        return (BuilderType2) dynamicMethod(i0.e, null, null);
    }

    public abstract Object dynamicMethod(i0 i0Var, Object obj, Object obj2);

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        p1 p1Var = p1.c;
        p1Var.getClass();
        return p1Var.a(getClass()).c(this, (j0) obj);
    }

    @Override // com.github.catvod.spider.merge.u.h1
    public final j0 getDefaultInstanceForType() {
        return (j0) dynamicMethod(i0.f, null, null);
    }

    public final int getMemoizedHashCode() {
        return this.memoizedHashCode;
    }

    public final int getMemoizedSerializedSize() {
        return this.memoizedSerializedSize & ManifestCreatorCache.DEFAULT_MAXIMUM_SIZE;
    }

    public final n1 getParserForType() {
        return (n1) dynamicMethod(i0.g, null, null);
    }

    @Override // com.github.catvod.spider.merge.u.c
    public int getSerializedSize(s1 s1Var) {
        int iE;
        int iE2;
        if (isMutable()) {
            if (s1Var == null) {
                p1 p1Var = p1.c;
                p1Var.getClass();
                iE2 = p1Var.a(getClass()).e(this);
            } else {
                iE2 = s1Var.e(this);
            }
            if (iE2 >= 0) {
                return iE2;
            }
            com.github.catvod.spider.merge.s0.a.h(com.github.catvod.spider.merge.b.b.j(iE2, "serialized size must be non-negative, was "));
            return 0;
        }
        if (getMemoizedSerializedSize() != Integer.MAX_VALUE) {
            return getMemoizedSerializedSize();
        }
        if (s1Var == null) {
            p1 p1Var2 = p1.c;
            p1Var2.getClass();
            iE = p1Var2.a(getClass()).e(this);
        } else {
            iE = s1Var.e(this);
        }
        setMemoizedSerializedSize(iE);
        return iE;
    }

    public int hashCode() {
        if (isMutable()) {
            return computeHashCode();
        }
        if (hashCodeIsNotMemoized()) {
            setMemoizedHashCode(computeHashCode());
        }
        return getMemoizedHashCode();
    }

    public final boolean hashCodeIsNotMemoized() {
        return getMemoizedHashCode() == 0;
    }

    public final boolean isInitialized() {
        return c(this, true);
    }

    public final boolean isMutable() {
        return (this.memoizedSerializedSize & MUTABLE_FLAG_MASK) != 0;
    }

    public final void makeImmutable() {
        p1 p1Var = p1.c;
        p1Var.getClass();
        p1Var.a(getClass()).d(this);
        markImmutable();
    }

    public final void markImmutable() {
        this.memoizedSerializedSize &= ManifestCreatorCache.DEFAULT_MAXIMUM_SIZE;
    }

    public final void mergeLengthDelimitedField(int i, l lVar) {
        if (this.unknownFields == v1.f) {
            this.unknownFields = new v1();
        }
        v1 v1Var = this.unknownFields;
        v1Var.a();
        if (i != 0) {
            v1Var.f((i << 3) | 2, lVar);
        } else {
            com.github.catvod.spider.merge.s0.a.r("Zero is not a valid field number.");
        }
    }

    public final void mergeUnknownFields(v1 v1Var) {
        this.unknownFields = v1.e(this.unknownFields, v1Var);
    }

    public final void mergeVarintField(int i, int i2) {
        if (this.unknownFields == v1.f) {
            this.unknownFields = new v1();
        }
        v1 v1Var = this.unknownFields;
        v1Var.a();
        if (i != 0) {
            v1Var.f(i << 3, Long.valueOf(i2));
        } else {
            com.github.catvod.spider.merge.s0.a.r("Zero is not a valid field number.");
        }
    }

    @Override // com.github.catvod.spider.merge.u.g1
    public final e0 newBuilderForType() {
        return (e0) dynamicMethod(i0.e, null, null);
    }

    public final j0 newMutableInstance() {
        return (j0) dynamicMethod(i0.d, null, null);
    }

    public final boolean parseUnknownField(int i, p pVar) {
        if ((i & 7) == 4) {
            return false;
        }
        if (this.unknownFields == v1.f) {
            this.unknownFields = new v1();
        }
        return this.unknownFields.d(i, pVar);
    }

    public final void setMemoizedHashCode(int i) {
        this.memoizedHashCode = i;
    }

    public void setMemoizedSerializedSize(int i) {
        if (i < 0) {
            com.github.catvod.spider.merge.s0.a.h(com.github.catvod.spider.merge.b.b.j(i, "serialized size must be non-negative, was "));
        } else {
            this.memoizedSerializedSize = (i & ManifestCreatorCache.DEFAULT_MAXIMUM_SIZE) | (this.memoizedSerializedSize & MUTABLE_FLAG_MASK);
        }
    }

    /* renamed from: toBuilder, reason: merged with bridge method [inline-methods] */
    public final e0 m24toBuilder() {
        return ((e0) dynamicMethod(i0.e, null, null)).mergeFrom(this);
    }

    public String toString() {
        String string = super.toString();
        char[] cArr = i1.a;
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(string);
        i1.c(this, sb, 0);
        return sb.toString();
    }

    @Override // com.github.catvod.spider.merge.u.g1
    public void writeTo(u uVar) {
        p1 p1Var = p1.c;
        p1Var.getClass();
        s1 s1VarA = p1Var.a(getClass());
        a1 a1Var = uVar.a;
        if (a1Var == null) {
            a1Var = new a1(uVar);
        }
        s1VarA.h(this, a1Var);
    }

    public final <MessageType2 extends j0, BuilderType2 extends e0> BuilderType2 createBuilder(MessageType2 messagetype2) {
        return (BuilderType2) createBuilder().mergeFrom((j0) messagetype2);
    }

    public static <T extends j0> T parseDelimitedFrom(T t, InputStream inputStream, y yVar) throws u0 {
        T t2 = (T) d(t, inputStream, yVar);
        b(t2);
        return t2;
    }

    public static q0 mutableCopy(q0 q0Var) {
        return ((y0) q0Var).j(((y0) q0Var).c * 2);
    }

    public static o0 mutableCopy(o0 o0Var) {
        return ((c0) o0Var).j(((c0) o0Var).c * 2);
    }

    public static m0 mutableCopy(m0 m0Var) {
        return ((v) m0Var).j(((v) m0Var).c * 2);
    }

    public static l0 mutableCopy(l0 l0Var) {
        return ((g) l0Var).j(((g) l0Var).c * 2);
    }

    public static <E> r0 mutableCopy(r0 r0Var) {
        return r0Var.j(r0Var.size() * 2);
    }

    public static <T extends j0> T parseFrom(T t, ByteBuffer byteBuffer) {
        return (T) parseFrom(t, byteBuffer, y.a());
    }

    public static <T extends j0> T parseFrom(T t, l lVar) throws u0 {
        T t2 = (T) parseFrom(t, lVar, y.a());
        b(t2);
        return t2;
    }

    public static <T extends j0> T parseFrom(T t, l lVar, y yVar) throws u0 {
        m mVarK = lVar.k();
        T t2 = (T) parsePartialFrom(t, mVarK, yVar);
        mVarK.a(0);
        b(t2);
        return t2;
    }

    public static <T extends j0> T parseFrom(T t, byte[] bArr) throws u0 {
        T t2 = (T) e(t, bArr, 0, bArr.length, y.a());
        b(t2);
        return t2;
    }

    public static <T extends j0> T parseFrom(T t, byte[] bArr, y yVar) throws u0 {
        T t2 = (T) e(t, bArr, 0, bArr.length, yVar);
        b(t2);
        return t2;
    }

    public static <T extends j0> T parseFrom(T t, InputStream inputStream) throws u0 {
        T t2 = (T) parsePartialFrom(t, p.g(inputStream), y.a());
        b(t2);
        return t2;
    }

    public static <T extends j0> T parseFrom(T t, InputStream inputStream, y yVar) throws u0 {
        T t2 = (T) parsePartialFrom(t, p.g(inputStream), yVar);
        b(t2);
        return t2;
    }

    public static <T extends j0> T parseFrom(T t, p pVar) {
        return (T) parseFrom(t, pVar, y.a());
    }

    public static <T extends j0> T parseFrom(T t, p pVar, y yVar) throws u0 {
        T t2 = (T) parsePartialFrom(t, pVar, yVar);
        b(t2);
        return t2;
    }

    @Override // com.github.catvod.spider.merge.u.g1
    public int getSerializedSize() {
        return getSerializedSize(null);
    }

    public static <T extends j0> T parsePartialFrom(T t, p pVar) {
        return (T) parsePartialFrom(t, pVar, y.a());
    }
}
