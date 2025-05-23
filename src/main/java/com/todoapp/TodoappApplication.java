package com.todoapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * アプリケーションのエントリーポイント(起動クラス)。
 * @SpringBootApplication アノテーションは以下を含む複合アノテーション：
 * @Configuration：設定クラスとして機能
 * @EnableAutoConfiguration：自動設定を有効か
 * @ConponentScan：指定パッケージ以下のコンポーネントを自動スキャン
 *
 * ブラウザでのアクセス：http://localhost:8080/todos
 */
@SpringBootApplication
public class TodoappApplication {
    /**
     * アプリケーションを起動するためのmainメソッド
     * SpringApplication.run()を呼び出すことで、SpringBootがアプリケーションを起動する仕組み。
     */
    public static void main(String[] args) {
        SpringApplication.run(TodoappApplication.class, args);
    }
}