package br.dev.ederson.estudo.jdbi.dao;

import br.dev.ederson.estudo.jdbi.model.Cliente;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.locator.UseClasspathSqlLocator;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@UseClasspathSqlLocator
@RegisterBeanMapper(Cliente.class)
public interface ClienteDao {

    @SqlUpdate
    @GetGeneratedKeys
    UUID insert(@BindBean Cliente cliente);

    @SqlQuery
    Optional<Cliente> findById(UUID id);

    @SqlQuery
    List<Cliente> findAll();

    @SqlUpdate
    int update(@BindBean Cliente cliente);

    @SqlUpdate
    void delete(UUID id);
}