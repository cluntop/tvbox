package com.github.catvod.spider.merge.n;

import com.github.catvod.spider.SettingsUI;
import com.github.catvod.spider.Youtube;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class u implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    public /* synthetic */ u(String str, String str2, int i) {
        this.a = i;
        this.b = str;
        this.c = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.a;
        String str = this.c;
        String str2 = this.b;
        switch (i) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                boolean z = Youtube.e;
                StringBuilder sb = new StringBuilder(str2);
                if (!str.isEmpty()) {
                    sb.append("\n\n[日志已导出] ");
                    sb.append(str);
                }
                SettingsUI.show("YouTube 自诊断", sb.toString());
                break;
            case 1:
                boolean z2 = Youtube.e;
                StringBuilder sb2 = new StringBuilder(str2);
                if (!str.isEmpty()) {
                    sb2.append("\n\n[日志已导出] ");
                    sb2.append(str);
                }
                SettingsUI.show("视频测试报告", sb2.toString());
                break;
            case 2:
                boolean z3 = Youtube.e;
                StringBuilder sb3 = new StringBuilder(str2);
                if (!str.isEmpty()) {
                    sb3.append("\n\n[日志已导出] ");
                    sb3.append(str);
                }
                SettingsUI.show("YouTube 自诊断", sb3.toString());
                break;
            default:
                boolean z4 = Youtube.e;
                StringBuilder sb4 = new StringBuilder(str2);
                if (!str.isEmpty()) {
                    sb4.append("\n\n[日志已导出] ");
                    sb4.append(str);
                }
                SettingsUI.show("视频测试报告", sb4.toString());
                break;
        }
    }
}
