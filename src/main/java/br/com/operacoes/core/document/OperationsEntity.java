package br.com.operacoes.core.document;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

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

  @Field(name = "sum")
  private Double sum;
  @Field(name = "subtract")
  private Double subtract;
  @Field(name = "division")
  private Double division;
  @Field(name = "multiply")
  private Double multiply;

}

