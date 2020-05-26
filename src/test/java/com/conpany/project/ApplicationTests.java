package com.conpany.project;

import org.junit.After;
import org.junit.Before;

public class ApplicationTests extends Tester {

    @Before
    public void init() {
        System.out.println("开始测试================");
    }

    @After
    public void after() {
        System.out.println("结束测试================");
    }
}
