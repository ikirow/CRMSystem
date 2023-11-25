package interfaces;

import java.io.Serializable;
import java.util.List;

public interface Writer {
    void write(List<Serializable> items, String path);
}
