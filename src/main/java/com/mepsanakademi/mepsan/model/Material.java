package com.mepsanakademi.mepsan.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Materials")
@Getter
@Setter
public class Material {

}
