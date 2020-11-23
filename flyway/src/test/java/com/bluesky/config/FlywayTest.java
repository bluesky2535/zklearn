package com.bluesky.config;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.*;

/**
 * @author zk
 * @date 2020/2/28 1:49
 */
public class FlywayTest {

    private  Logger logger;

    @Before
    public void setUp() throws Exception {
         logger = LoggerFactory.getLogger(getClass().getName());
         logger.info("start process");

    }

    @After
    public void tearDown() throws Exception {
        logger.info("end process");

    }

    @Test
    public void hah() {
        logger.info("running process");
    }
}