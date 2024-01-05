package com.example.advancedjunit.testsuites;

import com.example.advancedjunit.parametrizedtests.CalculatorTest;
import com.example.advancedjunit.parametrizedtests.StringUtilsTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

/**
 * @author timo.buechert
 */
@Suite
@SuiteDisplayName("My Test Suite")
@SelectClasses({CalculatorTest.class, StringUtilsTest.class})
//@SelectPackages({"com.example.advancedjunit"})
//@IncludePackages("com.example.advancedjunit.parametrizedtests")
//@ExcludePackages("com.example.advancedjunit.parametrizedtests")
//@IncludeClassNamePatterns("com.example.advancedjunit.parametrizedtests.*Test")
//@ExcludeClassNamePatterns("com.baeldung.testsuite.StringUtilsTest")
//@ExcludeTags("slow")
//@SelectMethod("com.baeldung.testsuite.StringUtilsTest#testIsPalindromeCsvSource")
public class JUnitTestSuite {
}
