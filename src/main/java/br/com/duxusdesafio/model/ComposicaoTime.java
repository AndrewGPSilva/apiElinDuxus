package br.com.duxusdesafio.model;

import jakarta.persistence.*;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "composicao")
public class ComposicaoTime {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "Id_Time", referencedColumnName = "id")
	private Time time;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "Id_Integrante", referencedColumnName = "id")
	private Integrante integrante;

	public ComposicaoTime() {
	}

	public ComposicaoTime(Time time, Integrante integrante) {
		this.time = time;
		this.integrante = integrante;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public Integrante getIntegrante() {
		return integrante;
	}

	public void setIntegrante(Integrante integrante) {
		this.integrante = integrante;
	}

	@Override
	public final boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof ComposicaoTime)) return false;
		ComposicaoTime that = (ComposicaoTime) o;
		return id == that.id && Objects.equals(time, that.time) && Objects.equals(integrante, that.integrante);
	}

	@Override
	public final int hashCode() {
		return Objects.hash(id, time, integrante);
	}

	@Override
	public String toString() {
		return "ComposicaoTime{" +
				"time=" + time +
				", integrante=" + integrante +
				'}';
	}
}
