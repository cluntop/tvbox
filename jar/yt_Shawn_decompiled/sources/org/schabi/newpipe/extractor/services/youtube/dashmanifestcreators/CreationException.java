package org.schabi.newpipe.extractor.services.youtube.dashmanifestcreators;

import com.github.catvod.spider.merge.b.b;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class CreationException extends RuntimeException {
    public CreationException(String str) {
        super(str);
    }

    public static CreationException couldNotAddElement(String str, Exception exc) {
        return new CreationException(b.A("Could not add ", str, " element"), exc);
    }

    public CreationException(String str, Exception exc) {
        super(str, exc);
    }

    public static CreationException couldNotAddElement(String str, String str2) {
        return new CreationException(b.p("Could not add ", str, " element: ", str2));
    }
}
