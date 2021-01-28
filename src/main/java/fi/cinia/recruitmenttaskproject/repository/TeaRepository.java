package fi.cinia.recruitmenttaskproject.repository;

import javax.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;

import fi.cinia.recruitmenttaskproject.model.Tea;

/**
 * JPA repository for tea-table
 */
@Table(name = "tea")
public interface TeaRepository extends JpaRepository<Tea, Long> {

}
