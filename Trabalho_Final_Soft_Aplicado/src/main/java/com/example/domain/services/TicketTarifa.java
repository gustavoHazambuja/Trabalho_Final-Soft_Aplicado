package com.example.domain.services;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.entities.Ticket;
import com.example.infrastructure.exceptions.TicketNotFoundException;
import com.example.infrastructure.repositories.TicketRepository;

@Service
public class TicketTarifa {
    

    @Autowired
    private TicketRepository repository;

    BigDecimal valorAte1hora = new BigDecimal(5.00);
    BigDecimal valorAdicional = new BigDecimal(4.50);

    public  BigDecimal calcularTarifa(String codigo){

        Ticket ticketEncontrado = repository.findTicketByCodigo(codigo)
            .orElseThrow(() -> new TicketNotFoundException("Ticket com o código " + codigo + " não encontrado."));

        LocalDateTime entrada = ticketEncontrado.getEntrada();
        LocalDateTime saida = LocalDateTime.now();


        Duration duracao = Duration.between(entrada, saida);

        long minutos = duracao.toMinutes();
        long horas = duracao.toHours();

        if(minutos <= 15){ // Até 15 minutos
            return BigDecimal.ZERO;
        }else if(minutos <= 60){ // Até 1 hora
            return valorAte1hora;
        }
        else{ // Mais de 1 hora
            long horasAdicionais = horas - 1;

            if(minutos % 60 != 0){ // Verifica se sobrou minutos
                horasAdicionais++;
            }

            return valorAte1hora.add(valorAdicional.multiply(BigDecimal.valueOf(horasAdicionais)));
        }
    }
}
