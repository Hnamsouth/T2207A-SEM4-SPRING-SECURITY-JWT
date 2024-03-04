package com.example.T2204A_sem4.service.IPML;

import com.example.T2204A_sem4.entity.Category;
import com.example.T2204A_sem4.repository.CategoryRepo;
import com.example.T2204A_sem4.service.IBaseCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService implements IBaseCRUD<Category> {

    @Autowired
    private CategoryRepo categoryRepo;


    @Override
    public List<Category> getAll() {
        return categoryRepo.findAll();
    }

    @Override
    public Category create(Category category) {
        return categoryRepo.save(category);
    }

    @Override
    public Category update(Category category) {
        if(categoryRepo.findById(category.getId()).isEmpty()){
            return null;
        }
        return categoryRepo.save(category);
    }

    @Override
    public Category update(Category category, Long e) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        categoryRepo.deleteById(id);
        return false;
    }

    @Override
    public <K> Category find(K id) {
        return null;
    }

    @Override
    public List<Category> search(String e) {
       return categoryRepo.findAll().stream().filter(p->
                (
//                        p.getId() == (Integer.parseInt(e)) ||
                        p.getName().contains(e) ||
                        p.getSlug().contains(e) ||
                        p.getStatus().equals(Integer.parseInt(e)==0) ||
                        p.getStatus().equals(Integer.parseInt(e)==1)
                )
        ).collect(Collectors.toList());
    }

    public List<Category> searchMultiple(Long id, String name, String slug, Boolean status){
        return categoryRepo.findAllByIdOrNameOrSlugOrStatus(id,name,slug,status);
    }
}
