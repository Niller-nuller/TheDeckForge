package org.example.thedeckforge.infrastructure;

import com.zaxxer.hikari.util.Credentials;
import org.example.thedeckforge.entity.Authority;
import org.example.thedeckforge.entity.User;
import org.example.thedeckforge.entity.enums.Roles;
import org.example.thedeckforge.entity.interfaces.IUserRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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
                        rs.getString("Email"),
                        rs.getString("PasswordHash"),
                        Roles.valueOf(rs.getString("UserRole"))
                ),
                userAuth.getEmail()
        );
    }
    private RowMapper<User> userRowMapper() {
        return (rs, rowNum) -> {
            Authority authority = new Authority(
                    rs.getString("Email"),
                    "",
                    Roles.valueOf(rs.getString("UserRole"))
            );
            User user = new User();
            user.setName(rs.getString("Name"));
            user.setAge(rs.getDate("Age").toLocalDate());
            user.setAuthority(authority);
            return user;
        };
    }
    public Optional<User> findByEmail(String email) {
        String sql = """
                SELECT u.*, c.Email, c.UserRole
                FROM Users u
                JOIN Credentials c ON u.UserCredentialsId = c.CredentialsId
                WHERE c.Email = ?
                """;
        List<User> results = jdbcTemplate.query(sql, userRowMapper(), email);
        return results.stream().findFirst();
    }

    public Optional<Authority> FindAuthorityByEmail(String email) {
        String sql = "SELECT * FROM Credentials WHERE Email = ?";
        List<Authority> results = jdbcTemplate.query(sql, (rs, rowNum) ->
                new Authority(
                        rs.getString("Email"),
                        rs.getString("PasswordHash"),
                        Roles.valueOf(rs.getString("UserRole"))
                ), email);
        return results.stream().findFirst();
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
    @Override
    public Long getUserId(User user){
        String sql = "SELECT UsersId FROM Users LEFT JOIN Credentials ON Users.UserCrednetialsId = Credentials.CredentialsId WHERE Email = ?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> rs.getLong("UserId"), user.getAuthority().getEmail());
    }
}
