package programmer.zaman.now.validation;

import jakarta.validation.metadata.BeanDescriptor;
import jakarta.validation.metadata.ConstraintDescriptor;
import jakarta.validation.metadata.PropertyDescriptor;
import org.junit.jupiter.api.Test;
import programmer.zaman.now.validation.data.Person;

import java.util.Set;

public class MetaDataTest extends AbstractValidatorTest{

    @Test
    void testPerson() {
        BeanDescriptor beanDescriptor =
                validator.getConstraintsForClass(Person.class);

        Set<PropertyDescriptor> constrainedProperties =
                beanDescriptor.getConstrainedProperties();

        constrainedProperties.forEach(constrain -> {
            System.out.println(constrain.getPropertyName());

            Set<ConstraintDescriptor<?>> descriptors =
                    constrain.getConstraintDescriptors();

            descriptors.forEach(descriptor -> {
                System.out.println(descriptor);
            });
        });

    }
}
