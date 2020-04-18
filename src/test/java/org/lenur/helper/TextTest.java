package org.lenur.helper;

import org.junit.Assert;
import org.junit.Test;

public class TextTest {
    private static final String TEXT = "Sed ut perspiciatis unde. omnis iste natus error sit voluptatem! accusantium doloremque.";
    private static final int COUNT_WORDS = 12;

    @Test
    public void countNotEmptyText() {
        int count = Text.countWords(TEXT);
        Assert.assertEquals(COUNT_WORDS, count);
    }

    @Test
    public void countEmptyText() {
        int count = Text.countWords("");
        Assert.assertEquals(0, count);
    }
}