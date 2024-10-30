package programmer.zaman.now.validation.extractor;

import jakarta.validation.valueextraction.ExtractedValue;
import jakarta.validation.valueextraction.ValueExtractor;
import programmer.zaman.now.validation.container.Entry;

public class EntryValueExtractorValue implements ValueExtractor<Entry<?,@ExtractedValue ?>> {

    @Override
    public void extractValues(Entry<?, ?> entry, ValueReceiver valueReceiver) {
        valueReceiver.keyedValue(null, "value", entry.getValue());
    }
}
