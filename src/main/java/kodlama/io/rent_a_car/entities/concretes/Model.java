package kodlama.io.rent_a_car.entities.concretes;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "models")
@Entity
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL,targetEntity = Brand.class)
    @JoinColumn(name = "brand_id") // Could be written like brandId, postgresql uses snake
                                                                // case. Not must to use snake case
    private Brand brand;

    @OneToMany(mappedBy = "model", targetEntity = Car.class)
    private List<Car> cars;
}
