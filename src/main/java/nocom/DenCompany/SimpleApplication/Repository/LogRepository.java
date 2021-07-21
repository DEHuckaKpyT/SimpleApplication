package nocom.DenCompany.SimpleApplication.Repository;

import nocom.DenCompany.SimpleApplication.Entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LogRepository extends JpaRepository<Log, UUID> {
}
