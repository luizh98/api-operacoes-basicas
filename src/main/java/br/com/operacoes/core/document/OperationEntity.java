package br.com.operacoes.core.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
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
@Document(collection = "operation")
public class OperationEntity {

    @Id
    private String id;

    @Field(name = "firstNumber")
    private Double firstNumber;
    @Field(name = "secondNumber")
    private Double secondNumber;

    @DBRef
    private OperationsEntity operations;
}