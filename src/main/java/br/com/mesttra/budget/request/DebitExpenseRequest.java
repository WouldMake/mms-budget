package br.com.mesttra.budget.request;

import br.com.mesttra.budget.enums.Folder;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class DebitExpenseRequest {
    @NonNull
    private Double amount;
    @NonNull
    @Enumerated(EnumType.STRING)
    private Folder folder;
}
