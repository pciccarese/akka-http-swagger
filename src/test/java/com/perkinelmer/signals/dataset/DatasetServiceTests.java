package com.perkinelmer.signals.dataset;

import org.junit.Test;
import org.junit.Assert;

public class DatasetServiceTests {

	@Test
    public void multiplicationOfZeroIntegersShouldReturnZero() {
        DatasetService tester = new DatasetService();

        // assert statements
        Assert.assertEquals("10 x 0 must be 0", "Hello dataset", tester.getDataset("", ""));
    }
}
