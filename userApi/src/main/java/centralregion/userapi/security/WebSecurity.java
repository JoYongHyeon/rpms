package centralregion.userapi.security;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity // 스프링 시큐리티 활성화
@RequiredArgsConstructor
public class WebSecurity {

//    private final CustomAuthenticationManager customAuthenticationManager;
//    private final UserFindPort userFindPort;
//    private final Environment environment;

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().
                requestMatchers(new AntPathRequestMatcher("/users/**"))
                .requestMatchers(new AntPathRequestMatcher("/h2-console/**"))
                .requestMatchers(new AntPathRequestMatcher( "/favicon.ico"))
                .requestMatchers(new AntPathRequestMatcher( "/css/**"))
                .requestMatchers(new AntPathRequestMatcher( "/js/**"))
                .requestMatchers(new AntPathRequestMatcher( "/img/**"))
                .requestMatchers(new AntPathRequestMatcher( "/lib/**"));
    }

//    @Bean
//    protected SecurityFilterChain filterChain(HttpSecurity http, HandlerMappingIntrospector introspector) throws Exception {
//        http.csrf(AbstractHttpConfigurer::disable);
//        http.authorizeHttpRequests(authorize ->
//                        authorize.requestMatchers(new MvcRequestMatcher(introspector, "/**")).permitAll()
//                                .anyRequest()
//                                .authenticated())
//                .addFilter(getAuthenticationFilter())
//                .httpBasic(Customizer.withDefaults());
//        return http.build();
//    }

//    private AuthenticationFilter getAuthenticationFilter() {
//        return new AuthenticationFilter(customAuthenticationManager, userFindPort, environment);
//    }
}
