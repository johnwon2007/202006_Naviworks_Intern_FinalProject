package com.example.goodfood.restaurant;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*")
@RepositoryRestResource(path = "bestmenus")
public interface BestMenuRepository extends PagingAndSortingRepository<BestMenu, Long> {
}
