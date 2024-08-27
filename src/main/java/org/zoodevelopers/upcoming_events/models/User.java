// package org.zoodevelopers.upcoming_events.models;
// import java.util.Set;
// import jakarta.persistence.CascadeType;
// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.FetchType;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.JoinTable;
// import jakarta.persistence.ManyToMany;
// import jakarta.persistence.OneToOne;
// import jakarta.persistence.Table;
// @Entity
// @Table(name = "users")
// public class User {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     @Column(name = "id")
//     private Long id;
//     @Column(name = "username")
//     private String username;
//     @Column(name = "password")
//     private String password;
//     @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//     private Profile profile;
//     @Column(name = "roles")
//     @ManyToMany(fetch = FetchType.EAGER)
//     @JoinTable(name = "roles_users", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
//     Set<Role> roles;
//     public User() {
//     }
//     public User(Long id, String username, String password, Profile profile) {
//         this.id = id;
//         this.username = username;
//         this.password = password;
//         this.profile = profile;
//     }
//     public Long getId() {
//         return id;
//     }
//     public void setId(Long id) {
//         this.id = id;
//     }
//     public String getUsername() {
//         return username;
//     }
//     public void setUsername(String username) {
//         this.username = username;
//     }
//     public String getPassword() {
//         return password;
//     }
//     public void setPassword(String password) {
//         this.password = password;
//     }
//     public Profile getProfile() {
//         return profile;
//     }
//     public void setProfile(Profile profile) {
//         this.profile = profile;
//     }
//     public Set<Role> getRoles() {
//         return roles;
//     }
//     public void setRoles(Set<Role> roles) {
//         this.roles = roles;
//     }
// }
package org.zoodevelopers.upcoming_events.models;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @ManyToMany
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;

    // Default constructor
    public User() {
    }

    // Constructor with all fields
    public User(String username, String password, Set<Role> roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
