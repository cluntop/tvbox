package com.github.catvod.spider.merge.n;

import com.github.catvod.spider.Samba;
import com.hierynomus.msfscc.FileAttributes;
import com.hierynomus.msfscc.fileinformation.FileIdBothDirectoryInformation;
import com.hierynomus.protocol.commons.EnumWithValue;
import java.io.File;
import java.util.Comparator;
import org.schabi.newpipe.extractor.stream.StreamExtractor;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements Comparator {
    public final /* synthetic */ int a;

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.a) {
            case StreamExtractor.NO_AGE_LIMIT /* 0 */:
                FileIdBothDirectoryInformation fileIdBothDirectoryInformation = (FileIdBothDirectoryInformation) obj;
                FileIdBothDirectoryInformation fileIdBothDirectoryInformation2 = (FileIdBothDirectoryInformation) obj2;
                long fileAttributes = fileIdBothDirectoryInformation.getFileAttributes();
                FileAttributes fileAttributes2 = FileAttributes.FILE_ATTRIBUTE_DIRECTORY;
                if (EnumWithValue.EnumUtils.isSet(fileAttributes, fileAttributes2) && Samba.c(fileIdBothDirectoryInformation2)) {
                    return -1;
                }
                if (Samba.c(fileIdBothDirectoryInformation) && EnumWithValue.EnumUtils.isSet(fileIdBothDirectoryInformation2.getFileAttributes(), fileAttributes2)) {
                    return 1;
                }
                return fileIdBothDirectoryInformation.getFileName().toLowerCase().compareTo(fileIdBothDirectoryInformation2.getFileName().toLowerCase());
            case 1:
                return ((File) obj).getName().toLowerCase().compareTo(((File) obj2).getName().toLowerCase());
            case 2:
                File file = (File) obj;
                File file2 = (File) obj2;
                if (file.isDirectory() && file2.isFile()) {
                    return -1;
                }
                if (file.isFile() && file2.isDirectory()) {
                    return 1;
                }
                return file.getName().toLowerCase().compareTo(file2.getName().toLowerCase());
            default:
                return ((String) obj2).length() - ((String) obj).length();
        }
    }
}
