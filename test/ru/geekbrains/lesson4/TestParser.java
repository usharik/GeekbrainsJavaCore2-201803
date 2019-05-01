package ru.geekbrains.lesson4;

import org.junit.Test;

import static org.junit.Assert.*;
import static ru.geekbrains.lesson4.MessagePatterns.*;

/**
 * Unit тесты для различных методов сетевого чата
 * Прежде чем запускать, необходимо отметить папку test как Test Source Root
 */
public class TestParser {

    @Test
    public void testParser() {
        TextMessage textMessage = parseTextMessage("/w userFrom Example of message", "userTo");

        assertNotNull(textMessage);
        assertEquals("userFrom", textMessage.getUserFrom());
        assertEquals("Example of message", textMessage.getText());
        assertEquals("userTo", textMessage.getUserTo());
    }

    @Test
    public void testParserRegx() {
        TextMessage textMessage = parseTextMessageRegx("/w userFrom Example of message", "userTo");

        assertNotNull(textMessage);
        assertEquals("userFrom", textMessage.getUserFrom());
        assertEquals("Example of message", textMessage.getText());
        assertEquals("userTo", textMessage.getUserTo());
    }

    @Test
    public void testParseConnectedMessage() {
        // написать тест для метода MessagePattern.ParseConnectedMessage
        TextMessage textMessage = parseConnectedMessageToMess("/connected login");
        assertNotNull(textMessage);
        assertEquals("login", textMessage.getUserTo());
        assertEquals(CONNECTED, textMessage.getMessageType());
    }

    // написать тесты для новых парсеров, если они будут добавлены при выполнении остальных заданий
    @Test
    public void parseTextForMessage() {
        TextMessage textMessage = parseText("/w userFrom Example of message", "userTo");
        assertNotNull(textMessage);
        assertEquals("userFrom", textMessage.getUserFrom());
        assertEquals("Example of message", textMessage.getText());
        assertEquals("userTo", textMessage.getUserTo());
    }

    @Test
    public void parseTextForContacts() {
        TextMessage textMessage = parseText("/contacts [ivan, petr]", "userTo");
        assertNotNull(textMessage);
        assertEquals("chatServer", textMessage.getUserFrom());
        assertEquals("[ivan, petr]", textMessage.getText());
        assertEquals("userTo", textMessage.getUserTo());
    }
}
