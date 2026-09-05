package com.github.catvod.spider.jdollar.nio.channels;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public interface CompletionHandler<V, A> {

    /* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
    public final /* synthetic */ class Wrapper implements java.nio.channels.CompletionHandler {
        public /* synthetic */ Wrapper() {
        }

        public static /* synthetic */ java.nio.channels.CompletionHandler convert(CompletionHandler completionHandler) {
            if (completionHandler == null) {
                return null;
            }
            if (completionHandler instanceof c) {
                throw null;
            }
            return new Wrapper();
        }

        @Override // java.nio.channels.CompletionHandler
        public final /* synthetic */ void completed(Object obj, Object obj2) {
            CompletionHandler.this.completed(obj, obj2);
        }

        public final /* synthetic */ boolean equals(Object obj) {
            CompletionHandler completionHandler = CompletionHandler.this;
            if (obj instanceof Wrapper) {
                obj = CompletionHandler.this;
            }
            return completionHandler.equals(obj);
        }

        @Override // java.nio.channels.CompletionHandler
        public final /* synthetic */ void failed(Throwable th, Object obj) {
            CompletionHandler.this.failed(th, obj);
        }

        public final /* synthetic */ int hashCode() {
            return CompletionHandler.this.hashCode();
        }
    }

    void completed(V v, A a);

    void failed(Throwable th, A a);
}
