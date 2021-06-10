package com.sw.projekat;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.test.context.TestPropertySource;

@RunWith(Suite.class)
@Suite.SuiteClasses({OsobaTest.class,AutomobilTest.class,AutomobilAndOsobaTest.class})
@TestPropertySource("classpath:test.properties")
public class SuiteAll {

}
