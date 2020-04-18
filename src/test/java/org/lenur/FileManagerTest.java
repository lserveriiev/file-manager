package org.lenur;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.lenur.helper.Text;

public class FileManagerTest {
    private static final String[][] ACTION_EXIT = {{"exit"}};
    private static final String[][] ACTION_CREATE_WRONG = {{"create", "test", "test.txt", "Test text!"}, {"exit"}};
    private static final String[][] ACTION_CREATE_CORRECT = {{"create", ".", "test.txt", "Test text!"}, {"exit"}};
    private static final String[][] ACTION_READ = {{"read", ".", "test.txt"}, {"exit"}};
    private static final String[][] ACTION_INFO = {{"info", ".", "test.txt"}, {"exit"}};
    private static final Pattern PATTERN_SYMBOLS = Pattern.compile("Count of symbols:\\s+(\\d+)");
    private static final Pattern PATTERN_WORDS = Pattern.compile("Count of words:\\s+(\\d+)");
    private static final Pattern PATTERN_SIZE = Pattern.compile("Size of the file:\\s+(\\d+)");

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void runExit() {
        FileManager fileManager = new FileManager();
        fileManager.run(new InputHelper(ACTION_EXIT));
        Assert.assertEquals("The program has finished!", outContent.toString());
    }

    @Test
    public void runCreateWithNotExistsFolder() {
        FileManager fileManager = new FileManager();
        fileManager.run(new InputHelper(ACTION_CREATE_WRONG));
        Assert.assertTrue(outContent.toString().contains("No such file or directory"));
    }

    @Test
    public void runCreate() {
        FileManager fileManager = new FileManager();
        fileManager.run(new InputHelper(ACTION_CREATE_CORRECT));

        FileHelper fileHelper = new FileHelper(ACTION_CREATE_CORRECT[0][1], ACTION_CREATE_CORRECT[0][2]);
        Assert.assertTrue(fileHelper.fileExist());
        Assert.assertEquals(ACTION_CREATE_CORRECT[0][3], fileHelper.getText());
    }

    @Test
    public void runRead() {
        FileManager fileManager = new FileManager();
        fileManager.run(new InputHelper(ACTION_READ));

        FileHelper fileHelper = new FileHelper(ACTION_READ[0][1], ACTION_READ[0][2]);
        Assert.assertEquals(outContent.toString().replace("The program has finished!", ""), fileHelper.getText());
    }

    @Test
    public void runInfoCountSymbols() {
        FileManager fileManager = new FileManager();
        fileManager.run(new InputHelper(ACTION_INFO));

        String text = outContent.toString();
        FileHelper fileHelper = new FileHelper(ACTION_INFO[0][1], ACTION_INFO[0][2]);
        Matcher matcher = PATTERN_SYMBOLS.matcher(text);

        if (matcher.find()) {
            Assert.assertEquals(fileHelper.getText().length(), Integer.parseInt(matcher.group(1)));
        } else {
            Assert.fail();
        }
    }

    @Test
    public void runInfoCountWord() {
        FileManager fileManager = new FileManager();
        fileManager.run(new InputHelper(ACTION_INFO));

        String text = outContent.toString();
        FileHelper fileHelper = new FileHelper(ACTION_INFO[0][1], ACTION_INFO[0][2]);
        Matcher matcher = PATTERN_WORDS.matcher(text);

        if (matcher.find()) {
            int expected = Text.countWords(fileHelper.getText());
            int actual = Integer.parseInt(matcher.group(1));
            Assert.assertEquals(expected, actual);
        } else {
            Assert.fail();
        }
    }

    @Test
    public void runInfoSize() {
        FileManager fileManager = new FileManager();
        fileManager.run(new InputHelper(ACTION_INFO));

        String text = outContent.toString();
        FileHelper fileHelper = new FileHelper(ACTION_INFO[0][1], ACTION_INFO[0][2]);
        Matcher matcher = PATTERN_SIZE.matcher(text);

        if (matcher.find()) {
            Assert.assertEquals(fileHelper.getFileSize(), Long.parseLong(matcher.group(1)));
        } else {
            Assert.fail();
        }
    }
}