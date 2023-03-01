package com.mywebnotebook.notebook.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


//Spring Security configuration in order to display custom login page
@Configuration
@EnableWebSecurity
public class WebSpringSecurity {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable().
                authorizeHttpRequests((authorize) ->
                        authorize.requestMatchers(new AntPathRequestMatcher("/resources/**")).permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/register/**")).permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/admin/**"))
                                .hasAnyRole("ADMIN")
                                .requestMatchers(new AntPathRequestMatcher("/")).permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/note/**")).permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/{noteUrl}/**")).permitAll()


                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/admin/notes")
                        .loginProcessingUrl("/login")
                        .permitAll()
                ).logout(logout -> logout.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .permitAll());
        return http.build();
    }
}
//    private UserDetailsService userDetailsService;
//
//    public WebSpringSecurity(UserDetailsService userDetailsService) {
//        this.userDetailsService = userDetailsService;
//    }
//
//    @Bean
//    public static PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.csrf().disable().
//                authorizeHttpRequests((authorize) ->
//                        authorize.requestMatchers(new AntPathRequestMatcher("/resources/**")).permitAll()
//                                .requestMatchers(new AntPathRequestMatcher("/register/**")).permitAll()
//                                .requestMatchers(new AntPathRequestMatcher("/admin/**"))
//                                .hasAnyRole("ADMIN", "GUEST")
//                                .requestMatchers(new AntPathRequestMatcher("/")).permitAll()
//                                .requestMatchers(new AntPathRequestMatcher("/note/**")).permitAll()
//                )
//                .formLogin(form -> form
//                        .loginPage("/login")
//                        .defaultSuccessUrl("/admin/notes")
//                        .loginProcessingUrl("/login")
//                        .permitAll()
//                ).logout(logout -> logout.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                        .permitAll()
//                );
//        return http.build();
//
//    }
//}
////
////    @Autowired
////    public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
////        builder.userDetailsService(userDetailsService)
////                .passwordEncoder(passwordEncoder());
////    }
////}
//
////    private UserDetailsService userDetailsService;
////
////    public WebSpringSecurity(UserDetailsService userDetailsService) {
////        this.userDetailsService = userDetailsService;
////    }
////
////    @Bean
////    public static PasswordEncoder passwordEncoder() {
////        return new BCryptPasswordEncoder();
////    }
////
////    @Bean
////    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
////        httpSecurity.csrf().disable()
////                .authorizeHttpRequests((authorize) ->
////                        authorize.requestMatchers(new AntPathRequestMatcher("/resources/**")).permitAll()
////                                .requestMatchers(new AntPathRequestMatcher("/register/**")).permitAll()
////                                .requestMatchers(new AntPathRequestMatcher("/admin/**"))
////                                .hasAnyRole("ADMIN", "GUEST")
////                                .requestMatchers(new AntPathRequestMatcher("/")).permitAll()
////                                .requestMatchers(new AntPathRequestMatcher("/note/**")).permitAll().anyRequest().authenticated()
////                )
////                .formLogin( form -> form.loginPage("/login")
////                        .defaultSuccessUrl("/admin/notes")
////                        .loginProcessingUrl("/login")
////                        .permitAll()
////                ).logout(logout -> logout.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
////                        .permitAll());
////        return httpSecurity.build();
////    }
////
////    @Autowired
////    public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
////        builder.userDetailsService(userDetailsService)
////                .passwordEncoder(passwordEncoder());
////    }
////}
