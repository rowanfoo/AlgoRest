package com.dharma.category.Controller

import com.dhamma.pesistence.entity.data.Category
import com.dhamma.pesistence.entity.data.QCategory
import com.dhamma.pesistence.entity.repo.CategoryRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class CategoryController {
    @Autowired
    lateinit var categoryRepo: CategoryRepo

    @GetMapping("/userid/{userid}")
    public fun getall(@PathVariable userid: String): Iterable<Category> = categoryRepo.findAll(QCategory.category.userid.eq(userid))

//    @PostMapping("/category")
//    public fun create(@PathVariable userid: String) = categoryRepo.findAll(QCategory.category.userid.eq(userid))

    @PutMapping("/category")
    fun insert(@RequestBody category: Category) {
        categoryRepo.save(category)
    }


}
