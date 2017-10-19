package com.zm.test.mapper;

import com.zm.mapper.ExamMapper;
import com.zm.mapper.UserMapper;
import com.zm.model.Exam;
import com.zm.model.Item;
import com.zm.model.User;
import com.zm.scan.mapper.ItemMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

/**
 * Created by Administrator on 2017/10/19.
 */
public class TestMapper {
    private SqlSessionFactory sqlSessionFactory = null;
    @Before
    public void init()throws Exception{
        //创建SqlSessionBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //创建SqlSessionFactory对象
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
       /* SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(new FileInputStream("SqlMapConfig.xml"));*/
       sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        //创建sqlSession对象
    }

    /**
     * 测试一般查询
     * @throws Exception
     */
    @Test
    public  void testUserMapper()throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //sqlSession执行,获取对象
        User user = (User) sqlSession.selectOne("selectByPrimaryKey" , 1 );
        System.out.println(user);
        //关流
        sqlSession.close();
    }


    /**
     * 模糊查询中使用#{}模糊查询,#{可以是任意值}
     * @throws Exception
     */
    @Test
    public void testUserLikeByStatement()throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<User> list =  sqlSession.selectList("selectUserByNameStatementLike" , "%张%" );
        for (User user: list) {
            System.out.println(user);
        }
        System.out.println("end");
        sqlSession.close();
    }

    /**
     * #{}与${}的差别 查看sql发送的语句即可
     * @throws Exception
     */
    @Test
    public void testUserLikeByString()throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<User> list =  sqlSession.selectList("selectUserByNameStringLike" , "%张%" );
        for (User user: list) {
            System.out.println(user);
        }
        System.out.println("end");
        sqlSession.close();
    }


    /**
     * mapper代理形式来获取来开发
     */
    @Test
    public void testMapperProxy(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ExamMapper mapper = sqlSession.getMapper(ExamMapper.class);
        Exam exam = mapper.selectByPrimaryKey(1);
        System.out.println(exam);
        sqlSession.close();
    }

    /**
     * 包扫描方式动态mapper
     */
    @Test
    public  void testMapperScan(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ItemMapper mapper = sqlSession.getMapper(ItemMapper.class);
        Item item = mapper.selectByPrimaryKey(1);
        System.out.println(item);
        sqlSession.close();
    }

}
