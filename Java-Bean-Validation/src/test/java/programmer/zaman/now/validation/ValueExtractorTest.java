package programmer.zaman.now.validation;

import org.junit.jupiter.api.Test;
import programmer.zaman.now.validation.container.Data;
import programmer.zaman.now.validation.container.DataInteger;
import programmer.zaman.now.validation.container.Entry;
import programmer.zaman.now.validation.data.SampleData;
import programmer.zaman.now.validation.data.SampleEntry;
import programmer.zaman.now.validation.data.SampleInteger;

public class ValueExtractorTest extends AbstractValidatorTest{

    @Test
    void testSampleData() {
        SampleData data = new SampleData();
        data.setData(new Data<>());
        data.getData().setData("    ");

        validate(data);
    }

    @Test
    void testSampleEntry() {
        SampleEntry entry = new SampleEntry();
        entry.setEntry(new Entry<>());
        entry.getEntry().setKey("   ");
        entry.getEntry().setValue("     ");

        validate(entry);
    }

    @Test
    void testSampleDataInteger() {
        SampleInteger data = new SampleInteger();
        data.setData(new DataInteger());
        data.getData().setData(0);

        validate(data);
    }
}
