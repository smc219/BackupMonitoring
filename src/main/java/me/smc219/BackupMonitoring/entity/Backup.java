package me.smc219.BackupMonitoring.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "backup")
public class Backup {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	private Kind plan;

	private LocalDateTime startTime;
	private LocalDateTime endTime;

	private int size;

	private Check check;

	@ManyToOne
	@JoinColumn(name = "server_ip")
	private Server server;
}