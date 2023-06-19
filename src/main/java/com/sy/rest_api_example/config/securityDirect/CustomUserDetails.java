package com.sy.rest_api_example.config.securityDirect;

import com.sy.rest_api_example.entity.Member;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

@Getter
public class CustomUserDetails implements UserDetails {
        //UserDetails에서 기본 getter가 필요한 fields
        private String username;                                            // DB의 P.K
        private String password;                                     // DB의 비밀번호
        private boolean accountNonLocked =true;                      // 계정 잠금 여부
        private boolean accountNonExpired =true ;                    // 사용자 계정 만료 없음
        private boolean credentialsNonExpired =true ;                // 비밀번호 만료 없음
        private boolean enabled =true;                               // 사용자 활성화 여부
        private Collection<? extends GrantedAuthority> authorities;  // 사용자 권한 목록

        // 추가로 설정하고 싶은 내용
        private String realName;                 // 사용자의 진짜 이름

        public CustomUserDetails(Member member) {
            this.username = member.getUserId();
            this.password = member.getPassword();
            this.realName = member.getName();
            Collection<GrantedAuthority> roles =
                            member.getRoles().stream().map(role -> new SimpleGrantedAuthority(username))
                                    .collect(Collectors.toList());
            this.authorities = roles;
        }

}
