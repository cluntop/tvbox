package org.schabi.newpipe.extractor.utils;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class ExtractorLogger {
    private static final Logger EMPTY_LOGGER;
    private static volatile Logger logger;

    /* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
    /* renamed from: org.schabi.newpipe.extractor.utils.ExtractorLogger$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$schabi$newpipe$extractor$utils$ExtractorLogger$Level;

        static {
            int[] iArr = new int[Level.values().length];
            $SwitchMap$org$schabi$newpipe$extractor$utils$ExtractorLogger$Level = iArr;
            try {
                iArr[Level.DEBUG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$schabi$newpipe$extractor$utils$ExtractorLogger$Level[Level.WARN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$schabi$newpipe$extractor$utils$ExtractorLogger$Level[Level.ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
    final class EmptyLogger implements Logger {
        public /* synthetic */ EmptyLogger(int i) {
            this();
        }

        @Override // org.schabi.newpipe.extractor.utils.Logger
        public void debug(String str, String str2) {
        }

        @Override // org.schabi.newpipe.extractor.utils.Logger
        public void error(String str, String str2) {
        }

        @Override // org.schabi.newpipe.extractor.utils.Logger
        public void warn(String str, String str2) {
        }

        @Override // org.schabi.newpipe.extractor.utils.Logger
        public void debug(String str, String str2, Throwable th) {
        }

        @Override // org.schabi.newpipe.extractor.utils.Logger
        public void error(String str, String str2, Throwable th) {
        }

        @Override // org.schabi.newpipe.extractor.utils.Logger
        public void warn(String str, String str2, Throwable th) {
        }

        private EmptyLogger() {
        }
    }

    /* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
    public enum Level {
        DEBUG,
        WARN,
        ERROR
    }

    static {
        EmptyLogger emptyLogger = new EmptyLogger(0);
        EMPTY_LOGGER = emptyLogger;
        logger = emptyLogger;
    }

    private ExtractorLogger() {
    }

    public static void d(String str, String str2) {
        log(Level.DEBUG, str, str2, null);
    }

    public static void e(String str, String str2) {
        log(Level.ERROR, str, str2, null);
    }

    private static String format(String str, Object... objArr) {
        int i;
        int i2;
        if (str == null || objArr == null || objArr.length == 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder(Math.min(32, objArr.length * 16) + str.length());
        int length = str.length();
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i3 >= length) {
                break;
            }
            char cCharAt = str.charAt(i3);
            if (cCharAt == '{' && (i2 = i3 + 1) < length && str.charAt(i2) == '{') {
                sb.append('{');
            } else if (cCharAt == '}' && (i = i3 + 1) < length && str.charAt(i) == '}') {
                sb.append('}');
            } else if (cCharAt == '{') {
                int iIndexOf = str.indexOf(125, i3 + 1);
                if (iIndexOf < 0) {
                    sb.append((CharSequence) str, i3, length);
                    break;
                }
                if (i4 < objArr.length) {
                    sb.append(objArr[i4]);
                    i4++;
                } else {
                    sb.append((CharSequence) str, i3, iIndexOf + 1);
                }
                i3 = iIndexOf + 1;
            } else {
                sb.append(cCharAt);
                i3++;
            }
            i3 += 2;
        }
        return sb.toString();
    }

    private static void log(Level level, String str, String str2, Throwable th) {
        if (logger == EMPTY_LOGGER) {
            return;
        }
        int i = AnonymousClass1.$SwitchMap$org$schabi$newpipe$extractor$utils$ExtractorLogger$Level[level.ordinal()];
        if (i == 1) {
            if (th == null) {
                logger.debug(str, str2);
                return;
            } else {
                logger.debug(str, str2, th);
                return;
            }
        }
        if (i == 2) {
            if (th == null) {
                logger.warn(str, str2);
                return;
            } else {
                logger.warn(str, str2, th);
                return;
            }
        }
        if (i != 3) {
            return;
        }
        if (th == null) {
            logger.error(str, str2);
        } else {
            logger.error(str, str2, th);
        }
    }

    private static void logFormat(Level level, String str, Throwable th, String str2, Object... objArr) {
        if (logger == EMPTY_LOGGER) {
            return;
        }
        log(level, str, format(str2, objArr), th);
    }

    public static void setLogger(Logger logger2) {
        if (logger2 == null) {
            logger2 = EMPTY_LOGGER;
        }
        logger = logger2;
    }

    public static void w(String str, String str2) {
        log(Level.WARN, str, str2, null);
    }

    public static void d(String str, String str2, Throwable th) {
        log(Level.DEBUG, str, str2, th);
    }

    public static void e(String str, String str2, Throwable th) {
        log(Level.ERROR, str, str2, th);
    }

    public static void w(String str, String str2, Throwable th) {
        log(Level.WARN, str, str2, th);
    }

    public static void d(String str, String str2, Object... objArr) {
        logFormat(Level.DEBUG, str, null, str2, objArr);
    }

    public static void e(String str, String str2, Object... objArr) {
        logFormat(Level.ERROR, str, null, str2, objArr);
    }

    public static void w(String str, String str2, Object... objArr) {
        logFormat(Level.WARN, str, null, str2, objArr);
    }

    public static void d(String str, Throwable th, String str2, Object... objArr) {
        logFormat(Level.DEBUG, str, th, str2, objArr);
    }

    public static void e(String str, Throwable th, String str2, Object... objArr) {
        logFormat(Level.ERROR, str, th, str2, objArr);
    }

    public static void w(String str, Throwable th, String str2, Object... objArr) {
        logFormat(Level.WARN, str, th, str2, objArr);
    }

    /* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
    public final class ConsoleLogger implements Logger {
        @Override // org.schabi.newpipe.extractor.utils.Logger
        public void debug(String str, String str2) {
            System.out.println("[DEBUG][" + str + "] " + str2);
        }

        @Override // org.schabi.newpipe.extractor.utils.Logger
        public void error(String str, String str2, Throwable th) {
            System.err.println("[ERROR][" + str + "] " + str2);
            th.printStackTrace(System.err);
        }

        @Override // org.schabi.newpipe.extractor.utils.Logger
        public void warn(String str, String str2) {
            System.out.println("[WARN ][" + str + "] " + str2);
        }

        @Override // org.schabi.newpipe.extractor.utils.Logger
        public void debug(String str, String str2, Throwable th) {
            debug(str, str2);
            th.printStackTrace(System.err);
        }

        @Override // org.schabi.newpipe.extractor.utils.Logger
        public void warn(String str, String str2, Throwable th) {
            warn(str, str2);
            th.printStackTrace(System.err);
        }

        @Override // org.schabi.newpipe.extractor.utils.Logger
        public void error(String str, String str2) {
            System.err.println("[ERROR][" + str + "] " + str2);
        }
    }
}
