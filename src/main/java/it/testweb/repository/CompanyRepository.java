package it.testweb.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.testweb.domain.entity.Company;

public interface CompanyRepository extends CrudRepository<Company, Long>
{
    List<Company> findAll();

    Company findById(Long id);
}
