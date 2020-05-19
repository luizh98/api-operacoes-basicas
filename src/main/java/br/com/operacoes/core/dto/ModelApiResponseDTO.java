package br.com.operacoes.core.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ModelApiResponseDTO {

  private Integer firstNumber;
  private Integer secondNumber;
  private OperationDTO operation;

}

