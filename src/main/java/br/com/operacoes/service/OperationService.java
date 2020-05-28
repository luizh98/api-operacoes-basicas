package br.com.operacoes.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;

import br.com.operacoes.core.dto.OperationDTO;

public interface OperationService {

    public void realizaCalculo(double numberOne, double numberTwo);

	public List<OperationDTO> retrieveOperations(PageRequest page);

}