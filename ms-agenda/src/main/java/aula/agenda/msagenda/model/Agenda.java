package aula.agenda.msagenda.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Agenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Long responsavel;
    @Column(nullable = false)
    private Long sala;
    /* Reservas sempre serão de 1 hora e incia em hora cheia ex: 11hs, 10hs, 12hs, etc.*/
    @Column(nullable = false)
    private LocalDateTime dataHoraReserva;

    public Agenda() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Long responsavel) {
        this.responsavel = responsavel;
    }

    public Long getSala() {
        return sala;
    }

    public void setSala(Long sala) {
        this.sala = sala;
    }

    public LocalDateTime getDataHoraReserva() {
        return dataHoraReserva;
    }

    public void setDataHoraReserva(LocalDateTime horaReserva) {
        this.dataHoraReserva = horaReserva;
    }
}
