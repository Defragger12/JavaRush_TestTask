FrontEnd : Spring MVC
MySQL, Spring, Hibernate, Maven
///


///
readAlready имеет тип varchar(3), со значениями ("Yes", "No"), как аналогия для boolean.
К Названию в списке книг добавляется (new), если книга не прочитана
Если мы на странице edit/{id} жмём Update, при этом не изменив значения полей, поле readAlready не меняется на false.
Реализован поиск только по названию книги.