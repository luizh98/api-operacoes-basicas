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

  private Integer sum = null;
  private Integer subtract = null;
  private Integer division = null;
  private Integer multiply = null;

}

