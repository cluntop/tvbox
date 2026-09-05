package org.schabi.newpipe.extractor.services.youtube.protos.video;

import com.github.catvod.spider.jdollar.util.DesugarCollections;
import com.github.catvod.spider.merge.u.c;
import com.github.catvod.spider.merge.u.d;
import com.github.catvod.spider.merge.u.e0;
import com.github.catvod.spider.merge.u.f0;
import com.github.catvod.spider.merge.u.g1;
import com.github.catvod.spider.merge.u.h1;
import com.github.catvod.spider.merge.u.i0;
import com.github.catvod.spider.merge.u.j0;
import com.github.catvod.spider.merge.u.l;
import com.github.catvod.spider.merge.u.n1;
import com.github.catvod.spider.merge.u.p;
import com.github.catvod.spider.merge.u.r0;
import com.github.catvod.spider.merge.u.y;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class Xtags {

    /* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
    /* renamed from: org.schabi.newpipe.extractor.services.youtube.protos.video.Xtags$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;

        static {
            int[] iArr = new int[((i0[]) i0.h.clone()).length];
            $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = iArr;
            try {
                iArr[3] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[4] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[5] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[6] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[0] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[1] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
    public interface KeyValuePairOrBuilder extends h1 {
        @Override // com.github.catvod.spider.merge.u.h1
        /* synthetic */ g1 getDefaultInstanceForType();

        String getKey();

        l getKeyBytes();

        String getValue();

        l getValueBytes();

        boolean hasKey();

        boolean hasValue();

        /* synthetic */ boolean isInitialized();
    }

    /* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
    public interface XTagsOrBuilder extends h1 {
        @Override // com.github.catvod.spider.merge.u.h1
        /* synthetic */ g1 getDefaultInstanceForType();

        KeyValuePair getXtags(int i);

        int getXtagsCount();

        List<KeyValuePair> getXtagsList();

        /* synthetic */ boolean isInitialized();
    }

    private Xtags() {
    }

    public static void registerAllExtensions(y yVar) {
    }

    /* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
    public final class KeyValuePair extends j0 implements KeyValuePairOrBuilder {
        private static final KeyValuePair DEFAULT_INSTANCE;
        public static final int KEY_FIELD_NUMBER = 1;
        private static volatile n1 PARSER = null;
        public static final int VALUE_FIELD_NUMBER = 2;
        private int bitField0_;
        private String key_ = VideoStream.RESOLUTION_UNKNOWN;
        private String value_ = VideoStream.RESOLUTION_UNKNOWN;

        static {
            KeyValuePair keyValuePair = new KeyValuePair();
            DEFAULT_INSTANCE = keyValuePair;
            j0.registerDefaultInstance(KeyValuePair.class, keyValuePair);
        }

        private KeyValuePair() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearKey() {
            this.bitField0_ &= -2;
            this.key_ = getDefaultInstance().getKey();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearValue() {
            this.bitField0_ &= -3;
            this.value_ = getDefaultInstance().getValue();
        }

        public static KeyValuePair getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static KeyValuePair parseDelimitedFrom(InputStream inputStream) {
            return (KeyValuePair) j0.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static KeyValuePair parseFrom(ByteBuffer byteBuffer) {
            return (KeyValuePair) j0.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static n1 parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setKey(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.key_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setKeyBytes(l lVar) {
            c.checkByteStringIsUtf8(lVar);
            this.key_ = lVar.o();
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setValue(String str) {
            str.getClass();
            this.bitField0_ |= 2;
            this.value_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setValueBytes(l lVar) {
            c.checkByteStringIsUtf8(lVar);
            this.value_ = lVar.o();
            this.bitField0_ |= 2;
        }

        @Override // com.github.catvod.spider.merge.u.j0
        public final Object dynamicMethod(i0 i0Var, Object obj, Object obj2) {
            n1 f0Var;
            int iOrdinal = i0Var.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            int i = 0;
            if (iOrdinal == 2) {
                return j0.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ለ\u0000\u0002ለ\u0001", new Object[]{"bitField0_", "key_", "value_"});
            }
            if (iOrdinal == 3) {
                return new KeyValuePair();
            }
            if (iOrdinal == 4) {
                return new Builder(i);
            }
            if (iOrdinal == 5) {
                return DEFAULT_INSTANCE;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            n1 n1Var = PARSER;
            if (n1Var != null) {
                return n1Var;
            }
            synchronized (KeyValuePair.class) {
                try {
                    f0Var = PARSER;
                    if (f0Var == null) {
                        f0Var = new f0(DEFAULT_INSTANCE);
                        PARSER = f0Var;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return f0Var;
        }

        @Override // org.schabi.newpipe.extractor.services.youtube.protos.video.Xtags.KeyValuePairOrBuilder
        public String getKey() {
            return this.key_;
        }

        @Override // org.schabi.newpipe.extractor.services.youtube.protos.video.Xtags.KeyValuePairOrBuilder
        public l getKeyBytes() {
            return l.e(this.key_);
        }

        @Override // org.schabi.newpipe.extractor.services.youtube.protos.video.Xtags.KeyValuePairOrBuilder
        public String getValue() {
            return this.value_;
        }

        @Override // org.schabi.newpipe.extractor.services.youtube.protos.video.Xtags.KeyValuePairOrBuilder
        public l getValueBytes() {
            return l.e(this.value_);
        }

        @Override // org.schabi.newpipe.extractor.services.youtube.protos.video.Xtags.KeyValuePairOrBuilder
        public boolean hasKey() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // org.schabi.newpipe.extractor.services.youtube.protos.video.Xtags.KeyValuePairOrBuilder
        public boolean hasValue() {
            return (this.bitField0_ & 2) != 0;
        }

        /* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
        public final class Builder extends e0 implements KeyValuePairOrBuilder {
            private Builder() {
                super(KeyValuePair.DEFAULT_INSTANCE);
            }

            public Builder clearKey() {
                copyOnWrite();
                ((KeyValuePair) this.instance).clearKey();
                return this;
            }

            public Builder clearValue() {
                copyOnWrite();
                ((KeyValuePair) this.instance).clearValue();
                return this;
            }

            @Override // org.schabi.newpipe.extractor.services.youtube.protos.video.Xtags.KeyValuePairOrBuilder
            public String getKey() {
                return ((KeyValuePair) this.instance).getKey();
            }

            @Override // org.schabi.newpipe.extractor.services.youtube.protos.video.Xtags.KeyValuePairOrBuilder
            public l getKeyBytes() {
                return ((KeyValuePair) this.instance).getKeyBytes();
            }

            @Override // org.schabi.newpipe.extractor.services.youtube.protos.video.Xtags.KeyValuePairOrBuilder
            public String getValue() {
                return ((KeyValuePair) this.instance).getValue();
            }

            @Override // org.schabi.newpipe.extractor.services.youtube.protos.video.Xtags.KeyValuePairOrBuilder
            public l getValueBytes() {
                return ((KeyValuePair) this.instance).getValueBytes();
            }

            @Override // org.schabi.newpipe.extractor.services.youtube.protos.video.Xtags.KeyValuePairOrBuilder
            public boolean hasKey() {
                return ((KeyValuePair) this.instance).hasKey();
            }

            @Override // org.schabi.newpipe.extractor.services.youtube.protos.video.Xtags.KeyValuePairOrBuilder
            public boolean hasValue() {
                return ((KeyValuePair) this.instance).hasValue();
            }

            public Builder setKey(String str) {
                copyOnWrite();
                ((KeyValuePair) this.instance).setKey(str);
                return this;
            }

            public Builder setKeyBytes(l lVar) {
                copyOnWrite();
                ((KeyValuePair) this.instance).setKeyBytes(lVar);
                return this;
            }

            public Builder setValue(String str) {
                copyOnWrite();
                ((KeyValuePair) this.instance).setValue(str);
                return this;
            }

            public Builder setValueBytes(l lVar) {
                copyOnWrite();
                ((KeyValuePair) this.instance).setValueBytes(lVar);
                return this;
            }

            public /* synthetic */ Builder(int i) {
                this();
            }
        }

        public static Builder newBuilder(KeyValuePair keyValuePair) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(keyValuePair);
        }

        public static KeyValuePair parseDelimitedFrom(InputStream inputStream, y yVar) {
            return (KeyValuePair) j0.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, yVar);
        }

        public static KeyValuePair parseFrom(ByteBuffer byteBuffer, y yVar) {
            return (KeyValuePair) j0.parseFrom(DEFAULT_INSTANCE, byteBuffer, yVar);
        }

        public static KeyValuePair parseFrom(l lVar) {
            return (KeyValuePair) j0.parseFrom(DEFAULT_INSTANCE, lVar);
        }

        public static KeyValuePair parseFrom(l lVar, y yVar) {
            return (KeyValuePair) j0.parseFrom(DEFAULT_INSTANCE, lVar, yVar);
        }

        public static KeyValuePair parseFrom(byte[] bArr) {
            return (KeyValuePair) j0.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static KeyValuePair parseFrom(byte[] bArr, y yVar) {
            return (KeyValuePair) j0.parseFrom(DEFAULT_INSTANCE, bArr, yVar);
        }

        public static KeyValuePair parseFrom(InputStream inputStream) {
            return (KeyValuePair) j0.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static KeyValuePair parseFrom(InputStream inputStream, y yVar) {
            return (KeyValuePair) j0.parseFrom(DEFAULT_INSTANCE, inputStream, yVar);
        }

        public static KeyValuePair parseFrom(p pVar) {
            return (KeyValuePair) j0.parseFrom(DEFAULT_INSTANCE, pVar);
        }

        public static KeyValuePair parseFrom(p pVar, y yVar) {
            return (KeyValuePair) j0.parseFrom(DEFAULT_INSTANCE, pVar, yVar);
        }
    }

    /* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
    public final class XTags extends j0 implements XTagsOrBuilder {
        private static final XTags DEFAULT_INSTANCE;
        private static volatile n1 PARSER = null;
        public static final int XTAGS_FIELD_NUMBER = 1;
        private r0 xtags_ = j0.emptyProtobufList();

        static {
            XTags xTags = new XTags();
            DEFAULT_INSTANCE = xTags;
            j0.registerDefaultInstance(XTags.class, xTags);
        }

        private XTags() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllXtags(Iterable<? extends KeyValuePair> iterable) {
            ensureXtagsIsMutable();
            c.addAll(iterable, this.xtags_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addXtags(KeyValuePair keyValuePair) {
            keyValuePair.getClass();
            ensureXtagsIsMutable();
            this.xtags_.add(keyValuePair);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearXtags() {
            this.xtags_ = j0.emptyProtobufList();
        }

        private void ensureXtagsIsMutable() {
            r0 r0Var = this.xtags_;
            if (((d) r0Var).a) {
                return;
            }
            this.xtags_ = j0.mutableCopy(r0Var);
        }

        public static XTags getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static XTags parseDelimitedFrom(InputStream inputStream) {
            return (XTags) j0.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static XTags parseFrom(ByteBuffer byteBuffer) {
            return (XTags) j0.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static n1 parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeXtags(int i) {
            ensureXtagsIsMutable();
            this.xtags_.remove(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setXtags(int i, KeyValuePair keyValuePair) {
            keyValuePair.getClass();
            ensureXtagsIsMutable();
            this.xtags_.set(i, keyValuePair);
        }

        @Override // com.github.catvod.spider.merge.u.j0
        public final Object dynamicMethod(i0 i0Var, Object obj, Object obj2) {
            n1 f0Var;
            int iOrdinal = i0Var.ordinal();
            if (iOrdinal == 0) {
                return (byte) 1;
            }
            int i = 0;
            if (iOrdinal == 2) {
                return j0.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"xtags_", KeyValuePair.class});
            }
            if (iOrdinal == 3) {
                return new XTags();
            }
            if (iOrdinal == 4) {
                return new Builder(i);
            }
            if (iOrdinal == 5) {
                return DEFAULT_INSTANCE;
            }
            if (iOrdinal != 6) {
                throw null;
            }
            n1 n1Var = PARSER;
            if (n1Var != null) {
                return n1Var;
            }
            synchronized (XTags.class) {
                try {
                    f0Var = PARSER;
                    if (f0Var == null) {
                        f0Var = new f0(DEFAULT_INSTANCE);
                        PARSER = f0Var;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return f0Var;
        }

        @Override // org.schabi.newpipe.extractor.services.youtube.protos.video.Xtags.XTagsOrBuilder
        public KeyValuePair getXtags(int i) {
            return (KeyValuePair) this.xtags_.get(i);
        }

        @Override // org.schabi.newpipe.extractor.services.youtube.protos.video.Xtags.XTagsOrBuilder
        public int getXtagsCount() {
            return this.xtags_.size();
        }

        @Override // org.schabi.newpipe.extractor.services.youtube.protos.video.Xtags.XTagsOrBuilder
        public List<KeyValuePair> getXtagsList() {
            return this.xtags_;
        }

        public KeyValuePairOrBuilder getXtagsOrBuilder(int i) {
            return (KeyValuePairOrBuilder) this.xtags_.get(i);
        }

        public List<? extends KeyValuePairOrBuilder> getXtagsOrBuilderList() {
            return this.xtags_;
        }

        /* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
        public final class Builder extends e0 implements XTagsOrBuilder {
            private Builder() {
                super(XTags.DEFAULT_INSTANCE);
            }

            public Builder addAllXtags(Iterable<? extends KeyValuePair> iterable) {
                copyOnWrite();
                ((XTags) this.instance).addAllXtags(iterable);
                return this;
            }

            public Builder addXtags(KeyValuePair.Builder builder) {
                copyOnWrite();
                ((XTags) this.instance).addXtags((KeyValuePair) builder.build());
                return this;
            }

            public Builder clearXtags() {
                copyOnWrite();
                ((XTags) this.instance).clearXtags();
                return this;
            }

            @Override // org.schabi.newpipe.extractor.services.youtube.protos.video.Xtags.XTagsOrBuilder
            public KeyValuePair getXtags(int i) {
                return ((XTags) this.instance).getXtags(i);
            }

            @Override // org.schabi.newpipe.extractor.services.youtube.protos.video.Xtags.XTagsOrBuilder
            public int getXtagsCount() {
                return ((XTags) this.instance).getXtagsCount();
            }

            @Override // org.schabi.newpipe.extractor.services.youtube.protos.video.Xtags.XTagsOrBuilder
            public List<KeyValuePair> getXtagsList() {
                return DesugarCollections.unmodifiableList(((XTags) this.instance).getXtagsList());
            }

            public Builder removeXtags(int i) {
                copyOnWrite();
                ((XTags) this.instance).removeXtags(i);
                return this;
            }

            public Builder setXtags(int i, KeyValuePair.Builder builder) {
                copyOnWrite();
                ((XTags) this.instance).setXtags(i, (KeyValuePair) builder.build());
                return this;
            }

            public /* synthetic */ Builder(int i) {
                this();
            }

            public Builder addXtags(int i, KeyValuePair keyValuePair) {
                copyOnWrite();
                ((XTags) this.instance).addXtags(i, keyValuePair);
                return this;
            }

            public Builder setXtags(int i, KeyValuePair keyValuePair) {
                copyOnWrite();
                ((XTags) this.instance).setXtags(i, keyValuePair);
                return this;
            }

            public Builder addXtags(KeyValuePair keyValuePair) {
                copyOnWrite();
                ((XTags) this.instance).addXtags(keyValuePair);
                return this;
            }

            public Builder addXtags(int i, KeyValuePair.Builder builder) {
                copyOnWrite();
                ((XTags) this.instance).addXtags(i, (KeyValuePair) builder.build());
                return this;
            }
        }

        public static Builder newBuilder(XTags xTags) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(xTags);
        }

        public static XTags parseDelimitedFrom(InputStream inputStream, y yVar) {
            return (XTags) j0.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, yVar);
        }

        public static XTags parseFrom(ByteBuffer byteBuffer, y yVar) {
            return (XTags) j0.parseFrom(DEFAULT_INSTANCE, byteBuffer, yVar);
        }

        public static XTags parseFrom(l lVar) {
            return (XTags) j0.parseFrom(DEFAULT_INSTANCE, lVar);
        }

        public static XTags parseFrom(l lVar, y yVar) {
            return (XTags) j0.parseFrom(DEFAULT_INSTANCE, lVar, yVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addXtags(int i, KeyValuePair keyValuePair) {
            keyValuePair.getClass();
            ensureXtagsIsMutable();
            this.xtags_.add(i, keyValuePair);
        }

        public static XTags parseFrom(byte[] bArr) {
            return (XTags) j0.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static XTags parseFrom(byte[] bArr, y yVar) {
            return (XTags) j0.parseFrom(DEFAULT_INSTANCE, bArr, yVar);
        }

        public static XTags parseFrom(InputStream inputStream) {
            return (XTags) j0.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static XTags parseFrom(InputStream inputStream, y yVar) {
            return (XTags) j0.parseFrom(DEFAULT_INSTANCE, inputStream, yVar);
        }

        public static XTags parseFrom(p pVar) {
            return (XTags) j0.parseFrom(DEFAULT_INSTANCE, pVar);
        }

        public static XTags parseFrom(p pVar, y yVar) {
            return (XTags) j0.parseFrom(DEFAULT_INSTANCE, pVar, yVar);
        }
    }
}
