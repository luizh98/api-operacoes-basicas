package br.com.operacoes.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.operacoes.core.dto.ApiRequestDTO;
import br.com.operacoes.core.dto.ApiResponseDTO;
import br.com.operacoes.core.dto.OperationDTO;
import br.com.operacoes.service.OperationService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor(onConstructor_={@Autowired})
public class ControllerApi {

    private final OperationService operationService;

    @RequestMapping(value = "/operacoes", method = RequestMethod.POST)
    public ResponseEntity operacoes(@RequestBody ApiRequestDTO apiRequestDTO) {
        
        operationService.realizaCalculo(apiRequestDTO.getFirstNumber(), apiRequestDTO.getSecondNumber());


        return ResponseEntity.status(HttpStatus.CREATED).body("");
    }

}