package br.com.softplan.component.process.repositories;

import br.com.softplan.domain.ProcessFeedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcessFeedbackRepository extends JpaRepository<ProcessFeedback, Long>, JpaSpecificationExecutor<ProcessFeedback> {
}
