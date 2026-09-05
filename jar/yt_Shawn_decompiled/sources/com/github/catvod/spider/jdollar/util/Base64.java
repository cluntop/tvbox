package com.github.catvod.spider.jdollar.util;

import java.util.Arrays;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class Base64 {

    /* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
    public static class Decoder {
        public static final int[] a;
        public static final int[] b;
        public static final Decoder c;

        static {
            int[] iArr = new int[256];
            a = iArr;
            Arrays.fill(iArr, -1);
            for (int i = 0; i < 64; i++) {
                a[Encoder.a[i]] = i;
            }
            a[61] = -2;
            int[] iArr2 = new int[256];
            b = iArr2;
            Arrays.fill(iArr2, -1);
            for (int i2 = 0; i2 < 64; i2++) {
                b[Encoder.b[i2]] = i2;
            }
            b[61] = -2;
            c = new Decoder();
        }

        /* JADX WARN: Code restructure failed: missing block: B:46:0x00c5, code lost:
        
            if (r10 != 18) goto L58;
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x0110, code lost:
        
            if (r10 != 6) goto L60;
         */
        /* JADX WARN: Code restructure failed: missing block: B:59:0x0112, code lost:
        
            r6[r11] = (byte) (r12 >> 16);
            r11 = r11 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x011d, code lost:
        
            if (r10 != 0) goto L62;
         */
        /* JADX WARN: Code restructure failed: missing block: B:61:0x011f, code lost:
        
            r0 = r11 + 1;
            r6[r11] = (byte) (r12 >> 16);
            r11 = r11 + 2;
            r6[r0] = (byte) (r12 >> 8);
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x0130, code lost:
        
            if (r10 == 12) goto L71;
         */
        /* JADX WARN: Code restructure failed: missing block: B:64:0x0132, code lost:
        
            if (r9 < r7) goto L69;
         */
        /* JADX WARN: Code restructure failed: missing block: B:65:0x0134, code lost:
        
            if (r11 == r1) goto L68;
         */
        /* JADX WARN: Code restructure failed: missing block: B:67:0x013a, code lost:
        
            return java.util.Arrays.copyOf(r6, r11);
         */
        /* JADX WARN: Code restructure failed: missing block: B:68:0x013b, code lost:
        
            return r6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:69:0x013c, code lost:
        
            com.github.catvod.spider.jdollar.nio.file.b.n("Input byte array has incorrect ending byte at ", r9);
         */
        /* JADX WARN: Code restructure failed: missing block: B:70:0x0141, code lost:
        
            return r21;
         */
        /* JADX WARN: Code restructure failed: missing block: B:71:0x0142, code lost:
        
            com.github.catvod.spider.jdollar.nio.file.b.c("Last unit does not have enough valid bits");
         */
        /* JADX WARN: Code restructure failed: missing block: B:72:0x0147, code lost:
        
            return r21;
         */
        /* JADX WARN: Removed duplicated region for block: B:52:0x00e8  */
        /* JADX WARN: Removed duplicated region for block: B:76:0x00b3 A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public byte[] decode(java.lang.String r21) {
            /*
                Method dump skipped, instructions count: 336
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.github.catvod.spider.jdollar.util.Base64.Decoder.decode(java.lang.String):byte[]");
        }
    }

    /* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
    public static class Encoder {
        public static final char[] a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
        public static final char[] b = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '-', '_'};
        public static final Encoder c = new Encoder();

        public String encodeToString(byte[] bArr) {
            int length = ((bArr.length + 2) / 3) * 4;
            byte[] bArrCopyOf = new byte[length];
            int length2 = bArr.length;
            int i = (length2 / 3) * 3;
            int i2 = 0;
            int i3 = 0;
            while (true) {
                char[] cArr = b;
                if (i2 >= i) {
                    if (i2 < length2) {
                        int i4 = i2 + 1;
                        int i5 = bArr[i2] & 255;
                        int i6 = i3 + 1;
                        bArrCopyOf[i3] = (byte) cArr[i5 >> 2];
                        if (i4 == length2) {
                            bArrCopyOf[i6] = (byte) cArr[(i5 << 4) & 63];
                            int i7 = i3 + 3;
                            bArrCopyOf[i3 + 2] = 61;
                            i3 += 4;
                            bArrCopyOf[i7] = 61;
                        } else {
                            int i8 = bArr[i4] & 255;
                            bArrCopyOf[i6] = (byte) cArr[((i5 << 4) & 63) | (i8 >> 4)];
                            int i9 = i3 + 3;
                            bArrCopyOf[i3 + 2] = (byte) cArr[(i8 << 2) & 63];
                            i3 += 4;
                            bArrCopyOf[i9] = 61;
                        }
                    }
                    if (i3 != length) {
                        bArrCopyOf = Arrays.copyOf(bArrCopyOf, i3);
                    }
                    return new String(bArrCopyOf, 0, 0, bArrCopyOf.length);
                }
                int iMin = Math.min(i2 + i, i);
                int i10 = i2;
                int i11 = i3;
                while (i10 < iMin) {
                    int i12 = i10 + 2;
                    int i13 = ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10] & 255) << 16);
                    i10 += 3;
                    int i14 = i13 | (bArr[i12] & 255);
                    bArrCopyOf[i11] = (byte) cArr[(i14 >>> 18) & 63];
                    bArrCopyOf[i11 + 1] = (byte) cArr[(i14 >>> 12) & 63];
                    int i15 = i11 + 3;
                    bArrCopyOf[i11 + 2] = (byte) cArr[(i14 >>> 6) & 63];
                    i11 += 4;
                    bArrCopyOf[i15] = (byte) cArr[i14 & 63];
                }
                int i16 = ((iMin - i2) / 3) * 4;
                i3 += i16;
                if (i16 == -1 && iMin < length2) {
                    throw null;
                }
                i2 = iMin;
            }
        }
    }

    public static Decoder getUrlDecoder() {
        return Decoder.c;
    }

    public static Encoder getUrlEncoder() {
        return Encoder.c;
    }
}
