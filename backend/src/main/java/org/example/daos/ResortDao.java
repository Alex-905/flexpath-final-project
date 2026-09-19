package org.example.daos;

import org.example.exceptions.DaoException;
import org.example.models.Resort;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class ResortDao {

    private final JdbcTemplate jdbcTemplate;

    public ResortDao (DataSource dataSource) {

        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Resort> getResorts() {
        return jdbcTemplate.query("SELECT * FROM resorts ORDER BY resort_name;", this::mapToResort);
    }

    private Resort mapToResort(ResultSet resultSet, int rowNumber) throws SQLException {
        String username = resultSet.getString("username");
        String resortName = resultSet.getString("resort_name");
        String location = resultSet.getString("location");
        String diffLevel = resultSet.getString("diff_level");
        String description = resultSet.getString("description");
        int id = resultSet.getInt("id");
        int base = resultSet.getInt("base");
        int vertDrop = resultSet.getInt("vert_drop");
        int avgSnow = resultSet.getInt("avg_snow");
        boolean isPub = resultSet.getBoolean("is_pub");
        return new Resort(username, resortName, location, diffLevel, description, id, base, vertDrop, avgSnow, isPub);
    }

    public Resort createResort(Resort resort) {
        String sql = "INSERT INTO resorts (username, resort_name, location, diff_level, description, base, vert_drop, avg_snow, is_pub) VALUES (?,?,?,?,?,?,?,?,?);";
        try {
            jdbcTemplate.update(sql, resort.getUsername(), resort.getResortName(), resort.getLocation(), resort.getDiffLevel(), resort.getDescription(), resort.getBase(), resort.getVertDrop(), resort.getAvgSnow(), resort.getIsPub());
            return resort;
        } catch (DataAccessException e) {
            throw new DaoException("Failed to create resort.");
        }
    }

    public Resort getResortByResortName(String resortName) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM resorts WHERE resort_name = ?", this::mapToResort, resortName);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public Resort getResortById(int id) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM resorts WHERE id = ?", this::mapToResort, id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public int deleteResort(int id) {
        String sql = "DELETE FROM resorts WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    public Resort updateResort(Resort resort) {
        String sql = "UPDATE resorts SET username = ?, resort_name = ?, location = ?, diff_level = ?, description = ?, base = ?, vert_drop = ?, avg_snow = ?, is_pub = ? WHERE id = ?";
        int rowsAffected = jdbcTemplate.update(sql, resort.getUsername(), resort.getResortName(), resort.getLocation(), resort.getDiffLevel(), resort.getDescription(), resort.getBase(), resort.getVertDrop(), resort.getAvgSnow(),resort.getIsPub(), resort.getId());
        if (rowsAffected == 0) {
            throw new DaoException("Zero rows affected, expected at least one.");
        } else {
            return getResortById(resort.getId());
        }
    }

    public List<Resort> searchResorts(String location, String diffLevel) {
        String sql = "SELECT * FROM resorts WHERE location LIKE ? AND diff_level = ?";
        return jdbcTemplate.query(sql, this::mapToResort, "%" + location + "%", diffLevel);
    }
}
