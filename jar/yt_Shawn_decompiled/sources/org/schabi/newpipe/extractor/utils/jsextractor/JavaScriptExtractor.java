package org.schabi.newpipe.extractor.utils.jsextractor;

import org.schabi.newpipe.extractor.exceptions.ParsingException;
import org.schabi.newpipe.extractor.utils.c;
import org.schabi.newpipe.extractor.utils.jsextractor.Lexer;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class JavaScriptExtractor {
    private JavaScriptExtractor() {
    }

    public static String matchToClosingBrace(String str, String str2) throws ParsingException {
        int iIndexOf = str.indexOf(str2);
        if (iIndexOf < 0) {
            c.a("Start not found");
            return null;
        }
        String strSubstring = str.substring(str2.length() + iIndexOf);
        Lexer lexer = new Lexer(strSubstring);
        boolean z = false;
        while (true) {
            Lexer.ParsedToken nextToken = lexer.getNextToken();
            Token token = nextToken.token;
            if (token == Token.LC) {
                z = true;
            } else {
                if (z && lexer.isBalanced()) {
                    return strSubstring.substring(0, nextToken.end);
                }
                if (token == Token.EOF) {
                    c.a("Could not find matching braces");
                    return null;
                }
            }
        }
    }
}
