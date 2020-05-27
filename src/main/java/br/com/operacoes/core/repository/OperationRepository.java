package br.com.operacoes.core.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.operacoes.core.document.OperationEntity;

public interface OperationRepository extends MongoRepository<OperationEntity, String> {
    
}