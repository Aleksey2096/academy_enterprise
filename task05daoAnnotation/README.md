Есть сущность Person, у нее есть индификатор, имя и фамилия.
Задание создать проект.
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