package br.com.mesttra.budget.data;

import br.com.mesttra.budget.model.Budget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BudgetRepository extends JpaRepository<Budget, Long> {

    @Query(value = "SELECT b FROM Budget b WHERE b.possibleDestinations LIKE CONCAT('%',:destination,'%')")
    public List<Budget> findByDestination(@Param("destination") String destination);
}
