package br.com.operacoes.core.document;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "operations")
public class OperationsEntity {

  private Double sum = null;
  private Double subtract = null;
  private Double division = null;
  private Double multiply = null;

}

