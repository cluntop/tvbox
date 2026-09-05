package com.github.catvod.spider.merge.n;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Build;
import com.github.catvod.crawler.SpiderDebug;
import com.github.catvod.spider.ClashCore;
import com.github.catvod.spider.Init;
import com.github.catvod.spider.SettingsUI;
import com.github.catvod.spider.Youtube;
import com.google.gson.JsonObject;
import java.util.Arrays;
import java.util.HashMap;
import org.schabi.newpipe.extractor.stream.StreamExtractor;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class v implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ Youtube b;

    public /* synthetic */ v(Youtube youtube, int i) {
        this.a = i;
        this.b = youtube;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.a;
        final int i2 = 3;
        final int i3 = 0;
        final Youtube youtube = this.b;
        switch (i) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                boolean z = Youtube.e;
                Init.post(new v(youtube, i2));
                break;
            case 1:
                boolean z2 = Youtube.e;
                youtube.d1();
                break;
            case 2:
                try {
                    Youtube.U();
                    if (!Youtube.o.isEmpty()) {
                        String str = "client_id=" + Youtube.T(Youtube.o) + "&scope=" + Youtube.T("https://www.googleapis.com/auth/youtube");
                        HashMap map = new HashMap();
                        map.put("Content-Type", "application/x-www-form-urlencoded");
                        String strA0 = Youtube.A0("https://www.youtube.com/o/oauth2/device/code", str, map);
                        JsonObject jsonObjectH = com.github.catvod.spider.merge.o.d.h(strA0);
                        if (!jsonObjectH.has("device_code")) {
                            SpiderDebug.log("[YouTube] oauth device code resp=".concat(strA0));
                            Init.post(new p(15));
                            break;
                        } else {
                            Youtube.u = jsonObjectH.get("device_code").getAsString();
                            Youtube.v = jsonObjectH.has("user_code") ? jsonObjectH.get("user_code").getAsString() : VideoStream.RESOLUTION_UNKNOWN;
                            Youtube.w = jsonObjectH.has("verification_url") ? jsonObjectH.get("verification_url").getAsString() : "https://www.google.com/device";
                            long asLong = jsonObjectH.has("interval") ? jsonObjectH.get("interval").getAsLong() : 5L;
                            long asLong2 = jsonObjectH.has("expires_in") ? jsonObjectH.get("expires_in").getAsLong() : 1800L;
                            Youtube.y = Math.max(asLong, 3L);
                            Youtube.x = (asLong2 * 1000) + System.currentTimeMillis();
                            SpiderDebug.log("[YouTube] oauth device code userCode=" + Youtube.v + " url=" + Youtube.w);
                            Init.post(new p(14));
                            Init.execute(new p(youtube, 0));
                            break;
                        }
                    } else {
                        Init.post(new p(13));
                        break;
                    }
                } catch (Exception e) {
                    SpiderDebug.log("[YouTube] startOauthLogin error: " + e.getMessage());
                    Init.post(new e0(e, 0));
                    return;
                }
            case 3:
                boolean z3 = Youtube.e;
                Activity activity = Init.activity();
                if (activity != null && !activity.isFinishing()) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                    builder.setTitle("选择诊断类型");
                    builder.setItems(new String[]{"快速诊断", "测试具体视频", "测试当前节点", "设备版本信息"}, new DialogInterface.OnClickListener() { // from class: com.github.catvod.spider.merge.n.x
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i4) throws Throwable {
                            int i5 = i2;
                            int i6 = 0;
                            Youtube youtube2 = youtube;
                            switch (i5) {
                                case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                                    boolean z4 = Youtube.e;
                                    String localFile = ClashCore.getLocalFile();
                                    ClashCore.setLocalFile(VideoStream.RESOLUTION_UNKNOWN);
                                    r rVar = new r(youtube2, localFile, 8);
                                    com.github.catvod.spider.merge.g1.a.e("正在拉取节点 ...");
                                    Init.execute(new c0(rVar, i6));
                                    break;
                                case 1:
                                    boolean z5 = Youtube.e;
                                    String localFile2 = ClashCore.getLocalFile();
                                    ClashCore.setLocalFile(VideoStream.RESOLUTION_UNKNOWN);
                                    String strS = Youtube.S();
                                    if (strS.isEmpty()) {
                                        youtube2.d1();
                                        break;
                                    } else {
                                        SettingsUI.confirm("检测到代理相关情况", com.github.catvod.spider.merge.b.b.A("检测结果：\n\n", strS, "\n若系统全局代理已指向其他代理软件，代理套娃会导致连接失败。\n建议：确认系统代理未指向其他代理软件后再启动本代理。\n\n是否继续启动？"), new v(youtube2, 4), new r(localFile2, 9));
                                        break;
                                    }
                                case 2:
                                    String strS2 = Youtube.S();
                                    if (strS2.isEmpty()) {
                                        youtube2.d1();
                                        break;
                                    } else {
                                        SettingsUI.confirm("检测到代理相关情况", com.github.catvod.spider.merge.b.b.A("检测结果：\n\n", strS2, "\n若系统全局代理已指向其他代理软件，代理套娃会导致连接失败。\n建议：确认系统代理未指向其他代理软件后再启动本代理。\n\n是否继续启动？"), new v(youtube2, 6), new p(20));
                                        break;
                                    }
                                default:
                                    boolean z6 = Youtube.e;
                                    if (i4 == 0) {
                                        com.github.catvod.spider.merge.g1.a.e("正在自诊断 ...");
                                        Init.execute(new p(youtube2, 1));
                                        break;
                                    } else if (i4 == 1) {
                                        SettingsUI.input("测试具体视频", "输入视频 ID 或完整 URL\n例如: jNQXAC9IVRw 或 https://www.youtube.com/watch?v=jNQXAC9IVRw", VideoStream.RESOLUTION_UNKNOWN, new q(youtube2, i6));
                                        break;
                                    } else if (i4 == 2) {
                                        String selectedNode = ClashCore.getSelectedNode();
                                        if (selectedNode.isEmpty()) {
                                            com.github.catvod.spider.merge.g1.a.e("请先选择节点");
                                            break;
                                        } else {
                                            if (!ClashCore.isRunning()) {
                                                com.github.catvod.spider.merge.g1.a.e("正在启动代理 ...");
                                                if (!ClashCore.start()) {
                                                    com.github.catvod.spider.merge.g1.a.e("代理启动失败");
                                                    break;
                                                }
                                            }
                                            com.github.catvod.spider.merge.g1.a.e("正在测试 ...");
                                            Init.execute(new r(youtube2, selectedNode, 0));
                                            break;
                                        }
                                    } else if (i4 == 3) {
                                        StringBuilder sb = new StringBuilder("=== 设备版本信息 ===\n\n[Android 版本] ");
                                        sb.append(Build.VERSION.RELEASE);
                                        sb.append("\n[SDK 版本] API ");
                                        int i7 = Build.VERSION.SDK_INT;
                                        sb.append(i7);
                                        sb.append("\n[插件兼容性] ✓ 支持（minSdk=21）\n");
                                        if (i7 >= 24) {
                                            sb.append("[代理功能] ✓ 完全支持\n");
                                        } else {
                                            sb.append("[代理功能] ⚠ 部分设备可能有权限限制\n");
                                        }
                                        sb.append("\n[设备品牌] ");
                                        sb.append(Build.BRAND);
                                        sb.append("\n[设备型号] ");
                                        sb.append(Build.MODEL);
                                        sb.append("\n[制造商] ");
                                        sb.append(Build.MANUFACTURER);
                                        sb.append("\n\n");
                                        String[] strArr = Build.SUPPORTED_ABIS;
                                        if (strArr != null && strArr.length > 0) {
                                            sb.append("[CPU 架构] ");
                                            sb.append(strArr[0]);
                                            if (strArr.length > 1) {
                                                sb.append(" (");
                                                CharSequence[] charSequenceArr = (CharSequence[]) Arrays.copyOfRange(strArr, 1, strArr.length);
                                                StringBuilder sb2 = new StringBuilder();
                                                if (charSequenceArr.length > 0) {
                                                    sb2.append(charSequenceArr[0]);
                                                    for (int i8 = 1; i8 < charSequenceArr.length; i8++) {
                                                        sb2.append((CharSequence) ", ");
                                                        sb2.append(charSequenceArr[i8]);
                                                    }
                                                }
                                                sb.append(sb2.toString());
                                                sb.append(")");
                                            }
                                            sb.append("\n");
                                        }
                                        if (ClashCore.isArchSupported()) {
                                            sb.append("[代理内核] ✓ 支持（mihomo 支持 arm64/amd64/armv7）\n");
                                        } else {
                                            sb.append("[代理内核] ✗ 不支持（仅支持 ARM 和 x86_64 架构）\n");
                                        }
                                        SettingsUI.show("设备版本信息", sb.toString());
                                        break;
                                    }
                                    break;
                            }
                        }
                    });
                    builder.setNegativeButton("取消", (DialogInterface.OnClickListener) null);
                    builder.show();
                    break;
                }
                break;
            case 4:
                boolean z4 = Youtube.e;
                youtube.d1();
                break;
            case 5:
                boolean z5 = Youtube.e;
                Activity activity2 = Init.activity();
                if (activity2 != null && !activity2.isFinishing()) {
                    new AlertDialog.Builder(activity2).setTitle("选择节点源").setMessage("检测到您同时设置了本地档案和在线订阅，请选择要更新的节点源：\n\n• 在线订阅：" + ClashCore.getSubscribeUrl() + "\n\n• 本地档案：" + ClashCore.getLocalFile()).setPositiveButton("使用在线订阅", new DialogInterface.OnClickListener() { // from class: com.github.catvod.spider.merge.n.x
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i4) throws Throwable {
                            int i5 = i3;
                            int i6 = 0;
                            Youtube youtube2 = youtube;
                            switch (i5) {
                                case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                                    boolean z42 = Youtube.e;
                                    String localFile = ClashCore.getLocalFile();
                                    ClashCore.setLocalFile(VideoStream.RESOLUTION_UNKNOWN);
                                    r rVar = new r(youtube2, localFile, 8);
                                    com.github.catvod.spider.merge.g1.a.e("正在拉取节点 ...");
                                    Init.execute(new c0(rVar, i6));
                                    break;
                                case 1:
                                    boolean z52 = Youtube.e;
                                    String localFile2 = ClashCore.getLocalFile();
                                    ClashCore.setLocalFile(VideoStream.RESOLUTION_UNKNOWN);
                                    String strS = Youtube.S();
                                    if (strS.isEmpty()) {
                                        youtube2.d1();
                                        break;
                                    } else {
                                        SettingsUI.confirm("检测到代理相关情况", com.github.catvod.spider.merge.b.b.A("检测结果：\n\n", strS, "\n若系统全局代理已指向其他代理软件，代理套娃会导致连接失败。\n建议：确认系统代理未指向其他代理软件后再启动本代理。\n\n是否继续启动？"), new v(youtube2, 4), new r(localFile2, 9));
                                        break;
                                    }
                                case 2:
                                    String strS2 = Youtube.S();
                                    if (strS2.isEmpty()) {
                                        youtube2.d1();
                                        break;
                                    } else {
                                        SettingsUI.confirm("检测到代理相关情况", com.github.catvod.spider.merge.b.b.A("检测结果：\n\n", strS2, "\n若系统全局代理已指向其他代理软件，代理套娃会导致连接失败。\n建议：确认系统代理未指向其他代理软件后再启动本代理。\n\n是否继续启动？"), new v(youtube2, 6), new p(20));
                                        break;
                                    }
                                default:
                                    boolean z6 = Youtube.e;
                                    if (i4 == 0) {
                                        com.github.catvod.spider.merge.g1.a.e("正在自诊断 ...");
                                        Init.execute(new p(youtube2, 1));
                                        break;
                                    } else if (i4 == 1) {
                                        SettingsUI.input("测试具体视频", "输入视频 ID 或完整 URL\n例如: jNQXAC9IVRw 或 https://www.youtube.com/watch?v=jNQXAC9IVRw", VideoStream.RESOLUTION_UNKNOWN, new q(youtube2, i6));
                                        break;
                                    } else if (i4 == 2) {
                                        String selectedNode = ClashCore.getSelectedNode();
                                        if (selectedNode.isEmpty()) {
                                            com.github.catvod.spider.merge.g1.a.e("请先选择节点");
                                            break;
                                        } else {
                                            if (!ClashCore.isRunning()) {
                                                com.github.catvod.spider.merge.g1.a.e("正在启动代理 ...");
                                                if (!ClashCore.start()) {
                                                    com.github.catvod.spider.merge.g1.a.e("代理启动失败");
                                                    break;
                                                }
                                            }
                                            com.github.catvod.spider.merge.g1.a.e("正在测试 ...");
                                            Init.execute(new r(youtube2, selectedNode, 0));
                                            break;
                                        }
                                    } else if (i4 == 3) {
                                        StringBuilder sb = new StringBuilder("=== 设备版本信息 ===\n\n[Android 版本] ");
                                        sb.append(Build.VERSION.RELEASE);
                                        sb.append("\n[SDK 版本] API ");
                                        int i7 = Build.VERSION.SDK_INT;
                                        sb.append(i7);
                                        sb.append("\n[插件兼容性] ✓ 支持（minSdk=21）\n");
                                        if (i7 >= 24) {
                                            sb.append("[代理功能] ✓ 完全支持\n");
                                        } else {
                                            sb.append("[代理功能] ⚠ 部分设备可能有权限限制\n");
                                        }
                                        sb.append("\n[设备品牌] ");
                                        sb.append(Build.BRAND);
                                        sb.append("\n[设备型号] ");
                                        sb.append(Build.MODEL);
                                        sb.append("\n[制造商] ");
                                        sb.append(Build.MANUFACTURER);
                                        sb.append("\n\n");
                                        String[] strArr = Build.SUPPORTED_ABIS;
                                        if (strArr != null && strArr.length > 0) {
                                            sb.append("[CPU 架构] ");
                                            sb.append(strArr[0]);
                                            if (strArr.length > 1) {
                                                sb.append(" (");
                                                CharSequence[] charSequenceArr = (CharSequence[]) Arrays.copyOfRange(strArr, 1, strArr.length);
                                                StringBuilder sb2 = new StringBuilder();
                                                if (charSequenceArr.length > 0) {
                                                    sb2.append(charSequenceArr[0]);
                                                    for (int i8 = 1; i8 < charSequenceArr.length; i8++) {
                                                        sb2.append((CharSequence) ", ");
                                                        sb2.append(charSequenceArr[i8]);
                                                    }
                                                }
                                                sb.append(sb2.toString());
                                                sb.append(")");
                                            }
                                            sb.append("\n");
                                        }
                                        if (ClashCore.isArchSupported()) {
                                            sb.append("[代理内核] ✓ 支持（mihomo 支持 arm64/amd64/armv7）\n");
                                        } else {
                                            sb.append("[代理内核] ✗ 不支持（仅支持 ARM 和 x86_64 架构）\n");
                                        }
                                        SettingsUI.show("设备版本信息", sb.toString());
                                        break;
                                    }
                                    break;
                            }
                        }
                    }).setNegativeButton("使用本地档案", new y()).setNeutralButton("取消", (DialogInterface.OnClickListener) null).show();
                    break;
                }
                break;
            case 6:
                boolean z6 = Youtube.e;
                youtube.d1();
                break;
            default:
                boolean z7 = Youtube.e;
                Activity activity3 = Init.activity();
                if (activity3 != null && !activity3.isFinishing()) {
                    final int i4 = 1;
                    final int i5 = 2;
                    new AlertDialog.Builder(activity3).setTitle("选择节点源").setMessage("检测到您同时设置了本地档案和在线订阅，请选择要使用的节点源：\n\n• 在线订阅：" + ClashCore.getSubscribeUrl() + "\n\n• 本地档案：" + ClashCore.getLocalFile()).setPositiveButton("使用在线订阅", new DialogInterface.OnClickListener() { // from class: com.github.catvod.spider.merge.n.x
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i42) throws Throwable {
                            int i52 = i4;
                            int i6 = 0;
                            Youtube youtube2 = youtube;
                            switch (i52) {
                                case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                                    boolean z42 = Youtube.e;
                                    String localFile = ClashCore.getLocalFile();
                                    ClashCore.setLocalFile(VideoStream.RESOLUTION_UNKNOWN);
                                    r rVar = new r(youtube2, localFile, 8);
                                    com.github.catvod.spider.merge.g1.a.e("正在拉取节点 ...");
                                    Init.execute(new c0(rVar, i6));
                                    break;
                                case 1:
                                    boolean z52 = Youtube.e;
                                    String localFile2 = ClashCore.getLocalFile();
                                    ClashCore.setLocalFile(VideoStream.RESOLUTION_UNKNOWN);
                                    String strS = Youtube.S();
                                    if (strS.isEmpty()) {
                                        youtube2.d1();
                                        break;
                                    } else {
                                        SettingsUI.confirm("检测到代理相关情况", com.github.catvod.spider.merge.b.b.A("检测结果：\n\n", strS, "\n若系统全局代理已指向其他代理软件，代理套娃会导致连接失败。\n建议：确认系统代理未指向其他代理软件后再启动本代理。\n\n是否继续启动？"), new v(youtube2, 4), new r(localFile2, 9));
                                        break;
                                    }
                                case 2:
                                    String strS2 = Youtube.S();
                                    if (strS2.isEmpty()) {
                                        youtube2.d1();
                                        break;
                                    } else {
                                        SettingsUI.confirm("检测到代理相关情况", com.github.catvod.spider.merge.b.b.A("检测结果：\n\n", strS2, "\n若系统全局代理已指向其他代理软件，代理套娃会导致连接失败。\n建议：确认系统代理未指向其他代理软件后再启动本代理。\n\n是否继续启动？"), new v(youtube2, 6), new p(20));
                                        break;
                                    }
                                default:
                                    boolean z62 = Youtube.e;
                                    if (i42 == 0) {
                                        com.github.catvod.spider.merge.g1.a.e("正在自诊断 ...");
                                        Init.execute(new p(youtube2, 1));
                                        break;
                                    } else if (i42 == 1) {
                                        SettingsUI.input("测试具体视频", "输入视频 ID 或完整 URL\n例如: jNQXAC9IVRw 或 https://www.youtube.com/watch?v=jNQXAC9IVRw", VideoStream.RESOLUTION_UNKNOWN, new q(youtube2, i6));
                                        break;
                                    } else if (i42 == 2) {
                                        String selectedNode = ClashCore.getSelectedNode();
                                        if (selectedNode.isEmpty()) {
                                            com.github.catvod.spider.merge.g1.a.e("请先选择节点");
                                            break;
                                        } else {
                                            if (!ClashCore.isRunning()) {
                                                com.github.catvod.spider.merge.g1.a.e("正在启动代理 ...");
                                                if (!ClashCore.start()) {
                                                    com.github.catvod.spider.merge.g1.a.e("代理启动失败");
                                                    break;
                                                }
                                            }
                                            com.github.catvod.spider.merge.g1.a.e("正在测试 ...");
                                            Init.execute(new r(youtube2, selectedNode, 0));
                                            break;
                                        }
                                    } else if (i42 == 3) {
                                        StringBuilder sb = new StringBuilder("=== 设备版本信息 ===\n\n[Android 版本] ");
                                        sb.append(Build.VERSION.RELEASE);
                                        sb.append("\n[SDK 版本] API ");
                                        int i7 = Build.VERSION.SDK_INT;
                                        sb.append(i7);
                                        sb.append("\n[插件兼容性] ✓ 支持（minSdk=21）\n");
                                        if (i7 >= 24) {
                                            sb.append("[代理功能] ✓ 完全支持\n");
                                        } else {
                                            sb.append("[代理功能] ⚠ 部分设备可能有权限限制\n");
                                        }
                                        sb.append("\n[设备品牌] ");
                                        sb.append(Build.BRAND);
                                        sb.append("\n[设备型号] ");
                                        sb.append(Build.MODEL);
                                        sb.append("\n[制造商] ");
                                        sb.append(Build.MANUFACTURER);
                                        sb.append("\n\n");
                                        String[] strArr = Build.SUPPORTED_ABIS;
                                        if (strArr != null && strArr.length > 0) {
                                            sb.append("[CPU 架构] ");
                                            sb.append(strArr[0]);
                                            if (strArr.length > 1) {
                                                sb.append(" (");
                                                CharSequence[] charSequenceArr = (CharSequence[]) Arrays.copyOfRange(strArr, 1, strArr.length);
                                                StringBuilder sb2 = new StringBuilder();
                                                if (charSequenceArr.length > 0) {
                                                    sb2.append(charSequenceArr[0]);
                                                    for (int i8 = 1; i8 < charSequenceArr.length; i8++) {
                                                        sb2.append((CharSequence) ", ");
                                                        sb2.append(charSequenceArr[i8]);
                                                    }
                                                }
                                                sb.append(sb2.toString());
                                                sb.append(")");
                                            }
                                            sb.append("\n");
                                        }
                                        if (ClashCore.isArchSupported()) {
                                            sb.append("[代理内核] ✓ 支持（mihomo 支持 arm64/amd64/armv7）\n");
                                        } else {
                                            sb.append("[代理内核] ✗ 不支持（仅支持 ARM 和 x86_64 架构）\n");
                                        }
                                        SettingsUI.show("设备版本信息", sb.toString());
                                        break;
                                    }
                                    break;
                            }
                        }
                    }).setNegativeButton("使用本地档案", new DialogInterface.OnClickListener() { // from class: com.github.catvod.spider.merge.n.x
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i42) throws Throwable {
                            int i52 = i5;
                            int i6 = 0;
                            Youtube youtube2 = youtube;
                            switch (i52) {
                                case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                                    boolean z42 = Youtube.e;
                                    String localFile = ClashCore.getLocalFile();
                                    ClashCore.setLocalFile(VideoStream.RESOLUTION_UNKNOWN);
                                    r rVar = new r(youtube2, localFile, 8);
                                    com.github.catvod.spider.merge.g1.a.e("正在拉取节点 ...");
                                    Init.execute(new c0(rVar, i6));
                                    break;
                                case 1:
                                    boolean z52 = Youtube.e;
                                    String localFile2 = ClashCore.getLocalFile();
                                    ClashCore.setLocalFile(VideoStream.RESOLUTION_UNKNOWN);
                                    String strS = Youtube.S();
                                    if (strS.isEmpty()) {
                                        youtube2.d1();
                                        break;
                                    } else {
                                        SettingsUI.confirm("检测到代理相关情况", com.github.catvod.spider.merge.b.b.A("检测结果：\n\n", strS, "\n若系统全局代理已指向其他代理软件，代理套娃会导致连接失败。\n建议：确认系统代理未指向其他代理软件后再启动本代理。\n\n是否继续启动？"), new v(youtube2, 4), new r(localFile2, 9));
                                        break;
                                    }
                                case 2:
                                    String strS2 = Youtube.S();
                                    if (strS2.isEmpty()) {
                                        youtube2.d1();
                                        break;
                                    } else {
                                        SettingsUI.confirm("检测到代理相关情况", com.github.catvod.spider.merge.b.b.A("检测结果：\n\n", strS2, "\n若系统全局代理已指向其他代理软件，代理套娃会导致连接失败。\n建议：确认系统代理未指向其他代理软件后再启动本代理。\n\n是否继续启动？"), new v(youtube2, 6), new p(20));
                                        break;
                                    }
                                default:
                                    boolean z62 = Youtube.e;
                                    if (i42 == 0) {
                                        com.github.catvod.spider.merge.g1.a.e("正在自诊断 ...");
                                        Init.execute(new p(youtube2, 1));
                                        break;
                                    } else if (i42 == 1) {
                                        SettingsUI.input("测试具体视频", "输入视频 ID 或完整 URL\n例如: jNQXAC9IVRw 或 https://www.youtube.com/watch?v=jNQXAC9IVRw", VideoStream.RESOLUTION_UNKNOWN, new q(youtube2, i6));
                                        break;
                                    } else if (i42 == 2) {
                                        String selectedNode = ClashCore.getSelectedNode();
                                        if (selectedNode.isEmpty()) {
                                            com.github.catvod.spider.merge.g1.a.e("请先选择节点");
                                            break;
                                        } else {
                                            if (!ClashCore.isRunning()) {
                                                com.github.catvod.spider.merge.g1.a.e("正在启动代理 ...");
                                                if (!ClashCore.start()) {
                                                    com.github.catvod.spider.merge.g1.a.e("代理启动失败");
                                                    break;
                                                }
                                            }
                                            com.github.catvod.spider.merge.g1.a.e("正在测试 ...");
                                            Init.execute(new r(youtube2, selectedNode, 0));
                                            break;
                                        }
                                    } else if (i42 == 3) {
                                        StringBuilder sb = new StringBuilder("=== 设备版本信息 ===\n\n[Android 版本] ");
                                        sb.append(Build.VERSION.RELEASE);
                                        sb.append("\n[SDK 版本] API ");
                                        int i7 = Build.VERSION.SDK_INT;
                                        sb.append(i7);
                                        sb.append("\n[插件兼容性] ✓ 支持（minSdk=21）\n");
                                        if (i7 >= 24) {
                                            sb.append("[代理功能] ✓ 完全支持\n");
                                        } else {
                                            sb.append("[代理功能] ⚠ 部分设备可能有权限限制\n");
                                        }
                                        sb.append("\n[设备品牌] ");
                                        sb.append(Build.BRAND);
                                        sb.append("\n[设备型号] ");
                                        sb.append(Build.MODEL);
                                        sb.append("\n[制造商] ");
                                        sb.append(Build.MANUFACTURER);
                                        sb.append("\n\n");
                                        String[] strArr = Build.SUPPORTED_ABIS;
                                        if (strArr != null && strArr.length > 0) {
                                            sb.append("[CPU 架构] ");
                                            sb.append(strArr[0]);
                                            if (strArr.length > 1) {
                                                sb.append(" (");
                                                CharSequence[] charSequenceArr = (CharSequence[]) Arrays.copyOfRange(strArr, 1, strArr.length);
                                                StringBuilder sb2 = new StringBuilder();
                                                if (charSequenceArr.length > 0) {
                                                    sb2.append(charSequenceArr[0]);
                                                    for (int i8 = 1; i8 < charSequenceArr.length; i8++) {
                                                        sb2.append((CharSequence) ", ");
                                                        sb2.append(charSequenceArr[i8]);
                                                    }
                                                }
                                                sb.append(sb2.toString());
                                                sb.append(")");
                                            }
                                            sb.append("\n");
                                        }
                                        if (ClashCore.isArchSupported()) {
                                            sb.append("[代理内核] ✓ 支持（mihomo 支持 arm64/amd64/armv7）\n");
                                        } else {
                                            sb.append("[代理内核] ✗ 不支持（仅支持 ARM 和 x86_64 架构）\n");
                                        }
                                        SettingsUI.show("设备版本信息", sb.toString());
                                        break;
                                    }
                                    break;
                            }
                        }
                    }).setNeutralButton("取消", (DialogInterface.OnClickListener) null).show();
                    break;
                }
                break;
        }
    }
}
