package uz.sirius.springjparelationships.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.sirius.springjparelationships.entity.Address;

public interface AddressRepository extends JpaRepository<Address,Integer> {
}
