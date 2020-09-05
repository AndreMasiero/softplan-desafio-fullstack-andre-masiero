package br.com.softplan.component.process.repositories;

import br.com.softplan.domain.CollaboratorsProcess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CollaboratorsProcessRepository extends JpaRepository<CollaboratorsProcess, Long>, JpaSpecificationExecutor<CollaboratorsProcess> {
}
