package br.com.operacoes.core.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.operacoes.core.document.OperationEntity;

public interface OperationRepository extends MongoRepository<OperationEntity, String> {
    
    Page<OperationEntity> findAll(Pageable pageable);
}