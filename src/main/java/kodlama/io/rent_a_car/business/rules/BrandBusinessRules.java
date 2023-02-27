package kodlama.io.rent_a_car.business.rules;

import org.springframework.stereotype.Service;

import kodlama.io.rent_a_car.core.utilities.exceptions.BusinessException;
import kodlama.io.rent_a_car.data_access.abstracts.BrandRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BrandBusinessRules {
    private BrandRepository brandRepository;

    public void checkIfBrandNameExists(String name) {
        if (brandRepository.existsByName(name)) {
            throw new BusinessException("Brand Name Already Exists!");
        }
    }
}
