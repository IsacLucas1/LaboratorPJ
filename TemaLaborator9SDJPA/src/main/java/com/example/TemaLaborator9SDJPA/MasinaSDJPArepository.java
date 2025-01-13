package com.example.TemaLaborator9SDJPA;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MasinaSDJPArepository extends JpaRepository<Masina, String> {
    List<Masina> findByNrInmatriculare(String nrInmatriculare);
    List<Masina> findByNumarkmGreaterThan(int numarkm);
    List<Masina> findByMarcaOrderByAnulDesc(String marca);
    int countByAnul(int anulFabricatiei);
    List<Masina> findByAnulGreaterThan(int anulFabricatiei);

    @Modifying
    @Query("DELETE FROM Masina m WHERE m.nrInmatriculare = :nrInmatriculare")
    void deleteByNrInmatriculare(@Param("nrInmatriculare") String nrInmatriculare);

    @Modifying
    @Query("UPDATE Masina m SET m.marca = :#{#masina.marca}, m.anul = :#{#masina.anul}, m.culoare = :#{#masina.culoare}, m.numarkm = :#{#masina.numarkm} WHERE m.nrInmatriculare = :nrInmatriculare")
    int updateMasinaByNrInmatriculare(@Param("nrInmatriculare") String nrInmatriculare, @Param("masina") Masina masina);

    @Query("FROM Masina m WHERE m.numarkm < 100000")
    List<Masina> getMasiniCuKilometriPutini();

    @Query("FROM Masina m WHERE YEAR(CURRENT_DATE) - m.anul <= 5")
    List<Masina> getMasiniMaiNoiDe5Ani();

    List<Masina> findByMarca(String marca);

    List<Masina> findByNumarkmLessThan(int i);
}
