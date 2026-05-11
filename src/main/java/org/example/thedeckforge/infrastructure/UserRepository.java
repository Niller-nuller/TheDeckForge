package org.example.thedeckforge.infrastructure;

import com.zaxxer.hikari.util.Credentials;
import org.example.thedeckforge.entity.Authority;
import org.example.thedeckforge.entity.User;
import org.example.thedeckforge.entity.enums.Roles;
import org.example.thedeckforge.entity.interfaces.IUserRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository implements IUserRepository {

    private final JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //@Override
    public Authority logUserIn(Authority userAuth) {
        String sql = "SELECT * FROM Credentials WHERE Email = ?";

        return jdbcTemplate.queryForObject(sql,
                (rs, rowNum) -> new Authority(
                        rs.getString("email"),
                        rs.getString("password"),
                        Roles.valueOf(rs.getString("role"))
                ),
                userAuth.getEmail()
        );
    }


    @Override
    public void createUserAuthority(Authority userAuth) {
        String sql = "INSERT INTO Credentials (Email, PasswordHash) VALUES (?, ?)";
        jdbcTemplate.update(sql, userAuth.getEmail(), userAuth.getPassword());
    }

    @Override
    public void createUser(User user) {
        String sql = "INSERT INTO Users (Name, Age, UsercredentialsId) VALUES (?, ?, ?)";
        long authorityId = getUserLoginId(user.getAuthority());
        jdbcTemplate.update(sql, user.getName(), user.getAge(), authorityId);
    }

    @Override
    public User getUserFromAuth(Authority userAuth) {
        String sql = "SELECT * FROM Users LEFT JOIN Credentials ON Users.UserCredentialsId = Credentials.CredentialsId WHERE Credentials.Email = ?";
        return jdbcTemplate.queryForObject(sql,(rs, rowNum) ->
                new User(
                        rs.getString("Name"),
                        rs.getDate("Age").toLocalDate(),
                        new Authority(rs.getString("Email"), "", Roles.valueOf(rs.getString("UserRole")))
        ), userAuth.getEmail());
    }

    @Override
    public Long getUserLoginId(Authority userAuth) {
        String sql = "SELECT CredentialsId FROM Credentials WHERE Email = ?";
        return jdbcTemplate.queryForObject(sql,
                (rs, rowNum) -> rs.getLong("CredentialsId"), userAuth.getEmail()
        );
    }
}
