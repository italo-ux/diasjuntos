package com.projeto.diasjuntos;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class NumeroService {
private int numeroAtual; //guarda o numero atual
private final Path arquivo = Paths.get("numero.txt"); //arquivo para armazenar o número

//contrutor da classe - ao iniciar o serviço, lê o número do arquivo
    public NumeroService(){
try{
    if(Files.exists(arquivo)){
        numeroAtual = Integer.parseInt(Files.readString(arquivo));
    }else{
        //se o arquivo não existir, inicia com 0
        numeroAtual = 129;
        salvarNumero();
    }
}catch (IOException e) {
        numeroAtual = 127; // valor padrão se ocorrer erro
    }
}
//metodo publico para obter o número atual
public int getNumeroAtual(){
    return numeroAtual;
}
//método agendado para rodar todo dia a meia noite, aumentando o número atual
@Scheduled(cron = "0 0 0 * * *") // a cada dia a meia noite
public void atualizarNumero() {
    numeroAtual++;
    salvarNumero();
}
//metodo que salva o numero atual no arquivo
private void salvarNumero() {
    try{
        Files.writeString(arquivo, String.valueOf(numeroAtual));
    }catch (IOException e) {
        e.printStackTrace(); // log de erro, pode ser melhorado
    }
}
}