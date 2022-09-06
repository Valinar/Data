package com.example.Dva.Rep;
import com.example.Dva.models.Data;
import com.example.Dva.models.Data2;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface Postrep extends CrudRepository<Data2, Long> {
    List<Data2> findByNameContaining(String name);
}
