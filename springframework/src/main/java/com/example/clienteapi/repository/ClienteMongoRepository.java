package com.example.clienteapi.repository;

import com.example.clienteapi.entity.ClienteEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteMongoRepository extends MongoRepository<ClienteEntity, String> {
}
