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
import br.com.operacoes.core.dto.ModelApiResponseDTO;
import br.com.operacoes.core.dto.OperationDTO;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor(onConstructor_={@Autowired})
public class ControllerApi {

    @RequestMapping(value = "/operacoes", method = RequestMethod.POST)
    public ResponseEntity operacoes(@RequestBody ApiRequestDTO apiRequestDTO) {
        ModelAndView model = new ModelAndView();

        double sum = apiRequestDTO.getFirstNumber() + apiRequestDTO.getSecondNumber();
        double sub = apiRequestDTO.getFirstNumber() - apiRequestDTO.getSecondNumber();
        double multi = apiRequestDTO.getFirstNumber() * apiRequestDTO.getSecondNumber();
        double div = apiRequestDTO.getFirstNumber() / apiRequestDTO.getSecondNumber();

        OperationDTO operationDTO = OperationDTO.builder().sum(sum).subtract(sub).multiply(multi).division(div).build();
        ModelApiResponseDTO modelResponse = ModelApiResponseDTO.builder().firstNumber(apiRequestDTO.getFirstNumber())
                .secondNumber(apiRequestDTO.getSecondNumber()).operation(operationDTO).build();

        model.addObject("ApiResponse", modelResponse);

        return ResponseEntity.status(HttpStatus.CREATED).body("");
    }

}