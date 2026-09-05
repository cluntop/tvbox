package com.github.catvod.spider.merge.p1;

import java.io.IOException;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* JADX WARN: $VALUES field not found */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class l3 {
    public static final e1 a = new e1();
    public static final p1 b = new p1();
    public static final a2 c = new a2();
    public static final l2 d = new l2();
    public static final w2 e = new w2();
    public static final h3 f = new h3();
    public static final i3 g = new i3();
    public static final j3 h = new j3();
    public static final k3 i = new k3();
    public static final u0 j = new u0();
    public static final v0 k = new v0();
    public static final w0 l = new w0();
    public static final x0 m = new x0();
    public static final y0 n = new y0();
    public static final z0 o = new z0();
    public static final a1 p = new a1();
    public static final b1 q = new b1();
    public static final c1 r = new c1();
    public static final d1 s = new d1();
    public static final f1 t = new f1();
    public static final g1 u = new g1();
    public static final h1 v = new h1();
    public static final i1 w = new i1();
    public static final j1 x = new j1();
    public static final k1 y = new k1();
    public static final l1 z = new l1();
    public static final m1 A = new m1();
    public static final n1 B = new n1();
    public static final o1 C = new o1();
    public static final q1 D = new q1();
    public static final r1 E = new r1();
    public static final s1 F = new s1();
    public static final t1 G = new t1();
    public static final u1 H = new u1();
    public static final v1 I = new v1();
    public static final w1 J = new w1();
    public static final x1 K = new x1();
    public static final y1 L = new y1();
    public static final z1 M = new z1();
    public static final b2 N = new b2();
    public static final c2 O = new c2();
    public static final d2 P = new d2();
    public static final e2 Q = new e2();
    public static final f2 R = new f2();
    public static final g2 S = new g2();
    public static final h2 T = new h2();
    public static final i2 U = new i2();
    public static final j2 V = new j2();
    public static final k2 W = new k2();
    public static final m2 X = new m2();
    public static final n2 Y = new n2();
    public static final o2 Z = new o2();
    public static final p2 a0 = new p2();
    public static final q2 b0 = new q2();
    public static final r2 c0 = new r2();
    public static final s2 d0 = new s2();
    public static final t2 e0 = new t2();
    public static final u2 f0 = new u2();
    public static final v2 g0 = new v2();
    public static final x2 h0 = new x2();
    public static final y2 i0 = new y2();
    public static final z2 j0 = new z2();
    public static final a3 k0 = new a3();
    public static final b3 l0 = new b3();
    public static final c3 m0 = new c3();
    public static final d3 n0 = new d3();
    public static final e3 o0 = new e3();
    public static final f3 p0 = new f3();
    public static final g3 q0 = new g3();
    public static final char[] r0 = {'\t', '\n', '\f', '\r', ' ', '\"', '\'', '/', '<', '=', '>', '?'};
    public static final char[] s0 = {0, '\t', '\n', '\f', '\r', ' ', '\"', '&', '\'', '<', '=', '>', '`'};
    public static final String t0 = String.valueOf((char) 65533);

    public static void a(t0 t0Var, a aVar, l3 l3Var, l3 l3Var2) throws IOException {
        char cJ = aVar.J();
        if (cJ == 0) {
            t0Var.m(l3Var);
            aVar.j();
            t0Var.f((char) 65533);
            return;
        }
        if (cJ == '<') {
            t0Var.a(l3Var2);
            return;
        }
        if (cJ == 65535) {
            t0Var.g(new m0());
            return;
        }
        aVar.z();
        int i2 = aVar.d;
        int i3 = aVar.e;
        char[] cArr = aVar.c;
        int i4 = i2;
        while (i4 < i3) {
            char c2 = cArr[i4];
            if (c2 == '<' || c2 == 0) {
                break;
            } else {
                i4++;
            }
        }
        aVar.d = i4;
        t0Var.h(i4 > i2 ? a.A(aVar.c, aVar.a, i2, i4 - i2) : VideoStream.RESOLUTION_UNKNOWN);
    }

    public static void b(t0 t0Var, a aVar, l3 l3Var) throws IOException {
        if (aVar.Q()) {
            String strE = aVar.E(new com.github.catvod.spider.merge.b0.a(18));
            t0Var.j.i(strE);
            t0Var.f.b(strE);
            return;
        }
        boolean zN = t0Var.n();
        com.github.catvod.spider.merge.g1.b bVar = t0Var.f;
        if (zN && !aVar.K()) {
            char cB = aVar.B();
            if (cB == '\t' || cB == '\n' || cB == '\f' || cB == '\r' || cB == ' ') {
                t0Var.o(H);
                return;
            }
            if (cB == '/') {
                t0Var.o(P);
                return;
            } else {
                if (cB == '>') {
                    t0Var.k();
                    t0Var.o(a);
                    return;
                }
                bVar.a(cB);
            }
        }
        t0Var.h("</");
        t0Var.h(bVar.j());
        t0Var.o(l3Var);
    }

    public static void c(t0 t0Var, a aVar, l3 l3Var, l3 l3Var2) throws IOException {
        if (aVar.Q()) {
            String strD = aVar.D();
            t0Var.f.b(strD);
            t0Var.h(strD);
            return;
        }
        char cB = aVar.B();
        if (cB != '\t' && cB != '\n' && cB != '\f' && cB != '\r' && cB != ' ' && cB != '/' && cB != '>') {
            aVar.W();
            t0Var.o(l3Var2);
        } else {
            if (t0Var.f.j().equals("script")) {
                t0Var.o(l3Var);
            } else {
                t0Var.o(l3Var2);
            }
            t0Var.f(cB);
        }
    }

    public abstract void d(t0 t0Var, a aVar);
}
