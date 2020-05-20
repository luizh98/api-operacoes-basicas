package br.com.operacoes.core.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OperationDTO {

  private Double sum = null;
  private Double subtract = null;
  private Double division = null;
  private Double multiply = null;

}

