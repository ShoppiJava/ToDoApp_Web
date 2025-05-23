package com.todoapp.repository;

import com.todoapp.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Todoエンティティのためのリポジトリインターフェース
 * JpaRepositoryを継承することにより、CRUD(作成・読み取り・更新・削除)操作が自動提供される仕組み。
 * 第一引数：操作対象となるエンティティのクラス(ToDo)
 * 第二引数：エンティティの主キーの型(Long)
 */

public interface TodoRepository extends JpaRepository<Todo, Long> {
    //必要に応じて、カスタムメソッド(findByTitleなどが候補)をここに追加可能
}
