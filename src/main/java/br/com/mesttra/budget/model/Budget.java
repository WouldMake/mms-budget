package br.com.mesttra.budget.model;

import br.com.mesttra.budget.enums.Origin;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Budget {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Double totalAmount;

    @Column(nullable = false)
    private Double spentAmount;

    @NotBlank
    @Column(nullable = false)
    private String possibleDestinations;

    @Enumerated(EnumType.STRING)
    private Origin origin;
}
