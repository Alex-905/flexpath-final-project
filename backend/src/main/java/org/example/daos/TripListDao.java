package org.example.daos;

import org.example.exceptions.DaoException;
import org.example.models.TripList;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class TripListDao {

    private final JdbcTemplate jdbcTemplate;

    public TripListDao (DataSource dataSource) {

        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<TripList> getTripLists() {
        return jdbcTemplate.query("SELECT * FROM trip_lists ORDER BY trip_list;", this::mapToTripList);
    }

    private TripList mapToTripList(ResultSet resultSet, int rowNumber) throws SQLException {
        String username = resultSet.getString("username");
        String tripList = resultSet.getString("trip_list");
        String description = resultSet.getString("description");
        int id = resultSet.getInt("id");
        boolean isPub = resultSet.getBoolean("is_pub");
        return new TripList(username, tripList, description, id, isPub);
    }

    public TripList createTripList(TripList tripList) {
        String sql = "INSERT INTO trip_lists (username, trip_list, description, is_pub) VALUES (?,?,?,?);";
        try {
            jdbcTemplate.update(sql, tripList.getUsername(), tripList.getTripList(), tripList.getDescription(), tripList.getIsPub());
            return tripList;
        } catch (DataAccessException e) {
            throw new DaoException("Failed to create trip list.");
        }
    }

    public TripList getTripListById(int id) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM trip_lists WHERE id = ?", this::mapToTripList, id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public int deleteTripList(int id) {
        String sql = "DELETE FROM trip_lists WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    public TripList updateTripList(TripList tripList) {
        String sql = "UPDATE trip_lists SET username = ?, trip_list = ?, description = ?, is_pub = ? WHERE id = ?";
        int rowsAffected = jdbcTemplate.update(sql, tripList.getUsername(), tripList.getTripList(), tripList.getDescription(), tripList.getIsPub(), tripList.getId());
        if (rowsAffected == 0) {
            throw new DaoException("Zero rows affected, expected at least one.");
        } else {
            return getTripListById(tripList.getId());
        }
    }

    public void addResortToTripList(int tripListId, int resortId) {
        String sql = "INSERT INTO trip_list_resorts (trip_list_id, resort_id) VALUES (?, ?)";
        jdbcTemplate.update(sql, tripListId, resortId);
    }

    public void removeResortFromTripList(int tripListId, int resortId) {
        String sql = "DELETE FROM trip_list_resorts WHERE trip_list_id = ? AND resort_id = ?";
        jdbcTemplate.update(sql, tripListId, resortId);
    }

    public List<Integer> getResortIdsInTripList(int tripListId) {
        return jdbcTemplate.queryForList("SELECT resort_id FROM trip_list_resorts WHERE trip_list_id = ?", Integer.class, tripListId);
    }
}
