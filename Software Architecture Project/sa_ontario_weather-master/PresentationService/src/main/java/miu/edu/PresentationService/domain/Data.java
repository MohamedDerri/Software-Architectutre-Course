package miu.edu.PresentationService.domain;

import java.util.ArrayList;
import java.util.Collection;

public class Data {
    private Collection<OntarioEnergy> data = new ArrayList<>();

    public Data() {
    }

    public Data(Collection<OntarioEnergy> data) {
        this.data = data;
    }

    public Collection<OntarioEnergy> getData() {
        return data;
    }

    public void setData(Collection<OntarioEnergy> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Data{" +
                "data=" + data +
                '}';
    }
}
