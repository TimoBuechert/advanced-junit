package com.example.advancedjunit.reflections;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.ReflectionUtils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author timo.buechert
 * <p>
 * Use cases for
 */
public class ReflectionUtilsTest {

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface SlowMethod {
    }

    static class TestClass {
        private String privateField = "privateField";
        public String publicField = "publicField";

        protected String protectedField = "protectedField";
        final String packagePrivateField = "packagePrivateField";

        public String getPrivateField() {
            return privateField;
        }

        @SlowMethod
        private String privateMethod() {
            return "private";
        }

    }

    @Test
    void testInvokePrivateMethod() {
        //given
        final Method privateMethod = ReflectionUtils.findMethod(TestClass.class, "privateMethod").get();

        //when
        final Object result = ReflectionUtils.invokeMethod(privateMethod, new TestClass());

        //then
        assertEquals("private", result);
    }

    @Test
    void testGetPrivateField() throws Exception {
        //given
        final List<Field> privateFields = ReflectionUtils.findFields(TestClass.class, field -> field.getName().equals("privateField"),
                ReflectionUtils.HierarchyTraversalMode.TOP_DOWN);
        final Field privateField = privateFields.get(0);

        //when
        final Object result = ReflectionUtils.tryToReadFieldValue(privateField, new TestClass()).get();

        //then
        assertEquals("privateField", result);
    }

    @Test
    void testModifyPrivateField() throws Exception {
        //given
        final TestClass testClass = new TestClass();

        final Field privateField = testClass.getClass().getDeclaredField("privateField");
        privateField.setAccessible(true);

        //when
        privateField.set(testClass, "privateFieldModified");

        //then
        assertEquals("privateFieldModified", testClass.getPrivateField());
    }

    @Test
    void testInvokeMethodWithAnnotation() {
        //given
        final TestClass testClass = new TestClass();

        final Method slowMethod =
                Arrays.stream(testClass.getClass().getDeclaredMethods()).
                        filter(method -> Arrays.stream(method.getAnnotations()).anyMatch(annotation -> annotation instanceof SlowMethod))
                        .findFirst().get();

        //when
        final Object result = ReflectionUtils.invokeMethod(slowMethod, new TestClass());

        //then
        assertEquals("private", result);
    }
}
