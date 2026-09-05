package com.github.catvod.spider.jdollar.nio.file;

import com.github.catvod.spider.jdollar.nio.file.attribute.FileAttributeView;
import java.nio.file.DirectoryStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public interface SecureDirectoryStream<T> extends DirectoryStream<T> {
    void deleteDirectory(T t);

    void deleteFile(T t);

    <V extends FileAttributeView> V getFileAttributeView(T t, Class<V> cls, LinkOption... linkOptionArr);

    SecureDirectoryStream<T> newDirectoryStream(T t, LinkOption... linkOptionArr);
}
