package kodlama.io.rent_a_car.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.rent_a_car.business.abstracts.BrandService;
import kodlama.io.rent_a_car.business.responses.GetAllBrandsResponse;
import kodlama.io.rent_a_car.data_access.abstracts.BrandRepository;
import kodlama.io.rent_a_car.entities.concretes.Brand;

@Service
public class BrandManager implements BrandService {

    private BrandRepository brandRepository;

    @Autowired
    public BrandManager(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public List<GetAllBrandsResponse> getAll() {
        List<Brand> brands = brandRepository.findAll();
        List<GetAllBrandsResponse> response = new ArrayList<GetAllBrandsResponse>();
        
        for (Brand brand : brands) {
            response.add(new GetAllBrandsResponse(brand.getId(), brand.getName()));
        }

        return response;
    }

}
