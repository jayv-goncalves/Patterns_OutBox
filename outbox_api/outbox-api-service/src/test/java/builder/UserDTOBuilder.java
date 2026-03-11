package builder;

import com.patterns.outbox_api.dtos.UserDTO;

public class UserDTOBuilder {
    public String id;
    public String name;
    public Long money;

    public UserDTOBuilder() {}

    public UserDTO build() {
        return new UserDTO(id, name, money);
    }

    public UserDTOBuilder id(String id) {
        this.id = id;
        return this;
    }

    public UserDTOBuilder name(String name) {
        this.name = name;
        return this;
    }

    public UserDTOBuilder money(Long money) {
        this.money = money;
        return this;
    }
}
