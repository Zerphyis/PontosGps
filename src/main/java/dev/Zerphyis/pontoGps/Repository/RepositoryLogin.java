package dev.Zerphyis.pontoGps.Repository;

import dev.Zerphyis.pontoGps.Entitys.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepositoryLogin extends JpaRepository<Login,Long> {
    Optional<Login> findByEmail(String email);
}
