package br.com.operacoes.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.operacoes.core.document.OperationEntity;
import br.com.operacoes.core.document.OperationsEntity;
import br.com.operacoes.core.dto.OperationDTO;
import br.com.operacoes.core.repository.OperationRepository;
import br.com.operacoes.service.OperationService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor(onConstructor_ = { @Autowired })
public class OperationServiceImpl implements OperationService {

    private final OperationRepository operationRepository;

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