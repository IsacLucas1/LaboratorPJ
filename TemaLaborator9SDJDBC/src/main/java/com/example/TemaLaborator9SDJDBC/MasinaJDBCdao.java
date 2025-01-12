package com.example.TemaLaborator9SDJDBC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MasinaJDBCdao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Masina> findAll(){
        String sql = "select * from masini";
        return jdbcTemplate.query(sql, new MasinaMapper());
    }

    public Masina findById(String nr_Inmatriculare){
        String sql = "select * from masini where nr_inmatriculare = ?";
        return jdbcTemplate.queryForObject(sql, new MasinaMapper(),nr_Inmatriculare);
    }

    public int deleteById(String nr_Inmmatriculare){
        String sql = "delete from masini where nr_inmatriculare = ?";
        return jdbcTemplate.update(sql, nr_Inmmatriculare);
    }

    public int insert(Masina masina){
        String sql="insert into masini values(?,?,?,?,?)";
        return jdbcTemplate.update(sql, masina.getNr_inmatriculare(),
                masina.getMarca(), masina.getAnul(),
                masina.getCuloare(), masina.getNumar_km());
    }

    public int update(Masina masina){
        String sql="update masini set nr_inmatriculare=?, marca=?, anul=?, " +
                "culoare=?, numarr_km=? where nr_inmatriculare = ?";
        return jdbcTemplate.update(sql, masina.getNr_inmatriculare(),
                masina.getMarca(), masina.getAnul(),
                masina.getCuloare(), masina.getNumar_km());
    }
}
