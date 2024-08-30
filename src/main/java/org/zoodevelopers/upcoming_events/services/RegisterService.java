package org.zoodevelopers.upcoming_events.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.zoodevelopers.upcoming_events.dtos.UserDto;
import org.zoodevelopers.upcoming_events.implementations.IEncryptFacade;
import org.zoodevelopers.upcoming_events.models.Role;
import org.zoodevelopers.upcoming_events.models.User;
import org.zoodevelopers.upcoming_events.repositories.UserRepository;

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

// package org.zoodevelopers.upcoming_events.services;
// import java.util.HashSet;
// import java.util.Set;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;
// import org.zoodevelopers.upcoming_events.dtos.UserDto;
// import org.zoodevelopers.upcoming_events.implementations.IEncryptFacade;
// import org.zoodevelopers.upcoming_events.models.Role;
// import org.zoodevelopers.upcoming_events.models.User;
// import org.zoodevelopers.upcoming_events.repositories.UserRepository;
// @Service
// public class RegisterService {
//     private final UserRepository repository;
//     private final RoleService roleService;
//     private final IEncryptFacade encoderFacade;
//     @Autowired
//     public RegisterService(UserRepository repository, RoleService roleService, IEncryptFacade encoderFacade) {
//         this.repository = repository;
//         this.roleService = roleService;
//         this.encoderFacade = encoderFacade;
//     }
//     public String save(UserDto newUserDto) {
//         // Decodifica la contraseña y luego codifícala
//         String passwordDecoded = encoderFacade.decode("base64", newUserDto.getPassword());
//         String passwordEncoded = encoderFacade.encode("bcrypt", passwordDecoded);
//         // Crea un nuevo usuario usando el constructor adecuado
//         User user = new User(newUserDto.getUsername(), passwordEncoded, assignDefaultRole());
//         // Guarda el usuario en el repositorio
//         repository.save(user);
//         return "Success";
//     }
//     public Set<Role> assignDefaultRole() {
//         Role defaultRole = roleService.getById(1L);
//         Set<Role> roles = new HashSet<>();
//         roles.add(defaultRole);
//         return roles;
//     }
// }
