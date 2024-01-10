package com.example.advancedjunit.reflections;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author timo.buechert
 * <p>
 * Use cases for
 */
public class ReflectionUtilsTest {

    static class TestClass {
        private final String privateField = "privateField";
        public final String publicField = "publicField";
        protected final String protectedField = "protectedField";
        final String packagePrivateField = "packagePrivateField";

        private String privateMethod() {
            return "private";
        }

        public String publicMethod() {
            return "public";
        }

        protected String protectedMethod() {
            return "protected";
        }

        String packagePrivateMethod() {
            return "packagePrivate";
        }
    }

    @Test
    void testPrivateMethod() {
        //given
        final Method privateMethod = ReflectionUtils.findMethod(TestClass.class, "privateMethod").get();

        //when
        final Object result = ReflectionUtils.invokeMethod(privateMethod, new TestClass());

        //then
        assertEquals("private", result);
    }

    @Test
    void testPrivateField() throws Exception {
        //given
        final List<Field> privateFields = ReflectionUtils.findFields(TestClass.class, field -> field.getName().equals("privateField"),
                ReflectionUtils.HierarchyTraversalMode.TOP_DOWN);
        final Field privateField = privateFields.get(0);

        //when
        final Object result = ReflectionUtils.tryToReadFieldValue(privateField, new TestClass()).get();

        //then
        assertEquals("privateField", result);
    }
}
