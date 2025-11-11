package com.example.domain.entities;

import java.time.LocalDateTime;

import com.example.domain.enums.TicketStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_ticket")
@Getter
@Setter
@NoArgsConstructor
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String codigo;

    private LocalDateTime entrada;
    private String placa;

    @Enumerated(EnumType.STRING)
    private TicketStatus status;

    public Ticket(String codigo, LocalDateTime entrada, String placa, TicketStatus status){
        this.codigo = codigo;
        this.entrada = entrada;
        this.placa = placa;
        this.status = status;
    }

}
