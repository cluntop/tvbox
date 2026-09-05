package org.schabi.newpipe.extractor.localization;

import com.github.catvod.spider.jdollar.time.LocalDateTime;
import com.github.catvod.spider.jdollar.time.temporal.ChronoUnit;
import com.github.catvod.spider.jdollar.util.Collection$EL;
import com.github.catvod.spider.merge.b.b;
import com.github.catvod.spider.merge.n1.d;
import com.github.catvod.spider.merge.n1.g;
import java.util.Collection;
import java.util.Map;
import java.util.regex.Pattern;
import org.schabi.newpipe.extractor.exceptions.ParsingException;
import org.schabi.newpipe.extractor.stream.Stream;
import org.schabi.newpipe.extractor.stream.VideoStream;
import org.schabi.newpipe.extractor.timeago.PatternsHolder;
import org.schabi.newpipe.extractor.utils.Parser;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public class TimeAgoParser {
    private final LocalDateTime now;
    private final PatternsHolder patternsHolder;

    public TimeAgoParser(PatternsHolder patternsHolder, LocalDateTime localDateTime) {
        this.patternsHolder = patternsHolder;
        this.now = localDateTime;
    }

    private DateWrapper getResultFor(int i, ChronoUnit chronoUnit) {
        ChronoUnit chronoUnit2 = ChronoUnit.YEARS;
        LocalDateTime localDateTime = this.now;
        LocalDateTime localDateTimeMinusDays = chronoUnit == chronoUnit2 ? localDateTime.minusYears(i).minusDays(1L) : localDateTime.t(i, chronoUnit);
        boolean zIsDateBased = chronoUnit.isDateBased();
        if (zIsDateBased) {
            localDateTimeMinusDays = localDateTimeMinusDays.truncatedTo(ChronoUnit.DAYS);
        }
        return new DateWrapper(localDateTimeMinusDays, zIsDateBased);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$parseChronoUnit$1(String str, Map.Entry entry) {
        return Collection$EL.stream((Collection) entry.getValue()).anyMatch(new a(this, str, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ParsingException lambda$parseChronoUnit$2(String str) {
        return new ParsingException(b.n("Unable to parse the date: ", str));
    }

    private ChronoUnit parseChronoUnit(String str) {
        return (ChronoUnit) Collection$EL.stream(this.patternsHolder.asMap().entrySet()).filter(new a(this, str, 1)).map(new g(13)).findFirst().orElseThrow(new d(str, 3));
    }

    private int parseTimeAgoAmount(String str) {
        try {
            return Integer.parseInt(str.replaceAll("\\D+", VideoStream.RESOLUTION_UNKNOWN));
        } catch (NumberFormatException unused) {
            return 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: textualDateMatches, reason: merged with bridge method [inline-methods] */
    public boolean lambda$parseChronoUnit$0(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        if (this.patternsHolder.wordSeparator().isEmpty()) {
            return str.toLowerCase().contains(str2.toLowerCase());
        }
        String strQuote = Pattern.quote(str2.toLowerCase());
        String strQuote2 = this.patternsHolder.wordSeparator().equals(Stream.ID_UNKNOWN) ? "[ \\t\\xA0\\u1680\\u180e\\u2000-\\u200a\\u202f\\u205f\\u3000\\d]" : Pattern.quote(this.patternsHolder.wordSeparator());
        StringBuilder sb = new StringBuilder("(^|");
        sb.append(strQuote2);
        sb.append(")");
        sb.append(strQuote);
        sb.append("($|");
        return Parser.isMatch(b.q(sb, strQuote2, ")"), str.toLowerCase());
    }

    public DateWrapper parse(String str) {
        for (Map.Entry<ChronoUnit, Map<String, Integer>> entry : this.patternsHolder.specialCases().entrySet()) {
            ChronoUnit key = entry.getKey();
            for (Map.Entry<String, Integer> entry2 : entry.getValue().entrySet()) {
                String key2 = entry2.getKey();
                int iIntValue = entry2.getValue().intValue();
                if (lambda$parseChronoUnit$0(str, key2)) {
                    return getResultFor(iIntValue, key);
                }
            }
        }
        return getResultFor(parseTimeAgoAmount(str), parseChronoUnit(str));
    }
}
