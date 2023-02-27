package kodlama.io.rent_a_car.web_api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import kodlama.io.rent_a_car.business.abstracts.ModelService;
import kodlama.io.rent_a_car.business.requests.CreateModelRequest;
import kodlama.io.rent_a_car.business.responses.GetAllModelsResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/models")
@AllArgsConstructor
public class ModelsController {
    private ModelService modelService;

    //! http://localhost:8080/swagger-ui/index.html

    @GetMapping()
    public List<GetAllModelsResponse> getAll()
    {
        return modelService.getAll();
    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody CreateModelRequest createModelRequest)
    {
        modelService.add(createModelRequest);
    }
}