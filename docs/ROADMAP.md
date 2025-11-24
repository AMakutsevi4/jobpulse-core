# JobPulse Roadmap

## Week 0 - Подготовка

- Настроить ветки main и developer
- Настроить защиту ветки main
- Создать структуру проекта

## Week 1 - MVP основы

- Инициализировать Spring Boot проект
- Настроить PostgreSQL + docker-compose
- Создать базовые модули (core)
- Создать HH API клиент
- Сделать тестовый endpoint для проверки интеграции

## Week 2 - Данные и сервисы

- Модель вакансий
- Сервис сохранения вакансий
- Парсинг ответов hh.ru
- Kafka producer:  отправка найденных вакансий

## Week 3 - Kafka + Consumers

- Consumers для обработки вакансий
- Сервис аналитики
- Хранение статистики

## Week 4 - K8s + CI/CD

- Dockerfile
- Helm chart
- GitHub Actions pipeline
- Автоматический деплой на k8s кластер

## Week 5 - Письма

- Модель навыков
- Генерация сопроводительного письма (шаблон)

## Week 6 - Frontend

