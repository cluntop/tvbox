package com.github.catvod.spider.merge.z0;

import com.github.catvod.spider.merge.y0.l0;
import java.io.IOException;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class n implements Function2 {
    public final /* synthetic */ int a = 0;
    public final /* synthetic */ Ref.ObjectRef b;
    public final /* synthetic */ l0 c;
    public final /* synthetic */ Ref.ObjectRef d;
    public final /* synthetic */ Ref.ObjectRef e;

    public /* synthetic */ n(l0 l0Var, Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2, Ref.ObjectRef objectRef3) {
        this.c = l0Var;
        this.b = objectRef;
        this.d = objectRef2;
        this.e = objectRef3;
    }

    public final Object invoke(Object obj, Object obj2) throws IOException {
        int i = this.a;
        Ref.ObjectRef objectRef = this.e;
        Ref.ObjectRef objectRef2 = this.d;
        l0 l0Var = this.c;
        Ref.ObjectRef objectRef3 = this.b;
        switch (i) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                int iIntValue = ((Integer) obj).intValue();
                long jLongValue = ((Long) obj2).longValue();
                if (iIntValue == 21589) {
                    if (jLongValue < 1) {
                        com.github.catvod.spider.merge.s0.a.w("bad zip: extended timestamp extra too short");
                        break;
                    } else {
                        byte b = l0Var.readByte();
                        boolean z = (b & 1) == 1;
                        boolean z2 = (b & 2) == 2;
                        boolean z3 = (b & 4) == 4;
                        long j = z ? 5L : 1L;
                        if (z2) {
                            j += 4;
                        }
                        if (z3) {
                            j += 4;
                        }
                        if (jLongValue < j) {
                            com.github.catvod.spider.merge.s0.a.w("bad zip: extended timestamp extra too short");
                            break;
                        } else {
                            if (z) {
                                objectRef3.element = Integer.valueOf(l0Var.z());
                            }
                            if (z2) {
                                objectRef2.element = Integer.valueOf(l0Var.z());
                            }
                            if (z3) {
                                objectRef.element = Integer.valueOf(l0Var.z());
                            }
                        }
                    }
                }
                break;
            default:
                int iIntValue2 = ((Integer) obj).intValue();
                long jLongValue2 = ((Long) obj2).longValue();
                if (iIntValue2 == 1) {
                    if (objectRef3.element != null) {
                        com.github.catvod.spider.merge.s0.a.w("bad zip: NTFS extra attribute tag 0x0001 repeated");
                        break;
                    } else if (jLongValue2 != 24) {
                        com.github.catvod.spider.merge.s0.a.w("bad zip: NTFS extra attribute tag 0x0001 size != 24");
                        break;
                    } else {
                        objectRef3.element = Long.valueOf(l0Var.A());
                        objectRef2.element = Long.valueOf(l0Var.A());
                        objectRef.element = Long.valueOf(l0Var.A());
                    }
                }
                break;
        }
        return Unit.INSTANCE;
    }

    public /* synthetic */ n(Ref.ObjectRef objectRef, l0 l0Var, Ref.ObjectRef objectRef2, Ref.ObjectRef objectRef3) {
        this.b = objectRef;
        this.c = l0Var;
        this.d = objectRef2;
        this.e = objectRef3;
    }
}
