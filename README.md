# Проект по автоматизации мобильного тестирования

<img width="6%" title="IntelliJ IDEA" src="images/logo/wiki.jpg">

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
<img width="6%" title="Java" src="images/logo/Appium_Inspector.svg">
<img width="6%" title="Allure Report" src="images/logo/Allure_Report.svg">
<img width="6%" title="Allure Report" src="images/logo/AllureTO.svg">
<img width="6%" title="Gradle" src="images/logo/Gradle.svg">
<img width="6%" title="JUnit5" src="images/logo/JUnit5.svg">
<img width="6%" title="GitHub" src="images/logo/GitHub.svg">
<img width="6%" title="Jenkins" src="images/logo/Jenkins.svg">
<img width="6%" title="Telegram" src="images/logo/Telegram.svg">
</p>

Автотесты написаны на <code>Java</code> с использованием <code>JUnit 5</code> и <code>Gradle</code>.
Для тестов для мобильного приложения использован фреймворк [Appium](https://appium.io/), и [Android Studio](https://developer.android.com/studio)
Запуск тестов можно осуществлять локально или удаленно.
Также реализована сборка в <code>Jenkins</code> с формированием Allure-отчета и отправкой уведомления с результатами в <code>Telegram</code> после завершения прогона.

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
```

## :computer: Получение отчёта


```
allure serve build/allure-results
```
___

## <img width="4%" style="vertical-align:middle" title="Jenkins" src="images/logo/Jenkins.svg"> Сборка в Jenkins

* Для запуска необходимо нажать на "Собрать сейчас"

<p align="center">
<img title="Jenkins Build" src="images/screenshots/jenkinsBuild.png">
</p>

## <img width="4%" style="vertical-align:middle" title="Allure Report" src="images/logo/Allure_Report.svg"> Пример Allure-отчета
### Overview

<p align="center">
<img title="Allure Overview" src="images/screenshots/allureReport.png">
</p>

___
### Результат выполнения теста

<p align="center">
<img title="Test Results in Alure" src="images/screenshots/allureTO.png">
</p>

### <img width="4%" style="vertical-align:middle" title="Telegram" src="images/logo/Telegram.svg"> Уведомления в Telegram с использованием бота

После завершения сборки специальный бот, созданный в <code>Telegram</code>, автоматически обрабатывает и отправляет сообщение с отчетом о прогоне.

<p align="center">
<img width="70%" title="Telegram Notifications" src="images/screenshots/telegramm.png">
</p>


