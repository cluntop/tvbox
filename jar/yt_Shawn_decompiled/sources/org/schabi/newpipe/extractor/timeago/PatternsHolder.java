package org.schabi.newpipe.extractor.timeago;

import com.github.catvod.spider.jdollar.time.temporal.ChronoUnit;
import com.github.catvod.spider.jdollar.util.Map;
import com.github.catvod.spider.merge.n1.g;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: r8-map-id-88b4ee5a47df08811008f50aae82e56df8b70dc6cf3967c4f5ff89d9e4610885 */
/* loaded from: classes.dex */
public abstract class PatternsHolder {
    private final Collection<String> days;
    private final Collection<String> hours;
    private final Collection<String> minutes;
    private final Collection<String> months;
    private final Collection<String> seconds;
    private final Map<ChronoUnit, Map<String, Integer>> specialCases;
    private final Collection<String> weeks;
    private final String wordSeparator;
    private final Collection<String> years;

    public PatternsHolder(String str, String[] strArr, String[] strArr2, String[] strArr3, String[] strArr4, String[] strArr5, String[] strArr6, String[] strArr7) {
        this(str, Arrays.asList(strArr), Arrays.asList(strArr2), Arrays.asList(strArr3), Arrays.asList(strArr4), Arrays.asList(strArr5), Arrays.asList(strArr6), Arrays.asList(strArr7));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Map lambda$putSpecialCase$0(ChronoUnit chronoUnit) {
        return new LinkedHashMap();
    }

    public Map<ChronoUnit, Collection<String>> asMap() {
        EnumMap enumMap = new EnumMap(ChronoUnit.class);
        enumMap.put((EnumMap) ChronoUnit.SECONDS, (ChronoUnit) seconds());
        enumMap.put((EnumMap) ChronoUnit.MINUTES, (ChronoUnit) minutes());
        enumMap.put((EnumMap) ChronoUnit.HOURS, (ChronoUnit) hours());
        enumMap.put((EnumMap) ChronoUnit.DAYS, (ChronoUnit) days());
        enumMap.put((EnumMap) ChronoUnit.WEEKS, (ChronoUnit) weeks());
        enumMap.put((EnumMap) ChronoUnit.MONTHS, (ChronoUnit) months());
        enumMap.put((EnumMap) ChronoUnit.YEARS, (ChronoUnit) years());
        return enumMap;
    }

    public Collection<String> days() {
        return this.days;
    }

    public Collection<String> hours() {
        return this.hours;
    }

    public Collection<String> minutes() {
        return this.minutes;
    }

    public Collection<String> months() {
        return this.months;
    }

    public void putSpecialCase(ChronoUnit chronoUnit, String str, int i) {
        ((Map) Map.EL.computeIfAbsent(this.specialCases, chronoUnit, new g(29))).put(str, Integer.valueOf(i));
    }

    public Collection<String> seconds() {
        return this.seconds;
    }

    public java.util.Map<ChronoUnit, java.util.Map<String, Integer>> specialCases() {
        return this.specialCases;
    }

    public Collection<String> weeks() {
        return this.weeks;
    }

    public String wordSeparator() {
        return this.wordSeparator;
    }

    public Collection<String> years() {
        return this.years;
    }

    public PatternsHolder(String str, Collection<String> collection, Collection<String> collection2, Collection<String> collection3, Collection<String> collection4, Collection<String> collection5, Collection<String> collection6, Collection<String> collection7) {
        this.specialCases = new EnumMap(ChronoUnit.class);
        this.wordSeparator = str;
        this.seconds = collection;
        this.minutes = collection2;
        this.hours = collection3;
        this.days = collection4;
        this.weeks = collection5;
        this.months = collection6;
        this.years = collection7;
    }
}
