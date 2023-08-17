package com.example.listore.controller;

import com.example.listore.models.GeneralModel;
import com.example.listore.models.Inventory;
import com.example.listore.models.User;
import com.example.listore.repository.GeneralRepository;
import com.example.listore.repository.InventoryRepository;
import com.example.listore.repository.UserRepository;
import com.example.listore.service.GeneralService;
import com.example.listore.utils.BeanGenerator;
import com.example.listore.utils.BeanLocator;
import com.example.listore.utils.RequestUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Transactional
@RequestMapping("/api")
public class ApiController {

    private final BeanGenerator beanGenerator;

    @Autowired
    public ApiController(BeanGenerator beanGenerator){
        this.beanGenerator = beanGenerator;
    }

    @RequestMapping("/**")
    public ResponseEntity<?> userRoute(HttpServletRequest request, @RequestBody(required = false) List<Object> body, @RequestParam(value = "pageNumber", required = false, defaultValue = "0") int pageNumber, @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize, @RequestParam(value = "id", required = false) String id ) throws ClassNotFoundException {
        String path = RequestUtil.getPartFromURI(request.getRequestURI(), 2);
        GeneralController<?> controller = this.beanGenerator.getRequiredController(path);
        controller.setAClass(this.beanGenerator.getClassFromPath(path));
        return controller.handleRequest(request, body, pageNumber, pageSize, id);
    }





}
