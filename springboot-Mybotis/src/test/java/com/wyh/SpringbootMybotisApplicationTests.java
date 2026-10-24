package com.wyh;

import com.wyh.mapper.UserMapper;
import com.wyh.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest //SpringBoot单元测试的注解 - 当前测试类中的测试方法运行时，会启动springboot项目 - IOC容器
class SpringbootMybotisApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testFindAll(){
        //int updateage = userMapper.updateage();
        //System.out.println(updateage);
        List<User> userList = userMapper.findAll();
        userList.forEach(System.out::println);
    }
    @Test
    public void testDeleteId(){
        userMapper.deleteid(5);
    }
    @Test
    public void testUpdateData(){
        userMapper.updateage(new User(1,"jiangziya","123456","姜子牙",80));
    }

    @Test
    public void testInsertData(){
        userMapper.insertdata(new User(null,"zhouyu","123456","周瑜",25));
    }

    @Test
    public void testSelectData(){
        List<User> jiangziya = userMapper.selectData("jiangziya", "123456");
        System.out.println(jiangziya);
    }
}
