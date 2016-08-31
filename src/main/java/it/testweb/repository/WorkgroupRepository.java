package it.testweb.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.testweb.domain.entity.Workgroup;

public interface WorkgroupRepository extends CrudRepository<Workgroup, Long>
{
    List<Workgroup> findAll();
}
