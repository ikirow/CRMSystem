package interfaces;

import com.clientManagementSystem.Client;

import java.io.Serializable;
import java.util.List;

public interface Reader {
    List<Client> read(List<Serializable> items, String path);
}
