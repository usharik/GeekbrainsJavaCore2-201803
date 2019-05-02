package ru.geekbrains.lesson4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class MessagePatterns {

    public static final String AUTH_PATTERN = "/auth %s %s";
    public static final String AUTH_SUCCESS_RESPONSE = "/auth successful";
    public static final String AUTH_FAIL_RESPONSE = "/auth fail";

    public static final String DISCONNECTED = "/disconnected";
    public static final String DISCONNECTED_SEND = DISCONNECTED + " %s";
    public static final String CONNECTED = "/connected";
    public static final String CONNECTED_SEND = CONNECTED + " %s";
    public static final String ONLINE= "/online";
    public static final String ONLINE_SEND = ONLINE + " %s";

    public static final String MESSAGE_PREFIX = "/w";
    public static final String MESSAGE_SEND_PATTERN = MESSAGE_PREFIX + " %s %s";

    public static final Pattern MESSAGE_REC_PATTERN = Pattern.compile("^/w (\\w+) (.+)", Pattern.MULTILINE);

    public static TextMessage parseTextMessageRegx(String text, String userTo) {
        Matcher matcher = MESSAGE_REC_PATTERN.matcher(text);
        if (matcher.matches()) {
            return new TextMessage(matcher.group(1), userTo, matcher.group(2));
        } else {
            System.out.println("Unknown message pattern(parseTextMessageRegx): " + text);
            return null;
        }
    }

    public static TextMessage parseTextMessage(String text, String userTo) {
        String[] parts = text.split(" ", 3);
        if (parts.length == 3 && parts[0].equals(MESSAGE_PREFIX)) {
            return new TextMessage(parts[1], userTo, parts[2]);
        } else {
            System.out.println("Unknown message pattern(parseTextMessage): " + text);
            return null;
        }
    }

    public static String parseConnectedMessage(String text) {
        String[] parts = text.split(" ");
        if (parts.length == 2 && parts[0].equals(CONNECTED)) {
            return parts[1];
        } else {
            System.out.println("Unknown message pattern(parseConnectedMessage): " + text);
            return null;
        }
    }

    public static String parseDisconnectedMessage(String text) {
        String[] parts = text.split(" ");
        if (parts.length == 2 && parts[0].equals(DISCONNECTED)) {
            return parts[1];
        } else {
            System.out.println("Unknown message pattern(parseDisconnectedMessage): " + text);
            return null;
        }
    }

    public static String[] parseOnlineMessage(String text) {
        String[] parts = text.split(" ");
        if (parts.length > 0 && parts[0].equals(ONLINE)) {
            return parts;
        } else {
            System.out.println("Unknown message pattern: " + text);
            return null;
        }
    }

}
