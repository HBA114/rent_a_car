package kodlama.io.rent_a_car.data_access.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.rent_a_car.entities.concretes.Brand;

public interface BrandRepository extends JpaRepository<Brand, Integer> {
    public boolean existsByName(String name);   // automatically creates body for this method (exists, find ... 
                                                // search for springJPA keywords)
}
