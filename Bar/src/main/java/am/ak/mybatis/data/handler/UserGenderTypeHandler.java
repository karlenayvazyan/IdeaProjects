package am.ak.mybatis.data.handler;

import am.ak.mybatis.data.model.lcp.Gender;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by karlen on 5/2/15.
 */
public class UserGenderTypeHandler extends BaseTypeHandler<Gender> {


    @Override
    public void setNonNullParameter(PreparedStatement ps,
                                    int i,
                                    Gender parameter,
                                    JdbcType jdbcType) throws SQLException {
        ps.setInt(i, parameter.getValue());
    }

    @Override
    public Gender getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return Gender.valueOf(rs.getInt(columnName));
    }

    @Override
    public Gender getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return Gender.valueOf(rs.getInt(columnIndex));
    }

    @Override
    public Gender getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return null;
    }
}
