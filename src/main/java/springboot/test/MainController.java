package springboot.test;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysql.jdbc.StringUtils;

@Controller
public class MainController {

    @Autowired
    private OrderDao orderDao;

    @GetMapping("/")
    public String index() {
        return "index";
    }


    @GetMapping("/xx")
    public String hello() {
        return "hello";
    }

    @GetMapping("/xxx")
    public String helloStatic() {
        return "static/hello";
    }

    @PostMapping("/save")
    public @ResponseBody
    Map<String, Object> save(@RequestBody Order order) {
        Map<String, Object> result = new HashMap<>();
        if (StringUtils.isNullOrEmpty(order.id))
            order.id = orderDao.insert(order);
        else {
            orderDao.update(order);
        }
        result.put("id", order.id);
        return result;
    }

    @PostMapping("/get")
    public @ResponseBody
    Object get(String id) {
        return orderDao.get(id);
    }

    @PostMapping("/findAll")
    public @ResponseBody
    Object findAll() {
        return orderDao.findAll();
    }

    @PostMapping("/delete")
    public @ResponseBody
    Map<String, Object> delete(String id) {
        Map<String, Object> result = new HashMap<>();
        orderDao.delete(id);
        result.put("id", id);
        return result;
    }
}