package com.github.catvod.spider.merge.n;

import android.content.DialogInterface;
import com.github.catvod.spider.Init;
import com.github.catvod.spider.Youtube;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class y implements DialogInterface.OnClickListener {
    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        boolean z = Youtube.e;
        com.github.catvod.spider.merge.g1.a.e("正在拉取节点 ...");
        Init.execute(new c0(null, 0));
    }
}
