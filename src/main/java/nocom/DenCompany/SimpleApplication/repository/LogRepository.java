package nocom.DenCompany.SimpleApplication.repository;

import nocom.DenCompany.SimpleApplication.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LogRepository extends JpaRepository<Log, UUID> {
}
