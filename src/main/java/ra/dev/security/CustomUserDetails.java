package ra.dev.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ra.dev.model.entity.User;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class CustomUserDetails implements UserDetails {
    private int userId;
    private String userName;
    @JsonIgnore
    private String password;
    private String email;
    private String phone;
    private boolean userStatus;
    private String fullName;
    private String address;
    private Collection<? extends GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    //Tu thong tin user chuyen sang thong tin CustomUserDetails
    public static CustomUserDetails mapUserToUserDetail(User user) {
        //Lay cac quyen tu doi tuong user
        List<GrantedAuthority> listAuthorities = user.getListRoles().stream()
                .map(roles -> new SimpleGrantedAuthority(roles.getRoleName().name()))
                .collect(Collectors.toList());
        //Tra ve doi tuong CustomUserDetails
        return new CustomUserDetails(
                user.getUserID(),
                user.getUserName(),
                user.getPassword(),
                user.getEmail(),
                user.getPhoneNumber(),
                user.isUserStatus(),
                user.getFullName(),
                user.getAddress(),
                listAuthorities
        );

    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
