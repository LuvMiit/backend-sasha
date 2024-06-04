package org.rusgidro.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.rusgidro.dto.RegisterDTO;
import org.rusgidro.entity.Employee;
import org.rusgidro.repos.EmployeeRepo;
import org.rusgidro.repos.PostRepo;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeService implements UserDetailsService {
    private final EmployeeRepo employeeRepo;
    private final PostService postService;


    public boolean registerNewUser(RegisterDTO registerDTO){
        if(employeeRepo.findByEmployeeLogin(registerDTO.getLogin()).isPresent()){
            return false;
        }else{
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            Employee newUser = new Employee();
            newUser.setEmployeeName(registerDTO.getName());
            newUser.setEmployeeSurname(registerDTO.getSurname());
            newUser.setEmployeePatronymic(registerDTO.getPatronimyc());
            newUser.setEmployeeLogin(registerDTO.getLogin());
            newUser.setEmployeePassword(bCryptPasswordEncoder.encode(registerDTO.getPass()));
            newUser.setPosts(List.of(postService.getPostByName(registerDTO.getPost())));
            employeeRepo.save(newUser);
            return true;
        }

    }






    ////SECURITY////
    public Optional<Employee> findByLogin(String login){
        return employeeRepo.findByEmployeeLogin(login);
    }
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Employee user = findByLogin(login).orElseThrow(()->new UsernameNotFoundException(
                "Пользователь с данным login не найден"));
        return new User(
                user.getUsername(),
                user.getPassword(),
                user.getPosts().stream().map(role -> new SimpleGrantedAuthority(role.getPostName())).collect(Collectors.toList())
        );
    }
}
