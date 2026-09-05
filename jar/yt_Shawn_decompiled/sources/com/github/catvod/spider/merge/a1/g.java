package com.github.catvod.spider.merge.a1;

import com.github.catvod.spider.jdollar.util.DesugarCollections;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public abstract class g {
    public static final Map a;
    public static final AtomicReference b;

    static {
        Logger.getLogger(g.class.getName());
        new e("globalConfig");
        new e("threadLocalConfig");
        new e("defaultRandomConfig");
        new e("constraints");
        ThreadLocal threadLocal = new ThreadLocal();
        Map mapSynchronizedMap = DesugarCollections.synchronizedMap(new HashMap());
        a = mapSynchronizedMap;
        new ThreadLocal();
        f fVar = new f();
        new AtomicReference();
        AtomicReference atomicReference = new AtomicReference();
        b = atomicReference;
        com.github.catvod.spider.merge.h1.d dVar = new com.github.catvod.spider.merge.h1.d(new BigInteger("fca682ce8e12caba26efccf7110e526db078b05edecbcd1eb4a208f3ae1617ae01f35b91a47e6df63413c5e12ed0899bcd132acd50d99151bdc43ee737592e17", 16), new BigInteger("962eddcc369cba8ebb260ee6b6a126d9346e38c5", 16), new BigInteger("678471b27a9cf44ee91a49c5147db1a9aaf244f05a434d6486931d2d14271b9e35030b71fd73da179069b32e2935630e1c2062354d0da20a6c416e50be794ca4", 16), new com.github.catvod.spider.merge.h1.e(com.github.catvod.spider.merge.k1.b.a("b869c82b35d70e1b1ff91b28e37a62ecdc34409b"), 123));
        com.github.catvod.spider.merge.h1.d dVar2 = new com.github.catvod.spider.merge.h1.d(new BigInteger("e9e642599d355f37c97ffd3567120b8e25c9cd43e927b3a9670fbec5d890141922d2c3b3ad2480093799869d1e846aab49fab0ad26d2ce6a22219d470bce7d777d4a21fbe9c270b57f607002f3cef8393694cf45ee3688c11a8c56ab127a3daf", 16), new BigInteger("9cdbd84c9f1ac2f38d0f80f42ab952e7338bf511", 16), new BigInteger("30470ad5a005fb14ce2d9dcd87e38bc7d1b1c5facbaecbe95f190aa7a31d23c4dbbcbe06174544401a5b2c020965d8c2bd2171d3668445771f74ba084d2029d83c1c158547f3a9f1a2715be23d51ae4d3e5a1f6a7064f316933a346d3f529252", 16), new com.github.catvod.spider.merge.h1.e(com.github.catvod.spider.merge.k1.b.a("77d0f8c4dad15eb8c4f2f8d6726cefd96d5bb399"), 263));
        com.github.catvod.spider.merge.h1.d dVar3 = new com.github.catvod.spider.merge.h1.d(new BigInteger("fd7f53811d75122952df4a9c2eece4e7f611b7523cef4400c31e3f80b6512669455d402251fb593d8d58fabfc5f5ba30f6cb9b556cd7813b801d346ff26660b76b9950a5a49f9fe8047b1022c24fbba9d7feb7c61bf83b57e7c6a8a6150f04fb83f6d3c51ec3023554135a169132f675f3ae2b61d72aeff22203199dd14801c7", 16), new BigInteger("9760508f15230bccb292b982a2eb840bf0581cf5", 16), new BigInteger("f7e1a085d69b3ddecbbcab5c36b857b97994afbbfa3aea82f9574c0b3d0782675159578ebad4594fe67107108180b449167123e84c281613b7cf09328cc8a6e13c167a8b547c8d28e0a3ae1e2bb3a675916ea37f0bfa213562f1fb627a01243bcca4f1bea8519089a883dfe15ae59f06928b665e807b552564014c3bfecf492a", 16), new com.github.catvod.spider.merge.h1.e(com.github.catvod.spider.merge.k1.b.a("8d5155894229d5e689ee01e6018a237e2cae64cd"), 92));
        com.github.catvod.spider.merge.h1.d dVar4 = new com.github.catvod.spider.merge.h1.d(new BigInteger("95475cf5d93e596c3fcd1d902add02f427f5f3c7210313bb45fb4d5bb2e5fe1cbd678cd4bbdd84c9836be1f31c0777725aeb6c2fc38b85f48076fa76bcd8146cc89a6fb2f706dd719898c2083dc8d896f84062e2c9c94d137b054a8d8096adb8d51952398eeca852a0af12df83e475aa65d4ec0c38a9560d5661186ff98b9fc9eb60eee8b030376b236bc73be3acdbd74fd61c1d2475fa3077b8f080467881ff7e1ca56fee066d79506ade51edbb5443a563927dbc4ba520086746175c8885925ebc64c6147906773496990cb714ec667304e261faee33b3cbdf008e0c3fa90650d97d3909c9275bf4ac86ffcb3d03e6dfc8ada5934242dd6d3bcca2a406cb0b", 16), new BigInteger("f8183668ba5fc5bb06b5981e6d8b795d30b8978d43ca0ec572e37e09939a9773", 16), new BigInteger("42debb9da5b3d88cc956e08787ec3f3a09bba5f48b889a74aaf53174aa0fbe7e3c5b8fcd7a53bef563b0e98560328960a9517f4014d3325fc7962bf1e049370d76d1314a76137e792f3f0db859d095e4a5b932024f079ecf2ef09c797452b0770e1350782ed57ddf794979dcef23cb96f183061965c4ebc93c9c71c56b925955a75f94cccf1449ac43d586d0beee43251b0b2287349d68de0d144403f13e802f4146d882e057af19b6f6275c6676c8fa0e3ca2713a3257fd1b27d0639f695e347d8d1cf9ac819a26ca9b04cb0eb9b7b035988d15bbac65212a55239cfc7e58fae38d7250ab9991ffbc97134025fe8ce04c4399ad96569be91a546f4978693c7a", 16), new com.github.catvod.spider.merge.h1.e(com.github.catvod.spider.merge.k1.b.a("b0b4417601b59cbc9d8ac8f935cadaec4f5fbb2f23785609ae466748d9b5a536"), 497));
        com.github.catvod.spider.merge.h1.d[] dVarArr = {dVar, dVar2, dVar3, dVar4};
        if (!com.github.catvod.spider.merge.h1.d.class.isAssignableFrom(dVarArr[0].getClass())) {
            com.github.catvod.spider.merge.s0.a.r("Bad property value passed");
            return;
        }
        Map map = (Map) threadLocal.get();
        if (map == null) {
            map = new HashMap();
            threadLocal.set(map);
        }
        map.put("dsaDefaultParams", dVarArr);
        mapSynchronizedMap.put("dsaDefaultParams", dVarArr);
        com.github.catvod.spider.merge.h1.c[] cVarArr = {b(dVar), b(dVar2), b(dVar3), b(dVar4)};
        if (!com.github.catvod.spider.merge.h1.c.class.isAssignableFrom(cVarArr[0].getClass())) {
            com.github.catvod.spider.merge.s0.a.r("Bad property value passed");
            return;
        }
        Map map2 = (Map) threadLocal.get();
        if (map2 == null) {
            map2 = new HashMap();
            threadLocal.set(map2);
        }
        map2.put("dhDefaultParams", cVarArr);
        mapSynchronizedMap.put("dhDefaultParams", cVarArr);
        atomicReference.set(fVar);
        atomicReference.get();
    }

    public static void a() {
        ((f) b.get()).getClass();
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x00bb, code lost:
    
        if (r2.charAt(3) == 'E') goto L50;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.github.catvod.spider.merge.h1.c b(com.github.catvod.spider.merge.h1.d r8) {
        /*
            java.math.BigInteger r0 = r8.c
            com.github.catvod.spider.merge.h1.e r1 = r8.d
            int r2 = r0.bitLength()
            r3 = 1024(0x400, float:1.435E-42)
            if (r2 <= r3) goto L24
            r3 = 2048(0x800, float:2.87E-42)
            if (r2 > r3) goto L13
            r2 = 224(0xe0, float:3.14E-43)
            goto L26
        L13:
            r3 = 3072(0xc00, float:4.305E-42)
            if (r2 > r3) goto L1a
            r2 = 256(0x100, float:3.59E-43)
            goto L26
        L1a:
            r3 = 7680(0x1e00, float:1.0762E-41)
            if (r2 > r3) goto L21
            r2 = 384(0x180, float:5.38E-43)
            goto L26
        L21:
            r2 = 512(0x200, float:7.17E-43)
            goto L26
        L24:
            r2 = 160(0xa0, float:2.24E-43)
        L26:
            com.github.catvod.spider.merge.h1.c r3 = new com.github.catvod.spider.merge.h1.c
            java.math.BigInteger r4 = r8.a
            java.math.BigInteger r8 = r8.b
            byte[] r1 = r1.a
            byte[] r1 = com.github.catvod.spider.merge.u.c2.i(r1)
            com.github.catvod.spider.merge.u.c2.i(r1)
            r3.<init>()
            int r1 = r0.bitLength()
            if (r2 <= r1) goto Lc5
            java.lang.String r1 = "org.bouncycastle.dh.allow_unsafe_p_value"
            java.lang.ThreadLocal r2 = com.github.catvod.spider.merge.j1.c.a
            com.github.catvod.spider.merge.j1.b r2 = new com.github.catvod.spider.merge.j1.b     // Catch: java.security.AccessControlException -> Lbe
            r5 = 0
            r2.<init>(r5)     // Catch: java.security.AccessControlException -> Lbe
            java.lang.Object r2 = java.security.AccessController.doPrivileged(r2)     // Catch: java.security.AccessControlException -> Lbe
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.security.AccessControlException -> Lbe
            r6 = 1
            if (r2 == 0) goto L52
            goto L72
        L52:
            java.lang.ThreadLocal r2 = com.github.catvod.spider.merge.j1.c.a     // Catch: java.security.AccessControlException -> Lbe
            java.lang.Object r2 = r2.get()     // Catch: java.security.AccessControlException -> Lbe
            java.util.Map r2 = (java.util.Map) r2     // Catch: java.security.AccessControlException -> Lbe
            if (r2 == 0) goto L66
            java.lang.Object r1 = r2.get(r1)     // Catch: java.security.AccessControlException -> Lbe
            r2 = r1
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.security.AccessControlException -> Lbe
            if (r2 == 0) goto L66
            goto L72
        L66:
            com.github.catvod.spider.merge.j1.b r1 = new com.github.catvod.spider.merge.j1.b     // Catch: java.security.AccessControlException -> Lbe
            r1.<init>(r6)     // Catch: java.security.AccessControlException -> Lbe
            java.lang.Object r1 = java.security.AccessController.doPrivileged(r1)     // Catch: java.security.AccessControlException -> Lbe
            r2 = r1
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.security.AccessControlException -> Lbe
        L72:
            if (r2 == 0) goto Lbe
            int r1 = r2.length()     // Catch: java.security.AccessControlException -> Lbe
            r7 = 4
            if (r1 != r7) goto Lbe
            char r1 = r2.charAt(r5)     // Catch: java.security.AccessControlException -> Lbe
            r7 = 116(0x74, float:1.63E-43)
            if (r1 == r7) goto L8b
            char r1 = r2.charAt(r5)     // Catch: java.security.AccessControlException -> Lbe
            r5 = 84
            if (r1 != r5) goto Lbe
        L8b:
            char r1 = r2.charAt(r6)     // Catch: java.security.AccessControlException -> Lbe
            r5 = 114(0x72, float:1.6E-43)
            if (r1 == r5) goto L9b
            char r1 = r2.charAt(r6)     // Catch: java.security.AccessControlException -> Lbe
            r5 = 82
            if (r1 != r5) goto Lbe
        L9b:
            r1 = 2
            char r5 = r2.charAt(r1)     // Catch: java.security.AccessControlException -> Lbe
            r6 = 117(0x75, float:1.64E-43)
            if (r5 == r6) goto Lac
            char r1 = r2.charAt(r1)     // Catch: java.security.AccessControlException -> Lbe
            r5 = 85
            if (r1 != r5) goto Lbe
        Lac:
            r1 = 3
            char r5 = r2.charAt(r1)     // Catch: java.security.AccessControlException -> Lbe
            r6 = 101(0x65, float:1.42E-43)
            if (r5 == r6) goto Lc5
            char r1 = r2.charAt(r1)     // Catch: java.security.AccessControlException -> Lbe
            r2 = 69
            if (r1 != r2) goto Lbe
            goto Lc5
        Lbe:
            java.lang.String r8 = "unsafe p value so small specific l required"
            com.github.catvod.spider.merge.s0.a.r(r8)
            r8 = 0
            return r8
        Lc5:
            r3.a = r4
            r3.b = r0
            r3.c = r8
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.catvod.spider.merge.a1.g.b(com.github.catvod.spider.merge.h1.d):com.github.catvod.spider.merge.h1.c");
    }
}
