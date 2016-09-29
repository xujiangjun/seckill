package org.seckill.junit;

import com.google.gson.Gson;
import org.junit.Test;
import org.seckill.entity.Person;
import org.seckill.entity.Student;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 反射 测试用例
 * @author xujiangjun
 * @date 2016-09-19 22:13
 */
public class ReflectTest {

    public static void main(String[] args) {
        System.out.println();
    }

    @Test
    public void ClassTest(){
        System.out.println(Person.class.getName());
        System.out.println(Person.class.getSimpleName());
        System.out.println(Student.class.getSuperclass());
        System.out.println(new Gson().toJson(Person.class.getInterfaces()));
        Class<Student> stuClazz = Student.class;
        Method[] methods = stuClazz.getDeclaredMethods();
        System.out.println("Class getDeclaredMethods");
        for (int i = 0; i < methods.length; i++) {
            Method method = methods[i];
            System.out.println(method.getName());
        }
        Method[] publicMethods = stuClazz.getMethods();
        System.out.println("Class getMethods()");
        for (int i = 0; i < publicMethods.length; i++) {
            Method publicMethod = publicMethods[i];
            System.out.println(publicMethod.getName());
        }
    }

    @Test
    public void FieldTest(){
        Class clazz = Student.class;
        try {
            Field field = clazz.getDeclaredField("stuNo");
            System.out.println(field.getType());
            Method method = clazz.getMethod("setName", String.class);
            Class[] parameterTypes = method.getParameterTypes();
            //Array.newInstance();
            //System.arraycopy();
            Array.getLength(parameterTypes);
            System.out.println(method.getReturnType());
            method.getModifiers();
            //Proxy.newProxyInstance();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

}
