# Проект по мобильной автоматизации

<img width="100%" title="IntelliJ IDEA" src="images/logo/wiki.jpg">

## :bookmark_tabs: Содержание:

- [Использованный стек технологий](#computer-использованный-стек-технологий)
- [Реализованный проверки](#реализованный-проверки)
- [Запуск тестов](#running_woman-запуск-тестов)
- [Сборка в Jenkins](#-сборка-в-jenkins)
- [Пример Allure-отчета](#-пример-allure-отчета)
- [Уведомления в Telegram с использованием бота](#-уведомления-в-telegram-с-использованием-бота)

___
## :computer: Использованный стек технологий

<p align="center">
<img width="6%" title="IntelliJ IDEA" src="images/logo/Intelij_IDEA.svg">
<img width="6%" title="Java" src="images/logo/Java.svg">
<img width="6%" title="Java" src="images/logo/Selenide.svg">
<img width="6%" title="Java" src="images/logo/Browserstack.svg">
<img width="6%" title="Java" src="images/logo/Android_Studio.svg">
<img width="6%" title="Java" src="images/logo/Appium.svg">
<img width="6%" title="Java" src="images/logo/Appium_Inspector.png">
<img width="6%" title="Allure Report" src="images/logo/Allure_Report.svg">
<img width="6%" title="Allure Report" src="images/logo/AllureTO.svg">
<img width="6%" title="Gradle" src="images/logo/Gradle.svg">
<img width="6%" title="JUnit5" src="images/logo/JUnit5.svg">
<img width="6%" title="GitHub" src="images/logo/GitHub.svg">
<img width="6%" title="Jenkins" src="images/logo/Jenkins.svg">
<img width="6%" title="Telegram" src="images/logo/Telegram.svg">
</p>

Автотесты написаны на <code>Java</code> с использованием <code>JUnit 5</code> и <code>Gradle</code>.
Для тестов для мобильного приложения использован фреймворк [Appium](https://appium.io/).
Запуск тестов можно осуществлять локально или удаленно.
Также реализована сборка в <code>Jenkins</code> с формированием Allure-отчета.

Allure-отчет включает в себя:
* Шаги выполнения тестов;
* Скриншот страницы в браузере в момент окончания автотеста;
* Page Source;
* Логи браузерной консоли;

___

## :bookmark: Запуск тестов из терминала

Локальный запуск:
```
gradle local -Denv-local
```

Удаленный запуск:
```
gradle android -Dnev=android
gradle android -Dnev=ios
```

## :computer: Получение отчёта


```
allure serve build/allure-results
```
___

### <img width="4%" style="vertical-align:middle" title="Jenkins" src="images/logo/Jenkins.svg"> Сборка в Jenkins

* Для запуска необходимо нажать на "Собрать c параметрами"

<p align="center">
<img title="Jenkins Build" src="images/screenshots/Jenkins.png">
</p>

### <img width="4%" style="vertical-align:middle" title="Allure Report" src="images/logo/Allure_Report.svg"> Пример Allure-отчета удаленного запуска автотестов


<p align="center">
<img title="Allure Overview" src="images/screenshots/Allure.png">
</p>


### <img width="4%" style="vertical-align:middle" title="Allure Report" src="images/logo/Allure_Report.svg"> Пример Allure-отчета локального запуска автотестов


<p align="center">
<img title="Allure Overview" src="images/screenshots/Allure2.png">
</p>

___
### <img width="4%" style="vertical-align:middle" title="Allure Report" src="images/logo/AllureTO.svg"> Результат выполнения теста

<p align="center">
<img title="Test Results in Allure" src="images/screenshots/allureTO.png">
</p>

### <img width="4%" style="vertical-align:middle" title="Browserstack" src="images/logo/Browserstack.svg"> Видео примера запуска автотеста

Далее представлено видео прохождения теста на неуспешную авторизацию в мобильном приложении Wikipedia
<p align="center">
  <img title="Video" src="images/gif/Test.gif">
</p>

