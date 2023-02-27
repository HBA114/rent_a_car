package kodlama.io.rent_a_car.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.rent_a_car.business.abstracts.BrandService;
import kodlama.io.rent_a_car.business.requests.CreateBrandRequest;
import kodlama.io.rent_a_car.business.requests.UpdateBrandRequest;
import kodlama.io.rent_a_car.business.responses.GetAllBrandsResponse;
import kodlama.io.rent_a_car.business.responses.GetByIdBrandResponse;
import kodlama.io.rent_a_car.business.rules.BrandBusinessRules;
import kodlama.io.rent_a_car.core.utilities.mappers.ModelMapperService;
import kodlama.io.rent_a_car.data_access.abstracts.BrandRepository;
import kodlama.io.rent_a_car.entities.concretes.Brand;
import lombok.AllArgsConstructor;

@Service // IOC
@AllArgsConstructor
public class BrandManager implements BrandService {

    private BrandRepository brandRepository;
    private BrandBusinessRules brandBusinessRules;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllBrandsResponse> getAll() {
        List<Brand> brands = brandRepository.findAll();

        // List<GetAllBrandsResponse> response = new ArrayList<GetAllBrandsResponse>();
        // for (Brand brand : brands) {
        //     response.add(new GetAllBrandsResponse(brand.getId(), brand.getName()));
        // }

        List<GetAllBrandsResponse> brandsResponse = brands.stream()
                .map(brand -> modelMapperService.forResponse().map(brand, GetAllBrandsResponse.class))
                .collect(Collectors.toList());

        return brandsResponse;
    }

    @Override
    public void add(CreateBrandRequest createBrandRequest) {
        brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getName());
        
        Brand brand = modelMapperService.forRequest().map(createBrandRequest, Brand.class);
        
        brandRepository.save(brand);
    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {
        Brand brand = modelMapperService.forRequest().map(updateBrandRequest, Brand.class);

        brandRepository.save(brand);
    }

    @Override
    public void delete(int id) {
        brandRepository.deleteById(id);
    }

    @Override
    public GetByIdBrandResponse getById(int id) {
        Brand brand = brandRepository.findById(id).orElseThrow();
        GetByIdBrandResponse response = modelMapperService.forResponse().map(brand, GetByIdBrandResponse.class);

        return response;
    }

}
