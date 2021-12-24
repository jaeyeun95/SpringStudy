package com.itvillage;

import com.itvillage.vo.ToDo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
public class ToDoController {
    @RequestMapping(value = "/todoAjax", method = RequestMethod.POST)
    @ResponseBody
    public List<ToDo> todoAjax(@RequestParam("todoName")String todoName,
                               @RequestParam("todoDate")String todoDate) {
        ToDo.todoList.add(new ToDo(todoName, todoDate));
        return ToDo.todoList;
    }
}
