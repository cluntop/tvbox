package com.github.catvod.spider.jdollar.nio.file;

import com.github.catvod.spider.jdollar.nio.file.attribute.FileAttribute;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.InvalidPathException;
import java.security.AccessController;
import java.security.SecureRandom;
import org.schabi.newpipe.extractor.stream.VideoStream;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class g0 {
    public static final Path a;
    public static final boolean b;
    public static final SecureRandom c;

    static {
        String property;
        if (System.getSecurityManager() == null) {
            property = System.getProperty("java.io.tmpdir");
        } else {
            com.github.catvod.spider.jdollar.sun.security.action.a aVar = new com.github.catvod.spider.jdollar.sun.security.action.a();
            aVar.b = "java.io.tmpdir";
            property = (String) AccessController.doPrivileged(aVar);
        }
        FileSystem fileSystem = j.a;
        a = fileSystem.getPath(property, new String[0]);
        b = fileSystem.F().contains("posix");
        c = new SecureRandom();
    }

    public static Path a(Path path, String str, String str2, boolean z, FileAttribute[] fileAttributeArr) {
        if (str == null) {
            str = VideoStream.RESOLUTION_UNKNOWN;
        }
        if (str2 == null) {
            str2 = z ? VideoStream.RESOLUTION_UNKNOWN : ".tmp";
        }
        Path path2 = a;
        if (path == null) {
            path = path2;
        }
        if (b && path.getFileSystem() == j.a) {
            if (fileAttributeArr.length == 0) {
                fileAttributeArr = new FileAttribute[]{z ? f0.b : f0.a};
            } else {
                int i = 0;
                while (true) {
                    if (i >= fileAttributeArr.length) {
                        int length = fileAttributeArr.length;
                        FileAttribute[] fileAttributeArr2 = new FileAttribute[length + 1];
                        System.arraycopy(fileAttributeArr, 0, fileAttributeArr2, 0, fileAttributeArr.length);
                        fileAttributeArr2[length] = z ? f0.b : f0.a;
                        fileAttributeArr = fileAttributeArr2;
                    } else {
                        if (fileAttributeArr[i].name().equals("posix:permissions")) {
                            break;
                        }
                        i++;
                    }
                }
            }
        }
        SecurityManager securityManager = System.getSecurityManager();
        while (true) {
            try {
                Path pathB = b(str, str2, path);
                try {
                    return z ? Files.createDirectory(pathB, fileAttributeArr) : Files.createFile(pathB, fileAttributeArr);
                } catch (SecurityException e) {
                    if (path != path2 || securityManager == null) {
                        throw e;
                    }
                    throw new SecurityException("Unable to create temporary file or directory");
                } catch (FileAlreadyExistsException unused) {
                }
            } catch (InvalidPathException e2) {
                if (securityManager == null) {
                    throw e2;
                }
                b.c("Invalid prefix or suffix");
                return null;
            }
        }
    }

    public static Path b(String str, String str2, Path path) {
        String str3;
        long jNextLong = c.nextLong();
        if (jNextLong == 0) {
            str3 = "0";
        } else if (jNextLong > 0) {
            str3 = Long.toString(jNextLong, 10);
        } else {
            char[] cArr = new char[64];
            long j = (jNextLong >>> 1) / 5;
            int i = 63;
            cArr[63] = Character.forDigit((int) (jNextLong - (j * 10)), 10);
            while (j > 0) {
                i--;
                cArr[i] = Character.forDigit((int) (j % 10), 10);
                j /= 10;
            }
            str3 = new String(cArr, i, 64 - i);
        }
        Path path2 = path.getFileSystem().getPath(str + str3 + str2, new String[0]);
        if (path2.getParent() == null) {
            return path.resolve(path2);
        }
        b.c("Invalid prefix or suffix");
        return null;
    }
}
