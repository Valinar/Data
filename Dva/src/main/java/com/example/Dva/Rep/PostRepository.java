package com.example.Dva.Rep;

import com.example.Dva.models.Data;
import com.example.Dva.models.Data2;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface PostRepository extends CrudRepository<Data, Long> {
    List <Data>  findByName(String name);
}
