package interfaces;

import com.clientManagementSystem.Client;

import java.io.Serializable;
import java.util.List;

public interface Writer {
    void write(List<Client> items, String path);
}
