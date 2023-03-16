package ra.dev.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ra.dev.model.entity.Size;

public interface SizeRepository extends JpaRepository<Size,Integer> {
}