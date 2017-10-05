FrontEnd : Spring MVC
MySQL, Spring, Hibernate, Maven, Tomcat 9 (в задании был tomcat 8, надеюсь, это не будет проблемой)
///
http://localhost:8888/list - список книг
///
readAlready имеет тип varchar(3), со значениями ("Yes", "No"), как аналогия для boolean.
К Названию в списке книг добавляется (new), если книга не прочитана
Если мы на странице edit/{id} жмём Update, при этом не изменив значения полей, поле readAlready не меняется на false.
Реализован поиск только по названию книги.
