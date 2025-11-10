package com.example.domain.dtos;

import java.time.LocalDateTime;

import com.example.domain.entities.Ticket;
import com.example.domain.enums.TicketStatus;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TicketDTO {
    
    @NotBlank(message = "O código é obrigatório.")
    private String codigo;

    @NotNull(message = "A hora e data são obrigatórios.")
    private LocalDateTime entrada;

    @NotBlank(message = "A placa é obrigatória.")
    private String placa;

    @NotBlank(message = "O status é obrigatório.")
    private TicketStatus status;






    public static TicketDTO toModel(Ticket ticket){
        return new TicketDTO(
            ticket.getCodigo(),
            ticket.getEntrada(),
            ticket.getPlaca(),
            ticket.getStatus()
        );
    }
}
