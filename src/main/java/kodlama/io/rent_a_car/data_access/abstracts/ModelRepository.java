package kodlama.io.rent_a_car.data_access.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.rent_a_car.entities.concretes.Model;

public interface ModelRepository extends JpaRepository<Model, Integer> {

}
