package co.edu.ucentral.GestionDeEmprendimientos.config;
/*
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers( "/public/**").permitAll()  // Permitir acceso a estas rutas sin autenticación
                        .anyRequest().authenticated()                                        // Restringir acceso a las demás rutas
                )
                .formLogin(form -> form
                        .loginPage("/")                                                 // Página de inicio de sesión personalizada
                        .defaultSuccessUrl("/", true)                                    // Redirige a /home después de inicio de sesión exitoso
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/")                                                // URL para cerrar sesión
                        .logoutSuccessUrl("/")                                          // Redirige a /index después de cerrar sesión
                        .permitAll()
                );

        return http.build();
    }
}
*/
