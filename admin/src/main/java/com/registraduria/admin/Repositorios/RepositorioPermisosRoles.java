package com.registraduria.admin.Repositorios;

import com.registraduria.admin.Modelos.PermisosRoles;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositorioPermisosRoles extends MongoRepository<PermisosRoles,String> {
}
