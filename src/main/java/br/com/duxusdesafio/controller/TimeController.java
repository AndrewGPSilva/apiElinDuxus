package br.com.duxusdesafio.controller;

import br.com.duxusdesafio.model.Integrante;
import br.com.duxusdesafio.model.Time;
import br.com.duxusdesafio.repository.TimeRepository;
import br.com.duxusdesafio.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/times")
public class TimeController {
    @Autowired
    private ApiService apiService;

    @Autowired
    private TimeRepository timeRepository;

    @GetMapping("/integrantes")
    public ResponseEntity<List<String>> obterTimeNaData(
            @RequestParam("data") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data
    ){

        List<Time> todosOsTimes = timeRepository.findAll();
        List<String> timeNaData = apiService.timeDaData(data, todosOsTimes);

        return new ResponseEntity<>(timeNaData, HttpStatus.OK);
    }

    @GetMapping("/integrantemaisusado")
    public ResponseEntity<Integrante> obterIntegranteMaisUsado(
            @RequestParam("dataInicial") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicial,
            @RequestParam("dataFinal") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFinal
    ) {
        List<Time> todosOsTimes = timeRepository.findAll();
        Integrante integranteMaisUsado = apiService.integranteMaisUsado(dataInicial, dataFinal, todosOsTimes);

        return new ResponseEntity<>(integranteMaisUsado, HttpStatus.OK);
    }

    @GetMapping("/timemaiscomum")
    public ResponseEntity<List<String>> obterTimeMaisComum(
            @RequestParam("dataInicial") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicial,
            @RequestParam("dataFinal") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFinal
    ) {
        List<Time> todosOsTimes = timeRepository.findAll();
        List<String> timeMaisComum = apiService.timeMaisComum(dataInicial, dataFinal, todosOsTimes);

        return new ResponseEntity<>(timeMaisComum, HttpStatus.OK);
    }

    @GetMapping("/funcaomaiscomum")
    public ResponseEntity<String> obterFuncaoMaisComum(
            @RequestParam("dataInicial") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicial,
            @RequestParam("dataFinal") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFinal
    ) {
        List<Time> todosOsTimes = timeRepository.findAll();
        String funcaoMaisComum = apiService.funcaoMaisComum(dataInicial, dataFinal, todosOsTimes);

        return ResponseEntity.ok(funcaoMaisComum);
    }

    @GetMapping("/franquiamaisfamosa")
    public String obterFranquiaMaisFamosa(
            @RequestParam("dataInicial") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicial,
            @RequestParam("dataFinal") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFinal
    ) {
        List<Time> todosOsTimes = timeRepository.findAll();
        return apiService.franquiaMaisFamosa(dataInicial, dataFinal, todosOsTimes);
    }

    @GetMapping("/contagemporfranquia")
    public ResponseEntity<Map<String, Long>> obterContagemPorFranquia(
            @RequestParam("dataInicial") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicial,
            @RequestParam("dataFinal") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFinal
    ) {
        List<Time> todosOsTimes = timeRepository.findAll();
        Map<String, Long> contagemFranquias = apiService.contagemPorFranquia(dataInicial, dataFinal, todosOsTimes);

        return ResponseEntity.ok(contagemFranquias);
    }

    @GetMapping("/contagemporfuncao")
    public ResponseEntity<Map<String, Long>> obterContagemPorFuncao(
            @RequestParam("dataInicial") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicial,
            @RequestParam("dataFinal") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFinal
    ) {
        List<Time> todosOsTimes = timeRepository.findAll();
        Map<String, Long> contagemFuncoes = apiService.contagemPorFuncao(dataInicial, dataFinal, todosOsTimes);

        return ResponseEntity.ok(contagemFuncoes);
    }
}