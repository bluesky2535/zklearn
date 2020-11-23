import com.zk.ssmbuild.dao.BookMapper;
import com.zk.ssmbuild.pojo.Book;
import com.zk.ssmbuild.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TestSSM {
    @Test
    public void test1(){
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);
        List<Book> Books = mapper.books();
        for (Book Book : Books) {
            System.out.println(Book.toString());
        }
        sqlSession.close();
    }
}
