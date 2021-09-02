package br.com.mesttra.budget.model;

import br.com.mesttra.budget.enums.Origin;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Budget {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Double totalAmount;

    @Column(nullable = false)
    private Double spentAmount;

    private String possibleDestinations;

    @Enumerated(EnumType.STRING)
    private Origin origin;
}
