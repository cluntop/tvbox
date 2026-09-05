package com.grack.nanojson;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.math.BigInteger;
import java.net.URL;
import org.schabi.newpipe.extractor.services.peertube.PeertubeParsingHelper;
import org.schabi.newpipe.extractor.services.soundcloud.linkHandler.SoundcloudSearchQueryHandlerFactory;

/* loaded from: classes.dex */
public final class JsonParser {
    private boolean lazyNumbers;
    private int token;
    private JsonTokener tokener;
    private Object value;

    public JsonParser(JsonTokener jsonTokener, boolean z) {
        this.tokener = jsonTokener;
        this.lazyNumbers = z;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private int advanceToken(boolean z, boolean z2) throws JsonParserException, IOException {
        Object string;
        int i;
        if (z2) {
            this.tokener.index--;
        }
        int iAdvanceToToken = this.tokener.advanceToToken(z);
        this.token = iAdvanceToToken;
        switch (iAdvanceToToken) {
            case 5:
                this.value = null;
                return this.token;
            case 6:
                string = Boolean.TRUE;
                this.value = string;
                return this.token;
            case 7:
                string = Boolean.FALSE;
                this.value = string;
                return this.token;
            case 8:
            case PeertubeParsingHelper.ITEMS_PER_PAGE /* 12 */:
                string = this.tokener.reusableBuffer.toString();
                this.value = string;
                return this.token;
            case 9:
                string = this.lazyNumbers ? new JsonLazyNumber(this.tokener.reusableBuffer.toString(), this.tokener.isDouble) : parseNumber();
                this.value = string;
                return this.token;
            case SoundcloudSearchQueryHandlerFactory.ITEMS_PER_PAGE /* 10 */:
                JsonObject jsonObject = new JsonObject();
                if (advanceToken(true, false) != 3) {
                    do {
                        int i2 = this.token;
                        if (i2 == 5 || i2 == 6 || i2 == 7) {
                            this.value = this.value.toString();
                        } else if (i2 != 8 && i2 != 12) {
                            throw this.tokener.createParseException(null, "Expected STRING, got " + this.token, true);
                        }
                        String str = (String) this.value;
                        if (this.token == 12) {
                            if (advanceToken(false, true) != 2) {
                                throw this.tokener.createParseException(null, "Expected COLON, got " + this.token, true);
                            }
                        } else if (advanceToken(false, false) != 2) {
                            throw this.tokener.createParseException(null, "Expected COLON, got " + this.token, true);
                        }
                        advanceToken(false, false);
                        jsonObject.put(str, currentValue());
                        if (advanceToken(false, false) != 3) {
                            if (this.token != 1) {
                                throw this.tokener.createParseException(null, "Expected a comma or end of the object instead of " + this.token, true);
                            }
                        }
                    } while (advanceToken(true, false) != 3);
                    throw this.tokener.createParseException(null, "Trailing object found in array", true);
                }
                this.value = jsonObject;
                i = 10;
                this.token = i;
                return i;
            case 11:
                JsonArray jsonArray = new JsonArray();
                if (advanceToken(false, false) != 4) {
                    do {
                        jsonArray.add(currentValue());
                        if (this.token == 12) {
                            throw this.tokener.createParseException(null, "Semi-string is not allowed in array", true);
                        }
                        if (advanceToken(false, false) != 4) {
                            if (this.token != 1) {
                                throw this.tokener.createParseException(null, "Expected a comma or end of the array instead of " + this.token, true);
                            }
                        }
                    } while (advanceToken(false, false) != 4);
                    throw this.tokener.createParseException(null, "Trailing comma found in array", true);
                }
                this.value = jsonArray;
                i = 11;
                this.token = i;
                return i;
            default:
                return this.token;
        }
    }

    public static JsonParserContext<Object> any() {
        return new JsonParserContext<>(Object.class);
    }

    public static JsonParserContext<JsonArray> array() {
        return new JsonParserContext<>(JsonArray.class);
    }

    private Object currentValue() throws JsonParserException {
        if (this.token >= 5) {
            return this.value;
        }
        throw this.tokener.createParseException(null, "Expected JSON value, got " + this.token, true);
    }

    public static JsonParserContext<JsonObject> object() {
        return new JsonParserContext<>(JsonObject.class);
    }

    private Number parseNumber() throws JsonParserException {
        String string = this.tokener.reusableBuffer.toString();
        try {
            if (this.tokener.isDouble) {
                return Double.valueOf(Double.parseDouble(string));
            }
            if (string.length() == 1) {
                return Integer.valueOf(string.charAt(0) - '0');
            }
            if (string.length() == 2 && string.charAt(0) == '-') {
                return Integer.valueOf('0' - string.charAt(1));
            }
            int i = string.charAt(0) == '-' ? 1 : 0;
            int length = i != 0 ? string.length() - 1 : string.length();
            if (length >= 10 && (length != 10 || string.charAt(i) >= '2')) {
                if (length >= 19 && (length != 19 || string.charAt(i) >= '9')) {
                    return new BigInteger(string);
                }
                return Long.valueOf(Long.parseLong(string));
            }
            return Integer.valueOf(Integer.parseInt(string));
        } catch (NumberFormatException e) {
            throw this.tokener.createParseException(e, "Malformed number: ".concat(string), true);
        }
    }

    public <T> T parse(Class<T> cls) throws JsonParserException, IOException {
        advanceToken(false, false);
        Object objCurrentValue = currentValue();
        if (advanceToken(false, false) != 0) {
            throw this.tokener.createParseException(null, "Expected end of input, got " + this.token, true);
        }
        if (cls == Object.class || (objCurrentValue != null && cls.isAssignableFrom(objCurrentValue.getClass()))) {
            return cls.cast(objCurrentValue);
        }
        throw this.tokener.createParseException(null, "JSON did not contain the correct type, expected " + cls.getSimpleName() + ".", true);
    }

    public final class JsonParserContext<T> {
        private final Class<T> clazz;
        private boolean lazyNumbers;

        public JsonParserContext(Class<T> cls) {
            this.clazz = cls;
        }

        public T from(URL url) throws JsonParserException, IOException {
            try {
                InputStream inputStreamOpenStream = url.openStream();
                try {
                    return from(inputStreamOpenStream);
                } finally {
                    inputStreamOpenStream.close();
                }
            } catch (IOException e) {
                throw new JsonParserException(e, "IOException opening URL", 1, 1, 0);
            }
        }

        public JsonParserContext<T> withLazyNumbers() {
            this.lazyNumbers = true;
            return this;
        }

        public T from(Reader reader) {
            return (T) new JsonParser(new JsonTokener(reader), this.lazyNumbers).parse(this.clazz);
        }

        public T from(String str) {
            return (T) new JsonParser(new JsonTokener(new StringReader(str)), this.lazyNumbers).parse(this.clazz);
        }

        public T from(InputStream inputStream) {
            return (T) new JsonParser(new JsonTokener(inputStream), this.lazyNumbers).parse(this.clazz);
        }
    }
}
