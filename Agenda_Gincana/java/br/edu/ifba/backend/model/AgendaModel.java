package br.edu.ifba.backend.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Agenda")
public class AgendaModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "data_agenda", nullable = false)
	private Date data_agenda;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private ProvaModel provaModel;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private EventoModel eventoModel;

	public AgendaModel() {
		super();
	}

	public AgendaModel(long id, Date data_agenda, ProvaModel provaModel, EventoModel eventoModel) {
		super();
		this.id = id;
		this.data_agenda = data_agenda;
		this.provaModel = provaModel;
		this.eventoModel = eventoModel;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getData_agenda() {
		return data_agenda;
	}

	public void setData_agenda(Date data_agenda) {
		this.data_agenda = data_agenda;
	}

	public ProvaModel getProvaModel() {
		return provaModel;
	}

	public void setProvaModel(ProvaModel provaModel) {
		this.provaModel = provaModel;
	}

	public EventoModel getEventoModel() {
		return eventoModel;
	}

	public void setEventoModel(EventoModel eventoModel) {
		this.eventoModel = eventoModel;
	}

	@Override
	public String toString() {
		return this.getId() + ":" + getData_agenda() + ":" + getProvaModel() + ":" + getEventoModel();
	}
}
