package org.schabi.newpipe.extractor.services.youtube;

import com.github.catvod.spider.jdollar.util.Comparator;
import com.github.catvod.spider.merge.o1.p;
import com.grack.nanojson.JsonObject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.schabi.newpipe.extractor.services.youtube.YoutubeDescriptionHelper;
import org.schabi.newpipe.extractor.stream.VideoStream;
import org.schabi.newpipe.extractor.utils.Utils;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public final class YoutubeDescriptionHelper {
    private static final String BOLD_CLOSE = "</b>";
    private static final String BOLD_OPEN = "<b>";
    private static final String ITALIC_CLOSE = "</i>";
    private static final String ITALIC_OPEN = "<i>";
    private static final String LINK_CLOSE = "</a>";
    private static final Pattern LINK_CONTENT_CLEANER_REGEX = Pattern.compile("(?s)^ +[/•] +(.*?) +$");
    private static final String STRIKETHROUGH_CLOSE = "</s>";
    private static final String STRIKETHROUGH_OPEN = "<s>";

    private YoutubeDescriptionHelper() {
    }

    private static void addAllCommandRuns(JsonObject jsonObject, List<Run> list, List<Run> list2) {
        jsonObject.getArray("commandRuns").streamAsJsonObjects().forEach(new d(list, list2, 1));
    }

    private static void addAllStyleRuns(JsonObject jsonObject, List<Run> list, List<Run> list2) {
        jsonObject.getArray("styleRuns").streamAsJsonObjects().forEach(new d(list, list2, 0));
    }

    public static String attributedDescriptionToHtml(JsonObject jsonObject) {
        String string;
        if (Utils.isNullOrEmpty(jsonObject) || (string = jsonObject.getString("content")) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        addAllCommandRuns(jsonObject, arrayList, arrayList2);
        addAllStyleRuns(jsonObject, arrayList, arrayList2);
        final int i = 0;
        Collections.sort(arrayList, Comparator.CC.comparingInt(new ToIntFunction() { // from class: org.schabi.newpipe.extractor.services.youtube.e
            @Override // java.util.function.ToIntFunction
            public final int applyAsInt(Object obj) {
                YoutubeDescriptionHelper.Run run = (YoutubeDescriptionHelper.Run) obj;
                switch (i) {
                }
                return run.pos;
            }
        }));
        final int i2 = 1;
        Collections.sort(arrayList2, Comparator.CC.comparingInt(new ToIntFunction() { // from class: org.schabi.newpipe.extractor.services.youtube.e
            @Override // java.util.function.ToIntFunction
            public final int applyAsInt(Object obj) {
                YoutubeDescriptionHelper.Run run = (YoutubeDescriptionHelper.Run) obj;
                switch (i2) {
                }
                return run.pos;
            }
        }));
        return runsToHtml(arrayList, arrayList2, string);
    }

    private static Function<String, String> getTransformContentFun(JsonObject jsonObject, boolean z) {
        String strReplaceFirst = jsonObject.getObject("onTapOptions").getObject("accessibilityInfo").getString("accessibilityLabel", VideoStream.RESOLUTION_UNKNOWN).replaceFirst(" Channel Link", VideoStream.RESOLUTION_UNKNOWN);
        return (z || strReplaceFirst.isEmpty() || strReplaceFirst.startsWith("YouTube: ")) ? new a(8) : new org.schabi.newpipe.extractor.services.bandcamp.extractors.b(strReplaceFirst, 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ void lambda$addAllCommandRuns$2(java.util.List r7, java.util.List r8, com.grack.nanojson.JsonObject r9) {
        /*
            java.lang.String r0 = "onTap"
            com.grack.nanojson.JsonObject r0 = r9.getObject(r0)
            java.lang.String r1 = "innertubeCommand"
            com.grack.nanojson.JsonObject r0 = r0.getObject(r1)
            java.lang.String r1 = "startIndex"
            r2 = -1
            int r1 = r9.getInt(r1, r2)
            java.lang.String r2 = "length"
            r3 = 0
            int r2 = r9.getInt(r2, r3)
            if (r1 < 0) goto L5e
            r4 = 1
            if (r2 < r4) goto L5e
            if (r0 != 0) goto L22
            goto L5e
        L22:
            java.lang.String r0 = org.schabi.newpipe.extractor.services.youtube.YoutubeParsingHelper.getUrlFromNavigationEndpoint(r0)
            if (r0 != 0) goto L29
            goto L5e
        L29:
            java.net.URL r5 = new java.net.URL     // Catch: java.net.MalformedURLException -> L3b
            r5.<init>(r0)     // Catch: java.net.MalformedURLException -> L3b
            boolean r6 = org.schabi.newpipe.extractor.services.youtube.YoutubeParsingHelper.isYoutubeURL(r5)     // Catch: java.net.MalformedURLException -> L3b
            if (r6 != 0) goto L3a
            boolean r5 = org.schabi.newpipe.extractor.services.youtube.YoutubeParsingHelper.isYoutubeServiceURL(r5)     // Catch: java.net.MalformedURLException -> L3b
            if (r5 == 0) goto L3b
        L3a:
            r3 = 1
        L3b:
            java.lang.String r0 = com.github.catvod.spider.merge.o1.p.d(r0)
            java.lang.String r4 = "<a href=\""
            java.lang.String r5 = "\">"
            java.lang.String r0 = com.github.catvod.spider.merge.b.b.A(r4, r0, r5)
            java.util.function.Function r9 = getTransformContentFun(r9, r3)
            org.schabi.newpipe.extractor.services.youtube.YoutubeDescriptionHelper$Run r3 = new org.schabi.newpipe.extractor.services.youtube.YoutubeDescriptionHelper$Run
            java.lang.String r4 = "</a>"
            r3.<init>(r0, r4, r1, r9)
            r7.add(r3)
            org.schabi.newpipe.extractor.services.youtube.YoutubeDescriptionHelper$Run r7 = new org.schabi.newpipe.extractor.services.youtube.YoutubeDescriptionHelper$Run
            int r1 = r1 + r2
            r7.<init>(r0, r4, r1, r9)
            r8.add(r7)
        L5e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.schabi.newpipe.extractor.services.youtube.YoutubeDescriptionHelper.lambda$addAllCommandRuns$2(java.util.List, java.util.List, com.grack.nanojson.JsonObject):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$addAllStyleRuns$5(List list, List list2, JsonObject jsonObject) {
        int i = jsonObject.getInt("startIndex", -1);
        int i2 = jsonObject.getInt("length", 0);
        if (i < 0 || i2 < 1) {
            return;
        }
        int i3 = i2 + i;
        if (jsonObject.has("strikethrough")) {
            list.add(new Run(STRIKETHROUGH_OPEN, STRIKETHROUGH_CLOSE, i));
            list2.add(new Run(STRIKETHROUGH_OPEN, STRIKETHROUGH_CLOSE, i3));
        }
        if (jsonObject.getBoolean("italic", Boolean.FALSE)) {
            list.add(new Run(ITALIC_OPEN, ITALIC_CLOSE, i));
            list2.add(new Run(ITALIC_OPEN, ITALIC_CLOSE, i3));
        }
        if (!jsonObject.has("weightLabel") || "FONT_WEIGHT_NORMAL".equals(jsonObject.getString("weightLabel"))) {
            return;
        }
        list.add(new Run(BOLD_OPEN, BOLD_CLOSE, i));
        list2.add(new Run(BOLD_OPEN, BOLD_CLOSE, i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$getTransformContentFun$3(String str) {
        Matcher matcher = LINK_CONTENT_CLEANER_REGEX.matcher(str);
        return matcher.find() ? matcher.group(1) : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$getTransformContentFun$4(String str, String str2) {
        return str;
    }

    public static String runsToHtml(List<Run> list, List<Run> list2, String str) {
        int i;
        String strReplace = str.replace((char) 160, ' ');
        Stack stack = new Stack();
        Stack stack2 = new Stack();
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < list2.size()) {
            int iMin = i4 < list.size() ? Math.min(list2.get(i2).pos, list.get(i4).pos) : list2.get(i2).pos;
            sb.append(p.d(strReplace.substring(i3, iMin)));
            if (list2.get(i2).pos == iMin) {
                Run run = list2.get(i2);
                i2++;
                while (true) {
                    if (stack.empty()) {
                        break;
                    }
                    Run run2 = (Run) stack.pop();
                    if (run2.sameOpen(run)) {
                        if (run2.transformContent != null && (i = run2.openPosInOutput) >= 0) {
                            sb.replace(i, sb.length(), run2.transformContent.apply(sb.substring(run2.openPosInOutput)));
                        }
                        sb.append(run2.close);
                    } else {
                        sb.append(run2.close);
                        stack2.push(run2);
                    }
                }
                while (!stack2.empty()) {
                    Run run3 = (Run) stack2.pop();
                    sb.append(run3.open);
                    stack.push(run3);
                }
            } else {
                Run run4 = list.get(i4);
                sb.append(run4.open);
                run4.openPosInOutput = sb.length();
                stack.push(run4);
                i4++;
            }
            i3 = iMin;
        }
        sb.append(p.d(strReplace.substring(i3)));
        return sb.toString().replace("\n", "<br>").replace("  ", " &nbsp;");
    }

    /* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
    final class Run {
        final String close;
        final String open;
        int openPosInOutput;
        final int pos;
        final Function<String, String> transformContent;

        public Run(String str, String str2, int i, Function<String, String> function) {
            this.openPosInOutput = -1;
            this.open = str;
            this.close = str2;
            this.pos = i;
            this.transformContent = function;
        }

        public boolean sameOpen(Run run) {
            return this.open.equals(run.open);
        }

        public Run(String str, String str2, int i) {
            this(str, str2, i, null);
        }
    }
}
