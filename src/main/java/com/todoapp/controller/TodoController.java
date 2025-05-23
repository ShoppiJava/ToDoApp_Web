package com.todoapp.controller;

import com.todoapp.entity.Todo;
import com.todoapp.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping("/todos") //全てのURLは/todosから始まる
public class TodoController {

    private final TodoService todoService;

    //コンストラクタインジェクションによって、TodoServieを注入
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }
    @GetMapping
    public String listTodos(Model model) {
        //全てのタスクを取得して、"todos"属性としビューに渡す
        model.addAttribute("todos", todoService.findAll());
        return "list"; //list.htmlの表示
    }
    @GetMapping("/new")
    public String showCreateForm(Model model){
        //新規作成用に空のTodoオブジェクトをフォームに渡す
        model.addAttribute("todo", new Todo());
        return "form"; //form.htmlの表示
    }
    @PostMapping
    public String createTodo(@ModelAttribute("todo") @Valid Todo todo, BindingResult result, Model model){
        //バリデーションエラーがあればフォームに戻る
        if(result.hasErrors()){
            model.addAttribute("todo", todo);
            return "form";
        }
        //正常の場合はデータを保存したうえで、一覧ページにリダイレクト
        todoService.save(todo);
        return "redirect:/todos";
    }
    @GetMapping("/{id}/delete")
    public String deleteTodo(@PathVariable Long id){
        //指定IDのタスクを削除
        todoService.deleteById(id);
        return "redirect:/todos";
    }
    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model){
        //指定IDのタスクを取得(存在しなければ例外)
        Todo todo = todoService.findById(id).orElseThrow(() -> new IllegalArgumentException("無効なID" + id));
        model.addAttribute("todo", todo);
        return "form"; //編集用に同じform.htmlを使用
    }
    @PostMapping("/{id}/update")
    public String updateTodo(@PathVariable Long id, @Valid @ModelAttribute Todo todo, BindingResult result, Model model){
        //バリデーションエラーがあればフォームに戻る
        if(result.hasErrors()){
            model.addAttribute("todo", todo);
            return "form";
        }
        //IDをセットして更新処理
        todo.setId(id);
        todoService.save(todo);
        return "redirect:/todos";
    }
}

