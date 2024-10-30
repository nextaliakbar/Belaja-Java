package programmer_zaman_now.Java_Reflection;

import org.junit.jupiter.api.Test;
import programmer_zaman_now.Java_Reflection.data.Person;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class ParamterTest {

    @Test
    void testGetParamater() {
        Class<Person> personClass = Person.class;
        Method[] declaredMethods = personClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod.getName());
            Parameter[] parameters = declaredMethod.getParameters();
            for (Parameter parameter : parameters) {
                System.out.println("Paramater Name : " + parameter.getName());
                System.out.println("Paramater Type : " + parameter.getType());
                System.out.println("Paramater Modifier : " + parameter.getModifiers());
                System.out.println("Paramater Annotaions : " + parameter.getAnnotations());
            }
            System.out.println("===============");
        }
    }

    @Test
    void testInvokeMethodWithParamater() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<Person> personClass = Person.class;
        Method setFirstName = personClass.getDeclaredMethod("setFirstName", String.class);

        Person person = new Person("Akbar", "Rafsanjani");

        setFirstName.invoke(person, "Joko");

        System.out.println(person.getFirstName());
    }
}
