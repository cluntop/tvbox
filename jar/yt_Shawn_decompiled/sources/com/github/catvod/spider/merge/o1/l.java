package com.github.catvod.spider.merge.o1;

import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.ObjectConstructor;
import java.lang.reflect.Constructor;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.internal._UtilJvmKt;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class l implements com.github.catvod.spider.merge.q1.u, ObjectConstructor, EventListener.Factory {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ l(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // com.github.catvod.spider.merge.q1.u
    public /* synthetic */ void a(s sVar, int i) {
    }

    @Override // com.github.catvod.spider.merge.q1.u
    public void b(s sVar, int i) {
        StringBuilder sb = (StringBuilder) this.b;
        if (sVar instanceof f) {
            sb.append(((f) sVar).D());
        } else if (sVar instanceof e) {
            sb.append(((e) sVar).D());
        } else if (sVar instanceof d) {
            sb.append(((d) sVar).D());
        }
    }

    public Object construct() {
        switch (this.a) {
            case 1:
                return ConstructorConstructor.e((Constructor) this.b);
            default:
                return ConstructorConstructor.a((Class) this.b);
        }
    }

    public EventListener create(Call call) {
        return _UtilJvmKt.b((EventListener) this.b, call);
    }
}
