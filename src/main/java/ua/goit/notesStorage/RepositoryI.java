package ua.goit.notesStorage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface RepositoryI<T extends BaseEntity<ID>,ID> extends JpaRepository<T,ID> {


}
