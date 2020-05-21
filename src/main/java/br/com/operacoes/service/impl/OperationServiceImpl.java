package br.com.operacoes.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.operacoes.core.dto.OperationDTO;
import br.com.operacoes.service.OperationService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class OperationServiceImpl implements OperationService {

    @Override
    public void realizaCalculo(double numberOne, double numberTwo) {
        double sum = calculaSoma(numberOne, numberTwo);
        double sub = calculaSub(numberOne, numberTwo);
        double multi = calculaMulti(numberOne, numberTwo);
        double div = calculaDiv(numberOne, numberTwo);

        OperationDTO operationDTO = OperationDTO.builder().sum(sum).subtract(sub).multiply(multi).division(div).build();
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