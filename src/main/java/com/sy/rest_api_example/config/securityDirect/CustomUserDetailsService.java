package com.sy.rest_api_example.config.securityDirect;

import com.sy.rest_api_example.entity.Member;
import com.sy.rest_api_example.entity.Role;
import com.sy.rest_api_example.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;
    @SneakyThrows
    @Override
    public CustomUserDetails loadUserByUsername(String loginId) {

        log.debug("**스프링시큐리터 회원정보조회 loadUserByUsername loginId:{}", loginId);

        final Member member = memberRepository.findByUserIdAndDelAt(loginId, "N");

        /*account.setAuthorities(
                Stream.concat(
                        getRoles(account.getRoles()).stream(),

                ).collect(Collectors.toList())
        );*/
        member.setRoles(member.getRoles());

        return new CustomUserDetails(member);
    }

    private Set<SimpleGrantedAuthority> getRoles(List<Role> roles) {
        return roles.stream()
                .map(Role::getRoleName)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toSet());
    }

}
