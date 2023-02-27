package kodlama.io.rent_a_car.business.abstracts;

import java.util.List;

import kodlama.io.rent_a_car.business.requests.CreateModelRequest;
import kodlama.io.rent_a_car.business.responses.GetAllModelsResponse;

public interface ModelService {
    List<GetAllModelsResponse> getAll();

    void add(CreateModelRequest createModelRequest);
}
