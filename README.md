# Metrics Consumer

Сервис получает и обрабатывает данные из Kafka, отправленные с Metrics Producer,
а также загружает их в БД.

# Запуск Kafka Broker

Запускается c помощью docker-compose файла из Metrics Producer

# Запуск Metrics Consumer

Командой git clone <URL__репозитория> клонировать проект и запустить в IntellIj Idea.

# Документация

Для доступа к документации нужно выполнить команду mvn clean package javadoc:javadoc и
перейти на http://localhost:63342/demo.metrics.consumer/target/site/apidocs/index.html

