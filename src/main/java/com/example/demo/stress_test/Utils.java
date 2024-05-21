package com.example.demo.stress_test;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.experimental.UtilityClass;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@UtilityClass
public class Utils {

    public static final Set<Character> TAG_ESCAPE_CHARS = Set.of( //
            ',', '.', '<', '>', '{', '}', '[', //
            ']', '"', '\'', ':', ';', '!', '@', //
            '#', '$', '%', '^', '&', '*', '(', //
            ')', '-', '+', '=', '~', '|', '/' //
    );


    public static <T> List<T> load(Class<T> t, ObjectMapper objectMapper, String path)
            throws IOException {
        String jsonString =
                IOUtils.toString(
                        Objects.requireNonNull(t.getResourceAsStream(path)), StandardCharsets.UTF_8);
        return objectMapper.readValue(
                jsonString, objectMapper.getTypeFactory().constructCollectionType(List.class, t));
    }


    public static String escape(String text) {
        return escape(text, true);
    }

    public static String escape(String text, boolean querying) {
        var sb = new StringBuilder();
        char[] chars = text.toCharArray();

        for (char c : chars) {
            if (TAG_ESCAPE_CHARS.contains(c)) {
                sb.append("\\");
            }
            if (querying && c == ' ') {
                sb.append("\\");
            }
            sb.append(c);
        }

        return sb.toString();
    }
}
