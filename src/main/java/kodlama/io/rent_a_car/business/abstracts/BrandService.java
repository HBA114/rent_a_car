package kodlama.io.rent_a_car.business.abstracts;

import java.util.List;

import kodlama.io.rent_a_car.business.requests.CreateBrandRequest;
import kodlama.io.rent_a_car.business.requests.UpdateBrandRequest;
import kodlama.io.rent_a_car.business.responses.GetAllBrandsResponse;
import kodlama.io.rent_a_car.business.responses.GetByIdBrandResponse;

public interface BrandService {
    List<GetAllBrandsResponse> getAll();

    GetByIdBrandResponse getById(int id);

    void add(CreateBrandRequest createBrandRequest);

    void update(UpdateBrandRequest updateBrandRequest);

    void delete(int id);
}
