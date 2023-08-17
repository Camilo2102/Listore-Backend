package com.example.listore.utils;

import com.example.listore.controller.GeneralController;
import com.example.listore.models.GeneralModel;
import com.example.listore.repository.GeneralRepository;
import com.example.listore.service.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class BeanGenerator {

    private final BeanLocator beanLocator;

    @Autowired
    public BeanGenerator(BeanLocator beanLocator){
        this.beanLocator = beanLocator;
    }
    public GeneralController<?> getRequiredController(String repository) throws ClassNotFoundException {
        String repositoryName = repository + "Repository";
        GeneralRepository<?> repositorySelected = beanLocator.getBeanByString(repositoryName, GeneralRepository.class);
        GeneralService<? extends GeneralModel> service = new GeneralService<>(repositorySelected);

        return new GeneralController<>(service);
    }

    public Class<?>  getClassFromPath (String path) throws ClassNotFoundException {
        Class<?> className = beanLocator.getClassByName(StringUtil.firstUpperLetter(path));
        return className.asSubclass(GeneralModel.class);
    }
}
