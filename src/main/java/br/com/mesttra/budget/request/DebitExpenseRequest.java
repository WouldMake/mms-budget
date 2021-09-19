package br.com.mesttra.budget.request;

import br.com.mesttra.budget.enums.Folder;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DebitExpenseRequest {
    private Double amount;
    @Enumerated(EnumType.STRING)
    private Folder folder;
}
