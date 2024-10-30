package programmer.zaman.now.validation.data;

import jakarta.validation.constraints.Min;
import programmer.zaman.now.validation.container.DataInteger;

public class SampleInteger {

    @Min(value = 10)
    private DataInteger data;

    public DataInteger getData() {
        return data;
    }

    public void setData(DataInteger data) {
        this.data = data;
    }
}
