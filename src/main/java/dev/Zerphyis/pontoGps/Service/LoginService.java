package dev.Zerphyis.pontoGps.Service;

import dev.Zerphyis.pontoGps.Entitys.Login;
import dev.Zerphyis.pontoGps.Repository.RepositoryLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements UserDetailsService {
    @Autowired
    RepositoryLogin repository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Login login = repository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + email));

        return login;
    }

    public Login createPerson(Login person) {
        return repository.save(person);
    }
}
