package br.com.limpay.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.limpay.domain.User;

public interface UserRepository extends JpaRepository<User, Long>{
    User findByEmail(String email);
}
