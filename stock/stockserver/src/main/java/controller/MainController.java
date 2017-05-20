package controller;

import entity.list.ListEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import repository.list.ListRepository;

@RestController
@RequestMapping(path = "/")
public class MainController {

    @Autowired
    private ListRepository listRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ListEntity index() {
        return listRepository.findOne(-1);
    }
}
