package dario.main.Repository;

import dario.main.Models.Partner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPartnerRepository extends JpaRepository<Partner, Long> {
}
