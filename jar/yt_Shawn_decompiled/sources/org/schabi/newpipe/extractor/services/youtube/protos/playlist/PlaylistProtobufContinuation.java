package org.schabi.newpipe.extractor.services.youtube.protos.playlist;

import com.github.catvod.spider.merge.u.c;
import com.github.catvod.spider.merge.u.e0;
import com.github.catvod.spider.merge.u.f0;
import com.github.catvod.spider.merge.u.g1;
import com.github.catvod.spider.merge.u.h1;
import com.github.catvod.spider.merge.u.i0;
import com.github.catvod.spider.merge.u.j0;
import com.github.catvod.spider.merge.u.l;
import com.github.catvod.spider.merge.u.n1;
import com.github.catvod.spider.merge.u.p;
import com.github.catvod.spider.merge.u.y;
import java.io.InputStream;
import java.nio.ByteBuffer;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class PlaylistProtobufContinuation {

    /* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
    /* renamed from: org.schabi.newpipe.extractor.services.youtube.protos.playlist.PlaylistProtobufContinuation$1, reason: invalid class name */
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
    public interface ContinuationParamsOrBuilder extends h1 {
        String getBrowseId();

        l getBrowseIdBytes();

        String getContinuationProperties();

        l getContinuationPropertiesBytes();

        @Override // com.github.catvod.spider.merge.u.h1
        /* synthetic */ g1 getDefaultInstanceForType();

        String getPlaylistId();

        l getPlaylistIdBytes();

        /* synthetic */ boolean isInitialized();
    }

    /* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
    public interface PlaylistContinuationOrBuilder extends h1 {
        @Override // com.github.catvod.spider.merge.u.h1
        /* synthetic */ g1 getDefaultInstanceForType();

        ContinuationParams getParameters();

        boolean hasParameters();

        /* synthetic */ boolean isInitialized();
    }

    private PlaylistProtobufContinuation() {
    }

    public static void registerAllExtensions(y yVar) {
    }

    /* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
    public final class ContinuationParams extends j0 implements ContinuationParamsOrBuilder {
        public static final int BROWSEID_FIELD_NUMBER = 2;
        public static final int CONTINUATIONPROPERTIES_FIELD_NUMBER = 3;
        private static final ContinuationParams DEFAULT_INSTANCE;
        private static volatile n1 PARSER = null;
        public static final int PLAYLISTID_FIELD_NUMBER = 35;
        private String browseId_ = VideoStream.RESOLUTION_UNKNOWN;
        private String continuationProperties_ = VideoStream.RESOLUTION_UNKNOWN;
        private String playlistId_ = VideoStream.RESOLUTION_UNKNOWN;

        static {
            ContinuationParams continuationParams = new ContinuationParams();
            DEFAULT_INSTANCE = continuationParams;
            j0.registerDefaultInstance(ContinuationParams.class, continuationParams);
        }

        private ContinuationParams() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearBrowseId() {
            this.browseId_ = getDefaultInstance().getBrowseId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearContinuationProperties() {
            this.continuationProperties_ = getDefaultInstance().getContinuationProperties();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPlaylistId() {
            this.playlistId_ = getDefaultInstance().getPlaylistId();
        }

        public static ContinuationParams getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static ContinuationParams parseDelimitedFrom(InputStream inputStream) {
            return (ContinuationParams) j0.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ContinuationParams parseFrom(ByteBuffer byteBuffer) {
            return (ContinuationParams) j0.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static n1 parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setBrowseId(String str) {
            str.getClass();
            this.browseId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setBrowseIdBytes(l lVar) {
            c.checkByteStringIsUtf8(lVar);
            this.browseId_ = lVar.o();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setContinuationProperties(String str) {
            str.getClass();
            this.continuationProperties_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setContinuationPropertiesBytes(l lVar) {
            c.checkByteStringIsUtf8(lVar);
            this.continuationProperties_ = lVar.o();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPlaylistId(String str) {
            str.getClass();
            this.playlistId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPlaylistIdBytes(l lVar) {
            c.checkByteStringIsUtf8(lVar);
            this.playlistId_ = lVar.o();
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
                return j0.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0002#\u0003\u0000\u0000\u0000\u0002Ȉ\u0003Ȉ#Ȉ", new Object[]{"browseId_", "continuationProperties_", "playlistId_"});
            }
            if (iOrdinal == 3) {
                return new ContinuationParams();
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
            synchronized (ContinuationParams.class) {
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

        @Override // org.schabi.newpipe.extractor.services.youtube.protos.playlist.PlaylistProtobufContinuation.ContinuationParamsOrBuilder
        public String getBrowseId() {
            return this.browseId_;
        }

        @Override // org.schabi.newpipe.extractor.services.youtube.protos.playlist.PlaylistProtobufContinuation.ContinuationParamsOrBuilder
        public l getBrowseIdBytes() {
            return l.e(this.browseId_);
        }

        @Override // org.schabi.newpipe.extractor.services.youtube.protos.playlist.PlaylistProtobufContinuation.ContinuationParamsOrBuilder
        public String getContinuationProperties() {
            return this.continuationProperties_;
        }

        @Override // org.schabi.newpipe.extractor.services.youtube.protos.playlist.PlaylistProtobufContinuation.ContinuationParamsOrBuilder
        public l getContinuationPropertiesBytes() {
            return l.e(this.continuationProperties_);
        }

        @Override // org.schabi.newpipe.extractor.services.youtube.protos.playlist.PlaylistProtobufContinuation.ContinuationParamsOrBuilder
        public String getPlaylistId() {
            return this.playlistId_;
        }

        @Override // org.schabi.newpipe.extractor.services.youtube.protos.playlist.PlaylistProtobufContinuation.ContinuationParamsOrBuilder
        public l getPlaylistIdBytes() {
            return l.e(this.playlistId_);
        }

        /* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
        public final class Builder extends e0 implements ContinuationParamsOrBuilder {
            private Builder() {
                super(ContinuationParams.DEFAULT_INSTANCE);
            }

            public Builder clearBrowseId() {
                copyOnWrite();
                ((ContinuationParams) this.instance).clearBrowseId();
                return this;
            }

            public Builder clearContinuationProperties() {
                copyOnWrite();
                ((ContinuationParams) this.instance).clearContinuationProperties();
                return this;
            }

            public Builder clearPlaylistId() {
                copyOnWrite();
                ((ContinuationParams) this.instance).clearPlaylistId();
                return this;
            }

            @Override // org.schabi.newpipe.extractor.services.youtube.protos.playlist.PlaylistProtobufContinuation.ContinuationParamsOrBuilder
            public String getBrowseId() {
                return ((ContinuationParams) this.instance).getBrowseId();
            }

            @Override // org.schabi.newpipe.extractor.services.youtube.protos.playlist.PlaylistProtobufContinuation.ContinuationParamsOrBuilder
            public l getBrowseIdBytes() {
                return ((ContinuationParams) this.instance).getBrowseIdBytes();
            }

            @Override // org.schabi.newpipe.extractor.services.youtube.protos.playlist.PlaylistProtobufContinuation.ContinuationParamsOrBuilder
            public String getContinuationProperties() {
                return ((ContinuationParams) this.instance).getContinuationProperties();
            }

            @Override // org.schabi.newpipe.extractor.services.youtube.protos.playlist.PlaylistProtobufContinuation.ContinuationParamsOrBuilder
            public l getContinuationPropertiesBytes() {
                return ((ContinuationParams) this.instance).getContinuationPropertiesBytes();
            }

            @Override // org.schabi.newpipe.extractor.services.youtube.protos.playlist.PlaylistProtobufContinuation.ContinuationParamsOrBuilder
            public String getPlaylistId() {
                return ((ContinuationParams) this.instance).getPlaylistId();
            }

            @Override // org.schabi.newpipe.extractor.services.youtube.protos.playlist.PlaylistProtobufContinuation.ContinuationParamsOrBuilder
            public l getPlaylistIdBytes() {
                return ((ContinuationParams) this.instance).getPlaylistIdBytes();
            }

            public Builder setBrowseId(String str) {
                copyOnWrite();
                ((ContinuationParams) this.instance).setBrowseId(str);
                return this;
            }

            public Builder setBrowseIdBytes(l lVar) {
                copyOnWrite();
                ((ContinuationParams) this.instance).setBrowseIdBytes(lVar);
                return this;
            }

            public Builder setContinuationProperties(String str) {
                copyOnWrite();
                ((ContinuationParams) this.instance).setContinuationProperties(str);
                return this;
            }

            public Builder setContinuationPropertiesBytes(l lVar) {
                copyOnWrite();
                ((ContinuationParams) this.instance).setContinuationPropertiesBytes(lVar);
                return this;
            }

            public Builder setPlaylistId(String str) {
                copyOnWrite();
                ((ContinuationParams) this.instance).setPlaylistId(str);
                return this;
            }

            public Builder setPlaylistIdBytes(l lVar) {
                copyOnWrite();
                ((ContinuationParams) this.instance).setPlaylistIdBytes(lVar);
                return this;
            }

            public /* synthetic */ Builder(int i) {
                this();
            }
        }

        public static Builder newBuilder(ContinuationParams continuationParams) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(continuationParams);
        }

        public static ContinuationParams parseDelimitedFrom(InputStream inputStream, y yVar) {
            return (ContinuationParams) j0.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, yVar);
        }

        public static ContinuationParams parseFrom(ByteBuffer byteBuffer, y yVar) {
            return (ContinuationParams) j0.parseFrom(DEFAULT_INSTANCE, byteBuffer, yVar);
        }

        public static ContinuationParams parseFrom(l lVar) {
            return (ContinuationParams) j0.parseFrom(DEFAULT_INSTANCE, lVar);
        }

        public static ContinuationParams parseFrom(l lVar, y yVar) {
            return (ContinuationParams) j0.parseFrom(DEFAULT_INSTANCE, lVar, yVar);
        }

        public static ContinuationParams parseFrom(byte[] bArr) {
            return (ContinuationParams) j0.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ContinuationParams parseFrom(byte[] bArr, y yVar) {
            return (ContinuationParams) j0.parseFrom(DEFAULT_INSTANCE, bArr, yVar);
        }

        public static ContinuationParams parseFrom(InputStream inputStream) {
            return (ContinuationParams) j0.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ContinuationParams parseFrom(InputStream inputStream, y yVar) {
            return (ContinuationParams) j0.parseFrom(DEFAULT_INSTANCE, inputStream, yVar);
        }

        public static ContinuationParams parseFrom(p pVar) {
            return (ContinuationParams) j0.parseFrom(DEFAULT_INSTANCE, pVar);
        }

        public static ContinuationParams parseFrom(p pVar, y yVar) {
            return (ContinuationParams) j0.parseFrom(DEFAULT_INSTANCE, pVar, yVar);
        }
    }

    /* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
    public final class PlaylistContinuation extends j0 implements PlaylistContinuationOrBuilder {
        private static final PlaylistContinuation DEFAULT_INSTANCE;
        public static final int PARAMETERS_FIELD_NUMBER = 80226972;
        private static volatile n1 PARSER;
        private int bitField0_;
        private ContinuationParams parameters_;

        static {
            PlaylistContinuation playlistContinuation = new PlaylistContinuation();
            DEFAULT_INSTANCE = playlistContinuation;
            j0.registerDefaultInstance(PlaylistContinuation.class, playlistContinuation);
        }

        private PlaylistContinuation() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearParameters() {
            this.parameters_ = null;
            this.bitField0_ &= -2;
        }

        public static PlaylistContinuation getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeParameters(ContinuationParams continuationParams) {
            continuationParams.getClass();
            ContinuationParams continuationParams2 = this.parameters_;
            if (continuationParams2 == null || continuationParams2 == ContinuationParams.getDefaultInstance()) {
                this.parameters_ = continuationParams;
            } else {
                this.parameters_ = (ContinuationParams) ((ContinuationParams.Builder) ContinuationParams.newBuilder(this.parameters_).mergeFrom((j0) continuationParams)).buildPartial();
            }
            this.bitField0_ |= 1;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static PlaylistContinuation parseDelimitedFrom(InputStream inputStream) {
            return (PlaylistContinuation) j0.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static PlaylistContinuation parseFrom(ByteBuffer byteBuffer) {
            return (PlaylistContinuation) j0.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static n1 parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setParameters(ContinuationParams continuationParams) {
            continuationParams.getClass();
            this.parameters_ = continuationParams;
            this.bitField0_ |= 1;
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
                return j0.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\uea9c♁\uea9c♁\u0001\u0000\u0000\u0000\uea9c♁ဉ\u0000", new Object[]{"bitField0_", "parameters_"});
            }
            if (iOrdinal == 3) {
                return new PlaylistContinuation();
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
            synchronized (PlaylistContinuation.class) {
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

        @Override // org.schabi.newpipe.extractor.services.youtube.protos.playlist.PlaylistProtobufContinuation.PlaylistContinuationOrBuilder
        public ContinuationParams getParameters() {
            ContinuationParams continuationParams = this.parameters_;
            return continuationParams == null ? ContinuationParams.getDefaultInstance() : continuationParams;
        }

        @Override // org.schabi.newpipe.extractor.services.youtube.protos.playlist.PlaylistProtobufContinuation.PlaylistContinuationOrBuilder
        public boolean hasParameters() {
            return (this.bitField0_ & 1) != 0;
        }

        /* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
        public final class Builder extends e0 implements PlaylistContinuationOrBuilder {
            private Builder() {
                super(PlaylistContinuation.DEFAULT_INSTANCE);
            }

            public Builder clearParameters() {
                copyOnWrite();
                ((PlaylistContinuation) this.instance).clearParameters();
                return this;
            }

            @Override // org.schabi.newpipe.extractor.services.youtube.protos.playlist.PlaylistProtobufContinuation.PlaylistContinuationOrBuilder
            public ContinuationParams getParameters() {
                return ((PlaylistContinuation) this.instance).getParameters();
            }

            @Override // org.schabi.newpipe.extractor.services.youtube.protos.playlist.PlaylistProtobufContinuation.PlaylistContinuationOrBuilder
            public boolean hasParameters() {
                return ((PlaylistContinuation) this.instance).hasParameters();
            }

            public Builder mergeParameters(ContinuationParams continuationParams) {
                copyOnWrite();
                ((PlaylistContinuation) this.instance).mergeParameters(continuationParams);
                return this;
            }

            public Builder setParameters(ContinuationParams.Builder builder) {
                copyOnWrite();
                ((PlaylistContinuation) this.instance).setParameters((ContinuationParams) builder.build());
                return this;
            }

            public /* synthetic */ Builder(int i) {
                this();
            }

            public Builder setParameters(ContinuationParams continuationParams) {
                copyOnWrite();
                ((PlaylistContinuation) this.instance).setParameters(continuationParams);
                return this;
            }
        }

        public static Builder newBuilder(PlaylistContinuation playlistContinuation) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(playlistContinuation);
        }

        public static PlaylistContinuation parseDelimitedFrom(InputStream inputStream, y yVar) {
            return (PlaylistContinuation) j0.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, yVar);
        }

        public static PlaylistContinuation parseFrom(ByteBuffer byteBuffer, y yVar) {
            return (PlaylistContinuation) j0.parseFrom(DEFAULT_INSTANCE, byteBuffer, yVar);
        }

        public static PlaylistContinuation parseFrom(l lVar) {
            return (PlaylistContinuation) j0.parseFrom(DEFAULT_INSTANCE, lVar);
        }

        public static PlaylistContinuation parseFrom(l lVar, y yVar) {
            return (PlaylistContinuation) j0.parseFrom(DEFAULT_INSTANCE, lVar, yVar);
        }

        public static PlaylistContinuation parseFrom(byte[] bArr) {
            return (PlaylistContinuation) j0.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static PlaylistContinuation parseFrom(byte[] bArr, y yVar) {
            return (PlaylistContinuation) j0.parseFrom(DEFAULT_INSTANCE, bArr, yVar);
        }

        public static PlaylistContinuation parseFrom(InputStream inputStream) {
            return (PlaylistContinuation) j0.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static PlaylistContinuation parseFrom(InputStream inputStream, y yVar) {
            return (PlaylistContinuation) j0.parseFrom(DEFAULT_INSTANCE, inputStream, yVar);
        }

        public static PlaylistContinuation parseFrom(p pVar) {
            return (PlaylistContinuation) j0.parseFrom(DEFAULT_INSTANCE, pVar);
        }

        public static PlaylistContinuation parseFrom(p pVar, y yVar) {
            return (PlaylistContinuation) j0.parseFrom(DEFAULT_INSTANCE, pVar, yVar);
        }
    }
}
