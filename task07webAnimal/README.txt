Есть сущность Animal, у нее есть индификатор, имя, вес.
Задание создать проект.
Добавление таблицы в базу сделать через liquibase
Для сущности Animal сделать DAO через hibernate (универсальность приветствутся)
-select
-update
-delete
-insert

Добавить  веб интерфейс для добавления, редактирования, удаления и просмотра списком Animal.
Использовать три слоя(servlet, service, dao)
Можно использовать паттерн “Команда“
Можно использовать конвертер между Animal и AnimalDAO для разделения данных между бэком и фронтом.

** По желанию

Покрыть тестами слой service. сделать тесты используя H2.


mvn liquibase:update (update default profile main db)

mvn -Ptest liquibase:update (update second profile test db)

mvn liquibase:rollback -Dliquibase.rollbackCount=1 (drop test table)

mvn -Ptest test (executes tests with test hibernate configuration)
