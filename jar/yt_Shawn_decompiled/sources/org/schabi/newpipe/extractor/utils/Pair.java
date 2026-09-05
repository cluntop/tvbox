package org.schabi.newpipe.extractor.utils;

import com.github.catvod.spider.jdollar.util.Objects;
import java.io.Serializable;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class Pair<F extends Serializable, S extends Serializable> implements Serializable {
    private F firstObject;
    private S secondObject;

    public Pair(F f, S s) {
        this.firstObject = f;
        this.secondObject = s;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            Pair pair = (Pair) obj;
            if (Objects.equals(this.firstObject, pair.firstObject) && Objects.equals(this.secondObject, pair.secondObject)) {
                return true;
            }
        }
        return false;
    }

    public F getFirst() {
        return this.firstObject;
    }

    public S getSecond() {
        return this.secondObject;
    }

    public int hashCode() {
        return Objects.hash(this.firstObject, this.secondObject);
    }

    public void setFirst(F f) {
        this.firstObject = f;
    }

    public void setSecond(S s) {
        this.secondObject = s;
    }

    public String toString() {
        return "{" + this.firstObject + ", " + this.secondObject + "}";
    }
}
