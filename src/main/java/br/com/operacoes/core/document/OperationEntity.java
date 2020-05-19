package br.com.operacoes.core.document;

import br.com.operacoes.core.dto.OperationDTO;
import lombok.Data;

@Data
public class OperationEntity {

    private Integer firstNumber;
    private Integer secondNumber;
    private OperationDTO operation;
}