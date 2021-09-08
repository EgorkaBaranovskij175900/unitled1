package by.tms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Operation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private double num1;
	private double num2;
	private String operation;
	private double result;

	public Operation(double num1, double num2, String operation, double result) {
		this.num1 = num1;
		this.num2 = num2;
		this.operation = operation;
		this.result = result;
	}
}
