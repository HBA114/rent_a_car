package kodlama.io.rent_a_car.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.rent_a_car.business.abstracts.ModelService;
import kodlama.io.rent_a_car.business.requests.CreateModelRequest;
import kodlama.io.rent_a_car.business.responses.GetAllModelsResponse;
import kodlama.io.rent_a_car.core.utilities.mappers.ModelMapperService;
import kodlama.io.rent_a_car.data_access.abstracts.BrandRepository;
import kodlama.io.rent_a_car.data_access.abstracts.ModelRepository;
import kodlama.io.rent_a_car.entities.concretes.Brand;
import kodlama.io.rent_a_car.entities.concretes.Model;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {

    private ModelRepository modelRepository;
    private BrandRepository brandRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllModelsResponse> getAll() {
        List<Model> models = modelRepository.findAll();
        List<GetAllModelsResponse> modelsResponse = models.stream()
                .map(model -> modelMapperService.forResponse().map(model, GetAllModelsResponse.class))
                .collect(Collectors.toList());

        return modelsResponse;
    }

    @Override
    public void add(CreateModelRequest createModelRequest) {
        Model model = modelMapperService.forRequest().map(createModelRequest, Model.class);
        Brand brand = brandRepository.findById(createModelRequest.getBrand_id()).get();
        model.setBrand(brand);
        modelRepository.save(model);
    }

}
