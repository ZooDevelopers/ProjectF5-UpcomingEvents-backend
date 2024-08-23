package org.zoodevelopers.upcoming_events.services;

import org.springframework.stereotype.Service;
import org.zoodevelopers.upcoming_events.dtos.UserDto;

@Service
public class RegisterService {

    UserRepository repository;
    RoleService roleService;
    IEncryptFacade encoderFacade;

    public RegisterService(UserRepository repository, RoleService roleService, IEncryptFacade encoderFacade) {
        this.repository = repository;
        this.roleService = roleService;
        this.encoderFacade = encoderFacade;
    }

    public String save(UserDto newUserDto) {

        String passwordDecoded = encoderFacade.decode("base64", newUserDto.getPassword());
        String passwordEncoded = encoderFacade.encode("bcrypt",  passwordDecoded);

        User user = new User(newUserDto.getUsername(), passwordEncoded);
        user.setRoles(assignDefaultRole());

        repository.save(user);

        return "Success";
    }

    public Set<Role> assignDefaultRole() {
        Role defaultRole = roleService.getById(1L);

        Set<Role> roles = new HashSet<>();
        roles.add(defaultRole);

        return roles;
    }

}
