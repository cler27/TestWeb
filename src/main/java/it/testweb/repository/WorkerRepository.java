package it.testweb.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.testweb.domain.entity.Worker;

public interface WorkerRepository extends CrudRepository<Worker, Long>
{
    List<Worker> findByUsername(String username);

    Worker findByUsernameAndPassword(String username, String password);
}
