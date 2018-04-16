import com.domain.emp;
import com.github.pagehelper.PageInfo;
import com.mapper.deptMapper;
import com.mapper.empMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration({ "/spring-config.xml" })
public class test {
    @Autowired
    private deptMapper dept;

    /*mybaties新用法批量处理,见Spring 配置文件*/
    @Autowired
   private SqlSession sqlSessionTemplate;
    /*传入SpringMVC的Ioc*/
    @Autowired
    WebApplicationContext context;
    /*模拟请求发送测试*/
  MockMvc mockMvc;

  @Before
  public  void initMockMvc(){
     mockMvc= MockMvcBuilders.webAppContextSetup(context).build();
  }
    @Test
    public void test() throws Exception{
       /* System.out.println(dept.selectByPrimaryKey(1));
        empMapper emp  =sqlSessionTemplate.getMapper(empMapper.class);//Spring批量处理
        for(int i=0;i<100;i++){
            String uuId=UUID.randomUUID().toString();
            emp.insert(new emp(i,String.valueOf(i),null,uuId,0));
        }*/
       /*模拟请求拿到返回值*/
      MvcResult result= mockMvc.perform(MockMvcRequestBuilders.post("/emp/all.do").param("pn","1")).andReturn();
        /*请求成功后获取请求域中的page进行验证*/
     MockHttpServletRequest request=result.getRequest();
    PageInfo info=(PageInfo) request.getAttribute("pagInfo");
        System.out.println("获取总记录"+info.getTotal());
        System.out.println("获取总页数"+info.getPages());
        //获取员工信息
        List<emp> list=info.getList();
        for(emp i:list){
            System.out.println(i.getEmail());
        }
  }
}

