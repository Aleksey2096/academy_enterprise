Есть сущность Person, у нее есть индификатор, имя и фамилия.
Задание создать проект.
Добавление таблицы в базу сделать через liquibase,
сделать тесты используя H2. Покрыть функционал тестами
и сделать отчет используя плагин jacoco.
Подключить checkstyle к проекту.
Для сущности Person сделать DAO над каждым полем написать
анотацию свою MyColumn(name - название колонки) с названием колонки над классом Person написать анатацию MyTable(name - название таблицы). Реализовать crud операции с Person используя jdbc
-select
-update
-delete
-insert
причем эти операции должны составлять запрос в базу используя анатации MyColumn и MyTable (через рефлексию)т.е. если я создам другую сущность то
-select
-update
-delete
-insert должны работать без изменения внутреней логики



mvn liquibase:update (add test table and rows)

mvn liquibase:rollback -Dliquibase.rollbackCount=1 (drop test table)

mvn test (runs tests and creates jacoco report in target/site/jacoco/index.html)

mvn site (creates checkstyle report in target/site/checkstyle.html)