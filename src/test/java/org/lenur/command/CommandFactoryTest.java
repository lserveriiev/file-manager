package org.lenur.command;

import org.junit.Assert;
import org.junit.Test;

public class CommandFactoryTest {
    @Test
    public void createCreateCommand() {
        Command command = CommandFactory.create("create", new String[]{".", "test.txt"});
        Assert.assertNotNull(command);
        Assert.assertTrue(command instanceof Create);
    }

    @Test
    public void createReadCommand() {
        Command command = CommandFactory.create("read", new String[]{".", "test.txt"});
        Assert.assertNotNull(command);
        Assert.assertTrue(command instanceof Read);
    }

    @Test
    public void createInfoCommand() {
        Command command = CommandFactory.create("info", new String[]{".", "test.txt"});
        Assert.assertNotNull(command);
        Assert.assertTrue(command instanceof Info);
    }

    @Test
    public void createEmptyCommand() {
        Command command = CommandFactory.create("", new String[]{".", "test.txt"});
        Assert.assertNull(command);
    }
}