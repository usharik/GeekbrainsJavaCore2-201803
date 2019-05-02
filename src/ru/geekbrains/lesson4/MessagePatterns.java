package ru.geekbrains.lesson4;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class MessagePatterns {

    public static final String AUTH_PATTERN = "/auth %s %s";
    public static final String AUTH_SUCCESS_RESPONSE = "/auth successful";
    public static final String AUTH_FAIL_RESPONSE = "/auth fail";

    public static final String DISCONNECT = "/disconnect";
    public static final String DISCONNECTED_SEND = DISCONNECT + " %s";
    public static final String CONNECTED = "/connected";
    public static final String CONNECTED_SEND = CONNECTED + " %s";

    public static final String CONTACTS = "/contacts";
    public static final String CONTACTS_LIST = "/contacts" + " %s";

    public static final String MESSAGE_PREFIX = "/w";
    public static final String MESSAGE_SEND_PATTERN = MESSAGE_PREFIX + " %s %s";

    public static final Pattern MESSAGE_REC_PATTERN = Pattern.compile("^/w (\\w+) (.+)", Pattern.MULTILINE);

    public static final String CHATSERVER = "chatServer";

    public static TextMessage parseTextMessageRegx(String text, String userTo) {
        Matcher matcher = MESSAGE_REC_PATTERN.matcher(text);
        if (matcher.matches()) {
            return new TextMessage(matcher.group(1), userTo,
                    matcher.group(2));
        } else {
            System.out.println("Unknown message pattern: " + text);
            return null;
        }
    }

    public static TextMessage parseTextMessage(String text, String userTo) {
        String[] parts = text.split(" ", 3);
        if (parts.length == 3 && parts[0].equals(MESSAGE_PREFIX)) {
            return new TextMessage(parts[1], userTo, parts[2], MESSAGE_PREFIX);
        } else {
            System.out.println("Unknown message pattern: " + text);
            return null;
        }
    }

    public static String parseConnectedMessage(String text) {
        String[] parts = text.split(" ");
        if (parts.length == 2 && parts[0].equals(CONNECTED)) {
            return parts[1];
        } else {
            System.out.println("Unknown message pattern: " + text);
            return null;
        }
    }

    public static TextMessage parseConnectedMessageToMess(String text) {
        String[] parts = text.split(" ");
        return new TextMessage(CHATSERVER,parts[1],null,CONNECTED);
        }

    public static TextMessage parseDisconnectMessage(String text, String userTo) {
        return new TextMessage(CHATSERVER, userTo, null, DISCONNECT);
    }

    public static TextMessage parseContactsMessage(String text, String userTo) {
        String[] parts = text.split(" ", 2);
        if (parts.length == 1) {
            //request
//            String[] contacts = parts[1].split( ", ");
//            return new TextMessage(CHATSERVER, userTo, "req");
            System.out.println("request: " + text);
            return new TextMessage(CHATSERVER, userTo, null, CONTACTS);
        } else if (parts.length == 2){
            System.out.println("Contact list: " + text);
            return new TextMessage(CHATSERVER, userTo, parts[1], CONTACTS);
        }else {
            System.out.println("Unknown message pattern: " + text);
            return null;
        }
    }

    public static TextMessage parseText(String text, String userTo) {
        String[] parts = text.split(" ", 3);
        TextMessage result = null;
        if (!parts[0].isEmpty()) {
            switch (parts[0]) {
                case MESSAGE_PREFIX:
                    result = parseTextMessage(text, userTo);
                    break;
                case CONNECTED:
                    result = parseConnectedMessageToMess(text);
                    break;
                case CONTACTS:
                    result = parseContactsMessage(text, userTo);
                    break;
                case DISCONNECT:
                    result = parseDisconnectMessage(text, userTo);
                    break;
                default:
                    System.out.println("Unknown message pattern: " + text);
                    result = null;
            }
        }
        return result;
    }
}
