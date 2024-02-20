package Java_backend.springstore.repository;

import Java_backend.springstore.entity.Hoover;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HooverRepository extends JpaRepository<Hoover, Long> {

}
