package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

public class JdbcTempleteMemberRepository implements MemberRepository {

  //스프링에서 inject을 받을수는 없다.
  private final JdbcTemplate jdbcTemplate;

  public JdbcTempleteMemberRepository(DataSource dataSource) {
    jdbcTemplate = new JdbcTemplate(dataSource);
  }

  @Override
  public Member save(Member member) {
    SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
    jdbcInsert.withTableName("member").usingGeneratedKeyColumns("id");

    Map<String, Object> parameters = new HashMap<>();
    parameters.put("name", member.getName());

    Number key = jdbcInsert.executeAndReturnKey(
      new MapSqlParameterSource(parameters)
    );
    member.setId(key.longValue());
    return member;
  }

  @Override
  public Optional<Member> findById(Long id) {
    List<Member> result = jdbcTemplate.query(
      "select * from member where id = ?",
      memberRowMapper(),
      id
    );
    //기존 jdbc 코드를 template를 써서 줄이셔 만든게 현재 코드를 사용한다.

    return result.stream().findAny();
  }

  @Override
  public Optional<Member> findByName(String name) {
    return jdbcTemplate
      .query("select * from member where name = ?", memberRowMapper(), name)
      .stream()
      .findAny();
  }

  @Override
  public List<Member> findAll() {
    return jdbcTemplate.query("select * from member", memberRowMapper());
  }

  //db데이터를 객체로 생성 시켜주는 기능.
  private RowMapper<Member> memberRowMapper() {
    //     return new RowMapper<Member>(){
    //         @Override
    //         public Member mapRow(ResultSet rs, int rowNum) throws SQLException{
    //             Member member = new Member();
    //             member.setId(rs.getLong("id"));
    //             member.setName(rs.getString("name"));
    //             return member;
    //         }
    //     }

    //람다스타일
    return (rs, rowNum) -> {
      Member member = new Member();
      member.setId(rs.getLong("id"));
      member.setName(rs.getString("name"));
      return member;
    };
  }
}
