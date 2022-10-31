package aula.agenda.msagenda.dto;

import aula.agenda.msagenda.model.Agenda;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class AgendaDTO {
    private Long id;
    private Long idResponsavel;
    private String responsavel;
    private Long idSala;
    private String sala;
    private String dataHoraReserva;

    private static final DateTimeFormatter FORMATO_DATA_HORA = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public AgendaDTO(Agenda agenda) {
        this.id = agenda.getId();
        this.idResponsavel = agenda.getResponsavel();
        this.idSala = agenda.getSala();
        this.dataHoraReserva = agenda.getDataHoraReserva().format(FORMATO_DATA_HORA);
    }

    public AgendaDTO() {
    }

    public Agenda converteParaAgenda() {
        Agenda agenda = new Agenda();
        if (this.getId() != null) {
            agenda.setId(this.getId());
        }
        agenda.setResponsavel(this.getIdResponsavel());
        agenda.setSala(this.getIdSala());
        agenda.setDataHoraReserva(LocalDateTime.parse(this.getDataHoraReserva(), FORMATO_DATA_HORA));

        return agenda;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdResponsavel() {
        return idResponsavel;
    }

    public void setIdResponsavel(Long idResponsavel) {
        this.idResponsavel = idResponsavel;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public Long getIdSala() {
        return idSala;
    }

    public void setIdSala(Long idSala) {
        this.idSala = idSala;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public String getDataHoraReserva() {
        return dataHoraReserva;
    }

    public void setDataHoraReserva(String dataHoraReserva) {
        this.dataHoraReserva = dataHoraReserva;
    }

    public static List<AgendaDTO> converteListaAgenda(List<Agenda> agendaList) {
        List<AgendaDTO> dtos = new ArrayList<>();
        for (Agenda agenda :
                agendaList) {
            AgendaDTO dto = new AgendaDTO(agenda);
            dtos.add(dto);
        }
        return dtos;
    }
}
