package programmer_zaman_now.Java_Reflection.validations;

import programmer_zaman_now.Java_Reflection.annotations.NotBlank;

import java.lang.reflect.Field;

public class Validator {

    public static void validateNotBlank(Object object) throws IllegalAccessException {
        // ambil class
        Class<?> aClass = object.getClass();

        // ambil semua field
        Field[] fields = aClass.getDeclaredFields();

        // iterate field
        for(Field field : fields) {

            // ambil annotations NotBlank
            NotBlank notBlank = field.getAnnotation(NotBlank.class);

            // cek @NotBlank is Exist
            if(notBlank != null) {
                field.setAccessible(true);
                String value = (String) field.get(object);


                if(notBlank.allowEmptyString()) {
                // jika allowEmptyString, maka ignore

                } else {
                    value = value.trim();
                }

                // cek jika value is empty string
                if("".equals(value)) {
                    // throw error
                    throw new RuntimeException(field.getName() + " must not be blank");
                } else {
                    System.out.println(field.getName() + ": " + value);
                }
            }
        }
    }
}
