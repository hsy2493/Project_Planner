
 package com.web.projectplanner.a00_configure;
 /*
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.http.HttpMethod; import
 * org.springframework.security.authentication.
 * UsernamePasswordAuthenticationToken; import
 * org.springframework.security.config.Customizer; import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import org.springframework.security.config.annotation.web.configuration.
 * EnableWebSecurity; import
 * org.springframework.security.config.annotation.web.configurers.
 * AbstractHttpConfigurer; import
 * org.springframework.security.config.http.SessionCreationPolicy; import
 * org.springframework.security.core.context.SecurityContextHolder; import
 * org.springframework.security.web.SecurityFilterChain; import
 * org.springframework.security.web.authentication.
 * WebAuthenticationDetailsSource; import
 * org.springframework.security.web.util.matcher.AntPathRequestMatcher; import
 * org.springframework.util.AntPathMatcher; import
 * org.springframework.web.servlet.config.annotation.CorsRegistry; import
 * org.springframework.web.servlet.config.annotation.EnableWebMvc; import
 * org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
 *
 * import com.web.projectplanner.a02_service.ThrUserDetailService;
 *
 * @Configuration
 *
 * @EnableWebSecurity public class SpringSecurityConfig implements
 * WebMvcConfigurer {
 *
 * @Autowired ThrUserDetailService thrUserDetailService;
 *
 *
 * @Bean public SecurityFilterChain filterChain(HttpSecurity http) throws
 * Exception {
 *
 *
 * http.authorizeHttpRequests(auth -> auth .requestMatchers(new
 * AntPathRequestMatcher("/**")).permitAll()
 *
 * // .requestMatchers(new
 * AntPathRequestMatcher("\\freeBoardList\\**")).hasRole("user") //
 * .requestMatchers(new AntPathRequestMatcher("\\managmnt\\**")).hasRole("pm")
 *
 *
 * .anyRequest().authenticated()) .cors(Customizer.withDefaults())
 * .sessionManagement(session ->
 * session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
 * .csrf(AbstractHttpConfigurer::disable);
 *
 *
 * return http.build(); }
 *
 * @Bean
 *
 * public void settingUser() {
 *
 * var context = SecurityContextHolder.getContext(); var userDetails =
 * thrUserDetailService.loadUserByUsername(null);
 *
 * var authtoken = new UsernamePasswordAuthenticationToken(userDetails, null,
 * userDetails.getAuthorities());
 *
 * System.out.println(userDetails);
 * System.out.println(userDetails.getUsername());
 *
 * //authtoken.setDetails(new
 * WebAuthenticationDetailsSource().buildDetails(null));
 * context.setAuthentication(authtoken);
 * SecurityContextHolder.setContext(context); }
 *
 * @Override public void addCorsMappings(CorsRegistry registry) {
 * registry.addMapping("/**").allowedMethods(HttpMethod.GET.name(),
 * HttpMethod.HEAD.name(), HttpMethod.POST.name(), HttpMethod.PUT.name(),
 * HttpMethod.DELETE.name() ); }
 *
 *
 * }
 */