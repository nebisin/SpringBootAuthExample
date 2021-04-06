package com.muaccel.testapp.employee;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@NoArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "You must provide a name!")
    @Size(min = 2, max = 30)
    private String name;

    @NotNull(message = "You must provide a role!")
    private String role;

    public Employee(String name, String role) {
        this.name = name;
        this.role = role;
    }
}
