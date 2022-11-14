package kodlama.io.Devs.dataAccess.concrete;

import kodlama.io.Devs.entites.Framework;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FrameworkRepository extends JpaRepository<Framework,Integer> {
}