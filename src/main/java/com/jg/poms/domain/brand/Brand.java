package com.jg.poms.domain.brand;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
public class Brand {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long brandIdx = null;

	private String name;

	private boolean deleteYn;

	private LocalDateTime registrationDate;

	private LocalDateTime modifyDate;

	private String rogoFilePath;
}
