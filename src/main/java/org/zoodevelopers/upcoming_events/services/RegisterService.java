package org.zoodevelopers.upcoming_events.services;

import java.util.HashSet;

import org.springframework.stereotype.Service;
import org.zoodevelopers.upcoming_events.dtos.UserDto;
import org.zoodevelopers.upcoming_events.implementations.events.IEncryptFacade;
import org.zoodevelopers.upcoming_events.repositories.UserRepository;

@Service
public class RegisterService {

    UserRepository repository;

    /* RoleService roleService; */
 /* IEncryptFacade encoderFacade; */
    public RegisterService(UserRepository repository, RoleService roleService, IEncryptFacade encoderFacade) {
        this.repository = repository;
        /* this.roleService = roleService;
        this.encoderFacade = encoderFacade; */
    }

    public String save(UserDto newUserDto) {

        String passwordDecoded = encoderFacade.decode("base64", newUserDto.getPassword());
        String passwordEncoded = encoderFacade.encode("bcrypt", passwordDecoded);

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
