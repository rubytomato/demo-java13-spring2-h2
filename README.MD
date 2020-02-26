# H2 with Spring Boot 2.2 Demo application

Development environment

* OpenJDK 13.0.2
* Spring Boot 2.2.4
* H2
* Maven 3.6.1

```
openjdk version "13.0.2" 2020-01-14
OpenJDK Runtime Environment (build 13.0.2+8)
OpenJDK 64-Bit Server VM (build 13.0.2+8, mixed mode, sharing)
```

## compile

```
mvn clean package
```

## run

```
java -jar .\target\demo.jar
```

## test

```
mvn clean test
```

# database

## schema

* category
* item
* item_stock
* user
* user_order
* user_review

```

```

図

## h2-console

```
http://localhost:8080/h2-console
```

# Misc

### howto.html

[10. Database Initialization](https://docs.spring.io/spring-boot/docs/2.2.4.RELEASE/reference/html/howto.html#howto-database-initialization)

> spring.jpa.generate-ddl (boolean) switches the feature on and off and is vendor independent.
> spring.jpa.generate-ddl（boolean）は機能のオンとオフを切り替え、ベンダーに依存しません。

> spring.jpa.hibernate.ddl-auto (enum) is a Hibernate feature that controls the behavior in a more fine-grained way.
> spring.jpa.hibernate.ddl-auto（enum）は、より詳細な方法で動作を制御するHibernateの機能です。 

[10.2. Initialize a Database Using Hibernate](https://docs.spring.io/spring-boot/docs/2.2.4.RELEASE/reference/html/howto.html#howto-initialize-a-database-using-hibernate)

> You can set spring.jpa.hibernate.ddl-auto explicitly and the standard Hibernate property values are none, validate, update, create, and create-drop. Spring Boot chooses a default value for you based on whether it thinks your database is embedded. It defaults to create-drop if no schema manager has been detected or none in all other cases.
> spring.jpa.hibernate.ddl-autoを明示的に設定でき、標準のHibernateプロパティ値はnone、validate、update、create、およびcreate-dropです。 Spring Bootは、データベースが埋め込まれていると判断したかどうかに基づいて、デフォルト値を選択します。 スキーママネージャーが検出されない場合、または他のすべてのケースで検出されない場合は、デフォルトでcreate-dropになります。

> In addition, a file named import.sql in the root of the classpath is executed on startup if Hibernate creates the schema from scratch (that is, if the ddl-auto property is set to create or create-drop). 
> さらに、クラスパスのルートにあるimport.sqlという名前のファイルは、Hibernateが最初からスキーマを作成する場合（つまり、ddl-autoプロパティがcreateまたはcreate-dropに設定されている場合）に起動時に実行されます。

[10.3. Initialize a Database](https://docs.spring.io/spring-boot/docs/2.2.4.RELEASE/reference/html/howto.html#howto-initialize-a-database-using-spring-jdbc)

> 	In a JPA-based app, you can choose to let Hibernate create the schema or use schema.sql, but you cannot do both. Make sure to disable spring.jpa.hibernate.ddl-auto if you use schema.sql.
> JPAベースのアプリでは、Hibernateにスキーマを作成させるか、schema.sqlを使用させることができますが、両方を行うことはできません。 schema.sqlを使用する場合は、spring.jpa.hibernate.ddl-autoを必ず無効にしてください。


### spring-boot-features.html 

[10.1.1. Embedded Database Support](https://docs.spring.io/spring-boot/docs/2.2.4.RELEASE/reference/html/spring-boot-features.html#boot-features-embedded-database-support)

> If, for whatever reason, you do configure the connection URL for an embedded database, take care to ensure that the database’s automatic shutdown is disabled. If you use H2, you should use DB_CLOSE_ON_EXIT=FALSE to do so. If you use HSQLDB, you should ensure that shutdown=true is not used. Disabling the database’s automatic shutdown lets Spring Boot control when the database is closed, thereby ensuring that it happens once access to the database is no longer needed.
> 何らかの理由で埋め込みデータベースの接続URLを構成する場合は、データベースの自動シャットダウンが無効になっていることを確認してください。 H2を使用する場合、DB_CLOSE_ON_EXIT = FALSEを使用してそうする必要があります。 HSQLDBを使用する場合、shutdown = trueが使用されていないことを確認する必要があります。 データベースの自動シャットダウンを無効にすると、データベースが閉じられたときにSpring Bootが制御できるため、データベースへのアクセスが不要になったときに確実に実行されます。
