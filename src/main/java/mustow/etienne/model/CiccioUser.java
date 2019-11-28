package mustow.etienne.model;

import java.util.UUID;

public class CiccioUser {

    private UUID id;
    private String name;

    public CiccioUser(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("CiccioUser{id=%s, name='%s'}", id, name);
    }
}
