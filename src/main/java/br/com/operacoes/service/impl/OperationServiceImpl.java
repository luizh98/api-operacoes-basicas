package br.com.operacoes.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.operacoes.core.document.OperationEntity;
import br.com.operacoes.core.document.OperationsEntity;
import br.com.operacoes.core.dto.OperationDTO;
import br.com.operacoes.core.dto.OperationsDTO;
import br.com.operacoes.core.repository.OperationRepository;
import br.com.operacoes.service.OperationService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor(onConstructor_ = { @Autowired })
public class OperationServiceImpl implements OperationService {

    private final OperationRepository operationRepository;

    @Override
    public List<OperationDTO> retrieveOperations(PageRequest page) {
        Page<OperationEntity> pagedResults = operationRepository.findAll(page);

        List<OperationDTO> operationList = pagedResults.stream().map(op -> OperationDTO.builder()
        .firstNumber(op.getFirstNumber())
        .secondNumber(op.getSecondNumber())
        .operations(OperationsDTO.builder()
            .division(op.getOperations().getDivision())
            .multiply(op.getOperations().getMultiply())
            .subtract(op.getOperations().getSubtract())
            .sum(op.getOperations().getSum())
            .build())
        .build())
        .collect(Collectors.toList());

        return operationList;
    }

    @Override
    public void realizaCalculo(double numberOne, double numberTwo) {
        double sum = calculaSoma(numberOne, numberTwo);
        double sub = calculaSub(numberOne, numberTwo);
        double multi = calculaMulti(numberOne, numberTwo);
        double div = calculaDiv(numberOne, numberTwo);

        operationRepository.save(OperationEntity.builder().firstNumber(numberOne).secondNumber(numberTwo)
                .operations(OperationsEntity.builder()
                .sum(sum).subtract(sub)
                .multiply(multi)
                .division(div)
                .build())
                .build());
    }

    private double calculaSoma(double numberOne, double numberTwo) {
        return numberOne + numberTwo;
    }

    private double calculaSub(double numberOne, double numberTwo) {
        return numberOne - numberTwo;
    }

    private double calculaMulti(double numberOne, double numberTwo) {
        return numberOne * numberTwo;
    }

    private double calculaDiv(double numberOne, double numberTwo) {
        return numberOne / numberTwo;
    }

}