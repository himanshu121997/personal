package fraud.repo;

import fraud.entity.FraudCheckHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FraudRepo extends JpaRepository<FraudCheckHistory, Integer> {
}
