Необходимо создать web приложение по управлению собственным туристическим
телеграм ботом.
1) Телеграм бот выдает пользователю справочную информацию о введенном городе.
   Например, пользователь вводит: «Москва», чат-бот отвечает: «Не забудьте посетить
   Красную Площадь. Ну а в ЦУМ можно и не заходить)))».
2) Данные о городах должны храниться в базе данных.
3) Управлять данными о городах (добавлять новые города и информацию о них, изменять
   и удалять любую информацию) необходимо через REST WebService.
   Используемые технологии: SpringBoot, SpringMVC, SpringData, Hibernate, Java не ниже 1.8.
   Для сборки проекта использовать Maven.

Для запуска необходимы:
 Имя бота: "X2nExBot";
 Токен бота: "5576451039:AAFBMalVfMOikJHD7R7JzhchBfVbA3TSxG8";

Установить PostgreSQL базу данных. Создать базу "telegramm_bot". 
Выполнить скрипт: recources/db/sequrity.schema
Этим скриптом мы подготовим базу для работы с Spring Sequrity. 
А так же создадим и заполним таблицу "phrases" с фразами приглашения.
Настройки можно подкрутить в recources/application.properties

Проект запускается через метод TelegrammBotApplication.main()
Для корректной работы нужно заполнить БД городами и местами.
Заходим по адресу: http://localhost:8082/
Регистрируемся и входим по логину и паролю. 
На всякий случай: 
логин admin
пароль admin

На основной странице видим форму, где вписываем город, название места и описание места.
Если город уже существует, то место добавится в список мест этого города.
Внизу страницы видим табличку с городами и местами связанными с этими городами. Можно удалить, можно подредактировать.

После заполнения базы запускаем Telegramm, ищем бота @X2nExBot и пишем ему название интересующего нас города.
Бот подтянет случайную фразу приглашения и случайное место, связанное с этим городом.
