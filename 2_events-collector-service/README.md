# Сервис получения событий от устройств

Данный сервис:
1) Подписывается на Kafka-топик `events` и получает события в формате Avro (через Schema Registry).
2) Обрабатывает сообщения строго по одному (без batch listener / без пачек).
3) Сохраняет каждое событие в ClickHouse (таблица `device_events`) для аналитики.
4) Дедуплицирует новые `device_id` через Redis.
5) Для публикации уникальных `device_id` использует паттерн Transactional Outbox:
при получении `device_id` создает запись в `device_outbox` (ClickHouse)
6) отдельная CRON-джоба читает `device_outbox` и публикует `device_id` в Kafka-топик `devices`, без дублей из-за параллельных CRON-джоб.