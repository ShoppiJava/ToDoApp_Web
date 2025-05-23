package com.todoapp.entity;
import jakarta.persistence.*;
import java.time.LocalDate;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.FutureOrPresent;


@Entity //JPAによって永続化されるエンティティクラスであると示す
public class Todo {

    @Id //主キー
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自動裁判(MySQLのAUTO_INCREMENTと同じ)
    private Long id;

    @NotBlank(message = "タイトルは必須です") //空文字・nullは不可
    @Size(max = 50, message = "タイトルは50文字以内で入力してください") //最大文字数の制限
    private String title;

    @Size(max = 200, message = "説明は200文字以内で入力してください") //説明は任意だが、最大文字数の制限
    private String description;

    @FutureOrPresent(message = "締切日は今日以降を選択してください") //過去日付は拒否
    private LocalDate dueDate;

    private boolean completed; //タスクの完了状態(true=完了, false=未完了)

    // ここから下は前フィールドのgetter/setter

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public LocalDate getDueDate() { return dueDate; }
    public void setDueDate(LocalDate dueDate) { this.dueDate = dueDate; }

    public boolean isCompleted() { return completed; }
    public void setCompleted(boolean completed) { this.completed = completed; }
}