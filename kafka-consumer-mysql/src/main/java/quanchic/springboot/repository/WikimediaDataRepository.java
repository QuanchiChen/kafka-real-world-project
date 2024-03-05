package quanchic.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import quanchic.springboot.model.WikimediaData;

public interface WikimediaDataRepository extends JpaRepository<WikimediaData, Long> {
}
