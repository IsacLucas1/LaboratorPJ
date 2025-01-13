package com.example.TemaLaborator10;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarteSDJPArepository extends JpaRepository<Carte, String> {
    List<Carte> findByAutorul(String autorul);
}
