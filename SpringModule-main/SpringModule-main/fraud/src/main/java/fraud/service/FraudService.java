package fraud.service;

import fraud.entity.FraudCheckHistory;
import fraud.repo.FraudRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class FraudService {

    private final FraudRepo repo;

    public boolean isFraudCustomer(Integer customerId){
        repo.save(FraudCheckHistory.builder().customerId(customerId).
                isFraudster(false).createdAt(LocalDateTime.now()).build());
        return false;
    }
}
