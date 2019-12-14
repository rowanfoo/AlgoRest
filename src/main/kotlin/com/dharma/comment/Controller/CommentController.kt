package com.dharma.comment.Controller

import com.dhamma.pesistence.entity.data.Comment
import com.dhamma.pesistence.entity.data.QComment
import com.dhamma.pesistence.entity.repo.CommentRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/comment")

class CommentController {
    @Autowired
    lateinit var commentRepo: CommentRepo

    @GetMapping("/userid/{userid}")
    public fun getallbyUserid(@PathVariable userid: String): Iterable<Comment> = commentRepo.findAll(QComment.comment.userid.eq(userid))

    @GetMapping("/code/{code}")
    public fun getallbyCode(@PathVariable code: String): Iterable<Comment> = commentRepo.findAll(QComment.comment.code.eq(code))

    @GetMapping("/type/{type}")
    public fun getallbyType(@PathVariable type: String): Iterable<Comment> = commentRepo.findAll(QComment.comment.type.eq(type))

//    @PostMapping("/category")
//    public fun create(@PathVariable userid: String) = categoryRepo.findAll(QCategory.category.userid.eq(userid))

    @PutMapping("/")
    fun insert(@RequestBody comment: Comment) {
        commentRepo.save(comment)
    }


}
