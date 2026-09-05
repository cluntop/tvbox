package com.github.catvod.spider.merge.a1;

import java.security.Permission;
import java.util.HashSet;

/* loaded from: classes.dex */
public final class e extends Permission {
    public final HashSet a;

    public e(String str) {
        super(str);
        HashSet hashSet = new HashSet();
        this.a = hashSet;
        hashSet.add(str);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof e) && this.a.equals(((e) obj).a);
    }

    @Override // java.security.Permission
    public final String getActions() {
        return this.a.toString();
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override // java.security.Permission
    public final boolean implies(Permission permission) {
        if (!(permission instanceof e)) {
            return false;
        }
        e eVar = (e) permission;
        return getName().equals(eVar.getName()) || this.a.containsAll(eVar.a);
    }
}
