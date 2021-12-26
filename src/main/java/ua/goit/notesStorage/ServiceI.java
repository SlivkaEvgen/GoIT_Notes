package ua.goit.notesStorage;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public abstract class ServiceI<T extends BaseEntity<ID>, ID> {

    private final RepositoryI<T,ID> repositoryI;

    public List<T> findAll(){
        return repositoryI.findAll();
    }

    public void save(T t){
        repositoryI.save(t);
    }

    public T getById(ID id){
        return repositoryI.getById(id);
    }

    public Optional<T> findById(ID id){
        return repositoryI.findById(id);
    }

    public void deleteById(ID id){
        repositoryI.deleteById(id);
    }

}
