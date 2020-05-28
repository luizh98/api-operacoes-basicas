package br.com.operacoes.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.operacoes.core.dto.ApiRequestDTO;
import br.com.operacoes.core.dto.OperationDTO;
import br.com.operacoes.service.OperationService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor(onConstructor_ = { @Autowired })
public class ControllerApi {

    private final OperationService operationService;

    @RequestMapping(value = "/operacoes", method = RequestMethod.POST)
    public ResponseEntity operacoes(@RequestBody ApiRequestDTO apiRequestDTO) {

        operationService.realizaCalculo(apiRequestDTO.getFirstNumber(), apiRequestDTO.getSecondNumber());

        return ResponseEntity.status(HttpStatus.CREATED).body("");
    }

    @GetMapping(value = "/operacoes")
    public ResponseEntity operacoes(@RequestParam(required = false, defaultValue = "5") int limit,
            @RequestParam(required = false, defaultValue = "0") int offset) {
        List<OperationDTO> operationList = operationService.retrieveOperations(PageRequest.of(offset, limit));

        return ResponseEntity.ok().body(operationList);
    }
}