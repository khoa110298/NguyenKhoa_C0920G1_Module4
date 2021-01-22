package vn.codegym.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import vn.codegym.service.impl.MyUserDetailServiceImpl;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailServiceImpl myUserDetailService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin()
                .defaultSuccessUrl("/blog")
                .permitAll()
                .and()
                .authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/blog/list").hasAnyRole("ADMIN", "MEMBER", "GUEST")
                .antMatchers("/blog/create").hasRole("ADMIN")
                .antMatchers("/blog/{id}/update").hasRole("ADMIN")
                .antMatchers("/blog/{id}/view").hasRole("ADMIN")
                .antMatchers("/blog/{id}/delete").hasRole("ADMIN")
                .antMatchers("/blog/{id}/view").hasRole("MEMBER")
                .anyRequest().authenticated();
                http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/blog/error");

        // Cấu hình cho Login Form.
//        http.authorizeRequests().and().formLogin()//
//                // Submit URL của trang login
//                .loginProcessingUrl("/j_spring_security_check") // Bạn còn nhớ bước 3 khi tạo form login thì action của nó là j_spring_security_check giống ở
//                .loginPage("/login")//
//                .defaultSuccessUrl("/userAccountInfo")//đây Khi đăng nhập thành công thì vào trang này. userAccountInfo sẽ được khai báo trong controller để hiển thị trang view tương ứng
//                .failureUrl("/login?error=true")// Khi đăng nhật sai username và password thì nhập lại
//                .usernameParameter("username")// tham số này nhận từ form login ở bước 3 có input  name='username'
//                .passwordParameter("password")// tham số này nhận từ form login ở bước 3 có input  name='password'
//                // Cấu hình cho Logout Page. Khi logout mình trả về trang
//                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/logoutSuccessful");

        // Cấu hình Remember Me . Ở form login bước 3, ta có 1 nút remember me. Nếu người dùng tick vào đó ta sẽ dung cookie lưu lại trong 24h

//        http.authorizeRequests().and() //
//                .rememberMe().tokenRepository(this.persistentTokenRepository()) //
//                .tokenValiditySeconds(1 * 24 * 60 * 60); // 24h


    }
//        public static void main(String[] args) {
//        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//        String pass = bCryptPasswordEncoder.encode("12345");
//        System.out.println(pass);
//        }
}
