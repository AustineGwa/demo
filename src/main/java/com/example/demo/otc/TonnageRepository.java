package com.example.demo.otc;

import com.example.demo.otc.models.OilTonnage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.CrudRepositoryExtensionsKt;

public interface TonnageRepository extends CrudRepository<OilTonnage,Long> {
}
