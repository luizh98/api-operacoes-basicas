package br.com.operacoes.core.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiRequestDTO {
  
  private Double firstNumber;
  private Double secondNumber;

}

