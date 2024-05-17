package com.project.pet.entity.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

    private int userId;
    private String username;
    private String password;
    private String name;
    private String address;
    private String detailAddress;
    private String telNumber;
    private String nickname;
    private String email;
    private String profileImageUrl;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    private List<RoleRegister> roleRegisters;

    public List<SimpleGrantedAuthority> getAuthorities() {
        return roleRegisters.stream()
                .map(roleRegister ->
                        new SimpleGrantedAuthority(roleRegister.getRole().getRoleName()))
                .collect(Collectors.toList());
    }

    public String addHyphenToTelNumber(String telNumber) {
        if (telNumber.length() == 9 || telNumber.length() == 10) {
            return telNumber.replaceFirst("(\\d{3})(\\d{3,4})(\\d+)", "$1-$2-$3");
        }
        else if (telNumber.length() == 11) {
            return telNumber.replaceFirst("(\\d{3})(\\d{4})(\\d{4})", "$1-$2-$3");
        }
        else {
            return telNumber;
        }
    }

    public PrincipalUser toPrincipalUser() {
        return PrincipalUser.builder()
                .userId(userId)
                .username(username)
                .name(name)
                .address(address)
                .detailAddress(detailAddress)
                .telNumber(addHyphenToTelNumber(telNumber))
                .nickname(nickname)
                .email(email)
                .profileImageUrl(profileImageUrl)
                .authorities(getAuthorities())
                .build();
    }

}
