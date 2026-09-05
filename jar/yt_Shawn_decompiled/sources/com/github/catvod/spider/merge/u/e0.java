package com.github.catvod.spider.merge.u;

import java.io.IOException;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class e0 extends b {
    private final j0 defaultInstance;
    protected j0 instance;

    public e0(j0 j0Var) {
        this.defaultInstance = j0Var;
        if (j0Var.isMutable()) {
            com.github.catvod.spider.merge.s0.a.r("Default instance must be immutable.");
            throw null;
        }
        this.instance = j0Var.newMutableInstance();
    }

    public final j0 build() {
        j0 j0VarBuildPartial = buildPartial();
        if (j0VarBuildPartial.isInitialized()) {
            return j0VarBuildPartial;
        }
        throw b.newUninitializedMessageException(j0VarBuildPartial);
    }

    @Override // com.github.catvod.spider.merge.u.f1
    public j0 buildPartial() {
        boolean zIsMutable = this.instance.isMutable();
        j0 j0Var = this.instance;
        if (!zIsMutable) {
            return j0Var;
        }
        j0Var.makeImmutable();
        return this.instance;
    }

    /* renamed from: clear, reason: merged with bridge method [inline-methods] */
    public final e0 m17clear() {
        if (this.defaultInstance.isMutable()) {
            com.github.catvod.spider.merge.s0.a.r("Default instance must be immutable.");
            return null;
        }
        this.instance = this.defaultInstance.newMutableInstance();
        return this;
    }

    /* renamed from: clone, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public e0 m20clone() {
        e0 e0VarNewBuilderForType = getDefaultInstanceForType().newBuilderForType();
        e0VarNewBuilderForType.instance = buildPartial();
        return e0VarNewBuilderForType;
    }

    public final void copyOnWrite() {
        if (this.instance.isMutable()) {
            return;
        }
        copyOnWriteInternal();
    }

    public void copyOnWriteInternal() {
        j0 j0VarNewMutableInstance = this.defaultInstance.newMutableInstance();
        j0 j0Var = this.instance;
        p1 p1Var = p1.c;
        p1Var.getClass();
        p1Var.a(j0VarNewMutableInstance.getClass()).b(j0VarNewMutableInstance, j0Var);
        this.instance = j0VarNewMutableInstance;
    }

    public final boolean isInitialized() {
        return j0.c(this.instance, false);
    }

    @Override // com.github.catvod.spider.merge.u.b
    /* renamed from: mergeFrom, reason: merged with bridge method [inline-methods] */
    public e0 m23mergeFrom(byte[] bArr, int i, int i2, y yVar) throws u0 {
        copyOnWrite();
        try {
            p1 p1Var = p1.c;
            j0 j0Var = this.instance;
            p1Var.getClass();
            p1Var.a(j0Var.getClass()).f(this.instance, bArr, i, i + i2, new f(yVar));
            return this;
        } catch (u0 e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException("Reading from byte array should not throw IOException.", e2);
        } catch (IndexOutOfBoundsException unused) {
            throw u0.g();
        }
    }

    @Override // com.github.catvod.spider.merge.u.h1
    public j0 getDefaultInstanceForType() {
        return this.defaultInstance;
    }

    @Override // com.github.catvod.spider.merge.u.b
    public e0 internalMergeFrom(j0 j0Var) {
        return mergeFrom(j0Var);
    }

    public e0 mergeFrom(j0 j0Var) {
        if (getDefaultInstanceForType().equals(j0Var)) {
            return this;
        }
        copyOnWrite();
        j0 j0Var2 = this.instance;
        p1 p1Var = p1.c;
        p1Var.getClass();
        p1Var.a(j0Var2.getClass()).b(j0Var2, j0Var);
        return this;
    }

    @Override // com.github.catvod.spider.merge.u.b
    /* renamed from: mergeFrom, reason: merged with bridge method [inline-methods] */
    public e0 m22mergeFrom(byte[] bArr, int i, int i2) {
        return m23mergeFrom(bArr, i, i2, y.a());
    }

    @Override // com.github.catvod.spider.merge.u.b
    /* renamed from: mergeFrom, reason: merged with bridge method [inline-methods] */
    public e0 m21mergeFrom(p pVar, y yVar) throws IOException {
        copyOnWrite();
        try {
            p1 p1Var = p1.c;
            j0 j0Var = this.instance;
            p1Var.getClass();
            s1 s1VarA = p1Var.a(j0Var.getClass());
            j0 j0Var2 = this.instance;
            q qVar = pVar.b;
            if (qVar == null) {
                qVar = new q(pVar);
            }
            s1VarA.i(j0Var2, qVar, yVar);
            return this;
        } catch (RuntimeException e) {
            if (e.getCause() instanceof IOException) {
                throw ((IOException) e.getCause());
            }
            throw e;
        }
    }
}
