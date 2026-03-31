package LMS.library;

import LMS.library.Table.LMSSchema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LMSRepo extends JpaRepository<LMSSchema,Long> {
}
