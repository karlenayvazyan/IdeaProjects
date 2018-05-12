package am.ak.mybatis.data.handler;

import am.ak.mybatis.data.model.lcp.LanguageLCP;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by karlen on 5/2/15.
 */
public class LanguageTypeHandler extends BaseTypeHandler<LanguageLCP> {


    @Override
    public void setNonNullParameter(PreparedStatement ps,
                                    int i,
                                    LanguageLCP parameter,
                                    JdbcType jdbcType) throws SQLException {
        ps.setInt(i, parameter.getValue());
    }

    @Override
    public LanguageLCP getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return LanguageLCP.valueOf(rs.getInt(columnName));
    }

    @Override
    public LanguageLCP getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return LanguageLCP.valueOf(rs.getInt(columnIndex));
    }

    @Override
    public LanguageLCP getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return null;
    }
}
